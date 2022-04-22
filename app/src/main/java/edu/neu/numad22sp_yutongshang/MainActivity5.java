package edu.neu.numad22sp_yutongshang;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//A6 at your service
public class MainActivity5 extends AppCompatActivity {

    // weather url to get JSON
    String weather_url1 = "";

    //API Key
    String api_id1 = "86df7a8438a94279810d7b21ca70ebc3";

    //Enter Zipcode
    Button Click;
    EditText mEdit;

    RequestQueue queue;

    TextView textView1;

    TextView textView2;

    String ts = "94089";

    ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Click = (Button) findViewById(R.id.btVar1);

        textView1 = findViewById(R.id.textView);

        textView2 = findViewById(R.id.textView6);

       // Log.v("00-X", "01");
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

       // Log.v("00-X", "02");

        Click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit = (EditText) findViewById(R.id.editTextTextPostalAddress);
            //    Log.v("ASCCC-1", mEdit.getText().toString());
                //Log.v("ASCCCX-1", mEdit.getText().toString().length());
                // mText = (TextView)findViewById(R.id.textView1);
                // mText.setText("Welcome "+mEdit.getText().toString()+"!");

                spinner.setVisibility(View.VISIBLE);

                if (mEdit.getText().toString().length() > 5 || mEdit.getText().toString().length() < 5) {

                    ts = "94089";
                    Toast.makeText(MainActivity5.this, "Invalid Zip Code! Will fetch default Zip 94089",
                            Toast.LENGTH_LONG).show();
                } else {
                    ts = mEdit.getText().toString();
                }
              //  Log.v("ASCCC-1x", mEdit.getText().toString());
              //  Log.v("ASCCC-11X", ts);

                obtainLocation();
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void obtainLocation() {

        // get the last location
        weather_url1 = "https://api.weatherbit.io/v2.0/current?" + "postal_code=" + ts + "&key=" + api_id1;
        Log.i("ASCCC-2", weather_url1);

        // this function will
        // fetch data from URL
        getTemp();
    }

    ;

    private void getTemp() {
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        String url = weather_url1;

        // Request a string response
        // from the provided URL.
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            public void onResponse(String response) {
                Log.i("ASCCC-3", response);

                JSONObject obj = new JSONObject();
                try {
                    obj = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray arr = null;
                try {
                    arr = obj.getJSONArray("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject obj2 = null;
                try {
                    obj2 = arr.getJSONObject(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    textView1.setText(obj2.getString("temp") + " Celsius and " + obj2.getString("UV") + "UV");
                    textView2.setText("In the City of " + obj2.getString("city_name") + " ," + obj2.getString("state_code"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                spinner.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
              //  Log.d("error", error.toString());
                spinner.setVisibility(View.GONE);
            }
        });
        // In case of any error
        queue.add(request);
    }

}


