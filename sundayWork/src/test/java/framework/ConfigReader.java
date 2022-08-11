package framework;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class ConfigReader {
    DesiredCapabilities desiredCapabilities;
    private static Yaml properties;
    static Map<String, Object > data;

    public static Map initialize_Properties() {
        properties = new Yaml();

        /*File config = new File("sundayWork/src/test/resources/file");
        File yamlFile = new File(config,"config.yaml");*/


        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/file/config.yaml");
            data = properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}