package com.Dataprovider;

import org.testng.annotations.Test;

public class DataProviderDemo {
	@Test(dataProvider = "Data", dataProviderClass = DataProviderTest.class)
	public void m1(String name, String password) {
		System.out.println("Name : " + name + "\t" + "password :" + password);
	}

}
