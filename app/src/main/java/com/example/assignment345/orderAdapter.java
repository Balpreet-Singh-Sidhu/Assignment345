package com.example.assignment345;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class orderAdapter extends ArrayAdapter {
    Context mContext;
    int layoutRes;
    List<orderInformation> Orders;
    dbHelper myDb;
    public orderAdapter(@NonNull Context mContext, int layoutRes,
                        List<orderInformation> Orders, dbHelper myDb) {
        super(mContext, layoutRes, Orders);
        this.mContext = mContext;
        this.layoutRes = layoutRes;
        this.Orders = Orders;
        this.myDb = myDb;
    }

    public View getView(int position, @Nullable View convertView ,
                        @Nullable ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v= inflater.inflate(layoutRes, null);
        TextView tvName = v.findViewById(R.id.mealName);
        TextView tvPrice = v.findViewById(R.id.price);
        TextView tvQuantity = v.findViewById(R.id.quantity);
        TextView tvTip = v.findViewById(R.id.tip);
        TextView tvTax = v.findViewById(R.id.tax);
        TextView tvCost = v.findViewById(R.id.cost);

        final orderInformation order = Orders.get(position);
        tvName.setText("Item:" +order.getFoodName());
        tvPrice.setText("Price: "+String.valueOf(order.getPrice()));
        tvQuantity.setText("Quantity: "+String.valueOf(order.getQuantity()));
        tvTip.setText("Tip: "+String.valueOf(order.getTip()));
        tvTax.setText("Tax: "+String.valueOf(order.getTax()));
        tvCost.setText("Total Price: "+String.valueOf(order.getCost()));


        return v;
    }
    }
