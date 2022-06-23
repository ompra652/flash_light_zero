package com.codingfiber.flashlightzero;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton flashoff;
    boolean hascameflash = true;
    boolean flashon = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashoff = findViewById(R.id.flashoff);
        hascameflash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        flashoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hascameflash){
                    if (flashon){
                        flashon = false;
                        flashoff.setImageResource(R.drawable.poweroff);
                        flashlightoff();
                    }else{
                        flashon =true;
                        flashoff.setImageResource(R.drawable.poweron);
                        flashlighton();
                    } else{
                        Toast.makeText(MainActivity.this, "No flash avilable on your device", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void flashlightoff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraID = CameraManager.getCameraIdlist()[0];
        CameraID.setTorchMode(CameraID,false);
    }

    private void flashlighton() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraID = CameraManager.getCameraIdlist()[0];
        CameraID.setTorchMode(CameraID,true);
    }
}