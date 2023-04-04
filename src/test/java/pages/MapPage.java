package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MapPage {
    public static final By MAP_PAGE = By.cssSelector("div.map_with_list__container");
    public static final By FIRST_HOTEL = By.cssSelector(".map-card__content-container");

    //1.7 сохранить(в переменные) название отеля, количество звезд, среднюю оценку,
    // количество отзывов, стоимость
    public static final By NAME_HOTEL = By.cssSelector("div.map-card__title");
    public static final By FIELD_WITH_STARS = By.cssSelector("span.bui-rating.bui-rating--smaller");
    public static final By AVERAGE_RATING = By.cssSelector("div.bui-review-score__badge");
    public static final By NUMBER_OF_REVIEWS = By.cssSelector("div.bui-review-score__text");
    public static final By COST = By.cssSelector("span.prco-valign-middle-helper");
    public static final By MOVING_MARKER = By.cssSelector(".atlas-marker.hotel.bounce");




    public MapPage findFirstHotel() throws InterruptedException {
        Thread.sleep(5000);
        $(MAP_PAGE).shouldBe(Condition.visible,Duration.ofSeconds(5)).hover();
        Thread.sleep(5000);
        $(FIRST_HOTEL).shouldBe(Condition.visible,Duration.ofSeconds(10)).hover();
        return this;
    }

    public String getNameOfHotel(){
        return $(NAME_HOTEL).innerText();
    }

    public MapPage getNumberOfStar() {
        String parentElement = $$(FIELD_WITH_STARS).get(0).getAttribute("aria-label");
        System.out.println(parentElement);
        return this;
    }
    public String getAverageRating(){
        return $(AVERAGE_RATING).innerText();
    }
    public String getNumberOfReviews(){
        return $(NUMBER_OF_REVIEWS).innerText();
    }
    public String getCost(){
        return $(COST).innerText();
    }

    public MapPage clickMovingMarker(){
        $(MOVING_MARKER).click();
        Selenide.switchTo().window(1);
        return this;
    }
}
