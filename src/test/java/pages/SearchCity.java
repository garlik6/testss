package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchCity {

    public static final By CITY_HEADER = By.xpath("//h1");
    public static final By MAP_BUTTON_2 = By.xpath("//div[@data-testid='map-trigger']");

    public SearchCity checkCityHeader(String city) {
        $(CITY_HEADER).shouldHave(Condition.text(city));
        return this;
    }

    public SearchCity clickMapButton() throws InterruptedException {
        $(MAP_BUTTON_2).click();
        Thread.sleep(1000);
        return this;
    }
}