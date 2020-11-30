package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class BasicTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_text_view);
        Log.d("DEBUG", "onCreate was  just  called!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEBUG", "onResum was  just  called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DEBUG", "onPause was  just  called!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_basic_text_view, menu);
        return true;
    }
}