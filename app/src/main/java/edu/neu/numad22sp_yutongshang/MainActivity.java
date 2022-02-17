package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ArrayList<ItemCard> itemList = new ArrayList<>();


//    public RecyclerView recyclerView;
//    public RviewAdapter rviewAdapter;
//    public RecyclerView.LayoutManager rLayoutManger;
//    public FloatingActionButton fab;
//
//    public static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
//    public static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("ASDF", "onCreate: Message");
        Button bt_1 = (Button) findViewById(R.id.btnAboutMe);
        Button bt_2 = (Button) findViewById(R.id.button);
        Button bt_3 = (Button) findViewById(R.id.button2);
        Button bt_4 = (Button) findViewById(R.id.button3);


        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MainActivity1.class));
            }
        });

        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });

        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MainActivity4.class));
            }
        });

    }


   // public void clickButton(android.view.View view){
    //    Toast.makeText(getApplicationContext(),"Yutong Shang shang.yut@northeastern.edu", Toast.LENGTH_SHORT).show();
    //}



}