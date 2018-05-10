package systemoutgames;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LocationTest {

    @Test
    public void getShipDirectionTest() throws Exception {
        Location location = new Location(1,2, Direction.HORIZONTAL);

        int result = location.getXValueFromString('A');

        assertThat(result, equalTo(1));
    }
}
