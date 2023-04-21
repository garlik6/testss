package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.*;
import steps.AttractionAssertions;
import steps.HotelAssertions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SelenideTests {
    HomePage homePage = new HomePage();
    SearchCity searchCity = new SearchCity();
    MapPage mapPage = new MapPage();
    HotelPage hotelPage = new HotelPage();
    AttractionsPage rentCarPage = new AttractionsPage();
    SearchAttractions searchAttractions = new SearchAttractions();
    FirstAttractionPage firstAttractionPage = new FirstAttractionPage();

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String startData = formatter.format(date);
    String endData = formatter.format(date.plusDays(2));
    private String city = "Лондон";


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

        Map<String, String> hotelParamsFromMapPage = mapPage.getParameterMap();
//        hotelParamsFromMapPage.put("name", "Test");
//        hotelParamsFromMapPage.put("cost","Test");

        mapPage.findFirstHotel();
        mapPage.clickMovingMarker();

        Map<String, String> hotelParamsFromHotelPage = hotelPage.getParameterMap();

        HotelAssertions.assertHotelEquals(hotelParamsFromMapPage, hotelParamsFromHotelPage);

    }

    @Test
    @DisplayName("Тест-кейс 2")
    public void testScenario_2() throws InterruptedException {

        //2.1 зайти на сайт https://www.booking.com/
        //2.2 нажать на кнопку «Варианты досуга»
        //2.3 ввести в поиске любой город(заграничный)
        //2.4 выбрать случайные даты
        //2.5 нажать на кнопку «Проверить цены»
        //2.6 на открывшейся странице достопримечательностей нажать на кнопку "Самая низкая цена"
        //2.7 сохранить(в переменные) название первой достопримечательности и цену
        //2.8 нажать на первую достопримечательность
        //2.7 на открывшейся странице достопримечательности проверить название и цену

        homePage.openHomePage()
                .acceptCookie()
                .clickAttractionsButton();

        rentCarPage.searchCityAndData(city, startData, endData);
        searchAttractions.clickLowPrice();

        Map<String, String> attractionParamsFromSearchAttractions = searchAttractions.getAttractionParams();

        searchAttractions.clickFirstAttraction();

        Map<String, String> attractionParamsFromFirstAttractionPage = firstAttractionPage.getAttractionParams();

        AttractionAssertions.assertAttractionEquals(attractionParamsFromSearchAttractions, attractionParamsFromFirstAttractionPage);
    }
}