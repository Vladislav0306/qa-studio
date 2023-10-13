import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PublicationTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }
}
