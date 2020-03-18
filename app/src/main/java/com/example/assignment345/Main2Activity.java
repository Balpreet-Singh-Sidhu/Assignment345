package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
private static final String TAG = "MainActivity2";
dbHelper myDb;
List<orderInformation> orderList = new ArrayList<>();
ListView listView;
TextView tvName, tvPrice, tvQuantity, tvTip, tvTax, tvCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvName = (TextView)findViewById(R.id.mealName);
        tvPrice = (TextView)findViewById(R.id.price);
        tvQuantity = (TextView)findViewById(R.id.quantity);
        tvTip = (TextView)findViewById(R.id.tip);
        tvTax = (TextView)findViewById(R.id.tax);
        tvCost = (TextView)findViewById(R.id.cost);
        orderList = new ArrayList<>();
        listView = (ListView)findViewById(R.id.listView1);

        myDb = new dbHelper(this);
        displayOrders();
    }

    private void displayOrders(){
        Cursor cursor = myDb.getAllOrders();

        if (cursor.moveToFirst()){
            do{
                orderList.add(new orderInformation(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getDouble(4),
                        cursor.getDouble(5),
                        cursor.getDouble(6)
                        ));
            } while (cursor.moveToNext());
            cursor.close();
            orderAdapter orderadapter = new orderAdapter(this,R.layout.l_item,
                    orderList,myDb);
            listView.setAdapter(orderadapter);
        }
    }
}
