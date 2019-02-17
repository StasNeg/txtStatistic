import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceTest {

    @Test
    public void getResources() {
        Properties prop = new Properties();
        try (final InputStream stream =
                     this.getClass().getResourceAsStream("\\resources\\dataBase.properties")) {
            prop.load(stream);
            Assert.assertEquals("txt_file_statistic", prop.getProperty("schema"));
            /* or properties.loadFromXML(...) */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
