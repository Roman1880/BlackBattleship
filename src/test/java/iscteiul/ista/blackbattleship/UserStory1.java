package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object correspondente à User Story 1: Jogar contra o robô.
 */
public class UserStory1 {

    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    public WebElement playVsRobotButton;

    @FindBy(css = ".cell-1-3 .circle")
    public WebElement firstShipCell;

    @FindBy(css = ".hover")
    public WebElement confirmShipPosition;

    @FindBy(css = ".is-selected > img")
    public WebElement secondShipSelector;

    @FindBy(css = ".weapon-button:nth-child(3) > img")
    public WebElement thirdShipSelector;

    /**
     * Inicializa os elementos da página para o cenário da US1.
     *
     * @param driver instância do WebDriver utilizada no teste
     */
    public UserStory1(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}