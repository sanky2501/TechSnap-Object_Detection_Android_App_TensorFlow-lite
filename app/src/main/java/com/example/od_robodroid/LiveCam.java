package com.example.od_robodroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;


import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.od_robodroid.Global.INPUT_SIZE;
import static com.example.od_robodroid.Global.mBitmap;
import static com.example.od_robodroid.Global.mBitmap1;

public class LiveCam extends AppCompatActivity {


    CameraView mCameraView;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_cam);

        click = findViewById(R.id.button_click);
        mCameraView = findViewById(R.id.cameraView);

        mCameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {
                mBitmap1=cameraKitImage.getBitmap();

                mBitmap = Bitmap.createScaledBitmap(mBitmap1, INPUT_SIZE, INPUT_SIZE, false);
                Intent i = new Intent(getApplicationContext(),ImagePreview.class);
                mCameraView.stop();
                startActivity(i);
            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraView.captureImage();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCameraView.start();
    }
}
