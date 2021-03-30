package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open '{url}'")
    public void openMainPage(String url){
        open(url);
    }

    @Step("Enter repo name: '{repo}' into the search input")
    public void enterSearchData(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
    }

    @Step("Execute search request")
    public void executeSearchRequest(){
        $(".header-search-input").submit();
    }

    @Step("Open repository: '{repo}'")
    public void openRepoPage(String repo){
        $(By.linkText(repo)).click();
    }

    @Step("Open 'Issues' tab")
    public void openIssuesTabAtRepoPage(String repo){
        $("[href='/" + repo + "/issues']").click();
    }

    @Step("Ensure an issue '{issue}' is present in the issues list")
    public void checkIssuePresence(int issue){
        $(withText("#" + issue)).should(Condition.exist);
    }

}
