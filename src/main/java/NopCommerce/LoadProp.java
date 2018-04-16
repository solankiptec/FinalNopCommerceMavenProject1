package NopCommerce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp extends BasePage {

    static Properties prop;
    static String fileName = "TestDataConfig.properties";
    static String filelocation = "src\\test\\Resources\\Properties\\";
    static FileInputStream input;

    public String getProperty(String key) {
        prop = new Properties();
        try
        {
            input = new FileInputStream(filelocation + fileName);
            prop.load(input);
            input.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop.getProperty(key);

    }
}
