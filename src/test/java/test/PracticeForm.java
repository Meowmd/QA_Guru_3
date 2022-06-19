package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
public PracticeForm() {
}

@BeforeAll
static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.browserPosition = "00x00";
}
@Test
    void successfulTest() {
     Selenide.open("/automation-practice-form");
        Selenide.executeJavaScript("$('footer').remove()", new Object[0]);
        Selenide.executeJavaScript("$('#fixedban').remove()", new Object[0]);
        Selenide.$("#firstName").setValue("Mariya");
        Selenide.$("#lastName").setValue("Bykova");
        Selenide.$("#userEmail").setValue("bykova.m@gmail.com");
        Selenide.$(Selectors.byText("Female")).click();
        Selenide.$("#userNumber").setValue("9999999999");
        Selenide.$("#dateOfBirthInput").click();
        Selenide.$(".react-datepicker__year-select").selectOption(new String[]{"1987"});
        Selenide.$(".react-datepicker__month-select").selectOption(new String[]{"July"});
        Selenide.$("[aria-label= 'Choose Wednesday, July 8th, 1987']").click();
        Selenide.$("#subjectsInput").setValue("Math").pressEnter();
        Selenide.$(Selectors.byText("Music")).click();
        Selenide.$("#uploadPicture").uploadFromClasspath(new String[]{"Screenshot_1.png"});
        Selenide.$("#currentAddress").setValue("Lenina 20");
        Selenide.$("#react-select-3-input").setValue("NCR").pressEnter();
        Selenide.$("#react-select-4-input").setValue("Delhi").pressEnter();
        Selenide.$("#submit").click();
    $(".modal-body").shouldHave(
            text("Mariya Bykova"),
            text("bykova.m@gmail.com"),
            text("Female"),
            text("9999999999"),
            text("8 july,1987"),
            text("Math"),
            text("Music"),
            text("Screenshot_1.png"),
            text("Lenina 20"),
            text("NCR Delhi")
    );
}
}
