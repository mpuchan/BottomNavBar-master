package com.example.trevt.navigationbar.VrPanoramicView;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.trevt.navigationbar.R;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class tampilan360 extends AppCompatActivity {
    private VrPanoramaView panoWidgetView;
    private ImageLoaderTask backgroundImageLoaderTask;
    private String photo360;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan360);
        Bundle bundle = getIntent().getExtras();
        photo360= bundle.getString("photo360");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        panoWidgetView = (VrPanoramaView) findViewById(R.id.pano_view);
        loadPanoImage();
    }

    private synchronized void loadPanoImage() {
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "https://1.bp.blogspot.com/"+photo360;

        // create the task passing the widget view and call execute to start.
//        Glide.with(this).load(fotowis).into(gambar);
        task = new ImageLoaderTask(panoWidgetView, viewOptions,panoImageName);
        task.execute();
        backgroundImageLoaderTask = task;

    }
}
