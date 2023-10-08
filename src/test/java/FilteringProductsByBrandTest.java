import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FilteringProductsByBrandTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("32. Просмотр дивана с брендом \"Balmain\"")
    public void viewingASofaWithTheBrandBalmain() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Balmain']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Balmain"));
    }

    @Test
    @DisplayName("33. Просмотр товаров с брендом \"Rannar\"")
    public void viewingProductsWithTheRannarBrand() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='rannar']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("rannar"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/11
    }

    @Test
    @DisplayName("34. Просмотр подвесного светильника с брендом \"Syma\"")
    public void viewingAPendantLampWithTheBrandSyma() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Syma']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Syma"));
    }

    @Test
    @DisplayName("35. Просмотр товаров с брендом \"Tada\"")
    public void viewingProductsWithTheTadaBrand() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Tada']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Tada"));
    }

    @Test
    @DisplayName("36. Поиск бренда для фильтрации товаров")
    public void searchForABrandToFilterProducts() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"search-field\"]").setValue("Tada");
        $x("//*[@class=\"products-filter__option-name name\" and text()='Tada']").shouldHave();
    }

    @Test
    @DisplayName("37. Поиск несуществующего бренда для фильтрации товаров")
    public void searchForANonExistentBrandToFilterProducts() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"search-field\"]").setValue("Tadd");
        $x("//*[@class=\"products-filter__option-name name\" and text()='Tada']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Syma']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='rannar']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Balmain']").shouldNotHave();
    }

    @Test
    @DisplayName("38. XSS-инъекция в строке поиска бренда для фильтрации товаров")
    public void XSSInjectionInTheBrandSearchBarToFilterProducts() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"search-field\"]").setValue("<script>alert(123)</script>");
        $x("//*[@class=\"products-filter__option-name name\" and text()='Tada']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Syma']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='rannar']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Balmain']").shouldNotHave();
    }

    @Test
    @DisplayName("39. SQL-инъекция в строке поиска бренда для фильтрации товаров")
    public void SQLInjectionInTheBrandSearchBarToFilterProducts() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"search-field\"]").setValue("1 or sleep(5)#");
        $x("//*[@class=\"products-filter__option-name name\" and text()='Tada']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Syma']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='rannar']").shouldNotHave();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Balmain']").shouldNotHave();
    }

    @Test
    @DisplayName("40. Сброс бренда товара")
    public void resetTheProductBrand() {
        $x("//*[@class=\"text-filter\"]").click();
        $x("//*[@class=\"products-filter__filter-name filter-name\" and text()='Бренды']").click();
        $x("//*[@class=\"products-filter__option-name name\" and text()='Balmain']").click();
        $x("//*[@class=\"button filter-button\"]").click();
        $x("//*[@class=\"remove-filtered\"]").click();
        $x("//*[@href=\"https://testqastudio.me/home/\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Все"));
    }
}


