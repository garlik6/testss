package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AttractionsPage {
    public static final By SEARCH_FIELD = By.cssSelector("[type='search']");
    public static final By FIRST_IN_DROPDOWN = By.cssSelector(".css-9dv5ti");
    public static final By DATA_FIELD = By.cssSelector("div.css-ck8kih");
    public static final String DATA = "span[data-date='%s']";
    public static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");
    
    public static final By POP_UP_WINDOW = By.xpath("//div[@class='e5aa33035e']//button");

    @Step("Ввести в поиске любой город(заграничный), выбрать случайные даты и нажать на кнопку «Проверить цены»" +
            "с параметрами: city={0}, startData={0}, endData={0}")
    public AttractionsPage searchCityAndData(String city, String startData, String endData) {
        $(SEARCH_FIELD).sendKeys(city);
        $(FIRST_IN_DROPDOWN).click();
        $(DATA_FIELD).click();
        $(String.format(DATA, startData)).click();
        $(String.format(DATA, endData)).click();
        $(SUBMIT_BUTTON).click();
        return this;
    }

    public AttractionsPage closePopUpWindow(){
        $(POP_UP_WINDOW).click();
        return this;
    }
}