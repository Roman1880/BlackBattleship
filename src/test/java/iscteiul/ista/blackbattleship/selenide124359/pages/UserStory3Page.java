package iscteiul.ista.blackbattleship.selenide124359.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object (Selenide) correspondente à User Story 3: Convidar um amigo através de link.
 */
public class UserStory3Page {

    @FindBy(css = ".w-100:nth-child(1) > .btn-lg .flex-grow-1")
    public SelenideElement playWithFriendButton;

    @FindBy(css = ".fa-copy")
    public SelenideElement copyInviteLinkButton;
}