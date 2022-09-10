
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.Month;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        browserSize = "1600x900";
    }

    @Test
    void registrationFormTest() {
        // Open form, remove ads
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        // Student's data
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivan@ivanov.nl";
        String gender = "Female";
        String phone = "1234567365";
        String year = "1999";
        int month = 2;
        int day = 6;
        String subject = "Chemistry";
        String hobby = "Sports";
        String pictureFile = "Hw-1.png";
        String address = "Lenina 1";
        String state = "NCR";
        String city = "Noida";
        // Fill in the form
        // First name
        $("#firstName").setValue(firstName);
        // Last name
        $("#lastName").setValue(lastName);
        // Email
        $("#userEmail").setValue(email);
        // Gender
        $("#genterWrapper").$(byText(gender)).click();
        // Phone number
        $("#userNumber").setValue(phone);
        // Date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--00" + day).click();
        // Subject
        $("#subjectsInput").sendKeys("C");
        $(byText(subject)).click();
        // Hobby
        $("#hobbiesWrapper").$(byText(hobby)).click();
        // Upload picture
        $("#uploadPicture").uploadFromClasspath(pictureFile);
        // Address
        $("#currentAddress").setValue(address);
        // State
        $("#state").click();
        $(byText(state)).click();
        // City
        $("#city").click();
        $(byText(city)).click();
        // Submit the form
        $("#submit").click();
        // Check results
        Assertions.assertTrue($(".modal-content").exists());
        $(".modal-content").shouldHave(text(firstName + " " + lastName), text(email)
                ,text(gender),text(phone),text(day + " " + Month.of(month + 1).toString() + "," + year)
                ,text(subject),text(hobby),text(pictureFile),text(address),text(state),text(city));
    }

}
