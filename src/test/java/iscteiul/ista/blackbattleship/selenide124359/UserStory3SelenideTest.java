package iscteiul.ista.blackbattleship.selenide124359;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124359.pages.UserStory3Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Testes de aceitação com Selenide para a User Story 3: Convidar um amigo através de link.
 */
public class UserStory3SelenideTest {

    private UserStory3Page userStory3Page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://papergames.io/en/battleship");
        userStory3Page = page(UserStory3Page.class);
    }

    @Test
    @Description("Verifica a criação de uma sala privada e a cópia do link de convite para um amigo.")
    public void testInviteFriendWithLink() {
        userStory3Page.playWithFriendButton.shouldBe(visible).click();
        userStory3Page.copyInviteLinkButton.shouldBe(visible).click();
    }
}