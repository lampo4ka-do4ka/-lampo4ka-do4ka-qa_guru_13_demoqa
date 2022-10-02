import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        browserSize = "1600x900";
    }
}
