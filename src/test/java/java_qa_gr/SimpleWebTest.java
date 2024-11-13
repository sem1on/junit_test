package java_qa_gr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

public class SimpleWebTest {

    @BeforeEach
    void setup() {
        open("https://ya.ru");
    }

    @ValueSource(strings = {
            "seleide", "allure"
    })
    @ParameterizedTest(name = "Проверка числа результатов {0}")
    @Blocker
    void searchResultItems10(String testData) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").shouldHave(sizeGreaterThanOrEqual(10));
    }

    @CsvSource(value = {
            "seleide|   стабильные UI тесты",
            "allure|   AllureFramework GitHub"
    },
    delimiter = '|')
    @ParameterizedTest(name = "В первом результате для {0} текст {1}")
    @Blocker
    void FirstSearchResultItems(String testData, String expecktResult) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").first().shouldHave(text(expecktResult));
    }
}
