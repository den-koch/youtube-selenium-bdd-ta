package utils;

import java.util.ResourceBundle;

public class DataReader {

    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(System.getProperty("env", "qa"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }

}
