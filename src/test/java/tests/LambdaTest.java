package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Test
    public void testIssueSearch() {
        step("Open Github", () -> {
            open(BASE_URL);
        });
        step("Enter repo name: " + REPOSITORY + " into the search input", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
        });
        step("Execute search request ",() -> {
            $(".header-search-input").submit();
        });
        step("Open repository: " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open 'Issues' tab", () -> {
            $("[href='/" + REPOSITORY + "/issues']").click();
        });
        step("Ensure an issue #" + ISSUE_NUMBER + " is present in the issues list",() -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }

}
