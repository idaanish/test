package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Feature\\AUFS.feature",glue="StepDefinition1",
tags="")
public class adduserUsingJUNITrunner {

}
