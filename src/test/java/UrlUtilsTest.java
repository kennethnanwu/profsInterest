import org.junit.Test;
import utils.UrlUtils;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by nan on 2016-12-26.
 */
public class UrlUtilsTest {

    @Test
    public void removePeoplePageTest() {
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, UrlUtils.removePeoplePage(null));
        assertEquals(expected, UrlUtils.removePeoplePage(new ArrayList<String>()));
    }


}
