package org.BaseClass.ReusableMethod;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BaseClass baseclass =  new BaseClass();
		
		baseclass.GetDrivers();
		
       baseclass.lanchUrl("https://adactinhotelapp.com/");
       
       baseclass.maximize();
       
      WebElement user = baseclass.ByID("username"); 
      String name = baseclass.getdata("Sheet1", 1, 0);
      baseclass.sendkeys(user, name);
      
      WebElement password = baseclass.ByID("password");
      String pass = baseclass.getdata("Sheet1", 1, 1);
      baseclass.sendkeys(password, pass);
      
      WebElement login = baseclass.ByID("login");
      baseclass.clickbutton(login);
      
      WebElement location = baseclass.ByID("location");
      String loc = baseclass.getdata("Sheet1", 1, 2);
      baseclass.sendkeys(location, loc);
      
      WebElement ho = baseclass.ByID("hotels");
      String tel = baseclass.getdata("Sheet1", 1, 3);
      baseclass.sendkeys(ho,tel);
      
      WebElement room = baseclass.ByID("room_type");
      String type = baseclass.getdata("Sheet1", 1, 4);
      baseclass.sendkeys(room,type);
      
      
      WebElement rooom = baseclass.ByID("room_nos");
      String nos = baseclass.getdata("Sheet1", 1,5);
      baseclass.sendkeys(room, nos);
      
      WebElement aduld = baseclass.ByID("adult_room");
      String rom = baseclass.getdata("Sheet1", 1,6);
      baseclass.sendkeys(aduld, rom);
      
      WebElement child = baseclass.ByID("child_room");
      String roooom = baseclass.getdata("Sheet1", 1, 7);
      baseclass.sendkeys(child, roooom);
      
      WebElement button = baseclass.ByID("Submit");
      baseclass.clickbutton(button);
      
      WebElement round = baseclass.ByID("radiobutton_0");
      baseclass.clickbutton(round);
      
      WebElement contin = baseclass.ByID("continue");
      baseclass.clickbutton(contin);
      
      WebElement first = baseclass.ByID("first_name");
      String na = baseclass.getdata("Sheet1", 1, 8);
      baseclass.sendkeys(first, na);
      
      
      WebElement last = baseclass.ByID("last_name");
      String nnn = baseclass.getdata("Sheet1", 1, 9);
      baseclass.sendkeys(last, nnn);
      
      WebElement bill = baseclass.ByID("address");
      String add = baseclass.getdata("Sheet1", 1, 10);
      baseclass.sendkeys(bill, add);
      
      
     
      
      WebElement credit = baseclass.ByID("cc_num");
      String n = baseclass.getdata("Sheet1", 1, 13);
      baseclass.sendkeys(credit, n);
      
      WebElement tp = baseclass.ByID("cc_type");
      String pe = baseclass.getdata("Sheet1", 1, 14);
      baseclass.sendkeys(tp, pe);
      
      
      WebElement exp = baseclass.ByID("cc_exp_month");
      String month = baseclass.getdata("Sheet1", 1, 15);
      baseclass.sendkeys(exp, month);
      
      WebElement ex = baseclass.ByID("cc_exp_year");
      String year = baseclass.getdata("Sheet1", 1, 16);
      baseclass .sendkeys(ex, year);
      
      WebElement cv = baseclass.ByID("cc_cvv");
      String cvv = baseclass.getdata("Sheet1", 1, 17);
      baseclass.sendkeys(cv, cvv);
      
      WebElement book = baseclass.ByID("book_now"); 
      baseclass.clickbutton(book);
      
      Thread.sleep(6000);
      
      WebElement orderid = baseclass.ByID("order_no");
      String attribute = baseclass.getattribute(orderid);
      baseclass.createcell("Sheet1", 1, 18, attribute);
      
      
      
      
      
      
	}

}
