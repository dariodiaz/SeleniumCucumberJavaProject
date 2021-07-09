package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage() {
        super(driver);
    }

    public void enterSearchCriteria() throws InterruptedException {
        Thread.sleep(500);
        write(searchField, "Washington");
    }

    public List<String> getAllSearchResults() {
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();
        for(WebElement e : list) {
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }
}
