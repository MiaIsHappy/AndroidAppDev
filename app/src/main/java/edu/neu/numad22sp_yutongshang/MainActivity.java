package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   // public void clickButton(android.view.View view){
    //    Toast.makeText(getApplicationContext(),"Yutong Shang shang.yut@northeastern.edu", Toast.LENGTH_SHORT).show();
    //}
   public void clickButton(android.view.View view){
       Button bt_1 = (Button) findViewById(R.id.btnAboutMe);

       bt_1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               Toast.makeText(getApplicationContext(),"Yutong Shang shang.yut@northeastern.edu", Toast.LENGTH_SHORT).show();
           }
       });
       Button bt_2 = (Button) findViewById(R.id.button);

       bt_2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               startActivity(new Intent(MainActivity.this, MainActivity2.class));
           }
       });}
}