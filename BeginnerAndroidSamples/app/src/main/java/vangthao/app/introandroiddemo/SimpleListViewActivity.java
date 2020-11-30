package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        String[] myStringArray = {"VangThao", "VangThao1", "VangThao2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_view_item, myStringArray);
        ListView listView = findViewById(R.id.lvDemo);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_simple_list_view, menu);
        return super.onCreateOptionsMenu(menu);
    }
}