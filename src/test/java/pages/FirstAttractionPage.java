package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FirstAttractionPage {
    public static final By NAME_ATTRACTION = By.xpath("//h2");
    public static final By PRICE_ATTRACTION = By.cssSelector(".bfe2feb671");

    public String getName() {
        return $(NAME_ATTRACTION).innerText();
    }

    public String getPrice() {
        return $(PRICE_ATTRACTION).innerText();
    }
}
