package com.example.experiment4;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class GroceryAdapter extends ArrayAdapter<GroceryItem> {

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    private ArrayList<GroceryItem> groceryItemArrayList;
    private Context context;

    GroceryAdapter(Context context, ArrayList<GroceryItem> groceryItemArrayList) {
        super(context, R.layout.grocery_item);
        this.groceryItemArrayList = groceryItemArrayList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grocery_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView_grocery);
            holder.textView = convertView.findViewById(R.id.textview_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        GroceryItem groceryItem = groceryItemArrayList.get(position);

        Glide.with(context)
                .load(groceryItem.getImages()) // URL of the image
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        holder.textView.setText(groceryItem.getName());

        return convertView;
    }


    @Override
    public int getCount() {
        return groceryItemArrayList.size();
    }

    @Override
    public GroceryItem getItem(int position) {
        return groceryItemArrayList.get(position);
    }
}
