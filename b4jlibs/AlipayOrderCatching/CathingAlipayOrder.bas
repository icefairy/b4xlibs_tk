Type=Class
Version=5.82
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Public WEBDRIVER_KEY="webdriver.chrome.driver",WEBDRIVER_PATH="D:/soft/chromedriver/chromedriver.exe",LOGIN_URL,SUCCESS_URL,Records_Url As String
	Public browserexepath As String=$"D:\soft\mychrome\Chrome\chrome.exe"$
	
	Private jo As JavaObject
End Sub
'depends on:jsoup-1.7.2、selenium-java-2.45.0、selenium-server-standalone-2.45.0
'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	jo=Me
	Dim str As String=jo.RunMethod("login",Array(WEBDRIVER_KEY,WEBDRIVER_PATH,browserexepath))
	Log("cookie:"&jo.GetField("ALIPAYJSESSIONID"))
	
	Log(str)
End Sub
#If java
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.Jsonable;
import org.json.simple.Jsoner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.JsonObject;

public static WebDriver webDriver;
public static final String LOGIN_URL = "https://auth.alipay.com/login/index.htm?goto=https%3A%2F%2Fmy.alipay.com%2Fportal%2Fi.htm";
public static final String SUCCESS_URL = "https://my.alipay.com/portal/i.htm";
public static final String Records_Url="https://consumeprod.alipay.com/record/advanced.htm";
public static final String LOGIN_ACCOUNT = "123@qq.com";//支付宝账号
public static final String LOGIN_PASSWORD = "123";//支付宝密码
public static String ALIPAYJSESSIONID="";
private static void sleep(long sec){
		
		try{
			Thread.sleep(sec);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
/**
	 * 登录支付宝.返回ALIPAYJSESSIONID
	 */
	public static String login(String driverkey,String driverpath,String browserexepath){
		
		/**
		 * 这里打开的是Chrome浏览器
		 */
		System.setProperty(driverkey,driverpath);
		ChromeOptions options = new ChromeOptions();
		options.setBinary(browserexepath);
		webDriver = new ChromeDriver(options);
		webDriver.get(LOGIN_URL);//转到登录页面
		
		/**
		 * 输入账号
		 */
		webDriver.findElement(By.id("J-input-user")).clear();
		for(int i=0;i<LOGIN_ACCOUNT.length();i++) {
			webDriver.findElement(By.id("J-input-user")).sendKeys(LOGIN_ACCOUNT.substring(i, i+1));
			sleep(100);
		}
//		webDriver.findElement(By.id("J-input-user")).sendKeys(LOGIN_ACCOUNT);
		
		sleep(1000);//休眠，防止密码输入到用户名输入框中去
		
		/**
		 * 输入密码
		 */
		webDriver.findElement(By.id("password_rsainput")).clear();
//		webDriver.findElement(By.id("password_rsainput")).sendKeys(LOGIN_PASSWORD);
		for(int i=0;i<LOGIN_PASSWORD.length();i++) {
			webDriver.findElement(By.id("password_rsainput")).sendKeys(LOGIN_PASSWORD.substring(i, i+1));
			sleep(100);
		}
		sleep(1000);//等待输入验证码时间
		webDriver.findElement(By.id("password_rsainput")).sendKeys("\r\n");
		
//		webDriver.findElement(By.id("J-login-btn")).click();//点击登录按钮
		
		/**
		 * 等待登录成功
		 */
		while(!webDriver.getCurrentUrl().equals(SUCCESS_URL)){
			//判断当前URL是不是登录成功页面的URL
		}
		webDriver.get(Records_Url);
		while(!webDriver.getCurrentUrl().equals(Records_Url)){
			//判断当前URL是不是登录成功页面的URL
		}
		//return displayCookies(getCookies(webDriver));//显示Cookies
		ALIPAYJSESSIONID=displayCookies(getCookies(webDriver));
		String page = webDriver.getPageSource();//得到登陆后页面源码
		Document document = Jsoup.parse(page);
//		System.out.println(page);
		return fetch(document);
	}
	private static String fetch(Document document){
		Element table = document.select("#tradeRecordsIndex").get(0);
		//System.out.println(table.html());
		Elements tableRows = table.select("tr");
		
		Iterator<Element> iterator = tableRows.iterator();
		
		List<Record> records = new ArrayList<>();
		
		while(iterator.hasNext()){
			Element element = iterator.next();
			JsonObject jo=new JsonObject();
			String name = element.select("td.name > p > a").text();
			String time = element.select("td.time > p.time-d").text();
			time =time+" "+ element.select("td.time > p.time-h").text();
			String amount = element.select("td.amount > span").text();
			String status = element.select("td.status > p:nth-child(1)").text();
			String tradeno=element.select("td.tradeNo > p").text();
			if(tradeno.length()>0){
				records.add(new Record(time, name, amount, status,tradeno));
			}
		}
		return Jsoner.serialize(records);
//		return records;
	}
	/**
	 * 得到Cookies.
	 * @param webDriver
	 * @return
	 */
	private static Set<Cookie> getCookies(WebDriver webDriver){
		Set<Cookie> cookies = webDriver.manage().getCookies();
		return cookies;
	}
	
	/**
	 * 打印Cookies.
	 * @param cookies
	 */
	private static String displayCookies(Set<Cookie> cookies){
		for(Cookie cookie : cookies){
			if (cookie.getName().compareTo("ALIPAYJSESSIONID")==0) {
				return cookie.getValue();
			}
			
		}
		return "";
	}
	public static class Record implements Jsonable {
		
		private String time;
		private String name;
		private String amount;
		private String status;
		private String tradeno;
		
		public Record() {
		}

		public Record(String time, String name, String amount, String status,String tradeno) {
			this.time = time;
			this.name = name;
			this.amount = amount;
			this.status = status;
			this.tradeno=tradeno;
		}

		public String getTradeno() {
			return tradeno;
		}

		public void setTradeno(String tradeno) {
			this.tradeno = tradeno;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Record [time=" + time + ", name=" + name + ", amount=" + amount + ", status=" + status + "]";
		}

		@Override
		public String toJson() {
			// TODO Auto-generated method stub
			return getjo().toJson();
		}
		private org.json.simple.JsonObject getjo() {
			org.json.simple.JsonObject jo=new org.json.simple.JsonObject();
			jo.put("amount", amount);
			jo.put("name", name);
			jo.put("status", status);
			jo.put("time", time);
			jo.put("tradeno", tradeno);
			return jo;
		}
		@Override
		public void toJson(Writer arg0) throws IOException {
			// TODO Auto-generated method stub
			getjo().toJson(arg0);
		}

	}
#End If
