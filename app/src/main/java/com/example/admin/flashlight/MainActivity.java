package com.example.admin.flashlight;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = Camera.open();
        boolean b= this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        Toast t = Toast.makeText(this,""+b,Toast.LENGTH_LONG); t.show();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }
}
