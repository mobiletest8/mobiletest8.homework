package com.wanmich.rest_assured_test;

import org.testng.annotations.DataProvider;

public class DataProviderMethod {
	@DataProvider(name="dataprovider1")
	public static Object[][] dataProvider1(){
		return new Object[][]{
				{"a1", "b1"},
				{"a2", "b2"},
				{"a3", "b3"}
		};
	}
}
