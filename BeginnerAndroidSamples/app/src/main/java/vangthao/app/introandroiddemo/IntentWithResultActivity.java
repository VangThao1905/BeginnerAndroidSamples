package vangthao.app.introandroiddemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class IntentWithResultActivity extends AppCompatActivity {

    static int GET_RESULT_TEXT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_result);
    }

    public void enterText(View view) {
        startActivityForResult(new Intent(IntentWithResultActivity.this, SimpleReturnResultActivity.class), GET_RESULT_TEXT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_RESULT_TEXT && resultCode == RESULT_OK && data != null) {
            TextView txtResult = findViewById(R.id.txtDisplayResult);
            txtResult.setText(data.getStringExtra("result"));
            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }
    }
}