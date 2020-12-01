package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerWithToastActivity extends AppCompatActivity {

    Spinner spinnerOptions;
    Button btnSpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_with_toast);

        loadViews();
        loadSpinner();
    }

    private void loadSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);
    }

    private void loadViews() {
        spinnerOptions = findViewById(R.id.spinnerOptions);
        btnSpinnerValue = findViewById(R.id.btnSpinnerValue);
    }

    public void displayValue(View view) {
        Toast.makeText(this, spinnerOptions.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }
}