package vangthao.app.introandroiddemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewDemoActivity extends AppCompatActivity {

    GridView gridViewImage;
    GridImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);
        populateGridViewImages();
    }

    private void populateGridViewImages() {
        gridViewImage = findViewById(R.id.gridViewImages);
        String[] numbers = new String[]{"ad", "ae", "af", "ag", "ai", "al"};
        adapter = new GridImageAdapter(this, android.R.layout.simple_list_item_1, numbers);
        gridViewImage.setAdapter(adapter);
    }

    class GridImageAdapter extends ArrayAdapter<String> {

        public GridImageAdapter(@NonNull Context context, int resource, String[] numbers) {
            super(context, resource, numbers);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ImageView imageView = new ImageView(GridViewDemoActivity.this);
            int resId = getResources().getIdentifier(getItem(position), "mipmap", getPackageName());
            imageView.setImageDrawable(getResources().getDrawable(resId));
            return imageView;
        }
    }
}