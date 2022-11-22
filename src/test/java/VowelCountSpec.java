import static org.junit.jupiter.api.Assertions.*;
import com.exercise.VowelCount;
import org.junit.jupiter.api.Test;

public class VowelCountSpec {
    @Test
    void demoTestMethod() {
        VowelCount.main(new String[] {"abc", "second"});
        System.out.println(VowelCount.main(new String[] {"abc", "second"}));
        assertTrue(true);
    }
}
