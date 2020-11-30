package vangthao.app.introandroiddemo;

import android.app.Activity;
import android.widget.ExpandableListView;

import java.util.HashMap;

public class ExerciseActivityMapper {
    private static ExerciseActivityMapper singleton;
    private HashMap<String, Class<? extends Activity>> exerciseClassMap;

    public ExerciseActivityMapper() {
        defineExercieMappings();
    }

    public static Class<? extends Activity> getExerciseClass(String exerciseId) {
        return getSingleton().exerciseClassMap.get(exerciseId);
    }

    private static ExerciseActivityMapper getSingleton() {
        if (singleton == null) {
            singleton = new ExerciseActivityMapper();
        }
        return singleton;
    }

    private void defineExercieMappings() {
        exerciseClassMap = new HashMap<String, Class<? extends Activity>>();
        //Chapter 1: App Fundamentals
        exerciseClassMap.put("chap1ex1", BasicTextViewActivity.class);
        //Chapter 2:User interface
        exerciseClassMap.put("chap2ex1", LinnearLayoutDemoActivity.class);
        //Chapter 3: View controls
        exerciseClassMap.put("chap3ex1", LayoutGravityActivity.class);
        exerciseClassMap.put("chap3ex2", BasicViewsActivity.class);
        exerciseClassMap.put("chap3ex3", ViewAttributesActivity.class);
        exerciseClassMap.put("chap3ex4", SimpleListViewActivity.class);

        //Chapter 4: User Interactions
        exerciseClassMap.put("chap4ex1", BasicClickHandlersActivity.class);
        exerciseClassMap.put("chap4ex2", ListViewClicksActivity.class);

        //Chapter 5: User Flows
        exerciseClassMap.put("chap5ex1", ExplicitIntentActivity.class);
        exerciseClassMap.put("chap5ex2", ImplicitIntentsActivity.class);
        exerciseClassMap.put("chap5ex3", IntentWithResultActivity.class);
        exerciseClassMap.put("chap5ex4", ActionBarMenuActivity.class);

        //Chapter 6: Networking
        exerciseClassMap.put("chap6ex1", BasicImageDownoadActivity.class);
        exerciseClassMap.put("chap6ex2", AsyncTaskPerformActivity.class);


    }
}
