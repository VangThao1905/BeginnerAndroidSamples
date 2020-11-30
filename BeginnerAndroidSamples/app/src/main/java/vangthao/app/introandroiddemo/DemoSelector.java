package vangthao.app.introandroiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class DemoSelector extends AppCompatActivity {

    ExpandableListView elvChapters;
    ChaptersListAdapter elaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_selector);
        setChaptersListView();
    }

    private void setChaptersListView() {
        elvChapters = findViewById(R.id.elvChapters);
        elaAdapter = new ChaptersListAdapter();
        elvChapters.setAdapter(elaAdapter);
        elvChapters.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String exerciseTitle = (String) elaAdapter.getChild(groupPosition, childPosition);
                Class<? extends Activity> exerciseClass = elaAdapter.getExerciseClass(groupPosition, childPosition, id);
                if (exerciseClass != null) {
                    Toast.makeText(DemoSelector.this, exerciseTitle, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DemoSelector.this, exerciseClass));
                } else {
                    Toast.makeText(DemoSelector.this, "Exercise Not Available", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private class ChaptersListAdapter extends BaseExpandableListAdapter {
        private String[] chapters = getResources().getStringArray(R.array.chapters);
        private String[][] exercises;

        public ChaptersListAdapter() {
            super();
            exercises = new String[chapters.length][];
            for (int i = 0; i < exercises.length; i++) {
                int resID = getResources().getIdentifier("chap" + (i + 1), "array", getPackageName());
                exercises[i] = getResources().getStringArray(resID);
            }
        }

        @Override
        public int getGroupCount() {
            return chapters.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return exercises[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return "Chapter " + (groupPosition + 1) + ": " + chapters[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return exercises[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        public TextView getGenericView() {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView textView = new TextView(DemoSelector.this);
            textView.setLayoutParams(layoutParams);

            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(60, 20, 20, 20);
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setPadding(80, 20, 20, 20);
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public Class<? extends Activity> getExerciseClass(int groupPostion, int childPosition, long id) {
            String exerciseID = "chap" + (groupPostion + 1) + "ex" + (childPosition + 1);
            return ExerciseActivityMapper.getExerciseClass(exerciseID);
        }
    }
}