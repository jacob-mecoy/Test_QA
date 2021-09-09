//this test acts as our Base for which our actual tests will extend and build on top of
package Tests;

//importing log4j logger classes
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//@BeforeTest, @AfterTest,... etc come from below library [Note there are annotations under the same name in junit]
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Test {

    // set these available as class variables so it is available globally and therefore shortens our code
    WebDriver driver;
    //here we create the logger using classes imported from log4j2 libraries
    //Logger logger = LogManager.getLogger(Base_Test.class);

    @BeforeTest
    public void Pre_Test()
    {
        System.out.println("Test start");

        //This line creates an object of the WebDriver class and calls it "driver". Its function is to open Chrome
        driver = new ChromeDriver();

        //the line below maximises our window
        driver.manage().window().maximize();
    }

    //This method is called after each Test we've written
    @AfterTest
    public void Post_Test()
    {
        //this closes the window our test is running in
        driver.close();
        driver.quit();

        System.out.println("Test end");
    }

    //This method called after all tests are finished
    @AfterSuite//(alwaysRun = true)
    public void teardown(){
        System.out.println("All Tests Complete");
    }
}
