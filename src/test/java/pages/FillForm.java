package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FillForm {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement hobbiesChoosing = $("#hobbiesWrapper");
    private final SelenideElement subjectInput =  $("#subjectsInput");
    private final SelenideElement address = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement tableResults = $(".table");
    private final SelenideElement checkResults = $(".table");

    CalendarComponent calendarComponent = new CalendarComponent();

    public FillForm openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FillForm removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public FillForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FillForm setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FillForm setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public FillForm setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public FillForm setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public FillForm setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FillForm setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public FillForm setHobbies(String value) {
        hobbiesChoosing.$(byText(value)).click();
        return this;
    }

    public FillForm setPictureUpload(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    public FillForm setAddress(String value) {
        address.setValue(value);
        return this;
    }

    public FillForm setState (String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public FillForm setCity (String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public FillForm clickSubmit() {
        submitButton.click();
        return this;
    }

    public FillForm checkErrorMail () {
        tableResults.shouldNotBe(visible);
        return this;
    }

    public FillForm checkResults (String key, String value) {
        checkResults.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}