package es.jcs.subjects.pmdm.helloworld_android;

import static org.junit.Assert.assertEquals;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testButtonClick() {
        activityRule.getScenario()
                .onActivity(activity -> {
                    // Verificar que el TextView está inicialmente oculto
                    assertEquals("El TextView debería estar inicialmente oculto",
                            View.GONE, activity.findViewById(R.id.textBtnClicked).getVisibility());

                    // Simulamos el clic en el botón
                    activity.findViewById(R.id.btnClickMe).performClick();

                    // Verificar que el TextView se hace visible después del clic
                    assertEquals("El TextView debería ser visible después del clic",
                            View.VISIBLE, activity.findViewById(R.id.textBtnClicked).getVisibility());
                }
        );
    }

}
