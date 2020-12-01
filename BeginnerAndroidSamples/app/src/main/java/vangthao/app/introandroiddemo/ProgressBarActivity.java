package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.server.http.HttpStatus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtResult;
    ArrayList<String> lines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        loadViews();
    }

    private void loadViews() {
        progressBar = findViewById(R.id.pgDowloading);
        txtResult = findViewById(R.id.txtUrlOutput);
    }

    public void startFourUrlAsync(View view) {
        new DelayTask().execute();
    }

    public class DelayTask extends AsyncTask<Void, Integer, String> {
        int count = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... voids) {
            String res = loadUrlBody("http://google.com");
            lines.add(res.split("\n")[0]);
            publishProgress(25);

            res  = loadUrlBody("http://yahoo.com");
            lines.add(res.split("\n")[0]);
            publishProgress(50);

            res  = loadUrlBody("http://twitter.com");
            lines.add(res.split("\n")[0]);
            publishProgress(75);
            res  = loadUrlBody("http://facebook.com");
            lines.add(res.split("\n")[0]);
            publishProgress(100);
            return "complete";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ProgressBarActivity.this, "Complete!", Toast.LENGTH_SHORT).show();
            txtResult.setText(lines.toString());
        }

        protected String loadUrlBody(String adress) {
            OkHttpClient httpClient = new OkHttpClient();
            Response response;
            String responseString = null;
            try {
                response = httpClient.newCall(new Request.Builder().url(adress).build()).execute();
                int statusCode = response.code();
                if (statusCode == HttpStatus.HTTP_OK) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    outputStream.write(response.body().bytes());
                    responseString = outputStream.toString();
                    outputStream.close();
                }
            } catch (IOException e) {
                Log.e(ProgressBarActivity.class.getSimpleName(), "Error retrieving data form: " + adress, e);
            }

            return responseString;
        }
    }
}