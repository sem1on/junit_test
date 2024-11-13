package java_qa_gr;

import java_qa_gr.data.Local;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SimpleLocalWebTest {

    static Stream<Arguments> siteShouldContainsText() {
        return Stream.of(
                Arguments.of(Local.En, List.of("Quick", "start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Local.Ru, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} текст {1}")
    @Blocker
    void siteShouldContainsText(Local locale, String expectedButton) {
        open("https://selenide.org");
        $$(".languages a").find(text(locale.name())).click();
        $$("main-menu-pages a").filter(visible).shouldHave(texts(expectedButton));
    }
}
