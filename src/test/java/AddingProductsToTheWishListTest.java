import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AddingProductsToTheWishListTest {
    @BeforeEach
    void setUp() {
        open("https://testqastudio.me/");
    }

    @Test
    @DisplayName("70. Добавление товара в список желаний")
    public void addingProductsToTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11345\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f1411-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
    }

    @Test
    @DisplayName("71. Удаление товара \"АЙША Барный стул\" из списка желаний")
    public void removingTheProductAISHABarStoolFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11338\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f510-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("72. Удаление товара \"БРЕДБЕРРИ Комод с ящиками\" из списка желаний")
    public void removingTheProductBradberryChestOfDrawersFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11345\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f1411-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("73. Удаление товара \"БРОММС Двухместная кровать\" из списка желаний")
    public void removingTheProductBrommsDoubleBedFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11342\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/04/f1310-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("74. Удаление товара \"ГРАДВИС Керамическая ваза\" из списка желаний")
    public void removingTheProductGradvisCeramicVaseFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11328\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/05/home2-slider04-e1650186055178-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("75. Удаление товара \"ДИВВИНА Журнальный столик\" из списка желаний")
    public void removingTheProductDivvinaCoffeeTableFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11341\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f810-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("76. Удаление товара \"ДИННИНГ Табурет со спинкой\" из списка желаний")
    public void removingTheProductDinningStoolWithBackFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11344\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/04/f910-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave();
        // Обнаружен баг: https://github.com/Vladislav0306/qa-studio/issues/20
    }

    @Test
    @DisplayName("77. Удаление товара \"КЛЛАРИОН Низкий столик\" из списка желаний")
    public void removingTheProductKlarionLowTableFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11337\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f410-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("78. Удаление товара \"ЛЕРГРЮН Подвесной светильник\" из списка желаний")
    public void removingTheProductLergrunePendantLampFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11333\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/04/f210-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("79. Удаление товара \"МАДЕЙРА Подвесной светильник\" из списка желаний")
    public void removingTheProductMadeiraPendantLampFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11334\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/bunkeflo-bunkeflu-podvesnoy-svetilnik-belyy-bereza__1112025_pe871073_s5.jpg-570x684.webp\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("80. Удаление товара \"ОТТАВА Софа\" из списка желаний")
    public void removingTheProductOttawaSofaFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11335\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f610-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("81. Удаление товара \"РАННАР Подвесной светильник\" из списка желаний")
    public void removingTheProductRannarPendantLampFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11332\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f111-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("82. Удаление товара \"САККАРИО Офисный стул\" из списка желаний")
    public void removingTheProductSaccarioOfficeChairFromTheWishList() {
        $x("//*[@href=\"?add_to_wishlist=11343\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/04/f1511-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("83. Удаление товара \"СИДНИ Тумба под TV\" из списка желаний")
    public void removingTheProductSydneyTumbaUnderTVFromTheWishList() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        $x("//*[@href=\"?add_to_wishlist=11349\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f1210-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("84. Удаление товара \"СТРЭНДМОН Кресло\" из списка желаний")
    public void removingTheProductStrandmonChairFromTheWishList() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        $x("//*[@href=\"?add_to_wishlist=11346\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f1010-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("85. Удаление товара \"ТАРДИС Скамья\" из списка желаний")
    public void removingTheProductTardisBenchFromTheWishList() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        $x("//*[@href=\"?add_to_wishlist=11347\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/04/f1110-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("86. Удаление товара \"ЭЛЛЬБИ Подвесная лампа\" из списка желаний")
    public void removingTheProductEllbyHangingLampFromTheWishList() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        $x("//*[@href=\"?add_to_wishlist=11340\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2020/12/f1611-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }

    @Test
    @DisplayName("87. Удаление товара \"ЭППЛАРЮД Диван трёхместный\" из списка желаний")
    public void removingTheProductApplarudSofaTripleFromTheWishList() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        $x("//*[@href=\"?add_to_wishlist=11331\"]").click();
        $x("//*[@class=\"wishlist-icon\"]").click();
        $x("//*[@class=\"remove remove_from_wishlist\"]").click();
        $x("//*[@src=\"https://testqastudio.me/wp-content/uploads/2021/04/f713-570x684.jpg\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldNotHave();
    }
}
