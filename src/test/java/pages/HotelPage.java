package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HotelPage {

    // 1.9 на открывшейся странице отеля проверить название отеля,
    // количество звезд, среднюю оценку, количество отзывов и стоимость

    public static final By HOTEL_NAME = By.xpath("//h2");
//    public static final By FIELD_WITH_STARS = By.xpath("//span[@data-testid='rating-stars']");
//    public static final By STAR = By.xpath("//span[@data-testid='rating-stars']//span");
    public static final By AVERAGE_RATING = By.cssSelector("div.b5cd09854e.d10a6220b4");
    public static final By NUMBER_OF_REVIEWS = By.cssSelector("div.d8eab2cf7f.c90c0a70d3.db63693c62");
    public static final By COST = By.cssSelector(".prco-valign-middle-helper");

    public String getHotelName(){
        return $(HOTEL_NAME).innerText();
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
}
