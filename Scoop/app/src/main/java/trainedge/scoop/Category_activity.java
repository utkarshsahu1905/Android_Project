package trainedge.scoop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Category_activity extends AppCompatActivity {

    private ArrayList<CategoryModel> CategoryList;
    private RecyclerView rvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);


        CategoryList = new ArrayList<>();
        generateCategories();

        rvCategory = (RecyclerView) findViewById(R.id.rvCategory);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        rvCategory.setLayoutManager(manager);


    }

    public void generateCategories() {
        CategoryList.add(new CategoryModel("tech", R.drawable.tech));
        CategoryList.add(new CategoryModel("fashion", R.drawable.fashion));
        CategoryList.add(new CategoryModel("education", R.drawable.education));
        CategoryList.add(new CategoryModel("business", R.drawable.business));
        CategoryList.add(new CategoryModel("travel", R.drawable.travel));
        CategoryList.add(new CategoryModel("entertainment", R.drawable.entertainment));
        CategoryList.add(new CategoryModel("food", R.drawable.food));
        CategoryList.add(new CategoryModel("sports", R.drawable.sports));
        CategoryList.add(new CategoryModel("gadgets", R.drawable.gadgets));
        CategoryList.add(new CategoryModel("news", R.drawable.news));
        CategoryList.add(new CategoryModel("Health and fitness", R.drawable.health));


    }

}
