import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class OtherProductFilteringChecksTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("45. Очистка фильтров")
    public void cleaningFilters() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[1]/span").click();
        $x("//*[@class=\"button alt reset-button button-lg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Очистить"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/13
    }

    @Test
    @DisplayName("46. Поиск товаров по нескольким критериям")
    public void searchForProductsBySeveralCriteria() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Каркас кровати']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Tada']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[2]/span").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@data-name=\"product_cat\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Каркас кровати"));
        $x("//*[@data-name=\"product_brand\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Tada"));
        $x("//*[@data-name=\"price\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Цена: 10,000.00 ₽ - 20,000.00 ₽"));
    }

    @Test
    @DisplayName("47. Поиск товаров по нескольким категориям")
    public void searchForProductsInSeveralCategories() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Диваны']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Журнальные столы']").click();
        $x("//*[@class=\"products-filter__option filter-checkboxes-item\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Диваны"));
        $x("//*[@class=\"products-filter__option filter-checkboxes-item selected\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Журнальные столы"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/14
    }

    @Test
    @DisplayName("48. Поиск товаров по нескольким брендам")
    public void searchForProductsInSeveralBrands() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Balmain']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Syma']").click();
        $x("//*[@class=\"products-filter__option filter-checkboxes-item\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Balmain"));
        $x("//*[@class=\"products-filter__option filter-checkboxes-item selected\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Syma"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/15
    }

    @Test
    @DisplayName("49. Поиск товаров по нескольким диапазонам цен")
    public void searchForProductsInSeveralPrices() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[1]/span").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[2]/span").click();
        $x("//*[@class=\"products-filter__option filter-ranges__item\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("1,000.00 ₽ - 10,000.00 ₽"));
        $x("//*[@class=\"products-filter__option filter-ranges__item selected\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("10,000.00 ₽ - 20,000.00 ₽"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/16
    }

    @Test
    @DisplayName("50. Поиск товаров по несуществующим критериям")
    public void searchForProductsByNonExistentCriteria() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter filter product_cat product_cat checkboxes products-filter--collapsible\"]").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Диваны']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@id=\"razzi-products-filter-1\"]/form/div[1]/div[4]/div/ul/li[1]/span").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"woocommerce-info woocommerce-no-products-found\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Товаров, соответствующих вашему запросу, не обнаружено."));
    }

    @Test
    @DisplayName("51. Закрытие формы фильтрации товаров")
    public void closingTheProductFilteringForm() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@id=\"catalog-filters-modal\"]/div[2]/div[1]/a/span").click();
        $x("//*[@class=\"text-filter\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Фильтр"));
    }

    @Test
    @DisplayName("52. Закрытие выпадающего списка категорий товаров")
    public void closingTheDropDownListOfProductCategories() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Категория']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Категория']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Категория']").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Категория"));
    }

    @Test
    @DisplayName("53. Закрытие выпадающего списка брендов товаров")
    public void closingTheDropDownListOfProductBrands() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Бренды"));
    }

    @Test
    @DisplayName("54. Закрытие выпадающего списка диапазонов цены")
    public void closingTheDropDownListOfPriceRanges() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Цена']").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Цена"));
    }

    @Test
    @DisplayName("55. Закрытие выпадающего списка сортировки товаров")
    public void closingTheDropDownListOfProductSorting() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Сортировать по']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Сортировать по']").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Сортировать по']").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Сортировать по"));
    }
}
