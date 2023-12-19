package TestNG.DataProviders;

import org.testng.annotations.Test;

public class login {

    @Test(dataProvider = "credProvider", dataProviderClass = credProvider.class)
    void loginTest(String email, String pass, String uname) {
        System.out.println(email + "     " + pass+ "     " + uname); //built in loop in the provider
    }

}
