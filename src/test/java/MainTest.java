import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class MainTest {
    @Test
    @Disabled
    void whenAssertingTimeout(){
        Assertions.assertTimeout(Duration.ofSeconds(10), ()->Main.main(null));
    }
}
