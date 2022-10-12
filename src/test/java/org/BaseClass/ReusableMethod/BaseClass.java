package org.BaseClass.ReusableMethod;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	WebElement element;
	Actions actions;
	Robot robot;
	Alert alert;
	TakesScreenshot screenshot;
	JavascriptExecutor executor;
	Select select;
	File file;
	FileInputStream inputStream;
	Workbook workbook;

	public void lanchchromebrowser() throws AWTException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// actions=new Actions(driver);
		// robot=new Robot();
		// alert=driver.switchTo().alert();
		// screenshot=(TakesScreenshot)driver;
		// executor=(JavascriptExecutor)driver;
		// select=new Select(element);
		// file=new
		// File("C:\\Users\\nesar\\eclipse-workspace\\Mavenday5\\Excel\\task1.xlsx");
		// inputStream=new FileInputStream(file);
		// workbook=new XSSFWorkbook(inputStream);

	}

	public void GetDrivers() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void lanchUrl(String Url) {
		driver.get(Url);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public String getcurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}

	public void closewindow() {
		driver.close();

	}

	public void quitwindow() {
		driver.quit();
	}

	public WebElement ByID(String value) {
		WebElement element = driver.findElement(By.id(value));
		return element;
	}

	public WebElement ByName(String value) {
		WebElement element = driver.findElement(By.name(value));
		return element;

	}

	public WebElement ByClassName(String value) {
		WebElement element = driver.findElement(By.className(value));
		return element;
	}

	public WebElement Xpath(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		return element;

	}

	public void sendkeys(WebElement element, String hello) {
		element.sendKeys(hello);
	}

	public void clickbutton(WebElement element) {
		element.click();
	}

	public String getattribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	public void mouseoveraction(WebElement element) {
		actions.moveToElement(element).perform();
	}

	public void dragAnddrop(WebElement abcd, WebElement target) {
		actions.dragAndDrop(abcd, target).perform();

	}

	public void rightclick(WebElement element) {
		actions.contextClick(element).perform();

	}

	public void doubleclick(WebElement element) {
		actions.doubleClick(element).perform();

	}

	public void keydown(CharSequence key) {

		actions.keyDown(key);
	}

	public void keyup(CharSequence key) {
		actions.keyUp(key);

	}

	public void keypress(int keyevent) {

		robot.keyPress(keyevent);

	}

	public void keyrelese(int keyevent) {

		robot.keyRelease(keyevent);

	}

	public void alertOK() {
		alert.accept();

	}

	public void aletrtCancel() {
		alert.dismiss();

	}

	public void alertsendkeys(String yes) {
		alert.sendKeys("yes");
		alert.accept();

	}

	public String alertgettext() {
		String text = alert.getText();
		return text;

	}

	public Object JavaScript(WebElement element, String text) {
		executor.executeScript("arguments[0].setAttribute('Value'" + text + "')", element);
		Object executeScript = executor.executeScript("return arguments[0].setAttribute('Value')", element);
		return executeScript;

	}

	public void Click(WebElement element) {
		executor.executeScript("arguments[0].click()", element);

	}

	public void ScrollDown(WebElement ScrollDown) {
		executor.executeScript("arguments[0].scrollIntView(true)", ScrollDown);
	}

	public void ScrollUp(WebElement ScrollUp) {
		executor.executeScript("arguments[0].scrollIntView(fale)", ScrollUp);
	}

	// nevigate method

	public void back() {
		driver.navigate().back();
	}

	public void Forward() {
		driver.navigate().forward();

	}

	public void Reload() {
		driver.navigate().refresh();
	}

	public void navigateUrl(String url) {
		driver.navigate().to("url");
	}

	// webtable methode

	public List<WebElement> Webtable(WebElement table, String value) {

		List<WebElement> elements = table.findElements(By.tagName(""));
		return elements;
	}

	// Drop Down

	public void Index(int index, String value) {
		select.selectByIndex(index);
		select.selectByValue(value);
	}

	private void Deselect() {
		select.deselectAll();
	}

	public int GetAllOptions(WebElement element) {
		List<WebElement> options = select.getOptions();
		int size = options.size();
		return size;
	}

	////////////// class
	////////////// out/////////////////////////////////////////////////////////////////////////

	public String getdata(String Sheetname, int rowno, int cellno) throws IOException {

		String Data = null;
		File file = new File("C:\\Users\\nesar\\eclipse-workspace\\Mavenday5\\Excel\\Task1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(Sheetname);

		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			Data = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				java.util.Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yy");
				Data = dateFormat.format(date);
			} else {
				double value = cell.getNumericCellValue();
				BigDecimal bd = new BigDecimal(value);
				Data = bd.toString();
			}
			break;
		default:
			break;
		}
		return Data;
	}

	public void updatedata(String Sheetname, int rowno, int cellno, String olddata, String Newdata) throws IOException {
		File file = new File("C:\\Users\\nesar\\eclipse-workspace\\Mavenday5\\Excel\\Task1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(Newdata);
		}
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}

	public void createcell(String Sheetname, int rowno, int cellno, String data) throws IOException {
		File file = new File("C:\\Users\\nesar\\eclipse-workspace\\Mavenday5\\Excel\\Task1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}

	public void createRow(String Sheetname, int rowno, int cellno, String data) throws IOException {
		File file = new File("C:\\Users\\nesar\\eclipse-workspace\\Mavenday5\\Excel\\Task1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);

	}

	public void createall(String Sheetname, int rowno, int cellno, String data) throws IOException {
		File file = new File("C:\\Users\\nesar\\eclipse-workspace\\Mavenday5\\Excel\\Task1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.createSheet(Sheetname);
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);

	}
}
