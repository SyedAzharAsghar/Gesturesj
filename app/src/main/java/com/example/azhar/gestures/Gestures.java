package com.example.azhar.gestures;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;

import java.io.IOException;

import static android.os.Build.VERSION.SDK_INT;

public class Gestures extends AppCompatActivity implements GestureDetector.OnGestureListener,
        SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;
    private int heightdp;
    private int widthdp;
    private static final int SWIPE_THRESHOLD = 120;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static final int SWIPE_VELOCITY_THRESHOLD = 200;
    LinearLayout brightShowLayout, volShowLayout, seekTouchLayout;
    private Toolbar toolbar;
    int brightprogress, volprogess, volconvert;
    SurfaceView surfaceView;
    private ScaleGestureDetector mScaleGestureDetector;
    android.view.ViewGroup.LayoutParams lp;
    private int MIN_WIDTH = 100;
    SurfaceHolder mSurfaceHolder;
    private MediaPlayer mMediaPlayer;
    private String videoPath;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    String uriPath2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                  uriPath2 = "android.resource://com.example.azhar.gestures/"+R.raw.mo;

//        videoPath = "/storage/emulated/0/zapya/video/[Hon3y] Ek Villain---Awari.mkv";

        getWindow().setFormat(PixelFormat.UNKNOWN);

        surfaceView = (SurfaceView) findViewById(R.id.videoView);
         mSurfaceHolder = surfaceView.getHolder();
        mSurfaceHolder.addCallback(Gestures.this);
        mSurfaceHolder.setFixedSize(176, 144);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        heightdp = displayMetrics.heightPixels;
        widthdp = displayMetrics.widthPixels;
        System.out.println(widthdp + "\\" + heightdp);
        System.out.println(widthdp / 2);

// Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this, this);
        mScaleGestureDetector = new ScaleGestureDetector(this, new MyScaleGestureListener());


//        checkPermission();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() > 1) {
            this.mScaleGestureDetector.onTouchEvent(event);
        } else {
            this.mDetector.onTouchEvent(event);
        }
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {

        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        float deltaY = event2.getY() - event1.getY();
        float deltaX = event2.getX() - event1.getX();

        System.out.println(deltaY + "//" + deltaX);
//        if (Math.abs(deltaX) > Math.abs(deltaY)) {
//            if (Math.abs(deltaX) > SWIPE_THRESHOLD) {
////                    listener.onHorizontalScroll(e2, deltaX);
//                if (deltaX > 0) {
////                    onScrollRight();
////                        Log.i("", "Slide right");
//                } else {
////                    onScrollLeft();
////                        Log.i("", "Slide left");
//                }
//            }
//        } else {
//            if (Math.abs(deltaY) > SWIPE_THRESHOLD) {
////                    listener.onVerticalScroll(e2, deltaY);
//                if (deltaY > 0) {
////                    onScrollDown();
//                    Log.i("", "Slide down");
//                } else {
////                    onScrollUp();
//                    Log.i("", "Slide up");
//                }
//            }
//        }


        System.out.println("event1X" + "//" + event1.getX());
        System.out.println("event2X" + "//" + event2.getX());
        System.out.println("event1Y" + "//" + event1.getY());
        System.out.println("event2Y" + "//" + event2.getY());
        System.out.println("deltaY" + deltaY);
        System.out.println("deltaX" + deltaX);
        float halfwidth = widthdp / 2;
        System.out.println("widthdphalf" + halfwidth);
        if (event1.getX() < halfwidth) {
            System.out.println("halfwidth" + event1.getX());
            if (Math.abs(deltaX) > Math.abs(deltaY)) {
                if (Math.abs(deltaX) > SWIPE_THRESHOLD) {
//                    listener.onHorizontalScroll(e2, deltaX);
                    if (deltaX > 0) {
//                    onScrollRight();
                        Log.i("", "Slide right");
                    } else {
//                    onScrollLeft();
                        Log.i("", "Slide left");
                    }
                }

            } else {
                if (Math.abs(deltaY) > SWIPE_THRESHOLD) {
//                    listener.onVerticalScroll(e2, deltaY);
                    if (deltaY > 0) {
//                    onScrollDown();
                        Log.i("", "Slide down");
                    } else {
//                    onScrollUp();
                        Log.i("", "Slide up");
                    }
                }
            }
        } else {
            System.out.println("nexthalfwidth" + event1.getX());
            if (Math.abs(deltaX) > Math.abs(deltaY)) {
                if (Math.abs(deltaX) > SWIPE_THRESHOLD) {
//                    listener.onHorizontalScroll(e2, deltaX);
                    if (deltaX > 0) {
//                    onScrollRight();
                        Log.i("", "Slide right");
                    } else {
//                    onScrollLeft();
                        Log.i("", "Slide left");
                    }
                }

            } else {
                if (Math.abs(deltaY) > SWIPE_THRESHOLD) {
//                    listener.onVerticalScroll(e2, deltaY);
                    if (deltaY > 0) {
//                    onScrollDown();
                        Log.i("", "Slide down");
                    } else {
//                    onScrollUp();
                        Log.i("", "Slide up");
                    }
                }
            }
        }
        Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setDisplay(mSurfaceHolder);
        try {
            mMediaPlayer.setDataSource(uriPath2);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(Gestures.this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }


    private class MyScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        private int mW, mH;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            // scale our video view
            mW *= detector.getScaleFactor();
            mH *= detector.getScaleFactor();
            if (mW < 250 && mH < 250) { // limits width
                mW = surfaceView.getWidth();
                mH = surfaceView.getHeight();
            } else if (mH == 2000) {
                mH = 2000;
            }
            Log.d("onScale", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
            lp = surfaceView.getLayoutParams();
            lp.height = mH;
            lp.width = mW;
            surfaceView.setLayoutParams(lp);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            mW = surfaceView.getWidth();
            mH = surfaceView.getHeight();
            Log.d("onScaleBegin", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
//            Log.d("onScaleEnd", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
        }

    }

    @Override
    public void onPrepared(MediaPlayer mp) {

        mMediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    protected void checkPermission() {
        if (SDK_INT >= Build.VERSION_CODES.M) {
            if (Gestures.this.checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    // Show an alert dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(Gestures.this);
                    builder.setMessage("Read external storage permission is required.");
                    builder.setTitle("Please grant permission");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(
                                    Gestures.this,
                                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                            );
                        }
                    });
                    builder.setNeutralButton("Cancel", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    // Request permission
                    ActivityCompat.requestPermissions(
                            Gestures.this,
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                    );
                }
            } else {
                // Permission already granted
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
//                    init_phone_music_grid();
                } else {
                    // Permission denied
                }
            }
        }
    }

}