package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    dbHelper myDb;
    EditText etext1,etext2;
    Spinner spin;
    SeekBar bar;
    RadioGroup rdg;
    RadioButton rdb1,rdb2,rdb3;
    Button bt1,bt2;
    TextView tv;
    CheckBox cb;
    int progressValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext1 = (EditText) findViewById(R.id.editText);
        etext2= (EditText) findViewById(R.id.editText2);
        spin = (Spinner) findViewById(R.id.spinner);
        bar = (SeekBar) findViewById(R.id.seekBar);
        rdb1 =  (RadioButton) findViewById(R.id.radioButton);
        rdb2 =  (RadioButton) findViewById(R.id.radioButton2);
        rdb3 =  (RadioButton) findViewById(R.id.radioButton3);
        bt1 =  (Button) findViewById(R.id.button);
        bt2 =  (Button) findViewById(R.id.button2);
        cb =  (CheckBox) findViewById(R.id.checkBox);
        bar = (SeekBar) findViewById(R.id.seekBar);
        tv = (TextView) findViewById(R.id.textView7);
        rdg =(RadioGroup)findViewById(R.id.rg1);

        List<String> Spinner = new ArrayList<>();
        Spinner.add("__Choose__");
        Spinner.add("Chicken Wrap");
        Spinner.add("Chicken Samosa");
        Spinner.add("Chicken Wings");
        Spinner.add("Chicken Kadahi");
        Spinner.add("Chicken Fry");
        Spinner.add("Butter Chicken");
        Spinner.add("Butter Naan");
        Spinner.add("Butter Roti");
        Spinner.add("Garlic Naan");
        Spinner.add("Chilly Chicken");

        myDb = new dbHelper(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Spinner);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spin.getSelectedItem().toString().equals("Chicken Wrap")){
                    etext1.setText("50");
                }else if(spin.getSelectedItem().toString().equals("Chicken Samosa")) {
                    etext1.setText("40");
                }else if(spin.getSelectedItem().toString().equals("Chicken Wings")) {
                    etext1.setText("60");
                }else if(spin.getSelectedItem().toString().equals("Chicken Kadahi")) {
                    etext1.setText("70");
                }else if(spin.getSelectedItem().toString().equals("Chicken Fry")) {
                    etext1.setText("80");
                }else if(spin.getSelectedItem().toString().equals("Butter Chicken")) {
                    etext1.setText("90");
                }else if(spin.getSelectedItem().toString().equals("Butter Naan")) {
                    etext1.setText("30");
                }else if(spin.getSelectedItem().toString().equals("Butter Roti")) {
                    etext1.setText("10");
                }else if(spin.getSelectedItem().toString().equals("Garlic Naan")) {
                    etext1.setText("15");
                }else if(spin.getSelectedItem().toString().equals("Chilly Chicken")) {
                    etext1.setText("100");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tv.setText(bar.getProgress() + "/" + bar.getMax());
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText(progressValue + "/" + seekBar.getMax());
            }
        });



    }

    public void calculateTotalPrice(View view) {
        String price = etext1.getText().toString();
        int order_price = Integer.parseInt(price);
        int quantity = progressValue;
        double taxRate = 0.13;
        double tip = 0.0;
        if(rdb1.isChecked()){
            tip = 0.10;
        } else if(rdb2.isChecked()){
            tip = 0.15;
        } else if (rdb3.isChecked()){
            tip = 0.20;
        }
        double cost = (order_price * quantity) + (tip * order_price);
        double calculateTax = order_price*taxRate;
        double finalAmount = cost + calculateTax;

        String showPrice = Double.toString(finalAmount);
        etext2.setText(showPrice);
    }

    public void submit(View view) {
        if(spin.getSelectedItem() == null || progressValue == 0 ||
        rdg.getCheckedRadioButtonId() == -1 || cb.isChecked() == false) {
            Toast.makeText(this, "All Fields Required.",
                    Toast.LENGTH_SHORT).show();
        }
            String foodName = spin.getSelectedItem().toString();
            int price = Integer.parseInt(etext1.getText().toString());
            int quantity = progressValue;
            Double tip = 0.0;
            switch (rdg.getCheckedRadioButtonId())
            {
                case R.id.radioButton:
                    tip = 0.10;
                    break;
                case R.id.radioButton2:
                    tip = 0.15;
                    break;
                case R.id.radioButton3:
                    tip = 0.20;
                    break;
                default:
                    break;
            }

            Double tax = 0.13;
            Double cost = Double.parseDouble(etext2.getText().toString());

            if (myDb.addOrder(foodName, price, quantity, tip
            , tax, cost)){
                Toast.makeText(this, "Order added",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
                else
                    Toast.makeText(this, "Order not added",
                            Toast.LENGTH_SHORT).show();

        }
    }

