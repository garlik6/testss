package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MapPage {
    public static final By FIRST_HOTEL_1 = By.cssSelector(".map-card__content-container");
    public static final By FIRST_HOTEL_2 = By.xpath("//span[@data-testid='header-title']");

    //1.7 сохранить(в переменные) название отеля, количество звезд, среднюю оценку,
    // количество отзывов, стоимость
    public static final By NAME_HOTEL_1 = By.cssSelector("div.map-card__title");
    public static final By NAME_HOTEL_2 = By.xpath("//div[@data-testid='header-container']");
    public static final By FIELD_WITH_STARS = By.cssSelector("span.bui-rating.bui-rating--smaller");
    public static final By FIELD_WITH_SQUARES = By.xpath("//span[@data-testid='rating-squares']");

    public static final By AVERAGE_RATING = By.cssSelector("div.bui-review-score__badge");
    public static final By NUMBER_OF_REVIEWS = By.cssSelector("div.bui-review-score__text");
    public static final By COST = By.cssSelector("span.prco-valign-middle-helper");
    public static final By MOVING_MARKER = By.cssSelector(".atlas-marker.hotel.bounce");


    public MapPage findFirstHotel() throws InterruptedException {
        if ($(FIRST_HOTEL_1).isDisplayed()) {
            $(FIRST_HOTEL_1).shouldBe(Condition.visible).hover();
        } else {
            $(FIRST_HOTEL_2).shouldBe(Condition.visible).hover();
        }
        Thread.sleep(5000);
        return this;
    }

    public String getNameOfHotel() {
        if ($(NAME_HOTEL_2).exists()) {
            return $(NAME_HOTEL_2).innerText();
        } else {
            return $(NAME_HOTEL_1).innerText();
        }
    }

    public Long getNumberOfStar() {
        if($(FIELD_WITH_STARS).exists()){
            String parentElement = $$(FIELD_WITH_STARS).get(0).getAttribute("aria-label");
            assert parentElement != null;
            return Long.parseLong(parentElement.split(" ")[0]);
        }else{
            return executeJavaScript("return $(arguments[0]).children().length", $(FIELD_WITH_SQUARES));
        }
    }

    public String getAverageRating() {
        return $(AVERAGE_RATING).innerText();
    }

    public String getNumberOfReviews() {
        return $(NUMBER_OF_REVIEWS).innerText();
    }

    public String getCost() {
        return $(COST).innerText();
    }

    public MapPage clickMovingMarker() {
        $(MOVING_MARKER).click();
        Selenide.switchTo().window(1);
        return this;
    }
}