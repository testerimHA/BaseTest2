package Steps.Sabitler;

import Utilities.Logger;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class PolygonTablosuSabitler {
    public static String polygonTabloAdi = "Otomasyon_kbOGnO";  //Otomasyon_kbOGnO
    public static String polygonKolonAdi = null;
    public static String polygonBolgeAdi= null; //bolgeAdi_82185
    public static String birinciPartAdi = null;
    public static String ikinciPartAdi = null;
    public static String ucuncuPartAdi = null;
    public static String ArsivlenmisTabloAdi = null;
    public static String tabloExportAdi = null;//= "GeomarketRapor-Otomasyon_yJIRqO";

    @Given("Polygon Tablosu Eklenmiş Olmalıdır")
    public static void EklenmisOlmalidir1() {
        if (polygonTabloAdi == null) {
            Assert.fail("polygonTabloAdi adı null olduğu için senaryo devam edemiyor");
        } else {
            Logger.info(" polygonTabloAdi :" + polygonTabloAdi + " eklendiği görüldü");
        }
    }

    @Given("Polygon Tablosuna Bölge Eklenmiş Olmalıdır")
    public static void EklenmisOlmalidir2() {
        if (polygonBolgeAdi == null) {
            Assert.fail("polygonBolgeAdi adı null olduğu için senaryo devam edemiyor");
        } else {
            Logger.info(" polygonBolgeAdi :" + polygonBolgeAdi + " eklendiği görüldü");
        }
    }
}
