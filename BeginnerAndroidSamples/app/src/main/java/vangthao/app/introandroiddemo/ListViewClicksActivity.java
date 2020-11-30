package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewClicksActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_clicks);

        String[] myCountrys = {"Vietnam", "United States", "Canada", "Mexico", "Japan"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myCountrys);

        ListView listView =findViewById(R.id.lvClickHandling);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = adapter.getItem(position);
                SimpleAlertDialog.displayWithOK(ListViewClicksActivity.this,country);
                Toast.makeText(ListViewClicksActivity.this, country, Toast.LENGTH_SHORT).show();
            }
        });
    }
}