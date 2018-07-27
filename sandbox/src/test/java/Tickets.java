import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by serg on 24.07.2018.
 */
public class Tickets {

  ChromeDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void ticketFinder() {
    wd.get("https://pass.rzd.ru/main-pass/public/ru");
    wd.findElement(By.id("name0")).sendKeys("Курск");
    wd.findElement(By.id("name1")).sendKeys("Москва");
    wd.findElement(By.cssSelector("div.box-form__datetime__calendar.sh_calendar")).click();
    wd.findElement(By.xpath("//div[@class='bg']/div/div[2]/div/div[2]/ul/li[12]/span")).click();
    wd.findElement(By.id("Submit")).click();

    WebElement poezd = getWebElementByText(By.className("route-item"), "742А");

    List<WebElement> wagonClasses = poezd.findElements(By.className("route-carType-item"));
    WebElement mesta = null;
    for (WebElement wagonClass : wagonClasses) {
      if (wagonClass.getText().contains("Сидячий")) {
        wagonClass.click();
        List<WebElement> wagons = wd.findElements(By.className("route-car-num"));
        for (WebElement wagon : wagons) {
          wagon.click();
          System.out.println(wagon.getText());
          new WebDriverWait(wd, 4).until(ExpectedConditions.elementToBeClickable(wagon));

          List<WebElement> seats = wd.findElements(By.className("s-occup"));

          for (WebElement seat : seats) {
            System.out.println(seat.getText());
          }
        }
      }
    }
  }
  private WebElement getWebElementByText(By locator, String text) {
    List<WebElement> elements = wd.findElements(locator);
    WebElement poezd = null;
    for (WebElement element : elements) {
      if (element.getText().contains(text)) {
        poezd = element;
      }
    }
    return poezd;
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
