package java_qa_gr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

public class SimpleWebTest {

    @Test
    @DisplayName("Проверка числа результатов")
    void serchResultItems10() {
        open("https://ya.ru");
        $("#text").setValue("selenide");
        $("button[type='submit']").click();
        $$("li.serp-item").shouldHave(sizeGreaterThanOrEqual(10));
    }
}
