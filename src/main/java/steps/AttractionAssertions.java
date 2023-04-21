package steps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AttractionAssertions {
    public static void assertAttractionEquals(Map<String, String> map1, Map<String, String> map2) {
        List<Executable> assertList = new ArrayList<>();
        assertList.add(() -> assertEquals(map1.size(), map2.size()));
        for (String key : map1.keySet()) {
            assertList.add(() -> assertEquals(map1.get(key), map2.get(key)));
        }
        Assertions.assertAll(assertList);
    }
}