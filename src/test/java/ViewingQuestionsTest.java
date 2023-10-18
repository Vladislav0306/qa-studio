import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ViewingQuestionsTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("101. Просмотр вопроса \"Можно ли поставить доп.фурнитуру?\"")
    public void viewingTheQuestionisTtPossibleToPutAdditionalAccessories() {
        $x("//*[@href=\"https://testqastudio.me/faq/\"]").click();
        $x("//*[@class=\"faq-title\" and text()='Можно ли поставить доп.фурнитуру?']").shouldBe(visible, Duration.ofSeconds(60)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/25
    }

    @Test
    @DisplayName("102. Просмотр вопроса \"Почему наша мебель дорогая?\"")
    public void viewingTheQuestionWhyIsOurFurnitureExpensive() {
        $x("//*[@href=\"https://testqastudio.me/faq/\"]").click();
        $x("//*[//*[@id=\"post-609\"]/div/section/div/div[2]/div/div[2]/div/div/div[3]]").click();
        $x("//*[//*[@id=\"post-609\"]/div/section/div/div[2]/div/div[2]/div/div/div[3]/div/p]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave();
    }

    @Test
    @DisplayName("103. Просмотр вопроса \"Есть ли возможность бесплатной доставки?\"")
    public void viewingTheQuestionIsThereAPossibilityOfFreeDelivery() {
        $x("//*[@href=\"https://testqastudio.me/faq/\"]").click();
        $x("//*[//*[@id=\"post-609\"]/div/section/div/div[2]/div/div[4]/div/div/div[2]]").click();
        $x("//*[//*[@id=\"post-609\"]/div/section/div/div[2]/div/div[4]/div/div/div[2]/div/p]").shouldBe(visible, Duration.ofSeconds(60)).shouldHave();
    }
}
