package newsupdate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class NewsUpdateApp {

	static WebDriver wd;
	static String URL = "https://stagemksteamnewstuckweb.z23.web.core.windows.net/#/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(URL);
		Thread.sleep(2000);

		// LOGIN
		WebElement headtitle = wd.findElement(By.xpath("//h2[text()='NEWSTUCK']"));
		String htitle = headtitle.getText();
		System.out.println("heading title is : " + htitle);
		wd.findElement(By.xpath("//input[@placeholder='User ID']")).sendKeys("Karthi");
		wd.findElement(By.xpath("//input[@type='password']")).sendKeys("Karthi@123");
		wd.findElement(By.xpath("//i[@role='button']")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);
		// data once logged in
	

		// click on NewsTuck in homepage
		WebElement ntlogo = wd.findElement(By.className("logo"));
		ntlogo.click();
		Thread.sleep(1000);
		
		// count & search data
		WebElement displaycount = wd.findElement(By.className("iconCountsDisplay"));
		String dcount = displaycount.getText();
		System.out.println("Display count is: " + dcount);

		Thread.sleep(2000);
		WebElement sresult = wd.findElement(By.className("noResults"));
		String sres = sresult.getText();
		System.out.println("search result: " + sres);
		
		

		// menu option
		WebElement menu = wd.findElement(By.xpath("//i[@class='fa fa-bars hamburgerIcon']"));
		menu.click();

		WebElement usrname = wd.findElement(By.xpath("//h6[@class='sidebarUsername']"));
		String usname = usrname.getText();
		System.out.println("user name is: " + usname);

		WebElement tcount = wd.findElement(By.xpath("//div[@title='Total']"));
		String tc = tcount.getText();
		System.out.println("total count:" + tc);
		tcount.click();
		menu.click();

		Thread.sleep(1000);
		WebElement unreadcount = wd.findElement(By.xpath("//div[@title='Unread']"));
		String uc = unreadcount.getText();
		System.out.println("unread count:" + uc);
		unreadcount.click();
		menu.click();

		Thread.sleep(1000);
		WebElement sentcount = wd.findElement(By.xpath("//div[@title='Sent']"));
		String sc = sentcount.getText();
		System.out.println("sent count:" + sc);
		sentcount.click();
		menu.click();

		Thread.sleep(1000);
		WebElement BookmarkedCount = wd.findElement(By.xpath("//div[@title='Bookmarked']"));
		String bc = BookmarkedCount.getText();
		System.out.println("bookmarked count:" + bc);
		BookmarkedCount.click();
		menu.click();

		Thread.sleep(1000);
		WebElement allbookmark = wd.findElement(By.xpath("//i[@class='fa fa-bookmark']"));
		allbookmark.click();
		WebElement abdata = wd.findElement(By.xpath("//h6[@class='allBookmark']"));
		String abtext = abdata.getText();
		System.out.println("title is: " + abtext);
		Thread.sleep(2000);
		WebElement abresults = wd.findElement(By.xpath("//h6[@class='noResults']"));
		String allbmarkdata = abresults.getText();
		System.out.println("search result: " + allbmarkdata);
		menu.click();

		Thread.sleep(1000);
		WebElement allsentitem = wd.findElement(By.xpath("//i[@class='fa fa-circle']"));
		allsentitem.click();
		WebElement asdata = wd.findElement(By.xpath("//h6[@class='allSent']"));
		String astext = asdata.getText();
		System.out.println("title is: " + astext);
		Thread.sleep(2000);
		WebElement asresults = wd.findElement(By.xpath("//h6[@class='noResults']"));
		String allsentresults = asresults.getText();
		System.out.println("search result: " + allsentresults);
		Thread.sleep(2000);
		ntlogo.click();
		
		Thread.sleep(1000);
		WebElement slider = wd.findElement(By.xpath("//span[@class='slider']"));
		slider.click();
		
		WebElement selecteddatacount = wd.findElement(By.xpath("//span[@class='iconCountsDisplay']"));
		String seldatacount = selecteddatacount.getText();
		System.out.println("total selected item is : "+ seldatacount);
		
		WebElement seldata = wd.findElement(By.xpath("//a[@class='logo']"));
		String sdata = seldata.getText();
		System.out.println("count of selected item is : "+ sdata);
	
		WebElement sendbutton = wd.findElement(By.xpath("//a[@class='actionButton']"));
		sendbutton.click();
		Thread.sleep(1000);
		slider.click();
		
		//click & select data from filter checkbox options
		
		WebElement filterdata = wd.findElement(By.xpath("//div[@title='Filter']"));
		filterdata.click();
		String filterlist = filterdata.getText();
		System.out.println("filter list data: "+filterlist);
		
		List<WebElement> filterallcheckbox = wd.findElements(By.xpath("//li/input[@type='checkbox']"));
		System.out.println(Integer.toString(filterallcheckbox.size()));
	 
		for(WebElement fc: filterallcheckbox)
		{
			
			fc.click();
			Thread.sleep(1000);
		}
		
		WebElement unread = wd.findElement(By.id("unread"));
		WebElement read = wd.findElement(By.id("read"));
		WebElement bookmarked = wd.findElement(By.id("bookmark"));
		WebElement selected = wd.findElement(By.id("select"));
		WebElement sentdata = wd.findElement(By.id("sent"));
		WebElement irrelevant = wd.findElement(By.id("irrelevant"));
		
		unread.click();
		Thread.sleep(2000);
		filterdata.click();
		
		//duration option data
		Thread.sleep(1000);
		WebElement timingdata = wd.findElement(By.xpath(" //div[@class='dateTimeFilterButton filter-box-active']"));
		String timdata = timingdata.getText();
		System.out.println("currently seclected duration is : "+timdata);
		timingdata.click();
		WebElement allfilterdata = wd.findElement(By.xpath(" //div[@class='filter']"));
		String alloption = allfilterdata.getText();
		System.out.println("all duration options are : "+alloption);
		
		WebElement last3days = wd.findElement(By.xpath("//li[contains(text(),'Last 3 days')]"));
		WebElement last5hours = wd.findElement(By.xpath("//li[contains(text(),'Last 5 hours')]"));
		WebElement last4hours = wd.findElement(By.xpath("//li[contains(text(),'Last 4 hours')]"));
		WebElement last3hours = wd.findElement(By.xpath("//li[contains(text(),'Last 3 hours')]"));
		WebElement last2hours = wd.findElement(By.xpath("//li[contains(text(),'Last 2 hours')]"));
		WebElement last1hours = wd.findElement(By.xpath("//li[contains(text(),'Last 1 hours')]"));
		WebElement choosedate = wd.findElement(By.xpath("//li[contains(text(),'Choose Date')]"));
		
		
		last2hours.click();
		WebElement seldurcount = wd.findElement(By.xpath("//span[@class='iconCountsDisplay']"));
		String durcount = seldurcount.getText();
		System.out.println("Last 2 hours count is: "+durcount);
		
		// click & enter anything in search box
		Thread.sleep(1000);
		 WebElement searchbox = wd.findElement(By.name("search"));
		 searchbox.click();
		 Thread.sleep(1000);
		 searchbox.sendKeys("sports");
		 searchbox.sendKeys(Keys.ENTER);
		 Thread.sleep(6000);
		 WebElement searchboxresults = wd.findElement(By.className("allBookmark"));
		 String searchbx = searchboxresults.getText();
		 System.out.println("search results are: "+searchbx);
		 
		 WebElement searchcount = wd.findElement(By.className("iconCountsDisplay"));
		 String searchct = searchcount.getText();
		 System.out.println("searched count is : "+searchct);
		
		 wd.findElement(By.xpath("//i[@class='fa fa-times-circle clearSearch']")).click(); //to close search X - button

		 
		//click Consumer
		Thread.sleep(1000);
		WebElement consumerlogo = wd.findElement(By.xpath("//a[@class='navigate']"));
		consumerlogo.click();

		// click user LOGO to go for curator
		WebElement userlogo = wd.findElement(By.xpath("//i[@class='fa fa-user-circle-o']"));
		userlogo.click();
		WebElement din1 = wd.findElement(By.xpath("//li[text()='Curator']"));
		String str1 = din1.getText();
		System.out.println("listed name1 is:" + str1);

		WebElement din2 = wd.findElement(By.xpath("//li[text()='Karthi']"));
		String str2 = din2.getText();
		System.out.println("listed name2 is:" + str2);

		WebElement din3 = wd.findElement(By.xpath("//li[text()='Karthi@pro.com']"));
		String str3 = din3.getText();
		System.out.println("listed name3 is:" + str3);

		WebElement changepwd = wd.findElement(By.xpath("//li[@class='change-password']"));
		String str4 = changepwd.getText();
		System.out.println("listed name4 is:" + str4);
		changepwd.click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//i[@class='fa fa-times']")).click();

		userlogo.click();
		Thread.sleep(1000);

		WebElement logout = wd.findElement(By.xpath("//li[text()='Logout']"));
		String lout = logout.getText();
		System.out.println("list name5 is:" + lout);
		Thread.sleep(2000);
		logout.click();

		 
			}

}
