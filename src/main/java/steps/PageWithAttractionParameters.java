package steps;

import java.util.HashMap;
import java.util.Map;

public interface PageWithAttractionParameters {
    String getNameOfAttraction();

    String getPriceOfAttraction();

    default Map<String, String> getAttractionParams() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("nameAttraction", this.getNameOfAttraction());
        hashMap.put("priceAttraction", this.getPriceOfAttraction());
        return hashMap;
    }
}