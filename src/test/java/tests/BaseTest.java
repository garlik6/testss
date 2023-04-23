package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Before;

import java.io.File;

public class BaseTest {
    ObjectMapper mapper;
    private File file;
    @Before
    public void setup(){
        mapper = new ObjectMapper(new YAMLFactory());
        file = new File("src/test/java/yaml/inputData.yml");
    }
}