package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etext1,etext2;
    Spinner spin;
    SeekBar bar;
    RadioButton rdb1,rdb2,rdb3;
    Button bt1,bt2;
    TextView tv;
    CheckBox cb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext1 = (EditText) findViewById(R.id.editText);
        etext2= (EditText) findViewById(R.id.editText);
        spin = (Spinner) findViewById(R.id.spinner);
        bar = (SeekBar) findViewById(R.id.seekBar);
        rdb1 =  (RadioButton) findViewById(R.id.radioButton);
        rdb2 =  (RadioButton) findViewById(R.id.radioButton2);
        rdb3 =  (RadioButton) findViewById(R.id.radioButton3);
        bt1 =  (Button) findViewById(R.id.button);
        bt2 =  (Button) findViewById(R.id.button2);
        cb =  (CheckBox) findViewById(R.id.checkBox);

        List<String> Spinner = new ArrayList<>();
        Spinner.add("__Choose__");
        Spinner.add("Chicken Wrap");
        Spinner.add("Chicken Smosa");
        Spinner.add("Chicken Wings");
        Spinner.add("Chicken Lababdar");
        Spinner.add("Chicken Fry");
        Spinner.add("Butter Chicken");
        Spinner.add("Butter Naan");
        Spinner.add("Butter Roti");
        Spinner.add("Garlic Naan");
        Spinner.add("Chilly Chicken");





    }
}
