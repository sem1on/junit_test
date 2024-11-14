package java_qa_gr;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileDownload {

    @Test
    void downLoadTest() throws Exception {
        open("https://github.com/sem1on/google-clone/blob/main/README.md");
        File file = $("[data-testid=raw-button]").download();
    }
}
