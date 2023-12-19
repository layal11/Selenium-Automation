package TestNG;

import org.testng.annotations.*;

public class annotationTC1 {

    @BeforeSuite
    void beforeSuite() {
        System.out.println("execute before the suite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("execute before the test");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("execute before the class");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("execute before every method");
    }

    @Test(priority = 1)
    void test1() {
        System.out.println("test1");
    }

    @Test(priority = 2)
    void test2() {
        System.out.println("test2");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("execute after every method");
    }

    @AfterClass
    void afterClass() {
        System.out.println("execute after the class");
    }

    @AfterTest
    void afterTest() {
        System.out.println("execute after the test");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("execute after the suite");
    }

}
