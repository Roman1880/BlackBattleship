package iscteiul.ista.blackbattleship.selenide124359;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.ista.blackbattleship.selenide124359.pages.UserStory4Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Testes de aceitação com Selenide para a User Story 4: Alterar o nickname do jogador.
 */
public class UserStory4SelenideTest {

    private UserStory4Page userStory4Page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://papergames.io/en/battleship");
        userStory4Page = page(UserStory4Page.class);
    }

    @Test
    @Description("Verifica a alteração do nickname do utilizador para 'bo11'.")
    public void testChangeNickname() {
        userStory4Page.userMenuButton.shouldBe(visible).click();
        userStory4Page.changeNicknameOption.shouldBe(visible).click();
        userStory4Page.nicknameInput.shouldBe(visible).setValue("bo11");
        userStory4Page.updateNicknameButton.shouldBe(visible).click();
    }
}