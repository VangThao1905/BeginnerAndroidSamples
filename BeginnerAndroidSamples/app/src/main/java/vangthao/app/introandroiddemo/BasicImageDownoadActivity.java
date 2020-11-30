package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BasicImageDownoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_image_downoad);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        downLoadImageFromUrl("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G");
    }

    private void downLoadImageFromUrl(String address) {
        URL url;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            url = null;
        }


        URLConnection urlConnection;
        InputStream inputStream;
        Bitmap bitmap;

        try {
            urlConnection = url.openConnection();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (IOException e) {
            bitmap = null;
        }

        if (bitmap != null) {
            ImageView imageView = findViewById(R.id.imgViewBasicImage);
            imageView.setImageBitmap(bitmap);
        }

    }
}