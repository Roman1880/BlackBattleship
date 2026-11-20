package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object correspondente à User Story 4: Alterar o nickname do jogador.
 */
public class UserStory4 {

    @FindBy(css = ".ms-2 > .text-truncate")
    public WebElement userProfileMenuButton;

    @FindBy(css = ".mat-mdc-menu-item:nth-child(3) > .mat-mdc-menu-item-text > span")
    public WebElement changeNicknameMenuOption;

    @FindBy(id = "mat-input-serverApp0")
    public WebElement nicknameInputField;

    @FindBy(css = ".btn-secondary")
    public WebElement updateNicknameButton;

    /**
     * Inicializa os elementos da página para o cenário da US4.
     *
     * @param driver instância do WebDriver utilizada no teste
     */
    public UserStory4(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}