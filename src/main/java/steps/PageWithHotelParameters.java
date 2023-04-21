package steps;

import java.util.HashMap;
import java.util.Map;

public interface PageWithHotelParameters {
    String getNameOfHotel() throws InterruptedException;

    String getNumberOfStars() throws InterruptedException;

    String getAverageRating() throws InterruptedException;

    String getNumberOfReviews();

    String getCost();

    default Map<String, String> getParameterMap() throws InterruptedException {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name", this.getNameOfHotel());
        hashMap.put("numberOfStars", this.getNumberOfStars());
        hashMap.put("rating", this.getAverageRating());
        hashMap.put("reviews", this.getNumberOfReviews());
        hashMap.put("cost", this.getCost());
        return hashMap;
    }
}