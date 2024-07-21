package pages;

//import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage extends pages.BasePage {
    private static final String URL = "https://demoqa.com/automation-practice-form";

    public PracticeFormPage() {
        open(URL);
    }

    public void setFirstName(String firstName) {
        findElement("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        findElement("#lastName").setValue(lastName);
    }

    public void setEmail(String email) {
        findElement("#userEmail").setValue(email);
    }

    public void setGender(String gender) {
        findElement(String.format("label[for='gender-radio-%s']", gender)).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        findElement("#userNumber").setValue(phoneNumber);
    }

    public void submitForm() {
        findElement("#submit").click();
    }
}