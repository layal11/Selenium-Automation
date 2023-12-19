package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependency {

    @Test
    void startEngine() {
        System.out.println("Start car");
        Assert.fail();
    }

    @Test(dependsOnMethods = "startEngine")
    void driveCar() {
        System.out.println("drive");
    }

    @Test(dependsOnMethods = "driveCar")
    void stop() {
        System.out.println("stop");
    }

    @Test(dependsOnMethods = {"driveCar", "stop"}, alwaysRun = true)
    void park() {
        System.out.println("park");
    }
}
