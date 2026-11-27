package iscteiul.ista.blackbattleship.selenide124359.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object (Selenide) correspondente à User Story 1: Jogar contra o robô.
 */
public class UserStory1Page {

    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    public SelenideElement playVsRobotButton;

    @FindBy(css = ".cell-1-3 .circle")
    public SelenideElement firstShipCell;

    @FindBy(css = ".hover")
    public SelenideElement confirmShipPosition;

    @FindBy(css = ".is-selected > img")
    public SelenideElement secondShipSelector;

    @FindBy(css = ".weapon-button:nth-child(3) > img")
    public SelenideElement thirdShipSelector;
}