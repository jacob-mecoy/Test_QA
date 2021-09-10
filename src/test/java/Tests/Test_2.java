package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Test_2 extends Base_Test{

    @Test
    private void Comp_Add() //throws InterruptedException
    {

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.navigate().to("https://demoqa.com/");

        //this line tells the driver to find an element with a specific (div) classname and then click on that element
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[2]/svg")).click();

        //click the "Check Box" link on the left of the page
        driver.findElement(By.id("item-1")).click();

        //click the expand link
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/ol/li/span/button/svg")).click();
        //logger.info("Clicked Home expand link");

        //find the second expand link and click it
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/ol/li/ol/li[3]/span/button/svg/path")).click();
        //logger.info("Clicked Downloads expand link");

        //find the excel file checkbox and click it
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]/svg")).click();
        //logger.info("Clicked excel file checkbox");

        //define variable xpath as the Webelement we get from the text "You have selected : ..."
        WebElement xpath = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]"));

        //get element text - rendered text of specified element
        System.out.println(xpath.getText());
        //get element tagname
        System.out.println(xpath.getTagName());

        System.out.println(xpath.getText());

        //the following is how we determine whether the test was successful, i.e. whether the website did what we
        //expected it should.
        //assertThat(xpath, is(equalTo("http://computer-database.herokuapp.com/computers")));

        //Thread.sleep(2500);
    }
}
