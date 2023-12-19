package TestNG.Grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class grouping {
    @Test(groups = {"sanity"})
    void test1() {
        System.out.println("test 1");
        Assert.fail();
    }

    @Test(groups = {"regression"})
    void test2() {
        System.out.println("test 2");
    }

    @Test(groups = {"regression"})
    void test3() {
        System.out.println("test 3");
    }

    @Test(groups = {"negative"}, dependsOnGroups = {"sanity"}, alwaysRun = true)
    void test4() {
        System.out.println("test 4");
    }

    @Test(groups = {"negative"}, dependsOnGroups = {"sanity"})
    void test5() {
        System.out.println("test 5");
    }
}
