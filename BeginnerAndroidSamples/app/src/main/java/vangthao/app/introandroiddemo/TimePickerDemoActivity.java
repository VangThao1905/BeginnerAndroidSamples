package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerDemoActivity extends AppCompatActivity {

    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_demo);

        loadViews();
    }

    private void loadViews() {
        timePicker = findViewById(R.id.timePicker);
    }

    public void displayTime(View view) {
        String time = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
    }
}