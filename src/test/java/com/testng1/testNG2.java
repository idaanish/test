package com.testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class testNG2 {
  @Test
  public void f() {
	  System.out.println("test method");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after method");
  }

}
