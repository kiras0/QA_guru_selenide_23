package dragAndDropTest;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {


    @Test
    void replacingRectangleAToBTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").shouldHave(text("B"));
        $("#column-a").shouldHave(text("A"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}
