package iscteiul.ista.blackbattleship.selenide124359.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object (Selenide) correspondente à User Story 4: Alterar o nickname do jogador.
 */
public class UserStory4Page {

    @FindBy(css = ".ms-2 > .text-truncate")
    public SelenideElement userMenuButton;

    @FindBy(css = ".mat-mdc-menu-item:nth-child(3) > .mat-mdc-menu-item-text > span")
    public SelenideElement changeNicknameOption;

    @FindBy(id = "mat-input-serverApp0")
    public SelenideElement nicknameInput;

    @FindBy(css = ".btn-secondary")
    public SelenideElement updateNicknameButton;
}