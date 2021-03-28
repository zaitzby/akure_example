package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step
    public void openMainPage(String url){
        open(url);
    }

    @Step
    public void enterSearchData(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
    }

    @Step
    public void executeSearchRequest(){
        $(".header-search-input").submit();
    }

    @Step
    public void openRepoPage(String repo){
        $(By.linkText(repo)).click();
    }

    @Step
    public void openIssuesTabatRepoPage(String repo){
        $("[href='/" + repo + "/issues']").click();
    }

    @Step
    public void checkIssuePresence(int issue){
        $(withText("#" + issue)).should(Condition.exist);
    }

}
