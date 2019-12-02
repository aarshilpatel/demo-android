package com.example.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
EditText edtarea,edttile;
TextView txtcalc;
Button calc;
String TAG="Calculator";
//String lang[] = {"8*8","12*12","18*18","12*24"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calc = (Button)findViewById(R.id.btncalc);
        edtarea = (EditText)findViewById(R.id.edtroom);
        edttile = (EditText)findViewById(R.id.tiles);
        txtcalc = (TextView)findViewById(R.id.txtcal);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Double t = Double.valueOf(edttile.getText().toString());
                Double f= Double.valueOf(edtarea.getText().toString());

                f=f*1550.003/t;
                final String f1 =String.valueOf(f);

                Log.e(TAG, "area of tile "+t);
                Log.e(TAG, "tiles required "+f1);

               // Toast.makeText(Calculator.this, "tiles required" +f1, Toast.LENGTH_LONG).show();
                txtcalc.setText(""+f1);

            }
        });

        /*ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lang){

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView)super.getDropDownView(position,convertView,parent);

                tv.setTextColor(Color.BLACK);

                if (position==0){

                    tv.setTextColor(Color.GRAY);
                }
                return tv;
            }
        };
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String data = parent.getItemAtPosition(position).toString();
                if (position!=0)
                {
                    Toast.makeText(Calculator.this,"Item is " +data, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
    }
}
