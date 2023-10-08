import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProductsTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("56. Просмотр отсутствующего товара")
    public void viewingAMissingItem() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='АЙША Барный стул']").click();
        $x("//*[@class=\"rz-stock\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("(Нет в наличии)"));
    }

    @Test
    @DisplayName("57. Увеличение количество товара на 1")
    public void increaseTheQuantityOfGoodsBy1() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"razzi-svg-icon razzi-qty-button increase\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("2"));
    }

    @Test
    @DisplayName("58. Уменьшение количества товара на 1 при 2 товарах")
    public void reducingTheQuantityOfGoodsBy1With2Goods() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"razzi-svg-icon razzi-qty-button increase\"]").click();
        $x("//*[@class=\"razzi-svg-icon razzi-qty-button decrease\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("1"));
    }

    @Test
    @DisplayName("59. Уменьшение количества товара на 1 при 1 товаре")
    public void reducingTheQuantityOfGoodsBy1With1Good() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"razzi-svg-icon razzi-qty-button decrease\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("1"));
    }

    @Test
    @DisplayName("60. Изменение количества товара с помощью ввода")
    public void changingTheQuantityOfTheProductByEntering() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("5");
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("5"));
    }
}
