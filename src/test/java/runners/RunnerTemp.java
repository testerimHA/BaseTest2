package runners;

import Utilities.Browsers;
import Utilities.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static runners.TestResultAnalizer.createHTMLReport;
import static runners.TestResultAnalizer.testRueltsAnalizer;


@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"Steps"},
        tags = "@TC_009_03.3_Analizler__İl_Bazlı_Potansiyel_Analizi_Dahil_Olmayan_Markalar_Tüik_2_Filtre",
        plugin = {"progress",
                "json:target/test-output/cucumber-reports/cucumber.json",
                "html:target/test-output/cucumber-reports/cucumberreport.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)



public class RunnerTemp extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public  void beforeTest( @Optional String browser){
        if (browser!=null){
            Driver.getDriver(Browsers.valueOf(browser));
        }else {
            Driver.getDriver(Browsers.CHROME);
        }

    }

    @AfterTest
    public void testalanizer(){
        testRueltsAnalizer();
        createHTMLReport();
    }
}
