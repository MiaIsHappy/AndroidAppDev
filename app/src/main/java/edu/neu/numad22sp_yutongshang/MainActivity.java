package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickButton(android.view.View view){
        Toast.makeText(getApplicationContext(),"Yutong Shang shang.yut@northeastern.edu", Toast.LENGTH_SHORT).show();
    }
}