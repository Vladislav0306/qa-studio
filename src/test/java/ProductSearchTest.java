import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProductSearchTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("119. Поиск товара")
    public void productSearch() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@placeholder=\"Поиск предметов\"]").setValue("ТАРДИС");
        $x("//*[@class=\"search-submit\"]").click();
        $x("//*[@class=\"product_title entry-title\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("ТАРДИС Скамья"));
    }

    @Test
    @DisplayName("120. Поиск несуществующего товара")
    public void searchForANonExistentProduct() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@placeholder=\"Поиск предметов\"]").setValue("ТАРДИЗ");
        $x("//*[@class=\"search-submit\"]").click();
        $x("//*[@class=\"woocommerce-info woocommerce-no-products-found\"]").shouldBe(visible, Duration.ofSeconds(60))
                .shouldHave(exactText("Товаров, соответствующих вашему запросу, не обнаружено."));
    }

    @Test
    @DisplayName("121. Пустая строка при поиске товара")
    public void emptyLineWhenSearchingForAProduct() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@class=\"search-submit\"]").click();
        $x("//*[@class=\"razzi-slide-heading\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Ваза в стиле минимализм"));
    }

    @Test
    @DisplayName("122. XSS-инъекция при поиске товара")
    public void XSSInjectionWhenSearchingForAProduct() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@placeholder=\"Поиск предметов\"]").setValue("<script>alert(123)</script>");
        $x("//*[@class=\"search-submit\"]").click();
        $x("//*[@class=\"woocommerce-info woocommerce-no-products-found\"]").shouldBe(visible, Duration.ofSeconds(60))
                .shouldHave(exactText("Товаров, соответствующих вашему запросу, не обнаружено."));
    }

    @Test
    @DisplayName("123. SQL-инъекция при поиске товара")
    public void SQLInjectionWhenSearchingForAProduct() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@placeholder=\"Поиск предметов\"]").setValue("1 or sleep(5)#");
        $x("//*[@class=\"search-submit\"]").click();
        $x("//*[@class=\"woocommerce-info woocommerce-no-products-found\"]").shouldBe(visible, Duration.ofSeconds(60))
                .shouldHave(exactText("Товаров, соответствующих вашему запросу, не обнаружено."));
    }

    @Test
    @DisplayName("124. Выбор категории для поиска товара")
    public void choosingACategoryToSearchForAProduct() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@selected=\"selected\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Все категории"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/30
    }
}
