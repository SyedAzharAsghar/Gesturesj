//package com.example.azhar.gestures;//package com.example.azhar.playerapp;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.ScaleGestureDetector;
//import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//
//
//public class ResizeVideo extends AppCompatActivity {
//    // minimum video view width
//    static final int MIN_WIDTH = 100;
//    // Root view's LayoutParams
//    private FrameLayout.LayoutParams mRootParam;
//
//    FrameLayout contain;
//    // Custom Video View
//    private VodView mVodView;
//    // detector to pinch zoom in/out
//    private ScaleGestureDetector mScaleGestureDetector;
//    // detector to single tab
//    private GestureDetector mGestureDetector;
//    float initialX, initialY;
//    private String TAG = ResizeVideo.class.getSimpleName();
//
//    LinearLayout equal;
//    Button show;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_resize_video);
//
//
//
//        mScaleGestureDetector = new ScaleGestureDetector(this, new MyScaleGestureListener());
//        mGestureDetector = new GestureDetector(this, new MySimpleOnGestureListener());
//
//
//        contain = (FrameLayout)findViewById(R.id.container);
//
//        mRootParam = (FrameLayout.LayoutParams) ((View) findViewById(R.id.root_view)).getLayoutParams();
//        mVodView = (VodView) findViewById(R.id.vodView1);
//        // Video Uri
////        mVodView.seekTo(pos);
//        mVodView.start();
////        mVodView.setZOrderOnTop(true);
//
////        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mo);
//        mVodView.setVideoURI(uri);
//        // set up gesture listeners
////        Seek(Orientation.HORIZONTAL,mVodView);
////        Volume(Orientation.VERTICAL);
////        Brightness(Orientation.VERTICAL);
////        disableSeek();
////        set(this);
//
////        mVodView.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                xx = (int)event.getX();
////                yy = (int)event.getY();
////                switch (event.getAction()) {
////                    case MotionEvent.ACTION_DOWN: // нажатие
////                        sDown = xx + yy;
////                        start = sDown;
////                        move = false;
////                        break;
////                    case MotionEvent.ACTION_MOVE: // движение
////                        sMove = xx + yy;
////
////
////                        break;
////                    case MotionEvent.ACTION_UP: // отпускание
////                        sUp = xx + yy;
////                        move = false;
////                        break;
////                }
////                tv.setText(sDown + "\n" + sMove + "\n" + sUp);
////                return true;
////        }
////    });
////
////
//
//
////        contain.setOnTouchListener(new OnSwipeTouchListener(this) {
////
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                mGestureDetector.onTouchEvent(event);
////                mScaleGestureDetector.onTouchEvent(event);
////                return true;
////            }
////
////
////        });
//    }
//
//    private class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {
//        private static final int SWIPE_THRESHOLD = 120;
//        private static final int SWIPE_VELOCITY_THRESHOLD = 800;
//
//        @Override
//        public boolean onSingleTapConfirmed(MotionEvent e) {
//            if (mVodView == null)
//                return false;
//            if (mVodView.isPlaying())
//                mVodView.pause();
//            else
//                mVodView.start();
//            return true;
//        }
//
////        @Override
////        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
////
////            float deltaY = e2.getY() - e1.getY();
////            float deltaX = e2.getX() - e1.getX();
////
////            if (Math.abs(deltaX) > Math.abs(deltaY)) {
////                if (Math.abs(deltaX) > SWIPE_VELOCITY_THRESHOLD) {
//////                    listener.onHorizontalScroll(e2, deltaX);
////                    if (deltaX > 0) {
////                        Log.i("", "Slide right");
////                    } else {
////                        Log.i("", "Slide left");
////                    }
////                }
////            } else {
////                if (Math.abs(deltaY) > SWIPE_VELOCITY_THRESHOLD) {
//////                    listener.onVerticalScroll(e2, deltaY);
////                    if (deltaY > 0) {
////
////                        Log.i("", "Slide down");
////                    } else {
////
////                        Log.i("", "Slide up");
////                    }
////                }
////            }
////            return false;
////        }
//
//        // these constants are used for onFling
//        private static final int SWIPE_MIN_DISTANCE = 120;
//        private static final int SWIPE_MAX_OFF_PATH = 250;
//        private static final int SWIPE_THRESHOLD_VELOCITY = 200;
//
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
//                               float velocityY) {
//
//            Log.e("Event", "onFling");
//            Log.e("Flags", "Flags: " + e1.getEdgeFlags());
//
//            if (e1.getEdgeFlags() == MotionEvent.EDGE_LEFT) {
//                // code to handle swipe from left edge
//                Log.e("!!!!!", "Edge fling!");
//
//            }
//
//            try {
//                // do not do anything if the swipe does not reach a certain length
//                // of distance
//                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
//                    return false;
//
//                // right to left swipe
//                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
//                        && Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY) {
//
//                }
//                // left to right swipe
//                else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
//                        && Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY) {
//
//                }
//            } catch (Exception e) {
//                // nothing
//            }
//            return false;
//
//        }
//
//    }
//
//    private class MyScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
//        private int mW, mH;
//
//        @Override
//        public boolean onScale(ScaleGestureDetector detector) {
//            // scale our video view
//            mW *= detector.getScaleFactor();
//            mH *= detector.getScaleFactor();
//            if (mW < MIN_WIDTH) { // limits width
//                mW = mVodView.getWidth();
//                mH = mVodView.getHeight();
//            }
//            Log.d("onScale", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
//            mVodView.setFixedVideoSize(mW, mH); // important
//            mRootParam.width = mW;
//            mRootParam.height = mH;
//            return true;
//        }
//
//        @Override
//        public boolean onScaleBegin(ScaleGestureDetector detector) {
//            mW = mVodView.getWidth();
//            mH = mVodView.getHeight();
//            Log.d("onScaleBegin", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
//            return true;
//        }
//
//        @Override
//        public void onScaleEnd(ScaleGestureDetector detector) {
////            Log.d("onScaleEnd", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
//        }
//
//    }
//
//
//}
//
