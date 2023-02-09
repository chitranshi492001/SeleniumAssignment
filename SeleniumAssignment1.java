package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumAssignment1 {
    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver","/Users/cchoudhary/Downloads/chromedriver_mac64/chromedriver");
        WebDriver driver =new ChromeDriver();

        //launch Google Website
        driver.get("https:google.com");

        //Search the Amazon.in Website
        WebElement searchbar=driver.findElement(By.xpath("//input[@title='Search']"));//locate the search bar
        searchbar.sendKeys("amazon.in");
        searchbar.submit();//redirect to amazon

        //Select the first showing link
        WebElement amazonlink=driver.findElement(By.xpath("//h3[normalize-space()='Amazon.in']"));
        amazonlink.click();

        //Open dropdown and select electronicoption
        WebElement drpdwn=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        drpdwn.click();

        Select drp =new Select(drpdwn);
        //To print all the categories on the console
        List<WebElement> listdrpdwn=drp.getOptions();
        for(WebElement e: listdrpdwn){
            System.out.println(e.getText());
        }
        drp.selectByValue("search-alias=electronics");

        //submit the electronic option
        WebElement search=driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
        search.submit();

        //Search Sony Bravia on the search bar
        WebElement searchsmthg=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchsmthg.sendKeys("Sony Bravia 55 inch");
        searchsmthg.submit();

        ////Print price on console
        WebElement price=driver.findElement(By.className("a-price-whole"));
        System.out.println(price.getText());

        //End the Browser
        driver.quit();


    }
}
