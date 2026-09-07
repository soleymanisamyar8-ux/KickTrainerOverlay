package com.kicktraineroverlay;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class OverlayService extends Service {

    private WindowManager windowManager;
    private View overlayView;

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        TextView guide = new TextView(this);
        guide.setText("Kick Trainer");
        guide.setTextColor(Color.WHITE);
        guide.setTextSize(16);
        guide.setGravity(Gravity.CENTER);
        guide.setBackgroundColor(0x66000000);
        guide.setPadding(20, 10, 20, 10);

        overlayView = guide;

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        params.y = 100;

        windowManager.addView(overlayView, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (overlayView != null) {
            windowManager.removeView(overlayView);
            overlayView = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
