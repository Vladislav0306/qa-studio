import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PresentationOfProductsTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("10. Просмотр товаров на презентации на главной странице")
    public void viewingProductsOnThePresentationOnTheMainPage() {
        $x("//*[@aria-label=\"Go to slide 2\"]").click();
        $x("//*[@aria-label=\"Go to slide 1\"]").click();
        $x("//*[@class=\"razzi-slide-heading\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Ваза в стиле минимализм"));
    }

    @Test
    @DisplayName("11. Покупка вазы в стиле минимализм через презентацию")
    public void buyingAMinimalisticVaseThroughAPresentation() {
        $x("//*[@class=\"button-text razzi-button\"]").click();
        $x("//*[@jsselect=\"heading\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Не удается получить доступ к сайту"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/2
    }

    @Test
    @DisplayName("12. Покупка подвесного светильника через презентацию")
    public void purchaseOfAPendantLampThroughAPresentation() {
        $x("//*[@aria-label=\"Go to slide 2\"]").click();
        $x("//*[@class=\"button-text razzi-button\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Купить сейчас "));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/3
    }
}
