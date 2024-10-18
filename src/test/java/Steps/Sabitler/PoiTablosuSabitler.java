package Steps.Sabitler;

import Utilities.Logger;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class PoiTablosuSabitler {

    public static String filePath = null;

    public static String poiTabloAdi=null; //Otomasyon_PmRqrH
    public static String birinciPartAdi=null;
    public static String ikinciPartAdi=null;
    public static String ucuncuPartAdi=null;
    public static String poiAdi=null;
    public static String ArsivlenmisTabloAdi=null;


    public static String kuralaUygunimportEdilenTabloAdi=null;
    public static String importEdilenDefauldKontrooliTabloAdi=null;
    public static String kuralaUygunOlmayanVeriTipiYanlisImportEdilenTabloAdi=null;
    public static String kuralaUygunOlmayanVeriTipiUyusmazligiOlanImportEdilenTabloAdi=null;
    public static String kuralaUygunOlmayanDosyaBoyutuHataliImportEdilenTabloAdi=null;
    public static String tabloExportAdi=null;


    public static String musteriSiparisTablosu="Musteri-Siparis_Otomasyon";






    @Given("Poi Tablosu Eklenmiş Olmalıdır")
    public static void EklenmisOlmalidir1() {
        if (poiTabloAdi == null) {
            Assert.fail("poiTabloAdi adı null olduğu için senaryo devam edemiyor");
        } else {
            Logger.info(" poiTabloAdi :" + poiTabloAdi + " eklendiği görüldü");
        }
    }

    @Given("Musteri Siparis Tablosu Import Edilmiş Olmalıdır")
    public void musteriSiparisTablosuImportEdilmişOlmalıdır() {
        if (musteriSiparisTablosu == null) {
            Assert.fail("musteriSiparisTablosu adı null olduğu için senaryo devam edemiyor");
        } else {
            Logger.info(" musteriSiparisTablosu :" + musteriSiparisTablosu + " eklendiği görüldü");
        }

    }
}
