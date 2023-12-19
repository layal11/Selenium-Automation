package TestNG.DataProviders;

import org.testng.annotations.DataProvider;

public class credProvider {

    @DataProvider(name = "credProvider")
    public Object[][] data() { //2 dimensional array
        Object[][] data = {
                {"layal@gmail.com", "123", "layal"},
                {"majd@gmail.com", "123", "majd"},
                {"zaher@gmail.com", "123", "zaher"},
        };
        return data;
    }
}
