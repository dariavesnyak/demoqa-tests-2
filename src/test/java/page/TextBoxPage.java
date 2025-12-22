package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CheckResult;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement   userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    CheckResult checkResult = new CheckResult();

    public void openPage() {
        open("/text-box");
    }


    public void setUserNameInput( String value) {
        userNameInput.setValue(value);
    }
    public void setUserEmailInput( String value) {
        userEmailInput.setValue(value);
    }
    public void setCurrentAddressInput( String value) {
        currentAddressInput.setValue(value);
    }
    public void setPermanentAddressInput( String value) {
        permanentAddressInput.setValue(value);
    }
    public void pressButton() {
        submitButton.click();
    }

    public void checkTextForm(String value) {
        checkResult.checkTextForm(value);
    }
}
