import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("1. Переход на главную страницу через логотип")
    public void goToTheMainPageViaTheLogo() {
        $x("//*[@class=\"logo-dark\"]").click();
        $x("//*[@class=\"razzi-slide-heading\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Ваза в стиле минимализм"));
    }

    @Test
    @DisplayName("2. Переход в каталог")
    public void goToTheCatalog() {
        $x("//*[@href=\"https://testqastudio.me\"]").click();
        $x("//*[@class=\"razzi-slide-heading\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Ваза в стиле минимализм"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/1
    }

    @Test
    @DisplayName("3. Переход на страницу часто задаваемых вопросов")
    public void goToTheFrequentlyAskedQuestionsPage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11088\"]").click();
        $x("//*[@class=\"page-header__title \"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Часто задавамые вопросы"));
    }

    @Test
    @DisplayName("4. Переход на страницу блога")
    public void goToTheBlogPage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@class=\"page-header__title \"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Блог"));
    }

    @Test
    @DisplayName("5. Переход на страницу \"О компании\"")
    public void goToTheAboutTheCompanyPage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11003\"]").click();
        $x("//*[@class=\"page-header__title \"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("О компании"));
    }

    @Test
    @DisplayName("6. Переход на страницу контактов")
    public void goToTheContactPage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[@class=\"page-header__title \"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Контакты"));
    }

    @Test
    @DisplayName("7. Переход в форму поиска")
    public void goingToTheSearchForm() {
        $x("//*[@class=\"search-icon\"]").click();
        $x("//*[@selected=\"selected\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Все категории"));
    }

    @Test
    @DisplayName("8. Переход на страницу списка желаний при отсутствии товаров")
    public void goToTheWishListPageIfThereAreNoProducts() {
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"wishlist-items-wrapper\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("В списке желаний нет ни одного товара"));
    }

    @Test
    @DisplayName("9 Переход в корзину при отсутствии товаров")
    public void goToTheShoppingCartIfThereAreNoProducts() {
        $x("//*[@class=\"razzi-svg-icon icon-cart\"]").click();
        $x("//*[@class=\"cart-panel-counter\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("(0)"));
        $x("//*[@class=\"razzi-button button-outline button-larger\"]").click();
        $x("//*[@class=\"razzi-slide-heading\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Ваза в стиле минимализм"));
    }
}
