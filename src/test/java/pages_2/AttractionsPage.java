package pages_2;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AttractionsPage {
    public static final By SEARCH_FIELD = By.cssSelector("[type='search']");
    public static final By FIRST_IN_DROPDOWN = By.cssSelector(".css-9dv5ti");
    public static final By DATA_FIELD = By.cssSelector("div.css-ck8kih");
    public static final String DATA = "span[data-date='%s']";
    public static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");

    public AttractionsPage searchCityAndData(String city, String startData, String endData) {
        $(SEARCH_FIELD).sendKeys(city);
        $(FIRST_IN_DROPDOWN).click();
        $(DATA_FIELD).click();
        $(String.format(DATA, startData)).click();
        $(String.format(DATA, endData)).click();
        $(SUBMIT_BUTTON).click();
        return this;
    }
}
