package tests;


import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import page.components.SkipBanners;


public class PracticeFormPageObject extends TestBase{


    RegistrationPage registrationPage = new RegistrationPage();
    SkipBanners skipBanners = new SkipBanners();


    @Test
    void fillFormTest() {
        registrationPage.openPage();
        skipBanners.notVisibleBanners();
        registrationPage.setFirstName("Daria");
        registrationPage.setLastName("Test");
        registrationPage.setEmail("daria@test.com");
        registrationPage.setGender("Female");
        registrationPage.setUserNumber("7999111223");
        registrationPage.setDateOfBirth("31", "January", "1998");
        registrationPage.setSubject("Math");
        registrationPage.setHobbies("Music");
        registrationPage.uploadFile("test.jpg");
        registrationPage.setStateAndCity("Haryana", "Karnal");
        registrationPage.setLocalAdress("Lenina Street 102");
        registrationPage.pressSubmit();


        //Проверка заполненной формы
        registrationPage.checkResultInForm("Student Name", "Daria Test");
        registrationPage.checkResultInForm("Student Email", "daria@test.com");
        registrationPage.checkResultInForm("Gender", "Female");
        registrationPage.checkResultInForm("Mobile", "7999111223");
        registrationPage.checkResultInForm("Date of Birth", "31 January,1998");
        registrationPage.checkResultInForm("Subjects", "Maths");
        registrationPage.checkResultInForm("Hobbies", "Music");
        registrationPage.checkResultInForm("Picture", "test.jpg");
        registrationPage.checkResultInForm("Address", "Lenina Street 102");
        registrationPage.checkResultInForm("State and City", "Haryana Karnal");



    }

    @Test
    void minimumFillFormTest() {
        registrationPage.openPage();
        skipBanners.notVisibleBanners();
        registrationPage.setFirstName("Daria");
        registrationPage.setLastName("Test");
        registrationPage.setEmail("daria@test.com");
        registrationPage.setGender("Female");
        registrationPage.setUserNumber("7999111223");
        registrationPage.pressSubmit();

        registrationPage.checkResultInForm("Student Name", "Daria Test");
        registrationPage.checkResultInForm("Student Email", "daria@test.com");
        registrationPage.checkResultInForm("Gender", "Female");
        registrationPage.checkResultInForm("Mobile", "7999111223");
    }

    @Test
    void negativTest() {
        registrationPage.openPage();
        skipBanners.notVisibleBanners();
        registrationPage.setFirstName("Daria");
        registrationPage.pressSubmit();
        registrationPage.checkNegativeTest();

    }
}
