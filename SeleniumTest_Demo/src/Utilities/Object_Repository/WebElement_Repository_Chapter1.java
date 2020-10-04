package Object_Repository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElement_Repository_Chapter1 {
	
	static WebDriver driver = null;
	
	@FindBy(xpath="//div[@id=\"divontheleft\"]")
	static WebElement textElement;
	
	@FindBy(xpath="//input[@id=\"verifybutton\"]")
	static WebElement verifybutton;
	
	@FindBy(xpath="//div[@id=\"html5div\"]")
	static WebElement textbox;
	
	@FindBy(xpath="//input[@id=\"secondajaxbutton\"]")
	static WebElement loadtextbutton;
	
	@FindBy(xpath="//div[@id=\"multiplewindow\"]")
	static WebElement windowpopup;
	
	@FindBy(xpath="//p[@id=\"popuptext\"]")
	static WebElement popuptext;
	
    public WebElement_Repository_Chapter1(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public static boolean IsButtonVisible()
    {
    	if(verifybutton.isDisplayed())
    		return true;
    	else
    		return false;
    }    
    public static String loadText()
    {
    	if(textbox.isDisplayed())
    	{
    		textbox.clear();
    	}
    	loadtextbutton.click();
    	String textboxText = textbox.getText();
    	return textboxText;
    }
    public static String getText()
    {
    	String text = textElement.getText();
    	return text;
    }
    public static void clickNewWindowpopup(WebDriver driver)
    {	
    	String parentWindowhandler = driver.getWindowHandle();
    	String subwindow = null;
    	Set<String> allWindows = driver.getWindowHandles();
    	Iterator<String> it = allWindows.iterator();
    	while (it.hasNext()) {
			subwindow = it.next();
		}
    	windowpopup.click();
    	driver.switchTo().window(subwindow);
    	String poptext = popuptext.getText();
    }
    public static void hover(WebDriver driver)
    {
    	Actions action = new Actions(driver);
    	action.moveToElement(textElement).perform();
    }
}
