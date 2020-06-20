package com.example.od_robodroid;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import static com.example.od_robodroid.Global.classifier;
import static com.example.od_robodroid.Global.executor;
import static com.example.od_robodroid.Global.mBitmap;
import static com.example.od_robodroid.Global.mBitmap1;


public class Predict extends AppCompatActivity {


    private TextView textViewResult;
    private ImageView imageViewResult;
    private TextView textViewPred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);

        imageViewResult = findViewById(R.id.imageview_predict);
        textViewResult = findViewById(R.id.textview_result);
        textViewPred = findViewById(R.id.textview_pred);

        imageViewResult.setImageBitmap(mBitmap1);

        List<Classifier.Recognition> results = classifier.recognizeImage(mBitmap);
        textViewResult.setText("Predicted Object: "+results.get(0).getTitle());
        textViewPred.setText("Probability is: "+Float.toString(results.get(0).getConfidence()*100)+"%");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                classifier.close();
            }
        });
    }
}
