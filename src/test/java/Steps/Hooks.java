package Steps;

import Pages.BaseClass;
import Utilities.Driver;
import Utilities.Logger;
import Utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static Utilities.Driver.quitDriver;


public class Hooks {

    public static boolean ekranFotoAl=false;
    public static String fotoBaslik="";

   public static int total;
   public static int passScenario;
   public static int failScenario;
    static LinkedHashMap<String, String> map = new LinkedHashMap<>();


    @Before
    public void before(Scenario scenario){
        Logger.info( scenario.getName()+" SENARYOSU BAŞLADI");
    }

    @After
    public void after1(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        if (ekranFotoAl) {

            BaseClass.sleep(1);
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",fotoBaslik);
        }
        ekranFotoAl=false;

        Logger.info(scenario.getName() + " SENARYOSU BİTTİ");

//       //FilePath null veya emty değilse sil
//        if (!(PoiTablosuSabitler.filePath==null)& !(PoiTablosuSabitler.filePath=="")) {
//            Utils.fileDelete(PoiTablosuSabitler.filePath);
//        }

        total++;
        if (scenario.isFailed())
            failScenario++;
        else
            passScenario++;

        map.put(scenario.getName(), scenario.getStatus().name());

       quitDriver();

    }


    @AfterAll
    public static void cucumberAfterAll(){
        int passRatio = 100*passScenario/total;
        int failRatio = 100*failScenario/total;
        Logger.info("");
        Logger.info("------------------------------------------------------");
        Logger.info("TOTAL  : " + total);
        Logger.info("PASSED : " + passScenario + "   %" + passRatio);
        Logger.info("FAILED : " + failScenario + "   %" + failRatio);
        Logger.info("");

        AtomicInteger i = new AtomicInteger(1);
        Logger.info(String.format("%-5s%-10s%s", "#", "Status", "Scenario Name"));
        Logger.info(String.format("%-5s%-10s%s", "----", "-------", "---------------------------------------"));
        map.forEach((k, v) ->{
            Logger.info(String.format("%-5d%-10s%s", i.getAndIncrement(), v, k));
        });
        Logger.info("------------------------------------------------------");
    }


}


