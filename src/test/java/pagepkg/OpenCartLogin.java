package pagepkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OpenCartLogin {
	WebDriver driver;
	WebDriverWait wait;
    Actions actions;
	//go to loginpage
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement Myaccount;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement Login;
	//login details
	@FindBy(name="email")
	WebElement Email;
	@FindBy(name="password")
	WebElement Pass;
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement Logbttn;
	//go to homepage
	@FindBy(xpath="//*[@id=\"logo\"]/a/img")
	WebElement Homepage;
	//produtcsaddtocart
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
	WebElement Product1;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[1]/span")
	WebElement Product2;
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement Prdt2Addtocart;
	//go to shopcart
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/span")
	WebElement ShopCart;
	//remove product
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]")
	WebElement Remove;
	//checkout
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement Checkout;
	
	@FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label/input")
	WebElement Radio;
	
	//billingdetails
	@FindBy(xpath="//*[@id=\"input-payment-firstname\"]")
	WebElement f1name;
	@FindBy(xpath="//*[@id=\"input-payment-lastname\"]")
	WebElement l1name;
	@FindBy(xpath="//*[@id=\"input-payment-address-1\"]")
	WebElement address;
	@FindBy(xpath="//*[@id=\"input-payment-city\"]")
	WebElement city1;
	@FindBy(xpath="//*[@id=\"input-payment-postcode\"]")
	WebElement pincode;
	@FindBy(name="country_id")//drop down
	WebElement country;
	@FindBy(name="zone_id")//drop down
	WebElement state;
	@FindBy(xpath="//*[@id=\"button-payment-address\"]")
	WebElement continue1;
	//shipping address
	@FindBy(xpath="//*[@id=\"button-shipping-address\"]")
	WebElement continue2;
	//delivery method
	@FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
	WebElement comment;
	@FindBy(id="button-shipping-method")
	WebElement continue3;
	//payment method
	@FindBy(xpath="//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
	WebElement termsandcon;
	@FindBy(xpath="//*[@id=\"button-payment-method\"]")
	WebElement continue4;
	//confirm order
	@FindBy(xpath="//*[@id=\"button-confirm\"]")
	WebElement confirm;
	
	@FindBy(xpath="//*[@id=\"search\"]/input")
	WebElement Searchbar;
	@FindBy(xpath="//*[@id=\"search\"]/span/button/i")
	WebElement Searchbttn;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
	WebElement hp;
	
	@FindBy(xpath="//*[@id=\"product\"]/div[1]/div/span/button")
	WebElement calender;
	@FindBy(xpath="/html/body/div[3]/div/div[1]/table/thead/tr[1]/th[2]")
	WebElement monthandyear;
	@FindBy(xpath="/html/body/div[3]/div/div[2]/table/thead/tr/th[2]")
	WebElement year;
	@FindBy(xpath="/html/body/div[3]/div/div[3]/table/thead/tr/th[3]")
	WebElement next;
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/ul[2]/li[3]/a")
	WebElement review;
	@FindBy(xpath="//*[@id=\"input-name\"]")
	WebElement ReviewerName;
	@FindBy(xpath="//*[@id=\"input-review\"]")
	WebElement ReviewText;
	@FindBy(xpath="//*[@id=\"button-review\"]")
	WebElement ReviewSubmit;
	@FindBy(xpath="//*[@id=\"form-review\"]/div[4]/div/input[4]")
	WebElement Rating;
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement HpAddtocart;
	
	@FindBy(xpath="//*[@id=\"input-option218\"]/div[1]/label/input")
	WebElement small;
	@FindBy(xpath="//*[@id=\"input-option223\"]/div[1]/label/input")
	WebElement checkbox1;
	@FindBy(xpath="//*[@id=\"input-option223\"]/div[3]/label/input")
	WebElement checkbox2;
	@FindBy(xpath="//*[@id=\"input-option217\"]")
	WebElement colour;
	@FindBy(xpath="//*[@id=\"input-option209\"]")
	WebElement textarea;
	@FindBy(xpath="//*[@id=\"button-upload222\"]")
	WebElement upload;
	@FindBy(xpath="//*[@id=\"input-option219\"]")
	WebElement prdt2date;
	@FindBy(xpath="//*[@id=\"input-option221\"]")
	WebElement prdt2time;
	@FindBy(xpath="//*[@id=\"input-option220\"]")
	WebElement dateandtime;
	@FindBy(xpath="//*[@id=\"input-quantity\"]")
	WebElement quantity;
	
	
	public OpenCartLogin(WebDriver driver) 
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public void login()
	{
		Myaccount.click();
	    wait.until(ExpectedConditions.visibilityOf(Login));
	    Login.click();
	    LoginWait();
	}
	private void LoginWait() {
		wait.until(ExpectedConditions.visibilityOf(Email));
		wait.until(ExpectedConditions.visibilityOf(Pass));
	}
	public void setValues(String username,String password)
	{
		Email.sendKeys(username);
		Pass.sendKeys(password);
	}
	public void loginbttn() //Clicking on login button
	{
		Logbttn.click();
	}
	public void Home() //Redirect to home page by clicking on the logo
	{
		wait.until(ExpectedConditions.visibilityOf(Homepage)).click();
	}
	
	
	
	public void addtocart() throws IOException, InterruptedException, AWTException //Add two products to the cart by scrolling down
	{
		scrollAndClick(Product1);
		wait.until(ExpectedConditions.visibilityOf(Product2));
		
		scrollAndClick(Product2);
		wait.until(ExpectedConditions.urlContains("product_id=42"));
		scrollUntilElementVisible(small);
		small.click();
		scrollAndClick(checkbox1);
		scrollAndClick(checkbox2);
		scrollUntilElementVisible(colour);
		selectFromDropdown(colour, "3"); //select by value 3 is blue
        scrollUntilElementVisible(textarea);
        textarea.sendKeys("Need it ASAP");
		scrollUntilElementVisible(upload);
		upload("\"C:\\Users\\lenovo\\Desktop\\Opencart\\vijay.jpg\"");
		wait.until(ExpectedConditions.alertIsPresent());
		
		 Alert alert = driver.switchTo().alert(); //Handle the alert message
	        alert.accept();
	        
		Thread.sleep(2000);
		prdt2date.clear();
		prdt2date.sendKeys("2024-10-13");
		prdt2time.clear();
		prdt2time.sendKeys("10:30");
		dateandtime.clear();
		Thread.sleep(2000);
		dateandtime.sendKeys("2024-10-13 10:30");
        Thread.sleep(3000);
		scrollUntilElementVisible(Prdt2Addtocart);
		Prdt2Addtocart.click();
		Thread.sleep(2000);
		
	}
	public void cart() throws InterruptedException //Click on cart icon to go to cart
	{
		scrollUntilElementVisible(ShopCart);
		ShopCart.click();
		wait.until(ExpectedConditions.visibilityOf(Remove));
		
	}
	public void remove() throws InterruptedException //Remove one product from the cart
	{
		Remove.click();
		Thread.sleep(3000);
		
	}
	public void checkout() throws InterruptedException //Go to checkout page
	{
		scrollUntilElementVisible(Checkout);
		wait.until(ExpectedConditions.visibilityOf(Radio));
	}
	
	public void billing(String fname,String lname,String Add1,String city,String post) //Enter billing details
	{
		Radio.click();
		f1name.sendKeys(fname);
		l1name.sendKeys(lname);
		address.sendKeys(Add1);
		city1.sendKeys(city);
		pincode.sendKeys(post);
		selectFromDropdown(country, "99");
		selectFromDropdown(state,"1490");
	}
	public void Nextbttn() throws InterruptedException //Click on next button to go to next billing section
	{
		continue1.click();
		wait.until(ExpectedConditions.elementToBeClickable(continue2)).click();
		Thread.sleep(3000);
		comment.sendKeys("Thanks");
		scrollUntilElementVisible(continue3);
		Thread.sleep(3000);
		termsandcon.click();
		continue4.click();
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);
	}    
	public void Homebtn() //Go to home page
	{
		Homepage.click();
	}
	
	public void search() //Click on search bar
	{
		Searchbar.sendKeys("hp");
		Searchbttn.click();
	}
	public void NewProduct() //New product
	{
		wait.until(ExpectedConditions.elementToBeClickable(hp)).click();
	}
	public void calender() throws InterruptedException //To set date
	{
		 WebElement calendarButton = driver.findElement(By.xpath("//*[@id=\"product\"]/div[1]/div/span/button")); // replace with actual ID
	        wait.until(ExpectedConditions.elementToBeClickable(calendarButton)).click();
	        
	        String targetMonth = "November 2024";
	        
	        WebElement monthYear = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/thead/tr[1]/th[2]"));
	        WebElement nextButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/thead/tr[1]/th[3]")); 
	        while (true) {
	            String displayedMonthYear = monthYear.getText();
	                       
	            if (displayedMonthYear.equals(targetMonth)) {
	                break;
	            }
	            
	            nextButton.click();
	        }

	        WebElement day = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/tbody/tr[3]/td[5]"));
	        day.click();
	}
	
	public void ProductReview() throws InterruptedException //Add product review
	{
		String ReviewName="Shobha";
		String ReviewMsg="This product i very good for casual use but for hardcore usage there are more suitable laptops at this price range.";
		review.click();
		ReviewerName.sendKeys(ReviewName);
		ReviewText.sendKeys(ReviewMsg);
		Thread.sleep(2000);
		Rating.click();
		Thread.sleep(2000);
		ReviewSubmit.click();
		wait.until(ExpectedConditions.elementToBeClickable(HpAddtocart));
		HpAddtocart.click();
		
	}
	
	public void scrollAndClick(WebElement element) //To scroll and click on element
	{
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
	}
	
	public void scrollUntilElementVisible(WebElement element) { //Scroll until element is visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean isVisible = false;

	    while (!isVisible) {
	        try {
	            isVisible = element.isDisplayed();
	            if (isVisible) {
	                element.click();
	                break;
	            } else {
	                js.executeScript("window.scrollBy(0, 250);");
	            }
	        } catch (Exception e) { // Handle any exception
	             
	        }
	    }
	}
	
	public void selectFromDropdown(WebElement dropdownElement, String value)  //select from drop down
	{
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(value); 
	    }
		
	
	public void upload(String filepath) throws AWTException //File upload
	{
		StringSelection selection=new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
		
		Robot robot=new Robot();
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	

}
