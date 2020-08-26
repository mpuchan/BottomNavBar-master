package com.example.trevt.navigationbar.VrPanoramicView;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoaderTask extends AsyncTask<String, Void, Bitmap> {
    private static final String TAG = "ImageLoaderTask";
    private String mUrl;
    private String assetName;
    private WeakReference<VrPanoramaView> viewReference;
    private VrPanoramaView.Options viewOptions;
    private static WeakReference<Bitmap> lastBitmap = new WeakReference<>(null);
    private static String lastName;
    public ImageLoaderTask(String url) {
        mUrl = url;
    }
    @Override
    protected Bitmap doInBackground(String ... params) {
//        final String url = mUrl;
        if (lastBitmap.get() != null) {
            return lastBitmap.get();
        }
//        ImageLoaderTask loadBitmap = new ImageLoaderTask();
//        loadBitmap.execute("http://www.example.com/path/to/image");

        try {
            URL url1 = new URL(assetName);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            lastBitmap = new WeakReference<>(myBitmap);
            return myBitmap;


//        try(InputStream istr = assetManager.open(assetName)) {
//
//            Bitmap b = BitmapFactory.decodeStream(istr);

//            lastName = assetName;
//            return b;
        } catch (IOException e) {
            Log.e(TAG, "Could not decode default bitmap: " + e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        final VrPanoramaView vw = viewReference.get();
        if (vw != null && bitmap != null) {
            vw.loadImageFromBitmap(bitmap, viewOptions);
        }
    }


    public ImageLoaderTask(VrPanoramaView view, VrPanoramaView.Options viewOptions,String assetName) {
        viewReference = new WeakReference<>(view);
        this.viewOptions = viewOptions;
        this.assetName = assetName;


    }
}
