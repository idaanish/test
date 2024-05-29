//package TestRunner;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.testng.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src\\test\\resource\\Feature\\AUFS.feature",glue="StepDefinition1")
//public class AUFS {
//
//}

/*
 * tags in rest assured to run particular scenarios 
 * (suppose in the all scenaros previous you have checked every scenario to avoid prevoius scenario you need to run present scenario to avoid time waste}
 * like in the scenario table i have given names tags as @user ,@add,@update..
 * 
 */

package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)

//@RunWith(CucumberOptions.class)



//@CucumberOptions(features="")
@CucumberOptions(features="src/test/resource/Feature", 
glue="StepDefinition1",
tags="",
monochrome=false,
plugin= {"pretty",
		"html:target/reqresReport/UserReport.html",
		"json:target/JsonReport/UserReport.json",
		"junit:target/JunitReport/UserReport.xml",
		
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class AUFSJUnitRunner extends AbstractTestNGCucumberTests{

}
