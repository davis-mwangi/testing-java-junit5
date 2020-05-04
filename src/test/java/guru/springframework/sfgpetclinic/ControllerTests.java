package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("controller")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTests {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Lets do something here before everything is called");
    }
}
