package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void selenideSoftTest() {
    open("/selenide/selenide");
    $("#wiki-tab").click();
    $("#wiki-pages-filter").setValue("Soft");
    $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
    $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class")
                .closest("h4").sibling(0).shouldHave(text("    @ExtendWith({SoftAssertsExtension.class})" +
                                                          "    class Tests {" +
                                                          "      @Test" +
                                                          "      void test() {" +
                                                          "        Configuration.assertionMode = SOFT;" +
                                                          "        open(\"page.html\");" +
                                                          " " +
                                                          "        $(\"#first\").should(visible).click();" +
                                                          "        $(\"#second\").should(visible).click();" +
                                                          "      }" +
                                                          "    }"));

   }


}
