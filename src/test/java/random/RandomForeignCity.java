package random;

import java.util.Random;

public class RandomForeignCity {
    private static final String[] FOREIGN_CITY = {"Акапулько",
            "Бока-Чика", "Варадеро", "Голд Кост", "Дубай", "Канкун",
            "Майами", "Ницца", "Пуэрто", "Санья"};

    public static void main(String[] args) {
        String randomForeignCity = generateRandomForeignCity();
        System.out.println(randomForeignCity);
    }

    public static String generateRandomForeignCity() {
        Random random = new Random();
        String foreignCity = FOREIGN_CITY [random.nextInt(FOREIGN_CITY.length)];
        return foreignCity;
    }
}


