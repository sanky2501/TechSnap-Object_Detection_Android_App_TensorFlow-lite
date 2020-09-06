#  TechSnap (Object Detection Android App using TensorFlow Lite)	

### Overview
This is the app that detects the objects in the photo form your gallery mobile or photo from your camera using the deep learning CNN model trained on the dataset. These instructions will give you brief idea of building and running the App on Android Device.

The model files are already in a assests folder. You don't need to do any steps to download TFlite models into the project explicitly.

Application can run either on device or emulator.

**For full documentation [Click Here](https://drive.google.com/file/d/185g8PrHTGxcy9uiWdOcJEsuyj5AWDn3m/view?usp=sharing)**

## Build the app using Android Studio

### Prerequisites
- If you don't have already, install Android Studio, following the instructions on the website.
- You need an Android device and Android development environment with minimum API 21.
- Android Studio 3.2 or later.

### Building

- Open Android Studio, and from the Welcome screen, select Open an existing Android Studio project.
- Open Android Studio, and from the Welcome screen, select Open an existing Android Studio project.
- From the Open File or Project window that appears, navigate to and select the Object-Detection-using-TFlite-in-android directory from wherever you cloned the This Project GitHub repo. Click OK.
- If it asks you to do a Gradle Sync, click OK.
You may also need to install various platforms and tools, if you get errors like "Failed to find target with hash string 'android-21'" and similar. Click the Run button (the green arrow) or select Run > Run 'android' from the top menu. You may need to rebuild the project using Build > Rebuild Project.
- If it asks you to use Instant Run, click Proceed Without Instant Run.
Also, you need to have an Android device plugged in with developer options enabled at this point. See here for more details on setting up developer devices.


### Model used
Downloading, extraction and placing it in assets folder has been already done.

If you explicitly want to download the model, you can download from [here]. Extract the zip to get the .tflite and label file.

## Flowchrt:-

![Flowchart](https://github.com/sanky2501/Object-Detection-using-TFlite-in-android/blob/master/Flowchart.png)

### Additional Note
Please do not delete the assets folder content.
