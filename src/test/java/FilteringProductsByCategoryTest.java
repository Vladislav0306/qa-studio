import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FilteringProductsByCategoryTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("23. Просмотр диванов")
    public void viewingSofas() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Диваны']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Диваны"));
    }

    @Test
    @DisplayName("24. Просмотр журнальных столов")
    public void viewingCoffeeTables() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Журнальные столы']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Журнальные столы"));
    }

    @Test
    @DisplayName("25. Просмотр вазы")
    public void viewingAVase() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Интерьер']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Вазы']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Вазы"));
    }

    @Test
    @DisplayName("26. Просмотр каркаса кровати")
    public void viewingTheBedFrame() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Каркас кровати']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Каркас кровати"));
    }

    @Test
    @DisplayName("27. Просмотр стульев и кресла")
    public void viewingChairsAndArmchairs() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Кресло']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Стулья']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Стулья"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/7
    }

    @Test
    @DisplayName("28. Просмотр подвесных светильников")
    public void viewingPendantLights() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Подвесные светильники']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Подвесные светильники"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/8
    }

    @Test
    @DisplayName("29. Просмотр тумб")
    public void viewingCurbstones() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Тумбы']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Тумбы"));
    }

    @Test
    @DisplayName("30. Просмотр товаров для хранения")
    public void viewingGoodsForStorage() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Хранение']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Хранение"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/9
    }

    @Test
    @DisplayName("31. Сброс категории товара")
    public void resetTheProductCategory() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Хранение']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").click();
        $x("//*[@class=\"meta-cat\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Тумбы"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/10
    }
}
