import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ClickOnTheLinkTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("95. Переход в группу ВК \"QA Studio\"")
    public void transitionToTheVKGroupQAStudio() {
        $x("//*[@href=\"https://vk.com/public212596610\"]").click();
        $x("//*[@class=\"redesigned-group-cover__img _page_cover\"]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave();
    }

    @Test
    @DisplayName("96. Переход в группу Instagram \"QA Studio\"")
    public void transitionToTheInstagramGroupQAStudio() {
        $x("//*[@href=\"https://instagram.com/qa.studio\"]").click();
        $x("//*[@class=\"x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i0vuye x1ms8i2q xo1l8bm x5n08af x10wh9bi x1wdrske x8viiok x18hxmgj\"]")
                .shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("qa.studio"));
    }

    @Test
    @DisplayName("97. Переход в группу Telegram \"QA Studio\"")
    public void transitionToTheTelegramGroupQAStudio() {
        $x("//*[@href=\"https://t.me/qa_studio\"]").click();
        $x("//*[@class=\"tgme_page_title\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("QA Studio  | Шаг за шагом к Junior QA"));
    }

    @Test
    @DisplayName("98. Переход на канал Youtube \"QA Studio\"")
    public void goToTheYoutubeChannelQAStudio() {
        $x("//*[@href=\"https://#\"]").click();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/22
    }

    @Test
    @DisplayName("99. Переход на страницу оплаты и доставки")
    public void goToThePaymentAndDeliveryPage() {
        $x("//*[@href=\"https://testqastudio.me/faq/\"]").click();
        $x("//*[@class=\"page-header__title \"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Часто задавамые вопросы"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/23
    }

    @Test
    @DisplayName("100. Переход на страницу политики конфиденциальности")
    public void goToThePrivacyPolicyPage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11091\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Политика конфиденциальности"));
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/24
    }
}
