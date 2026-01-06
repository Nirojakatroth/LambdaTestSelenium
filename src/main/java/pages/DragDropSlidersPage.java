package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragDropSlidersPage {
    WebDriver driver;

    By slider = By.xpath("//input[@value='15']");
    By sliderValue = By.xpath("//output[@id='rangeSuccess']");

    public DragDropSlidersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adjustSlider(int desiredValue) {
        WebElement sliderElement = driver.findElement(slider);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", sliderElement, desiredValue);

        js.executeScript("arguments[0].dispatchEvent(new Event('input'))", sliderElement);
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText().trim();
    }
}
