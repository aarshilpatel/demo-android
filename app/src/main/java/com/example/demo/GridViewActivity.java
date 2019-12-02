package com.example.demo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class GridViewActivity extends AppCompatActivity {
    Button btnOrders,calc ;

    GridView gridView;
    String strLang[] = {"ceramic bearing", "flower pot", "pot", "tiles","tubes"};
    int imgData[] = {R.drawable.bearing,R.drawable.fp,R.drawable.pot,
            R.drawable.tiles,R.drawable.tubes};

    ArrayList<DataModel>dataModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
*/

                btnOrders = (Button) findViewById(R.id.btnOrder);
                btnOrders.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(GridViewActivity.this, Orders.class);
                        startActivity(i);
                        finish();
                    }
                });
                calc = (Button) findViewById(R.id.calc);
                calc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i2 = new Intent(GridViewActivity.this, Calculator.class);
                        startActivity(i2);
                        finish();
                    }
                });


                gridView = (GridView) findViewById(R.id.grid);
                dataModelArrayList = new ArrayList<DataModel>();
                for (int i = 0; i < strLang.length; i++) {
                    DataModel dataModel = new DataModel(strLang[i], imgData[i]);
                    dataModelArrayList.add(dataModel);
                }

                MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, dataModelArrayList, "Grid");
                gridView.setAdapter(myBaseAdapter);

            }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main3, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.item_order) {

                Intent i = new Intent(GridViewActivity.this, Orders.class);
                startActivity(i);
                finish();

                return true;
            }
            else if (id == R.id.item_calculator){

                Intent i2 = new Intent(GridViewActivity.this, Calculator.class);
                startActivity(i2);
                finish();
            }
            else if(id == R.id.item_logout){

                Intent i3 = new Intent(GridViewActivity.this, login.class);
                startActivity(i3);
                finish();

            }


            return super.onOptionsItemSelected(item);
        }


    }