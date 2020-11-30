package vangthao.app.introandroiddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_menu);
        getSupportActionBar().setTitle("Click  an Icon");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_toat:
                Toast.makeText(this, "Toasted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_launch:
                Intent intent = new Intent(this, SimpleBundleDemoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }
}