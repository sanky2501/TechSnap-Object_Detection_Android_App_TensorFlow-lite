package com.example.od_robodroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.IOException;
import static com.example.od_robodroid.Global.INPUT_SIZE;
import static com.example.od_robodroid.Global.mBitmap;
import static com.example.od_robodroid.Global.mBitmap1;

public class BrowseImg extends AppCompatActivity {

    ImageView imgView;
    Button reload;
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_img);

        imgView = findViewById(R.id.imageview);
        reload=findViewById(R.id.Reload_button);
        proceed = findViewById(R.id.Proceed_button);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, 42);


        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, 42);
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BrowseImg.this,ImagePreview.class));
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            final Uri uri;
            if (resultData != null) {
                uri = resultData.getData();
                try {
                    mBitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    mBitmap = Bitmap.createScaledBitmap(mBitmap1, INPUT_SIZE, INPUT_SIZE, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imgView.setImageBitmap(mBitmap1);
            }
        }
    }
}
