package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.HomePage;
import pages.HotelPage;
import pages.MapPage;
import pages.SearchCity;

import static org.junit.Assert.assertEquals;

public class SelenideTests {
    HomePage homePage = new HomePage();
    SearchCity searchCity = new SearchCity();
    MapPage mapPage = new MapPage();
    HotelPage hotelPage = new HotelPage();
    private String city = "Канкун";
    private String startData = "2023-04-29";
    private String endData = "2023-05-02";

    @Test
    @DisplayName("Тест-кейс 1")
    public void testScenario_1() throws InterruptedException {

        //1.1 зайти на сайт https://www.booking.com/
        //1.2 ввести в поиске любой город(заграничный)
        //1.3 выбрать случайные даты
        //1.4 нажать на кнопку «Найти»
        //1.5 нажать на кнопку «Показать на карте»
        //1.6 навести курсор на первый отель(карточка слева)
        //1.7 сохранить(в переменные) название отеля, количество звезд, среднюю оценку,
        // количество отзывов, стоимость
        //1.8 нажать на прыгающий маркер на карте
        //1.9 на открывшейся странице отеля проверить название отеля,
        // количество звезд, среднюю оценку, количество отзывов и стоимость

        homePage.openHomePage()
                .acceptCookie()
                .searchCityAndData(city, startData, endData);

        searchCity.checkCityHeader(city)
                  .clickMapButton();

        String name = mapPage.getNameOfHotel().trim();
        Long numberOfStars = mapPage.getNumberOfStar();
        String rating = mapPage.getAverageRating().trim();
        String reviews = mapPage.getNumberOfReviews().trim();
        String cost = mapPage.getCost().trim();

        mapPage.findFirstHotel();
        mapPage.clickMovingMarker();

        String newName = hotelPage.getHotelName().trim();
        Long newNumberOfStars = hotelPage.getStars();
        String newRating = hotelPage.getAverageRating();
        String newReview = hotelPage.getNumberOfReviews().trim();
        String newCost = hotelPage.getCost().trim();

        assertEquals(name, newName);
        assertEquals(numberOfStars, newNumberOfStars);
        assertEquals(rating, newRating);
        assertEquals(reviews, newReview);
        assertEquals(cost, newCost);
    }
}