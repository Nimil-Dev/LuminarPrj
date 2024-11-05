package testpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagepkg.OpenCartLogin;
import utilities.Excelutils;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

public class OpenCartTest {
    WebDriver driver;
    OpenCartLogin openCartLogin;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
    }
    @Test
    public void Test() throws InterruptedException, IOException, AWTException
    {
    	OpenCartLogin OP=new OpenCartLogin(driver);
    	String xl="D:\\\\\\\\Saucedemo.xlsx";
    	String Sheet="Sheet1";
    	int row=Excelutils.getRowCount(xl, Sheet);
    	for(int i=1;i<=row;i++)
    	{
    		String un=Excelutils.getCellValue(xl, Sheet, i, 0);
    		System.out.println("username-----"+un);
    		String pswd=Excelutils.getCellValue(xl, Sheet, i, 1);
    		System.out.println("password---"+pswd);
    		OP.login();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
    		
    		OP.setValues(un, pswd);
    		
    		OP.loginbttn();
    		
    		String expurl="https://awesomeqa.com/ui/index.php?route=account/account";
    		String acturl=driver.getCurrentUrl();
    		if(expurl.equals(acturl))
    		{
    			System.out.println("login successful");
    			
    			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logo\"]/a/img")));
    			
    			OP.Home();	
    			
    			String Homeurl="https://awesomeqa.com/ui/index.php?route=common/home";
    			if(driver.getCurrentUrl().equals(Homeurl))
    			{
    				System.out.println("Succefully loaded homepage");
    			}
    			else
    			{
    				System.out.println("Homepage not loaded");
    			}
    			
    			OP.addtocart();
    			
    			By cartLocate = By.xpath("//*[@id='cart-total']");
    			try {
    			    String cartTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocate)).getText();
    			    String[] parts = cartTotal.split(" ");
    			    int itemCount = Integer.parseInt(parts[0]); // Assuming the first part is the item count
    			    if (itemCount > 0) 
    			    {
    			        System.out.println("Item added to cart successfully. Cart item count: " + itemCount);
    			    } 
    			    else 
    			    {
    			        System.out.println("Item not added to the cart. Current item count: " + itemCount);
    			    }
    			} 
    			catch (Exception e) 
    			{
    			    System.out.println("An expected error occured: " + e.getMessage());
    			}
    			
    			OP.cart();
    			
    			String carturl="https://awesomeqa.com/ui/index.php?route=checkout/cart";
    			if(driver.getCurrentUrl().equals(carturl))
    			{
    				System.out.println("Cart is opened");
    			}
    			else
    			{
    				System.out.println("cart is not opened");
    			}
    			
    			OP.remove();
    			
    			OP.checkout();
    			
    			String checkouturl="https://awesomeqa.com/ui/index.php?route=checkout/checkout";
    			if(driver.getCurrentUrl().equals(checkouturl))
    			{
    				System.out.println("Checkout page is opened");
    			}
    			else
    			{
    				System.out.println("Checkout page not loaded");
    			}
    			OP.billing("Shobha","rajan","Snehaveed,Pathanamthitta","Thiruvalla","789101");
    			OP.Nextbttn();
    			OP.Homebtn();
    			OP.search();
    			OP.NewProduct();
    			OP.calender();
    			OP.ProductReview();
    			
    }
    		else
    		{
    			System.out.println("Login unsuccessfull");
    			driver.findElement(By.xpath("//*[@id=\"input-email\"]")).clear();
    			driver.findElement(By.xpath("//*[@id=\"input-password\"]")).clear();
    		    
    		}
    	}
    	
    }
}
