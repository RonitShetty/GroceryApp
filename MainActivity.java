package com.example.experiment4;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private ListView listViewGroceries;
    private GroceryAdapter adapter;
    private ArrayList<GroceryItem> groceriesList = new ArrayList<>();
    private TextView textViewDate;
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewGroceries = findViewById(R.id.listview_groceries);
        textViewDate = findViewById(R.id.editTextDate);

        initArrayList();
        adapter = new GroceryAdapter(this, groceriesList);
        listViewGroceries.setAdapter(adapter);
        listViewGroceries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroceryItem groceryItem = adapter.getItem(position);
                Toast.makeText(MainActivity.this, groceryItem.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                android.R.style.Theme_Holo_Light_Dialog,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDateInView();
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        datePickerDialog.show();
    }
    private void updateDateInView() {
        String myFormat = "MMMM dd, yyyy"; // Date format to display
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        textViewDate.setText(sdf.format(calendar.getTime()));
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initArrayList() {
        groceriesList.clear();
        groceriesList.add(new GroceryItem("Carrot", "https://www.kew.org/sites/default/files/styles/original/public/2022-04/Carrots_-_Daucus_carota_subsp._sativus.jpg.webp"));
        groceriesList.add(new GroceryItem("Potato", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWk_zwdi3JO8XCJyjMQSEfIqr0cRbYtSBt4w&s"));
        groceriesList.add(new GroceryItem("Onion", "https://img3.exportersindia.com/product_images/bc-full/2020/11/5491638/fresh-onion-1606372011-5640991webp"));
        groceriesList.add(new GroceryItem("Apple", "https://ichef.bbci.co.uk/images/ic/480xn/p07v2wjn.jpg.webp"));
        groceriesList.add(new GroceryItem("Lettuce", "https://thumbs.dreamstime.com/b/iceberg-lettuce-1346776.jpg"));
        groceriesList.add(new GroceryItem("Tomato", "https://static01.nyt.com/images/2012/05/31/science/31tomato/31tomato-articleLarge.jpg"));
        groceriesList.add(new GroceryItem("Garlic", "https://5.imimg.com/data5/SELLER/Default/2023/5/306301999/MU/DN/SB/108346781/a-grade-fresh-garlic.webp"));
        groceriesList.add(new GroceryItem("Spinach", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaUibNT2TSYnu1kbCvd2Mlr4XuGqt53pqswA&s"));
//        adapter.notifyDataSetChanged();
    }
}
