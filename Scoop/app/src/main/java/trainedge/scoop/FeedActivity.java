package trainedge.scoop;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.einmalfel.earl.EarlParser;
import com.einmalfel.earl.Feed;
import com.einmalfel.earl.Item;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

import trainedge.scoop.Model.FeedModel;

public class FeedActivity extends AppCompatActivity {

    private static final String TAG = "FEED_ACTIVITY";
    private ViewGroup flProgressContainer;
    private RecyclerView rvFeedList;
    private CustomAdapter adapter;

   /*int techurls[]=new int[]{R.string.techcrunch,R.string.TechRadar,R.string.cnet,R.string.wired,R.string.ComputerWeekly,R.string.techRepublic,R.string.ZDNet};
    int fashionurls[]=new int []{R.string.quanta,R.string.nationalgeographic,R.string.discovermagazine,R.string.sciencechannel,R.string.sciencedaily,R.string.sciencereddit,R.string.theatlantic};
    int entertainmenturls[]=new int []{R.string.empirenews,R.string.spotify,R.string.rottentomatoes,R.string.mashables,R.string.indiewire,R.string.boxofficemojo,R.string.spin,R.string.makeuseof,R.string.salon,R.string.entertainmentweekly};
    int educationurls[]=new int []{R.string.photographmag,R.string.photographyreddit,R.string.photographytheverge,R.string.pixels,R.string.expertphotography,R.string.dailypuppy,R.string.dkphotography,R.string.diyphotographystuff};
    int businessurls[]=new  int []{};
    int travelurls[]=new int[]{};
    int foodurls[]=new int[]{};
    int sportsurls[]= new int[]{};
    int gadgetsurla[]=new int[]{};
    int newsurls[]=new int[]{};
    int healthandfitnessurls[]=new int
    int politicsurls[]= new int[]{R.string.PoliticsHome, R.string.RealClearPolitics,R.string.The Economist,R.string.Politico,R.string.Economic_and_Political_Weekly,R.string.The New Yorker,R.string.Washington Times}*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        flProgressContainer = (ViewGroup) findViewById(R.id.flProgressContainer);
        flProgressContainer.setVisibility(View.GONE);

        if (getIntent() != null && getIntent().hasExtra("trainedge.scoop.EXTRA_URL")) {
            String url = getIntent().getStringExtra("trainedge.scoop.EXTRA_URL");
            String name = getIntent().getStringExtra("trainedge.scoop.EXTRA_NAME");
            getSupportActionBar().setTitle(name);
            FeedFetchTask task = new FeedFetchTask();

            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);
            flProgressContainer.setVisibility(View.VISIBLE);
        }
        rvFeedList = (RecyclerView) findViewById(R.id.rvFeedList);
        rvFeedList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter(this);
    }


    class FeedFetchTask extends AsyncTask<String, Void, ArrayList<FeedModel>> {

        @Override
        protected void onPreExecute() {

        }

        @Override

        protected ArrayList<FeedModel> doInBackground(String... strings) {
            String link = strings[0];
            InputStream inputStream = null;
            ArrayList<FeedModel> feeds = new ArrayList<>();
            ArrayList<Feed> retreivedFeed = new ArrayList<>();
            try {
                inputStream = new URL(link).openConnection().getInputStream();
                retreivedFeed.add(EarlParser.parseOrThrow(inputStream, 0));
                for (Feed feed : retreivedFeed) {
                    for (Item item : feed.getItems()) {
                        //add the data to your arraylist
                        feeds.add(new FeedModel(item));
                        //testingw
                        //Log.i(TAG, "Item title: " + (item.getTitle() == null ? "N/A" : item.getTitle()));
                        //Log.i(TAG, "Item author: " + (item.getAuthor() == null ? "N/A" : item.getAuthor()));
                        Log.i(TAG, "Item description: " + (item.getDescription() == null ? "N/A" : item.getDescription()));
                        Log.i(TAG, "Image link: " + (item.getImageLink() == null ? "N/A" : item.getImageLink()));
                        //Log.i(TAG, "link: " + (item.getImageLink() == null ? "N/A" : item.getLink()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DataFormatException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } finally {
                try {

                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return feeds;
        }


        @Override
        protected void onPostExecute(ArrayList<FeedModel> objects) {
            updateRecyclerFeeds(objects);
            flProgressContainer.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        public void onActivityStopped() {

        }
    }

    private void updateRecyclerFeeds(ArrayList<FeedModel> modelArrayList) {
        adapter.setListContent(modelArrayList);
        rvFeedList.setAdapter(adapter);
    }


}
