package com.app.task;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements
        EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {
    GoogleMapFragment googleMapFragment;
    String[] perms = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (EasyPermissions.hasPermissions(this, perms)) {
                addfragmentFirst(new GoogleMapFragment());
            } else {
                EasyPermissions.requestPermissions(
                        MainActivity.this,
                        "App requires some permissions to function properly.",
                        10011,
                        perms
                );
            }
        }


    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (perms.size() > 1 && requestCode == 10011) {
            addfragmentFirst(new GoogleMapFragment());
            Toast.makeText(MainActivity.this, "Permissions Granted...", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(MainActivity.this).build().show();
        } else {

        }
    }

    @Override
    public void onRationaleAccepted(int requestCode) {

    }

    @Override
    public void onRationaleDenied(int requestCode) {
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
        } else if (requestCode == 10011) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
            }
        } else {
            finish();
        }
    }


    void addfragmentFirst(GoogleMapFragment fragment) {
        googleMapFragment = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, "GoogleMap")
                .addToBackStack("GoogleMap")
                .commit();
    }


}