package Steps.Sabitler;

import Utilities.Logger;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class AnalizIslemleriSabitler {

    public  static  String kaydedilenGridbolgeAnalizAdi="Otomasyon_Grid Analiz_51281"; // Otomasyon_Grid Analiz_51281



    @Given("Grid Bolge Analizi Kaydedilmiş Olmalıdır")
    public static void EklenmisOlmalidir1() {
        if (kaydedilenGridbolgeAnalizAdi == null) {
            Assert.fail("kaydedilenGridbolgeAnalizAdi adı null olduğu için senaryo devam edemiyor");
        } else {
            Logger.info(" kaydedilenGridbolgeAnalizAdi :" + kaydedilenGridbolgeAnalizAdi + " eklendiği görüldü");
        }
    }
}
