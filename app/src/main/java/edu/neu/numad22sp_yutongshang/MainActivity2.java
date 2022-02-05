package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
   // protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main2);
    //}
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setContentView(R.layout.activity_main2);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("PRESSED:-");


        Button btn_A = (Button) findViewById(R.id.A);
        btn_A.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText("PRESSED:A");
        }});

        Button btn_B = (Button) findViewById(R.id.B);
        btn_B.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("PRESSED:B");
            }});

        Button btn_C = (Button) findViewById(R.id.C);
        btn_C.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("PRESSED:C");
            }});

        Button btn_D = (Button) findViewById(R.id.D);
        btn_D.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("PRESSED:D");
            }});

        Button btn_E = (Button) findViewById(R.id.E);
        btn_E.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("PRESSED:E");
            }});

        Button btn_F = (Button) findViewById(R.id.F);
        btn_F.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("PRESSED:F");
            }});
    }
}