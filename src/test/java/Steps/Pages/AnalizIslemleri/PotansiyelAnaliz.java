package Steps.Pages.AnalizIslemleri;

import Pages.Analizler.Analizler_PotansiyelAnalizPenceresi;
import Pages.AramaIslemleri.AramaIslemleriKendiNoktalarimAnaPenceresi;
import Pages.BaseClass;
import Steps.Sabitler.PoiTablosuSabitler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class PotansiyelAnaliz {
    @And("Analiz Bazı olarak Mahalle seçer")
    public void analizBazıOlarakMahalleSeçer() {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .analizBaziOlarak_MahalleceSec();
    }

    @And("Filtreleme Alanında {string} İlini Filtreler")
    public void filtrelemeAlanındaİliniFiltreler(String il) {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .filtrelemeOlarak_IlFiltrele(il);
    }

    @And("Filtreleme Alanında {string} İlçesini Filtreler")
    public void filtrelemeAlanındaİlçesiniFiltreler(String ilce) {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .filtrelemeOlarak_IlceFiltrele(ilce);
    }

    @And("Dahil olan markaları aşağıdaki gibi seçer")
    public void markasınıDahilOlanMarkaOlarakSeçer(DataTable table) {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .markalariSec(table, true);

    }

    @And("Dahil olmayan markaları aşağıdaki gibi seçer")
    public void markasınıDahilOlmayanMarkaOlarakSeçer(DataTable table) {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .markalariSec(table, false);

    }

    @Then("Uygulama Sonuçları harita üzerinde Göstermelidir")
    public void uygulamaSonuçlarıHaritaÜzerindeGöstermelidir() {

    }


    @Then("Potansiyel Analiz Penceresi Açilmiş Olmalıdır")
    public void potansiyelAnalizPenceresiAçilmişOlmalıdır() {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .potansiyelAnalizPEnceresiAcilmisOlmalidir();
    }


    @And("Tüik Verisi Olarak Aşağıdaki Veri {string}'inci Seçimini Yapar")
    public void tüikVerisiOlarakAşağıdakiVeriInciSeçiminiYapar(String index, DataTable table) {
        Map<String, String> map = table.asMap();
        String tuik_verisi = map.get("Tüik Verisi");
        String operator = map.get("Operator");
        String deger = map.get("Değer");

        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .getTuikVerileri()
                .kuralEkleClick()
                .TuikfiltresiEkle(tuik_verisi, operator, deger, index);
    }

    @And("Kendi Noktalrım filresi Olarak {string} tablosunu Seçer")
    public void kendiNoktalrımFilresiOlarakTablosunuSeçer(String type) {

        if (type.equals("musteri_siparis")) {

            Analizler_PotansiyelAnalizPenceresi.
                    getAnalizler_PotansiyelAnalizPenceresi()
                    .kendiNoktarimTabloSec(PoiTablosuSabitler.musteriSiparisTablosu);
        } else {
            Assert.fail("Doğru parametre Gönderilmeli");
        }
    }

    @And("Analiz Bazı olarak İlçe seçer")
    public void analizBazıOlarakIlçeSeçer() {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .analizBaziOlarak_IlceSec();
    }


    @And("Analiz Bazı olarak İl seçer")
    public void analizBazıOlarakİlSeçer() {
        Analizler_PotansiyelAnalizPenceresi.getAnalizler_PotansiyelAnalizPenceresi()
                .analizBaziOlarak_IlSec();
    }

    @When("Haritada {string}'inci zoom seviyesine iner")
    public void haritadaInciZoomSeviyesineIner(String zoom) {

        BaseClass.zoomYap(Integer.parseInt(zoom));
        BaseClass.haritaYukleneneKadarBekle();
    }
}
