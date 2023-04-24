package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import steps.PageWithAttractionParameters;

import static com.codeborne.selenide.Selenide.$;

public class FirstAttractionPage implements PageWithAttractionParameters {
    public static final By NAME_ATTRACTION = By.xpath("//h2");
    public static final By PRICE_ATTRACTION = By.cssSelector(".bfe2feb671");

    @Step("на открывшейся странице достопримечательности проверить название достопримечательности")
    public String getNameOfAttraction() {
        return $(NAME_ATTRACTION).innerText();
    }

    @Step("на открывшейся странице достопримечательности проверить цену достопримечательности")
    public String getPriceOfAttraction() {
        return $(PRICE_ATTRACTION).innerText();
    }
}