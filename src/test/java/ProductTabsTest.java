import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductTabsTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("13. Просмотр бестселлеров")
    public void viewingBestsellers() {
        $x("//*[@class=\"tab-best_sellers \"]").click();
        $x("//*[@class=\"tab-best_sellers active\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Бестселлеры"));
    }

    @Test
    @DisplayName("14. Просмотр горячих товаров")
    public void viewingHotProducts() {
        $x("//*[@class=\"tab-featured \"]").click();
        $x("//*[@class=\"tab-featured active\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Горячие товары"));
    }

    @Test
    @DisplayName("15. Просмотр новых товаров")
    public void viewingNewtProducts() {
        $x("//*[@class=\"tab-new \"]").click();
        $x("//*[@class=\"tab-new active\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Новые товары"));
    }

    @Test
    @DisplayName("16. Просмотр товаров по распродаже")
    public void viewingProductsOnSale() {
        $x("//*[@class=\"tab-sale \"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Распродажа товаров"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/4
    }
}
