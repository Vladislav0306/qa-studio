import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SortingOfGoodsTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("17. Сортировка товаров по популярности")
    public void sortingProductsByPopularity() {
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").click();
        $x("//*[@href=\"https://testqastudio.me?orderby=popularity\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Сортировать по популярности"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/5
    }

    @Test
    @DisplayName("18. Сортировка товаров по среднему рейтингу")
    public void sortingProductsByAverageRating() {
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").click();
        $x("//*[@href=\"https://testqastudio.me?orderby=rating\"]").click();
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Сортировать по среднему рейтингу"));
    }

    @Test
    @DisplayName("19. Сортировка товаров по последним")
    public void sortingProductsByTheLatest() {
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").click();
        $x("//*[@href=\"https://testqastudio.me?orderby=date\"]").click();
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Сортировать по последним"));
    }

    @Test
    @DisplayName("20. Сортировка товаров по цене: от низкой к высокой")
    public void sortingGoodsByPriceFromLowToHigh() {
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").click();
        $x("//*[@href=\"https://testqastudio.me?orderby=price\"]").click();
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Сортировать по цене: от низкой к высокой"));
    }

    @Test
    @DisplayName("21. Сортировка товаров по цене: по возрастанию")
    public void sortingOfGoodsByPriceAscending() {
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").click();
        $x("//*[@href=\"https://testqastudio.me?orderby=price-desc\"]").click();
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Сортировать по цене: по возрастанию"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/6
    }

    @Test
    @DisplayName("22. Сброс сортировки товаров")
    public void resettingTheSortingOfGoods() {
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").click();
        $x("//*[@href=\"https://testqastudio.me?orderby=price-desc\"]").click();
        $x("//*[@class=\"remove-filtered\"]").click();
        $x("//*[@class=\"woocommerce-ordering__button-label\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("По умолчанию"));
    }
}
