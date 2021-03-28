package tests;

import org.junit.jupiter.api.Test;

public class AnnotationTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    private WebSteps steps = new WebSteps();

    @Test
    public void testIssueSearch() {
        steps.openMainPage(BASE_URL);
        steps.enterSearchData(REPOSITORY);
        steps.executeSearchRequest();
        steps.openRepoPage(REPOSITORY);
        steps.openIssuesTabatRepoPage(REPOSITORY);
        steps.checkIssuePresence(ISSUE_NUMBER);
    }

}
