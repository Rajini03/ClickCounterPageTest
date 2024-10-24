import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickCounterTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\91739\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qaclickcounter.ccbp.tech/");
        System.out.println("Open Browser");


        for (int i = 1; i <= 100; i++) {
            WebElement clickMeBut = driver.findElement(By.xpath("//button[contains(text() , 'Click Me!')]"));
            clickMeBut.click();

            WebElement spanEle = driver.findElement(By.xpath("//span[contains(@class , 'counter')]"));
            String currentCount = (spanEle.getText());

            if (currentCount.equals(String.valueOf(i))){
                 System.out.println(i);
            }
            else {
                System.out.println("Mismatch in count");
                break;
            }
            if (i == 100){
                System.out.println("Click Counter App: Working as expected");
            }
        }

        driver.quit();



    }
}
