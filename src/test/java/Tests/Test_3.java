package Tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_3 extends Base_Test{

    @Test
    private void Test_3_a(){

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.navigate().to("https://demoqa.com/");
    }
}
