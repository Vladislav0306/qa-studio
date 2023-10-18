import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ViewingArticlesTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("104. Просмотр статьи в блоге")
    public void viewingABlogArticle() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@href=\"https://testqastudio.me/sea-good-every-which-said-first-divided/\"]").click();
        $x("//*[@class=\"entry-title\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("Однокомнатная квартира. Как расставить мебель?"));
    }

    @Test
    @DisplayName("105. Просмотр статей с рубрикой \"Дом\"")
    public void viewingArticlesWithTheHeadingHome() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@href=\"https://testqastudio.me/category/%d0%b4%d0%be%d0%bc/\"]").click();
        $x("//*[@class=\"selected\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("Дом"));
    }

    @Test
    @DisplayName("106. Просмотр статей с рубрикой \"Интерьер\"")
    public void viewingArticlesWithTheHeadingInterior() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@href=\"https://testqastudio.me/category/%d0%b8%d0%bd%d1%82%d0%b5%d1%80%d1%8c%d0%b5%d1%80/\"]").click();
        $x("//*[@class=\"selected\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("Интерьер"));
    }

    @Test
    @DisplayName("107. Просмотр статей без рубрики")
    public void viewingArticlesWithoutHeading() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@href=\"https://testqastudio.me/category/%d0%b1%d0%b5%d0%b7-%d1%80%d1%83%d0%b1%d1%80%d0%b8%d0%ba%d0%b8/\"]").click();
        $x("//*[@class=\"selected\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("Без рубрики"));
    }

    @Test
    @DisplayName("108. Просмотр статей с рубрикой \"Минимализм\"")
    public void viewingArticlesWithTheHeadingMinimalism() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@href=\"https://testqastudio.me/category/%d0%bc%d0%b8%d0%bd%d0%b8%d0%bc%d0%b0%d0%bb%d0%b8%d0%b7%d0%bc/\"]").click();
        $x("//*[@class=\"selected\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("Минимализм"));
    }

    @Test
    @DisplayName("109. Просмотр статей с рубрикой \"Эстетика\"")
    public void viewingArticlesWithTheHeadingAesthetics() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11002\"]").click();
        $x("//*[@href=\"https://testqastudio.me/category/%d1%8d%d1%81%d1%82%d0%b5%d1%82%d0%b8%d0%ba%d0%b0/\"]").click();
        $x("//*[@class=\"selected\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave(exactText("Эстетика"));
    }
}
