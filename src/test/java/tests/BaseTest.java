package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;

import java.io.File;

public class BaseTest {
    ObjectMapper mapper;
    File file;
    @Before
    public void setup(){
        mapper = new ObjectMapper(new YAMLFactory());
        file = new File("src/test/java/yaml/inputData.yml");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}