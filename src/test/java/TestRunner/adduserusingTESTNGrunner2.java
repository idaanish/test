//package TestRunner;

//public class runner2 {

//}

package TestRunner;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
 
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Feature\\adduser.feature",
glue="StepDefinition1")
public class adduserusingTESTNGrunner2 extends AbstractTestNGCucumberTests{
 
}