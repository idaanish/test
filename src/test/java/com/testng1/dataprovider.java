package com.testng1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
	  }
	 
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "Luffy" },
	      new Object[] { 2, "SMY" },
	    };
	  }
	}