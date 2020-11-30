package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        Button btnExplicitIntentClick = findViewById(R.id.btnExplicitIntentClick);

        btnExplicitIntentClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplicitIntentActivity.this, SimpleBundleDemoActivity.class);
                intent.putExtra("text", "Passed String Extra!");
                startActivity(intent);
            }
        });
    }
}