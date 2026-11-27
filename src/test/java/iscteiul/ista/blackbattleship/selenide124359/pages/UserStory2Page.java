package iscteiul.ista.blackbattleship.selenide124359.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object (Selenide) correspondente à User Story 2: Jogar online contra um adversário aleatório.
 */
public class UserStory2Page {

    @FindBy(css = ".d-flex > .fw-normal:nth-child(1)")
    public SelenideElement playOnlineButton;
}