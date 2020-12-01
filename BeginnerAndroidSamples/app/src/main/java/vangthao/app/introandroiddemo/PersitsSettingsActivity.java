package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PersitsSettingsActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView txtPersist;
    CheckBox cbPersist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persits_settings);

        loadViews();
    }

    private void loadViews() {
        txtPersist = findViewById(R.id.txtPersistText);
        cbPersist = findViewById(R.id.cbPersistState);
        sharedPreferences = getSharedPreferences("view",0);
        editor =sharedPreferences.edit();
        populateValues();
    }

    private void populateValues() {
        String persistText = sharedPreferences.getString("txtVal","None Stored Yet");
        boolean isChecked = sharedPreferences.getBoolean("chkState",false);
        txtPersist.setText(persistText);
        cbPersist.setChecked(isChecked);
    }

    public void persistValue(View view) {
        editor.putString("txtVal",txtPersist.getText().toString());
        editor.putBoolean("chkState",cbPersist.isChecked());
        editor.commit();
        Toast.makeText(this, "Persisted!", Toast.LENGTH_SHORT).show();
    }
}