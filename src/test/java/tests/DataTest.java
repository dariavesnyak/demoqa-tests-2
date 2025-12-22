package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class DataTest {

     static Faker faker = new Faker(new Locale("en"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Female", "Male", "Other"),
            userPhone = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September",
                    "October", "November", "December"),
            year = String.format("%s", faker.number().numberBetween(1920, 2024)),
            subject = faker.options().option("Math", "Hindi"),
            hobbies = faker.options().option("Music", "Sports", "Reading"),
            file = faker.options().option("test.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana"),
            city = getCity(state),
            localAddress = faker.address().fullAddress();


    String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> "null";
        };
    }
}
