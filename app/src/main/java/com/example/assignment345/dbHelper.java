package com.example.assignment345;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final String myDb_Name = "foodOrders";
    private static final int myDb_version = 1;
    public static final String tableName = "orders";
    public static final String clmnId = "orderId";
    public static final String clmnFood = "foodName";
    public static final String clmnPrice = "price";
    public static final String clmnQuantity = "quantity";
    public static final String clmnTip = "tip";
    public static final String clmnTax = "tax";
    public static final String clmnCost = "cost";
    public static final String createTable = "CREATE TABLE " + tableName + "(" +
            clmnId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            clmnFood + " varchar(200) NOT NULL," +
            clmnPrice + " integer NOT NULL," +
            clmnQuantity + " integer NOT NULL," +
            clmnTip + " double NOT NULL," +
            clmnTax + " double NOT NULL," +
            clmnCost + " double NOT NULL" +
            ");";

    public dbHelper(@Nullable Context context) {
        super(context, myDb_Name, null,myDb_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + tableName);
        db.execSQL(createTable);
        onCreate(db);
    }

    boolean addOrder(String foodName, int price, int quantity,
                     double tip, double tax, double cost){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(clmnFood, foodName);
        cv.put(clmnPrice, String.valueOf(price));
        cv.put(clmnQuantity, String.valueOf(quantity));
        cv.put(clmnTip, String.valueOf(tip));
        cv.put(clmnTax, String.valueOf(tax));
        cv.put(clmnCost, String.valueOf(cost));
        return  sqLiteDatabase.insert(tableName, null, cv)
                != -1;
    }
        Cursor getAllOrders()
        {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            return sqLiteDatabase.rawQuery("SELECT * FROM " + tableName,null);
        }
}
