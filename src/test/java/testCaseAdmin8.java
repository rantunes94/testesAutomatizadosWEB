import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class  testCaseAdmin8 extends junit.framework.TestCase {
   private WebDriver driver;
   private String baseUrl;
   private boolean acceptNextAlert = true;
   private StringBuffer verificationErrors = new StringBuffer();

   @Before
   public void setUp() throws Exception {
       Logger.getLogger("").setLevel(Level.OFF);
       System.setProperty("webdriver.gecko.driver",
               "drivers\\geckodriver.exe");
       System.setProperty("webdriver.edge.driver",
               "drivers\\MicrosoftWebDriver.exe");
       System.setProperty("webdriver.chrome.driver",
               "drivers\\chromedriver.exe");
       System.setProperty("phantomjs.binary.path",
               "drivers\\phantomjs.exe");
       driver = new ChromeDriver();
       baseUrl = "http://159.65.29.212";
       driver.manage().window().setSize(new Dimension(1024,768));
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }

   @Test
   public void testTestCaseAdmin8() throws Exception {
       driver.get("http://159.65.29.212/login");
       driver.findElement(By.id("password")).clear();
       driver.findElement(By.id("password")).sendKeys("password_tp18_p");
       driver.findElement(By.id("email")).clear();
       driver.findElement(By.id("email")).sendKeys("profissionaldesaude@mail.com");
       driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
       driver.findElement(By.linkText("Fórum")).click();
       driver.findElement(By.id("new_category_btn")).click();

       driver.findElement(By.name("name")).sendKeys("Automatizados");
       Thread.sleep(2000);
       driver.findElement(By.id("submit_category")).click();
       driver.findElement(By.linkText("Automatizados")).click();
       driver.findElement(By.id("new_discussion_btn")).click();
       driver.findElement(By.id("title")).clear();
       driver.findElement(By.id("title")).sendKeys("Teste");


       driver.switchTo().frame(driver.findElement(By.id("body_ifr")));
       //driver.findElement(By.cssSelector("tinymce.mce-content-body p")).click();
       driver.findElement(By.id("tinymce")).sendKeys("TesteTEEEEEEEEESTE sadasdsad");
       driver.switchTo().defaultContent();

       driver.findElement(By.id("submit_discussion")).click();
       assertEquals("Nova Discussão criada com Sucesso.", driver.findElement(By.xpath("//div[@id='chatter']/div[2]/div")).getText());



       driver.findElement(By.cssSelector("i.chatter-back")).click();
       driver.findElement(By.linkText("Automatizados")).click();
       driver.findElement(By.id("delete-button")).click();
       Thread.sleep(1000);
       driver.findElement(By.cssSelector("button.btn.btn-danger")).click();

   }

   @After
   public void tearDown() throws Exception {
       driver.quit();
       String verificationErrorString = verificationErrors.toString();
       if (!"".equals(verificationErrorString)) {
           fail(verificationErrorString);
       }
   }

   private boolean isElementPresent(By by) {
       try {
           driver.findElement(by);
           return true;
       } catch (NoSuchElementException e) {
           return false;
       }
   }

   private boolean isAlertPresent() {
       try {
           driver.switchTo().alert();
           return true;
       } catch (NoAlertPresentException e) {
           return false;
       }
   }

   private String closeAlertAndGetItsText() {
       try {
           Alert alert = driver.switchTo().alert();
           String alertText = alert.getText();
           if (acceptNextAlert) {
               alert.accept();
           } else {
               alert.dismiss();
           }
           return alertText;
       } finally {
           acceptNextAlert = true;
       }
   }
}

