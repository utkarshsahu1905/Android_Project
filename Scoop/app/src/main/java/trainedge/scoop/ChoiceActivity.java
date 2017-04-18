package trainedge.scoop;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.HashMap;

public class ChoiceActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView rvCategory;
    HashMap<String, Integer> choicesTech = new HashMap<>();
    HashMap<String, Integer> choicesFashion = new HashMap<>();
    HashMap<String, Integer> choicesEducation = new HashMap<>();
    HashMap<String, Integer> choicesBusiness = new HashMap<>();
    HashMap<String, Integer> choicesTravel = new HashMap<>();
    HashMap<String, Integer> choicesEntertainment = new HashMap<>();
    HashMap<String, Integer> choicesFood = new HashMap<>();
    HashMap<String, Integer> choicesSport = new HashMap<>();
    HashMap<String, Integer> choicesGadgets = new HashMap<>();
    HashMap<String, Integer> choicesNews = new HashMap<>();
    HashMap<String, Integer> choicesHealth_and_fitness = new HashMap<>();
    HashMap<String, Integer> choicesPolitics = new HashMap<>();
    private int categoryType;
    private Object[] feedNames;
    private HashMap<String, Integer> megaList;
    private ListView lvChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        choicesTech.put("Techcrunch", R.string.techcrunch);
        choicesTech.put("ZDNet", R.string.zdnet);
        choicesTech.put("techRepublic", R.string.techRepublic);
        choicesTech.put("Wired", R.string.wired);
        choicesTech.put("Computer Weekly", R.string.computer);
        choicesTech.put("Cnet", R.string.cnet);
        choicesTech.put("Techradar", R.string.techradar);

        choicesGadgets.put("Windows 7/8/10 Gadgets", R.string.window);
        choicesGadgets.put("NDTV Gadgets360" , R.string.ndtv);
        choicesGadgets.put("TechRadar", R.string.tech);
        choicesGadgets.put("The Gadgets and Tech Guide", R.string.gadgets);

        choicesEntertainment.put("Entertainment Tonight", R.string.entertainment);
        choicesEntertainment.put(" E! Online", R.string.online);
        choicesEntertainment.put("Access Hollywood", R.string.hollywood);
        choicesEntertainment.put("Hollywood Reporter", R.string.reporter);
        choicesEntertainment.put("Contactmusic", R.string.contactmusic);
        choicesEntertainment.put("TMZ", R.string.tmz);


        choicesPolitics.put("Washington Times", R.string.washingtontimes);
        choicesPolitics.put("PoliticsHome", R.string.politicshome);
        choicesPolitics.put("The Economist", R.string.economist);
        choicesPolitics.put("RealClearPolitics", R.string.realclear);
        choicesPolitics.put("Economic and Political Weekly", R.string.political);
        choicesPolitics.put("The New Yorker", R.string.newyorker);
        choicesPolitics.put("Politico", R.string.politico);

        choicesSport.put("Sports world", R.string.sportsworld);
        choicesSport.put("Sport24", R.string.sport24);
        choicesSport.put("Fox sports", R.string.fox);
        choicesSport.put("Yahoo sports", R.string.yahoo);
        choicesSport.put("BBC sport", R.string.bbc);
        choicesSport.put("Times of india", R.string.timesofindia);
        choicesSport.put("ESPN", R.string.espn);


        choicesFashion.put("ELLE's", R.string.elle);
        choicesFashion.put("InStyle", R.string.instyle);
        choicesFashion.put("JustLuxe", R.string.justLuxe);
        choicesFashion.put("Fibre2Fashion", R.string.fibre2fashion);
        choicesFashion.put("Fashion & Style", R.string.fashionandstyle);
        choicesFashion.put("Apparel Search", R.string.apparelsearch);
        choicesFashion.put("Beauty World", R.string.beautyworldnews);

        choicesEducation.put("Education Week", R.string.educationweek);
        choicesEducation.put("Education International", R.string.educationinternational);
        choicesEducation.put("Education Next", R.string.educationnext);
        choicesEducation.put("Edutopia", R.string.edutopia);
        choicesEducation.put("US Department of Education", R.string.usdepartment);
        choicesEducation.put("Education world", R.string.educationworld);
        choicesEducation.put("Education times", R.string.educationtimes);
        choicesEducation.put("Harvard Graduate School Of Education", R.string.harvardgraduate);

        choicesBusiness.put("Business Standard", R.string.businesstandard);
        choicesBusiness.put("The Economist", R.string.economists);
        choicesBusiness.put("The Economic Times-Indiatimes", R.string.economictimes);
        choicesBusiness.put("Business Today", R.string.businesstoday);
        choicesBusiness.put("Entreprenuer", R.string.entrepreneur);
        choicesBusiness.put("Business Wire", R.string.businesswire);
        choicesBusiness.put("Business Insider India", R.string.businessinsider);
        choicesBusiness.put("CNBC", R.string.cnbc);

        choicesTravel.put("IndependentTraveler", R.string.independenttraveler);
        choicesTravel.put("Expedia India", R.string.expedia);
        choicesTravel.put("Breaking Travel News", R.string.breakingtravelnews);
        choicesTravel.put("TravelMole", R.string.travelmole);
        choicesTravel.put("Travel State", R.string.travelstate);



        choicesFood.put("Food & Wine", R.string.foodandwine);
        choicesFood.put("The Telegraph", R.string.thetelegraph);
        choicesFood.put("Eating Well", R.string.eatingwell);
        choicesFood.put("Food", R.string.food);
        choicesFood.put("Eat Your World", R.string.eatyourworld);
        choicesFood.put("Fine dining Lovers", R.string.finedininglovers);
        choicesFood.put("Serious Eats", R.string.seriouseats);






        choicesNews.put("NDTV", R.string.ndtvnews);
        choicesNews.put("Times of India", R.string.timesof);
        choicesNews.put("The Hindu", R.string.hindu);
        choicesNews.put("India Today Group", R.string.indiatodaygroup);
        choicesNews.put("News18", R.string.news18);
        choicesNews.put("Fox News", R.string.foxnews);
        choicesNews.put("BBC News", R.string.bbcnews);
        choicesNews.put("CNN", R.string.cnn);

        choicesHealth_and_fitness.put("Health", R.string.health);
        choicesHealth_and_fitness.put("Women's Health and Fitness", R.string.womenshealthandfitness);
        choicesHealth_and_fitness.put("American Council", R.string.americancouncil);
        choicesHealth_and_fitness.put("Womens Fitness", R.string.womensfitness);
        choicesHealth_and_fitness.put("Shape Singapore", R.string.shapesingapore);
        choicesHealth_and_fitness.put("body+ Soul", R.string.bodyandsoul);
        choicesHealth_and_fitness.put("HealthCentral", R.string.healthcentral);
        choicesHealth_and_fitness.put("Health24", R.string.health24);



        lvChoice = (ListView) findViewById(R.id.lvChoice);
        if (getIntent() != null && getIntent().hasExtra("trainedge.scoop.EXTRA_CATEGORY")) {
            String category = getIntent().getStringExtra("trainedge.scoop.EXTRA_CATEGORY");
            getSupportActionBar().setSubtitle(category);
            categoryType = getIntent().getIntExtra("trainedge.scoop.EXTRA_POS", 0);
            ArrayAdapter<Object> adapter = null;
            switch (categoryType) {
                case 0:
                    feedNames = choicesTech.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 1:
                    feedNames = choicesGadgets.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 2:
                    feedNames = choicesEntertainment.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 3:
                    feedNames = choicesPolitics.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 4:
                    feedNames = choicesSport.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 5:
                    feedNames = choicesBusiness.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 6:
                    feedNames = choicesNews.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 7:
                    feedNames = choicesEducation.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 8:
                    feedNames = choicesTravel.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 9:
                    feedNames = choicesHealth_and_fitness.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 10:
                    feedNames = choicesFood.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case 11:
                    feedNames = choicesFashion.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
                case -1:
                    megaList = new HashMap<String, Integer>();
                    megaList.putAll(choicesTech);
                    megaList.putAll(choicesFashion);
                    megaList.putAll(choicesEducation);
                    megaList.putAll(choicesBusiness);
                    megaList.putAll(choicesTravel);
                    megaList.putAll(choicesEntertainment);
                    megaList.putAll(choicesFood);
                    megaList.putAll(choicesSport);
                    megaList.putAll(choicesGadgets);
                    megaList.putAll(choicesNews);
                    megaList.putAll(choicesHealth_and_fitness);
                    megaList.putAll(choicesPolitics);

                    feedNames = megaList.keySet().toArray();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, feedNames);
                    break;
            }
            lvChoice.setAdapter(adapter);
            lvChoice.setOnItemClickListener(this);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedUrl = null;
        String feedKey = feedNames[i].toString();
        switch (categoryType) {
            case 0:
                selectedUrl = getResources().getString(choicesTech.get(feedKey));
                break;
            case 1:
                Integer id = choicesGadgets.get(feedKey);
                selectedUrl = getResources().getString(id);

                break;
            case 2:
                selectedUrl = getResources().getString(choicesEntertainment.get(feedKey));
                break;
            case 3:
                selectedUrl = getResources().getString(choicesPolitics.get(feedKey));
                break;
            case 4:
                selectedUrl = getResources().getString(choicesSport.get(feedKey));
                break;
            case 5:
                selectedUrl = getResources().getString(choicesBusiness.get(feedKey));
                break;
            case 6:
                selectedUrl = getResources().getString(choicesNews.get(feedKey));
                break;
            case 7:
                selectedUrl = getResources().getString(choicesEducation.get(feedKey));
                break;
            case 8:
                selectedUrl = getResources().getString(choicesTravel.get(feedKey));
                break;
            case 9:
                selectedUrl = getResources().getString(choicesHealth_and_fitness.get(feedKey));
                break;
            case 10:
                selectedUrl = getResources().getString(choicesFood.get(feedKey));
                break;
            case 11:
                selectedUrl = getResources().getString(choicesFashion.get(feedKey));
                break;
            case -1:
                selectedUrl = getResources().getString(megaList.get(feedKey));
                break;
        }
        Intent feedIntent = new Intent(this, FeedActivity.class);
        feedIntent.putExtra("trainedge.scoop.EXTRA_URL", selectedUrl);
        feedIntent.putExtra("trainedge.scoop.EXTRA_NAME", feedKey);
        startActivity(feedIntent);

    }
}

