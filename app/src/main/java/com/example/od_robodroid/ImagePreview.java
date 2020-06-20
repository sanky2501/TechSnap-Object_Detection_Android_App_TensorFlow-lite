package com.example.od_robodroid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.od_robodroid.Global.INPUT_SIZE;
import static com.example.od_robodroid.Global.LABEL_PATH;
import static com.example.od_robodroid.Global.MODEL_PATH;
import static com.example.od_robodroid.Global.QUANT;
import static com.example.od_robodroid.Global.classifier;
import static com.example.od_robodroid.Global.executor;
import static com.example.od_robodroid.Global.mBitmap;
import static com.example.od_robodroid.Global.mBitmap1;

public class ImagePreview extends AppCompatActivity {

    Button detect;
    ImageView inputImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);

        detect = findViewById(R.id.button_detect);
        inputImage = findViewById(R.id.imageView_ip);

        inputImage.setMaxHeight(mBitmap.getHeight());
        inputImage.setMaxWidth(mBitmap.getWidth());
        inputImage.setImageBitmap(mBitmap1);

        detect.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                detect.setBackgroundColor(getColor(R.color.clicked));
                Thread initTensorFlow = new Thread(){
                    public void run(){
                        LABEL_PATH="labels3.txt";
                        MODEL_PATH="test3.tflite";
                        initTensorFlowAndLoadModel();
                        Intent i =new Intent(getApplicationContext(), Predict.class);
                        startActivity(i);
                        finish();

                    }
                };
                initTensorFlow.start();
            }
        });
    }

    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_PATH,
                            LABEL_PATH,
                            INPUT_SIZE,
                            QUANT);
                } catch (final Exception e) {
                    Log.d("TagI",""+MODEL_PATH);
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }

}
