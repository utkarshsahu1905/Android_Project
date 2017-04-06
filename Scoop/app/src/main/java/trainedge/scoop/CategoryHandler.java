package trainedge.scoop;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import trainedge.scoop.CategoryHolder;
import trainedge.scoop.CategoryModel;
import trainedge.scoop.R;

/**
 * Created by hp on 05-Apr-17.
 */

public class CategoryHandler extends RecyclerView.Adapter<CategoryHolder> {

    List<CategoryModel> CategoryList;
    private CategoryModel categoryModel;

    public CategoryHandler(List<CategoryModel> categoryList) {
        CategoryList = categoryList;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row=((LayoutInflater)parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.simple_category_item,parent,false);

        return new CategoryHolder(row);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        categoryModel = CategoryList.get(position);
        holder.tvLabel.setText(categoryModel.label);



    }

    @Override
    public int getItemCount() {
        return CategoryList.size();

    }
}
