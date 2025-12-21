package page;

import page.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import page.components.CheckResult;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public static SelenideElement firstNameInput = $("#firstName"),
                                  lastNameInput = $("#lastName"),
                                  userEmailInput = $("#userEmail"),
                                  genderWrapper = $("#genterWrapper"),
                                  userNumberInput = $("#userNumber"),
                                  calendarInput = $("#dateOfBirthInput"),
                                  subjectInput = $("#subjectsInput"),
                                  subjectLabel = $("#subjects-label"),
                                  hobbiesWrapper = $("#hobbiesWrapper"),
                                  pictureInput = $("#uploadPicture"),
                                  stateInput = $("#state"),
                                  cityInput = $("#city"),
                                  cityWrapper = $("#stateCity-wrapper"),
                                  adressInput = $("#currentAddress"),
                                  buttonSubmit = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResult checkResult = new CheckResult();


    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void setGender(String value) {
        genderWrapper.$(byText(value)).click();
    }

    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
    }

    public void setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        subjectLabel.click();
    }

    public void setHobbies(String value) {
      hobbiesWrapper.$(byText(value)).click();
    }

    public void uploadFile(String value) {
        pictureInput.uploadFromClasspath(value);

    }

    public void setStateAndCity(String state, String city) {
        stateInput.click();
        cityWrapper.$(byText(state)).click();
        cityInput.click();
        cityWrapper.$(byText(city)).click();

    }
    public void setLocalAdress(String value) {
        adressInput.setValue(value);

    }

    public void pressSubmit() {
        buttonSubmit.click();
    }

    public void checkResultInForm(String key, String value) {
        checkResult.checkFullFillPracticeForm(key, value);

    }

    public void checkNegativeTest() {
        checkResult.checkNegativeTest();
    }

}
