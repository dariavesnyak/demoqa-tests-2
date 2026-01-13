package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import helpers.JsSnippets;


public class PracticeFormPageObjectWithDataTest extends TestBase{


    RegistrationPage registrationPage = new RegistrationPage();
    JsSnippets jsSnippets = new JsSnippets();
    DataTest dataTest = new DataTest();


    @Test
    void fillFormTest() {
        registrationPage.openPage();
        jsSnippets.notVisibleBanners();
        registrationPage.setFirstName(dataTest.firstName);
        registrationPage.setLastName(dataTest.lastName);
        registrationPage.setEmail(dataTest.userEmail);
        registrationPage.setGender(dataTest.gender);
        registrationPage.setUserNumber(dataTest.userPhone);
        registrationPage.setDateOfBirth(dataTest.day, dataTest.month, dataTest.year);
        registrationPage.setSubject(dataTest.subject);
        registrationPage.setHobbies(dataTest.hobbies);
        registrationPage.uploadFile(dataTest.file);
        registrationPage.setStateAndCity(dataTest.state, dataTest.city);
        registrationPage.setLocalAdress(dataTest.localAddress);
        registrationPage.pressSubmit();


        //Проверка заполненной формы
        registrationPage.checkResultInForm("Student Name", dataTest.firstName + " " + dataTest.lastName);
        registrationPage.checkResultInForm("Student Email", dataTest.userEmail);
        registrationPage.checkResultInForm("Gender", dataTest.gender);
        registrationPage.checkResultInForm("Mobile", dataTest.userPhone);
        registrationPage.checkResultInForm("Date of Birth", dataTest.day + " " + dataTest.month + " " + dataTest.year);
        registrationPage.checkResultInForm("Subjects", dataTest.subject);
        registrationPage.checkResultInForm("Hobbies", dataTest.hobbies);
        registrationPage.checkResultInForm("Picture", dataTest.file);
        registrationPage.checkResultInForm("Address", dataTest.localAddress);
        registrationPage.checkResultInForm("State and City", dataTest.state + " " + dataTest.city);



    }

    @Test
    void minimumFillFormTest() {
        registrationPage.openPage();
        jsSnippets.notVisibleBanners();
        registrationPage.setFirstName(dataTest.firstName);
        registrationPage.setLastName(dataTest.lastName);
        registrationPage.setEmail(dataTest.userEmail);
        registrationPage.setGender(dataTest.gender);
        registrationPage.setUserNumber(dataTest.userPhone);
        registrationPage.pressSubmit();

        registrationPage.checkResultInForm("Student Name", dataTest.firstName + " " + dataTest.lastName);
        registrationPage.checkResultInForm("Student Email", dataTest.userEmail);
        registrationPage.checkResultInForm("Gender", dataTest.gender);
        registrationPage.checkResultInForm("Mobile", dataTest.userPhone);
    }

    @Test
    void negativTest() {
        registrationPage.openPage();
        jsSnippets.notVisibleBanners();
        registrationPage.setFirstName(dataTest.firstName);
        registrationPage.pressSubmit();
        registrationPage.checkNegativeTest();

    }
}
