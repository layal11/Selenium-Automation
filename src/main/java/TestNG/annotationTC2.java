package TestNG;

import org.testng.annotations.*;

public class annotationTC2 {

    @BeforeClass
    void beforeClass() {
        System.out.println("execute before the class");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("execute before every method");
    }

    @Test(priority = 1)
    void test3() {
        System.out.println("test3");
    }

    @Test(priority = 2, enabled = false)//this method will not execute
    void test4() {
        System.out.println("test4");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("execute after every method");
    }

    @AfterClass
    void afterClass() {
        System.out.println("execute after the class");
    }

}
