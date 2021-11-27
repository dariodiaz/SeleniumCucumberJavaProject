package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {

    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon() {
        amazon.navigateToAmazon();
    }

    @And("^searches for(.+)$")
    public void enterSearchCriteria(String criteria) {
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber) {
        amazon.goToPage(pageNumber);
    }

    @And("^selects the third item$")
    public void itemCanBeAddedToTheCart() {
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
}
