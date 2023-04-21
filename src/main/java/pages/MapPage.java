package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import steps.PageWithHotelParameters;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class MapPage implements PageWithHotelParameters {
    public static final By FIRST_HOTEL_1 = By.cssSelector(".map-card__content-container");
    public static final By FIRST_HOTEL_2 = By.xpath("//span[@data-testid='header-title']");

    //1.7 сохранить(в переменные) название отеля, количество звезд, среднюю оценку,
    // количество отзывов, стоимость
    public static final By NAME_HOTEL_1 = By.cssSelector("div.map-card__title");
    public static final By NAME_HOTEL_2 = By.xpath("//div[@data-testid='header-container']");
    public static final By FIELD_WITH_STARS = By.cssSelector("span.bui-rating.bui-rating--smaller");
    public static final By FIELD_WITH_SQUARES = By.xpath("//span[@data-testid='rating-squares']");
    public static final By AVERAGE_RATING_1 = By.cssSelector("div.bui-review-score__badge");
    public static final By AVERAGE_RATING_2 = By.xpath("//div[@class='c3deae0c07']//div//div");
    public static final By NUMBER_OF_REVIEWS = By.cssSelector("div.bui-review-score__text");
    public static final By COST = By.cssSelector("span.prco-valign-middle-helper");
    public static final By MOVING_MARKER = By.cssSelector(".atlas-marker.hotel.bounce");

    public MapPage findFirstHotel() throws InterruptedException {
        Thread.sleep(5000);
        if ($(FIRST_HOTEL_1).exists()) {
            $(FIRST_HOTEL_1).shouldBe(Condition.visible).hover();
        } else {
            $(FIRST_HOTEL_2).shouldBe(Condition.visible).hover();
        }
        return this;
    }

    public String getNameOfHotel() throws InterruptedException {
        Thread.sleep(10000);
        if ($(NAME_HOTEL_1).exists()) {
            return $(NAME_HOTEL_1).innerText().trim();
        } else {
            return $(NAME_HOTEL_2).innerText().trim();
        }
    }

    public String getNumberOfStars() throws InterruptedException {
        Thread.sleep(5000);
        if ($(FIELD_WITH_STARS).exists()) {
            String parentElement = $$(FIELD_WITH_STARS).get(0).getAttribute("aria-label");
            assert parentElement != null;
            return parentElement.split(" ")[0];
        } else {
            return Objects
                    .requireNonNull(executeJavaScript("return $(arguments[0]).children().length", $(FIELD_WITH_SQUARES)))
                    .toString();
        }
    }

    public String getAverageRating() throws InterruptedException {
        Thread.sleep(5000);
        if ($(AVERAGE_RATING_1).exists())
            return $(AVERAGE_RATING_1).innerText().trim();
        else {
            return $(AVERAGE_RATING_2).innerText().trim();
        }
    }

    public String getNumberOfReviews() {
        return $(NUMBER_OF_REVIEWS).innerText().trim();
    }

    public String getCost() {
        return $(COST).innerText().trim();
    }

    public MapPage clickMovingMarker() {
        $(MOVING_MARKER).click();
        Selenide.switchTo().window(1);
        return this;
    }
}