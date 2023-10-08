import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FilteringProductsByPriceTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("41. Просмотр товаров с ценой от 1000 до 10000 рублей")
    public void viewingProductsWithAPriceFrom1000To10000Rubles() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[1]/span").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Цена: 1,000.00 ₽ - 10,000.00 ₽"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/12
    }

    @Test
    @DisplayName("42. Просмотр товаров с ценой от 10000 до 20000 рублей")
    public void viewingProductsWithAPriceFrom10000To20000Rubles() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[2]/span").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Цена: 10,000.00 ₽ - 20,000.00 ₽"));
    }

    @Test
    @DisplayName("43. Просмотр товаров с ценой от 20000 до 30000 рублей")
    public void viewingProductsWithAPriceFrom20000To30000Rubles() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[3]/span").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Цена: 20,000.00 ₽ - 30,000.00 ₽"));
    }

    @Test
    @DisplayName("44. Сброс цены товара")
    public void resetTheProductPrice() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[3]/span").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").click();
        $x("//*[@href=\"https://testqastudio.me/home/\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Все"));
    }
}
