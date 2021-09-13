package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//we get our matchers from hamcrest
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
//we get our assertions from junit
import static org.junit.Assert.assertThat;

public class Test_1 extends Base_Test{

    @Test
    //we make this method private because we will only use it within this class
    private void Test_1_a(){
        //we add an implicit wait, meaning when we call the driver it will keep trying the command
        //for the amount of time we've set, if the command cannot be performed within this time an error is shown
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        //this line tells the driver to search for the url
        driver.navigate().to("https://demoqa.com/");

        //info passed to Logger
        //logger.info("Navigated to computer database");

        //this line tells the driver to find an element with a specific (div) classname and then click on that element
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]")).click();

        //Below we use an assertion assertThat. This comes from the JUnit library.
        //We also use Matchers. These come from the Hamcrest library. We use these to improve code readability.
        //The following is how we determine whether the test was successful, i.e. whether the website did what we
        //expected it should. Here we ask whether the URL of the current site is the URL for the "Add a computer" page
        //if there is no error message starting with java.lang.AssertionError then our test was successful
        assertThat(driver.getCurrentUrl(), is(equalTo("https://demoqa.com/elements")));

        //logger.info("Test Comp_link finished");
    }

}
