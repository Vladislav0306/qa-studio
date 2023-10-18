import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ViewingTheBrandPhilosophyTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("110. Просмотр философии бренда")
    public void viewingTheBrandPhilosophy() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11003\"]").click();
        $x("//*[@class=\"razzi-svg-icon rz-swiper-button-next rz-swiper-button\"]").click();
        $x("//*[@class=\"razzi-svg-icon rz-swiper-button-next rz-swiper-button swiper-button-disabled\"]")
                .shouldBe(visible, Duration.ofSeconds(60)).shouldHave();
        $x("//*[@class=\"razzi-svg-icon rz-swiper-button-prev rz-swiper-button\"]").click();
        $x("//*[@class=\"razzi-svg-icon rz-swiper-button-prev rz-swiper-button swiper-button-disabled\"]")
                .shouldBe(visible, Duration.ofSeconds(60)).shouldHave();
    }
}
