import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SendingAMessageTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("111. Ввод имени при отправке сообщения")
    public void enteringANameWhenSendingAMessage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[1]]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/26
    }

    @Test
    @DisplayName("112. Ввод email при отправке сообщения")
    public void enteringAnEmailWhenSendingAMessage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[2]]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/27
    }

    @Test
    @DisplayName("113. Ввод телефона при отправке сообщения")
    public void enteringAPhoneNumberWhenSendingAMessage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[3]]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/28
    }

    @Test
    @DisplayName("114. Ввод заголовка при отправке сообщения")
    public void enteringAHeaderWhenSendingAMessage() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[4]]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/29
    }

    @Test
    @DisplayName("115. Отправка сообщения при оставлении остальных полей пустыми")
    public void sendingAMessageWhileLeavingTheOtherFieldsEmpty() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[@class=\"wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required\"]").setValue("АБВГД");
        $x("//*[@class=\"wpcf7-form init\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[1]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[2]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[4]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
    }

    @Test
    @DisplayName("116. Отправка пустого сообщения при оставлении остальных полей пустыми")
    public void sendingAEmptyMessageWhileLeavingTheOtherFieldsEmpty() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[@class=\"wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required\"]").setValue("АБВГД");
        $x("//*[@class=\"wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required\"]").setValue("");
        $x("//*[@class=\"wpcf7-form init\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[1]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[2]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[4]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[5]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
    }

    @Test
    @DisplayName("117. Отправка XSS-инъекции при оставлении остальных полей пустыми")
    public void sendingXSSInjectionWhileLeavingTheOtherFieldsEmpty() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[@class=\"wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required\"]").setValue("<script>alert(123)</script>");
        $x("//*[@class=\"wpcf7-form init\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[1]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[2]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[4]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
    }

    @Test
    @DisplayName("118. Отправка SQL-инъекции при оставлении остальных полей пустыми")
    public void sendingSQLInjectionWhileLeavingTheOtherFieldsEmpty() {
        $x("//*[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11005\"]").click();
        $x("//*[@class=\"wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required\"]").setValue("1 or sleep(5)#");
        $x("//*[@class=\"wpcf7-form init\"]").click();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[1]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[2]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[//*[@id=\"wpcf7-f598-p584-o1\"]/form/p[1]/span[4]/span]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
    }
}
