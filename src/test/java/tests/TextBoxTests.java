package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTestWithNotGoodLocators() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("alex");
        $("#userEmail").setValue("aa@aa.com");
        $("[placeholder='Current Address']").setValue("1234");
        $(byId("Current Address")).setValue("5678");
        $(".btn.btn-primary").click();

        System.out.println("debug");
    }

    @Test
    void successfulFillTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("alex");
        $("#userEmail").setValue("aa@aa.com");
        $("#currentAddress").setValue("1234");
        $("#permanentAddress").setValue("5678").scrollTo();
        $("#submit").click();


        $("#name").shouldHave(text("alex"));
        $("#email").shouldHave(text("aa@aa.com"));
        $("#currentAddress").shouldHave(text("1234"));
        $("#permanentAddress").shouldHave(text("5678"));
    }

    @Test
    void successfulFillTestWithVariables() {

        String name = "alex";
        open("https://demoqa.com/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue("aa@aa.com");
        $("#currentAddress").setValue("1234");
        $("#permanentAddress").setValue("5678").scrollTo();
        $("#submit").click();


        $("#name").shouldHave(text(name));
        $("#email").shouldHave(text("aa@aa.com"));
        $("#currentAddress").shouldHave(text("1234"));
        $("#permanentAddress").shouldHave(text("5678"));
    }

    @Test
    void successfulFillTestWithSearchInOutput() {

        String name = "alex1";
        open("https://demoqa.com/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue("aa@aa.com");
        $("#currentAddress").setValue("1234");
        $("#permanentAddress").setValue("5678").scrollTo();
        $("#submit").click();


        $("#output").shouldHave(text(name), text("aa@aa.com"));
       
    }


    @Test
    void successfulFillTestWithSearchInOutput2() {

        String name = "alex";
        open("https://demoqa.com/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue("aa@aa.com");
        $("#currentAddress").setValue("1234");
        $("#permanentAddress").setValue("5678").scrollTo();
        $("#submit").click();


        $("#output").shouldHave(text(name), text("aa@aa.com"));

    }
}
