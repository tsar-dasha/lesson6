package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormTest {
    @BeforeAll
    public static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void testFormSubmission() {
        PracticeFormPage formPage = new PracticeFormPage();
        formPage.setFirstName("John");
        formPage.setLastName("Doe");
        formPage.setEmail("john.doe@example.com");
        formPage.setGender("1"); // 1 for Male, 2 for Female, 3 for Other
        formPage.setPhoneNumber("1234567890");
        formPage.submitForm();
        // Проверка на успешное заполнение формы
        assertTrue(webdriver().driver().url().contains("https://demoqa.com/automation-practice-form"));
    }
}