package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.neu.numad22sp_yutongshang.ItemCard;
import edu.neu.numad22sp_yutongshang.MainActivity1;
import edu.neu.numad22sp_yutongshang.MainActivity2;
import edu.neu.numad22sp_yutongshang.MainActivity3;
import edu.neu.numad22sp_yutongshang.MainActivity4;
import edu.neu.numad22sp_yutongshang.MainActivity5;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class MainActivity extends AppCompatActivity {

    public ArrayList<ItemCard> itemList = new ArrayList<>();

    //    public RecyclerView recyclerView;
//    public RviewAdapter rviewAdapter;
//    public RecyclerView.LayoutManager rLayoutManger;
//    public FloatingActionButton fab;
//
//    public static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
//    public static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";
//test2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("ASDF", "onCreate: Message");
        Button bt_1 = (Button) findViewById(R.id.btnAboutMe);
        Button bt_2 = (Button) findViewById(R.id.button);
        Button bt_3 = (Button) findViewById(R.id.button2);
        Button bt_4 = (Button) findViewById(R.id.button3);
        Button bt_5 = (Button) findViewById(R.id.button4);



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

        bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MainActivity5.class));
            }
        });

    }



    // public void clickButton(android.view.View view){
    //    Toast.makeText(getApplicationContext(),"Yutong Shang shang.yut@northeastern.edu", Toast.LENGTH_SHORT).show();
    //}



}