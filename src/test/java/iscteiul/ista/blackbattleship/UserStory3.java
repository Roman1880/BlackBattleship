package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object correspondente à User Story 3: Convidar um amigo através de link.
 */
public class UserStory3 {

    @FindBy(css = ".w-100:nth-child(1) > .btn-lg .flex-grow-1")
    public WebElement playWithFriendButton;

    @FindBy(css = ".fa-copy")
    public WebElement copyInviteLinkButton;

    /**
     * Inicializa os elementos da página para o cenário da US3.
     *
     * @param driver instância do WebDriver utilizada no teste
     */
    public UserStory3(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}