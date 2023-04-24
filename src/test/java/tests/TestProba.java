package tests;

import io.qameta.allure.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;


@Epic("Web tests")
@Feature("Booking website")
@DisplayName("Проверка параметров")
@Link(name = "Ссылка сайта", url = "https://www.booking.com/")
@Owner("Дребезова Наталья")
public class TestProba extends BaseTest {


    @Test
//    @ParameterizedTest(name="Проверка параметров отеля")
    @DisplayName("Пробный тест")
    @Description("Пробный тест")
    @Severity(SeverityLevel.BLOCKER)
    public void testScenario_1() throws InterruptedException, IOException {
        assert true;
    }
}

