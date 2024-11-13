package java_qa_gr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

public class SimpleWebTest {

    @BeforeEach
    void setup() {
        open("https://ya.ru");
    }

    @Test
    @DisplayName("Проверка числа результатов")
    @Blocker
    void serchResultItems10() {
        $("#text").setValue("selenide");
        $("button[type='submit']").click();
        $$("li.serp-item").shouldHave(sizeGreaterThanOrEqual(10));
    }
}
