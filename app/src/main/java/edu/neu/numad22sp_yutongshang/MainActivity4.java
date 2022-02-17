package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity4<backgroundLocationRequestCode> extends AppCompatActivity {

    private TextView text;

    private final int REQUEST_LOCATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//

        text = (TextView)findViewById(R.id.textView5);//




        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            //public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
            requestLocationPermission();
            return ;
        }

        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE); //获取系统的LocationManager对象


        // Get location info
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                2000,
                1,
                new LocationListener(){

                    @Override
                    public void onLocationChanged(Location location){
                        locationUpdates(location);
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras){
                    }

                    @Override
                    public void onProviderEnabled(String provider){
                    }

                    @Override
                    public void onProviderDisabled(String provider){
                    }
                });


        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        locationUpdates(location);

    }


    public void locationUpdates(Location location){
        if(location !=null){
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Longitude: ");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\nLatitude: ");
            stringBuilder.append(location.getLatitude());

            text.setText(stringBuilder);
        }else{
            text.setText("Cannot fetch your coordinates :-(");
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    public void requestLocationPermission() {
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if(EasyPermissions.hasPermissions(this, perms)) {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
        else {
            EasyPermissions.requestPermissions(this, "Please grant the location permission", REQUEST_LOCATION_PERMISSION, perms);
        }
    }


}