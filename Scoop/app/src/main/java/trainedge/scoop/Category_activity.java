package trainedge.scoop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Category_activity extends AppCompatActivity {

    private ArrayList<CategoryModel> CategoryList;
    private RecyclerView rvCategory;
    private int item;
    private CategoryAdapter adapter;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getSharedPreferences("setting_pref", MODE_PRIVATE);
        String theme = pref.getString("theme", "AppTheme");
        if (theme.equals("Blue")) {
            setTheme(R.style.Bluetheme);
        } else if (theme.equals("Black")) {
            setTheme(R.style.BlackTheme);
        } else if (theme.equals("White")) {
            setTheme(R.style.WhiteTheme);
        }
        else if (theme.equals("Pink")) {
            setTheme(R.style.PinkTheme);
        }else {
            setTheme(R.style.AppTheme_NoActionBar);
        }
        setContentView(R.layout.activity_category_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        CategoryList = new ArrayList<>();


        rvCategory = (RecyclerView) findViewById(R.id.rvCategory);
        GridLayoutManager manager=new GridLayoutManager(this,2);

        rvCategory.setLayoutManager(manager);
        generateCategories();

    }

    public void generateCategories() {
        CategoryList.add(new CategoryModel("Tech", R.drawable.tech));
        CategoryList.add(new CategoryModel("Gadgets", R.drawable.gadgets));
        CategoryList.add(new CategoryModel("Entertainment", R.drawable.entertainment));
        CategoryList.add(new CategoryModel("Politics", R.drawable.politics));
        CategoryList.add(new CategoryModel("Sports", R.drawable.sports));
        CategoryList.add(new CategoryModel("Business", R.drawable.business));
        CategoryList.add(new CategoryModel("News", R.drawable.news));
        CategoryList.add(new CategoryModel("Education", R.drawable.education));
        CategoryList.add(new CategoryModel("Travel", R.drawable.travel));
        CategoryList.add(new CategoryModel("Health and Fitness", R.drawable.health));
        CategoryList.add(new CategoryModel("Food", R.drawable.food));
        CategoryList.add(new CategoryModel("Fashion", R.drawable.fashion));
        adapter = new CategoryAdapter(CategoryList);
        rvCategory.setAdapter(adapter);


    }

    /*private class RssListAdapter extends RecyclerView.Adapter<CategoryHolder> {
        public RssListAdapter(Context context, ArrayList<CategoryModel> list, int layout) {
            super();
        }
    }*/


}
