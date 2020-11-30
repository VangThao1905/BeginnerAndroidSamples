package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class BasicClickHandlersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_click_handlers);
        Button secondButton = findViewById(R.id.btnClick2);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondButtonClicked(v);
            }
        });
    }

    private void secondButtonClicked(View view) {
        SimpleAlertDialog.displayWithOK(this, "secondButton clicked via Java handler in onCreate");
    }

    public void firstButtonClicked(View view) {
        SimpleAlertDialog.displayWithOK(this, "firstButton clicked via XML handler");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_basic_click_handlers, menu);
        return true;
    }
}