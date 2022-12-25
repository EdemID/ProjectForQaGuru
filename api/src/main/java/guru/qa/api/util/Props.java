package guru.qa.api.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {

    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    private String email;
    private String password;

    public Props() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);

            email = prop.getProperty("email");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
