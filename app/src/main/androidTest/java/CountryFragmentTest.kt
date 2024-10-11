import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CountryDetailsFragmentTest {

    @Test
    public void testCountryDetailsDisplayed() {
        FragmentScenario.launchInContainer(CountryDetailsFragment.class);

        // Assuming the text view with country name has the ID country_name_textview
        Espresso.onView(ViewMatchers.withId(R.id.country_name_textview))
                .check(ViewAssertions.matches(withText("USA")));
    }
}
@RunWith(AndroidJUnit4.class)
public class CountryFragmentTest {

    @Test
    public void testCountryListDisplayed() {
        FragmentScenario.launchInContainer(CountryFragment.class);

        // Assuming the RecyclerView for countries has the ID countries_recycler_view
        Espresso.onView(ViewMatchers.withId(R.id.countries_recycler_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
