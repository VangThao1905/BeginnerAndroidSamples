package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ImplicitIntentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);
    }

    public void visitUrlAddress(View view) {
        Uri url = getUriToVisit();
        if (url != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(url);
            startActivity(intent);
        }
    }

    private Uri getUriToVisit() {
        String urlAddress = ((TextView) findViewById(R.id.txtUrlAddress)).getText().toString();
        if (urlAddress != null) {
            if (!urlAddress.startsWith("http://")) {
                urlAddress = "http://" + urlAddress;
            }
            return Uri.parse(urlAddress);
        } else {
            return null;
        }
    }
}