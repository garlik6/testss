package pages_2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchAttractions {

    public static final By LOW_PRICE_BUTTON = By.xpath("//label[text()='Самая низкая цена']");
    public static final By NAME_FIRST_ATTRACTION = By.xpath("//h4");
    public static final By PRICE_FIRST_ATTRACTION = By.cssSelector("div.ac78a73c96");
    public static final By FIRST_ATTRACTION_FIELD = By.cssSelector("[data-testid='card']");

    public SearchAttractions clickLowPrice() throws InterruptedException {
        Thread.sleep(5000);
        $(LOW_PRICE_BUTTON).shouldBe(Condition.visible).click();
        return this;
    }

    public String getNameFirstAttraction() {
        return $(NAME_FIRST_ATTRACTION).innerText();
    }

    public String getPriceFirstAttraction() {
        return $(PRICE_FIRST_ATTRACTION).innerText();
    }

    public SearchAttractions clickFirstAtracction() throws InterruptedException {
        $(FIRST_ATTRACTION_FIELD).click();
        Selenide.switchTo().window(1);
        Thread.sleep(5000);
        return this;
    }
}