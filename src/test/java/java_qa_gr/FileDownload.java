package java_qa_gr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileDownload {

    @Test
    void downLoadTest() throws Exception {
        open("https://github.com/sem1on/google-clone/blob/main/README.md");
        File file = $("[data-testid=raw-button]").download();

        try (InputStream is = new FileInputStream(file)) {
            byte[] bytes = is.readAllBytes();
            String fileToString = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(fileToString.contains("Google Search API"));
        }
    }
}
