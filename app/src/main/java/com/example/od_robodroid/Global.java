package com.example.od_robodroid;

import android.graphics.Bitmap;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Global {
    public static Bitmap mBitmap = null;
    public static Bitmap mBitmap1 = null;


    public static String LABEL_PATH = "labels3.txt";
    public static String MODEL_PATH = "test3.tflite";
    public static Classifier classifier;


    public static Executor executor = Executors.newSingleThreadExecutor();
    public static final boolean QUANT = false;
    public static final int INPUT_SIZE = 50;
}
