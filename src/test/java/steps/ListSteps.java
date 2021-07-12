package steps;

import pages.ListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListPage() {
        list.navigateToListPage();
    }

    @When("^I search the list$")
    public void searchTheList() throws InterruptedException {
        list.enterSearchCriteria();
    }

    @Then("^I can find the text in the list$")
    public void theTableIsThere() {
        List<String> resultsList = list.getAllSearchResults();
        boolean textIsThere = resultsList.contains("Seattle, Washington");

        if(textIsThere) {
            System.out.println("The text is on the list: PASSED");
        } else {
            throw new Error("The text is not on the list: FAILED!");
        }
    }
}
