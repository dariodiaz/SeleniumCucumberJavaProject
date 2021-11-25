package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ListPage;

import java.util.List;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListPage() {
        list.navigateToListPage();
    }

    @When("^I search (.+) in the list$")
    public void searchTheList(String state) throws InterruptedException {
        list.enterSearchCriteria(state);
    }

    @Then("^I can find (.+) in the list$")
    public void theCityIsThere(String city) {
        List<String> resultsList = list.getAllSearchResults();
        boolean textIsThere = resultsList.contains(city);

        if(textIsThere) {
            System.out.println("The text is on the list: PASSED");
        } else {
            throw new Error("The text is not on the list: FAILED!");
        }
    }
}
