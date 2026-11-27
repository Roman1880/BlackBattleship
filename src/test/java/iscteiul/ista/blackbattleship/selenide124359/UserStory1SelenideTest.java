package iscteiul.ista.blackbattleship.selenide124359;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124359.pages.UserStory1Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Testes de aceitação com Selenide para a User Story 1: Jogar contra o robô.
 */
public class UserStory1SelenideTest {

    private UserStory1Page userStory1Page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://papergames.io/en/battleship");
        userStory1Page = page(UserStory1Page.class);
    }

    @Test
    @Description("Verifica a inicialização de uma partida contra o robô e o posicionamento da frota.")
    public void testPlayAgainstRobot() {
        userStory1Page.playVsRobotButton.shouldBe(visible).click();
        userStory1Page.firstShipCell.shouldBe(visible).click();
        userStory1Page.confirmShipPosition.shouldBe(visible).click();
        userStory1Page.secondShipSelector.shouldBe(visible).click();
        userStory1Page.confirmShipPosition.shouldBe(visible).click();
        userStory1Page.thirdShipSelector.shouldBe(visible).click();
    }
}