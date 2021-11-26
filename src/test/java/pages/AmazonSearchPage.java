package pages;

import steps.AmazonSearchSteps;

public class AmazonSearchPage extends BasePage {

    private String searchBox;
    private String searchButton;
    private String thirdResult;
    private String addToCartButton;
    private String addedMessageText;

    public AmazonSearchPage() {
        super(driver);
    }

    public void navigateToAmazon() {
        navigateTo("https://www.amazon.com");
    }

    public void enterSearchCriteria(String criteria) {
        write(searchBox, criteria);
    }

    public void clickSearch() {
        clickElement(searchButton);
    }

    public void goToPage2() {
        goToLinkText("2");
    }

    public void pick3rdItem() {
        clickElement(thirdResult);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addedMessageText);
    }

}
