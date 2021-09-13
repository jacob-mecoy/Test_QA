package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertThat;

public class Test_2 extends Base_Test{

    //this is a positive test that makes sure that when we add valid information into the Practice Form, our info is submitted
    @Test
    private void Test_2_a() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.navigate().to("https://demoqa.com/");

        //we use the full XPath of the main <div> tag for the button
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]")).click();

        //click the "Practice Form" section on the left. We use the <ul> tag for xpath
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul")).click();

        //First Name field, found using xpath of <input> tag
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[1]/div[2]/input")).sendKeys("Brad");

        //Last Name field
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[1]/div[4]/input")).sendKeys("Pitt");

        //email field
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/input")).sendKeys("bradpitt@gmail.com");

        //select male
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div[1]/label")).click();

        //enter mobile number
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[4]/div[2]/input")).sendKeys("11111111111");

        //click on date of birth text field to bring up the mini calendar
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[1]/div/input")).click();

        //select Month from dropdown
        Select SelMonth = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")));
        SelMonth.selectByVisibleText("July");

        //select Year from dropdown
        Select SelYear = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")));
        SelYear.selectByVisibleText("1969");

        //select the specific element for day 3
        driver.findElement(By.className("react-datepicker__day--003")).click();

        //Adding the Subject "English"
        //buried within the div containers there is an <input> element that allows us to sendkeys to it! We call this WebElement "Text"
        WebElement Text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div[2]/div/div/div[1]/div[2]/div/input"));
        //we need only enter "E" since the field auto-generates the subject we want
        Text.sendKeys("E");
        //"English" is selected automatically so all we need to do is click enter
        Text.sendKeys(Keys.ENTER);

        //click Sports option in Hobbies (we must take the xpath from the <label> element)
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[7]/div[2]/div[1]/label")).click();

        //enter address
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[9]/div[2]/textarea")).sendKeys("My house");

        //select State
        WebElement State = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[10]/div[2]/div/div/div[1]/div[2]/div/input"));
        State.sendKeys("Har");
        State.sendKeys(Keys.ENTER);

        //select City
        WebElement City = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[10]/div[3]/div/div/div[1]/div[2]/div/input"));
        City.sendKeys("kar");
        City.sendKeys(Keys.ENTER);

        //click submit button
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[11]/div/button")).click();

        //finally we make sure our information has been submitted. We do this by verifying that an element on
        //the pop-up message (that only appears if our information is accepted) has the text value we know it should have (seeing
        // as it is just static text), if the element can't be found then an error will be thrown
        assertThat(driver.findElement(By.className("modal-title")).getText(), is(equalTo("Thanks for submitting the form")));

        Thread.sleep(2500);
    }
}
