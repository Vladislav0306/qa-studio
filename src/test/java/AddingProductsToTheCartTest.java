import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AddingProductsToTheCartTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("61. Добавление 1 товара в корзину")
    public void adding1ProductToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("1"));
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
    }

    @Test
    @DisplayName("62. Добавление 5 товаров в корзину")
    public void adding5ProductsToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("5");
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("5"));
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
    }

    @Test
    @DisplayName("63. Добавление 0 товаров в корзину")
    public void adding0ProductsToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("0");
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"cart-panel-counter\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("(1)"));
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/17
    }

    @Test
    @DisplayName("64. Добавление -5 товаров в корзину")
    public void addingMinus5ProductsToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("-5");
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"notifyjs-razzi-base notifyjs-razzi-info\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/18
    }

    @Test
    @DisplayName("65. Добавление 4.4 товаров в корзину")
    public void adding4Point4ProductsToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("4.4");
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("4"));
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/19
    }

    @Test
    @DisplayName("66. Добавление 1 000 000 000 000 000 000 товаров в корзину")
    public void adding1000000000000000000ProductsToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("1000000000000000000");
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"input-text qty text\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(value("1000000000000000000"));
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
    }

    @Test
    @DisplayName("67. Добавление 10 000 000 000 000 000 000 товаров в корзину")
    public void adding10000000000000000000ProductsToTheCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"input-text qty text\"]").setValue("10000000000000000000");
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"cart-panel-counter\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("(9223372036854775807)"));
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
    }

    @Test
    @DisplayName("68. Удаление товара из корзины")
    public void removingAnItemFromTheShoppingCart() {
        $x("//*[@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\" and text()='БРЕДБЕРРИ Комод с ящиками']").click();
        $x("//*[@class=\"single_add_to_cart_button button alt\"]").click();
        $x("//*[@class=\"name\"  and text()='Удалить']").click();
        $x("//*[@class=\"cart-panel-counter\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("(0)"));
    }

    @Test
    @DisplayName("69. Закрытие корзины")
    public void closingTheBasket() {
        $x("//*[@class=\"razzi-svg-icon icon-cart\"]").click();
        $x("//*[@id=\"cart-modal\"]/div[2]/div[1]/a/span").click();
        $x("//*[@class=\"text-filter\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Фильтр"));
    }
}
