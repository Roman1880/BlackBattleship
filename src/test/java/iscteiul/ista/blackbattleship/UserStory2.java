package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object correspondente à User Story 2: Jogar online contra um adversário aleatório.
 */
public class UserStory2 {

    @FindBy(css = ".d-flex > .fw-normal:nth-child(1)")
    public WebElement playOnlineButton;

    /**
     * Inicializa os elementos da página para o cenário da US2.
     *
     * @param driver instância do WebDriver utilizada no teste
     */
    public UserStory2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}