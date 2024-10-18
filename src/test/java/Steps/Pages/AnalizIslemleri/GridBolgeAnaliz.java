package Steps.Pages.AnalizIslemleri;

import Pages.Analizler.Analizler_Grid__BolgeAnaliziPenceresi;
import Pages.BaseClass;
import Steps.Sabitler.AnalizIslemleriSabitler;
import Steps.Sabitler.PolygonTablosuSabitler;
import io.cucumber.java.en.And;
import org.apache.commons.lang3.RandomStringUtils;
import Enum.KayıtlıAnalizIcon;
import org.openqa.selenium.By;

public class GridBolgeAnaliz {

    @And("Oluştur Butonuna Tıklar")
    public void oluşturButonunaTıklar() {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .OlusturBotonunaTikla();
    }

    @And("Renk Scalasından {int} üncü renkgi seçer")
    public void renkScalasındanÜncüRenkgiSeçer(int index) {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .renkSec(String.valueOf(index));
    }

    @And("Alaka Yüzeyi olarak {string} seçimi yapar")
    public void alakaYüzeyiOlarakSeçimiYapar(String alakaYuzeyi) {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .alakaYuzeyiSec(alakaYuzeyi);
    }

    @And("Kendi Noktalarım filresi Olarak {string} tablosunu Seçer")
    public void kendiNoktalarımFilresiOlarakTablosunuSeçer(String tabloAdi) {

        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .kendiNoktalarimSec(tabloAdi);

    }

    @And("İl filtresi olarak  {string}  ilini seçer")
    public void ilFiltresiOlarakIliniSeçer(String il) {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .ilSec(il);
    }

    @And("Grit Tipi Olarak {string} seçer")
    public void gritTipiOlarakSeçer(String gridTipi) {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .giritTipiGir(gridTipi);
    }

    @And("İlçe filtresi olarak  {string}  ilçesini seçer")
    public void ilçeFiltresiOlarakIlçesiniSeçer(String ilce) {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .ilceSec(ilce);


    }

    @And("Grid Boyutu olarak {string} değeri yazılır")
    public void gridBoyutuOlarakDeğeriYazılır(String gridBoyutu) {

        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .giritBoyutuGir(gridBoyutu);
    }

    static String analizAdi = null;

    @And("Analiz Adı Olarak {string} yazar")
    public void analizAdıOlarakYazar(String analizAdi) {
        analizAdi = analizAdi + "_" + RandomStringUtils.randomNumeric(5);
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .analizAdiYaz(analizAdi);
        GridBolgeAnaliz.analizAdi = analizAdi;


    }


    @And("Oluştur ve Kaydet Butonuna Tıklar")
    public void oluşturVeKaydetButonunaTıklar() {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .kaydetveOlusturBotonunaTikla();

        AnalizIslemleriSabitler.kaydedilenGridbolgeAnalizAdi = GridBolgeAnaliz.analizAdi;
    }

    @And("Kayıtlı Analiz Butonuna Tıklar")
    public void kayıtlıAnalizButonunaTıklar() {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .kayitliAnalizListesineTikla();
    }

    @And("Kaydedilmiş olan Grid Bolge Analizi'nin Analizi Gerçekleştir Ikonuna Tıklar")
    public void kaydedilmişOlanGridBolgeAnaliziNinAnaliziGerçekleştirIkonunaTıklar() {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getKayıtlıAnalizListesi()
                .analizeAitIkonaTikla(AnalizIslemleriSabitler.kaydedilenGridbolgeAnalizAdi, KayıtlıAnalizIcon.AnaliziGerceklestir);
    }

    @And("Kaydedilmiş olan Grid Bolge Analizi'nin Detay Ikonuna Tıklar")
    public void kaydedilmişOlanGridBolgeAnaliziNinDetayIkonunaTıklar() {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getKayıtlıAnalizListesi()
                .analizeAitIkonaTikla(AnalizIslemleriSabitler.kaydedilenGridbolgeAnalizAdi, KayıtlıAnalizIcon.Detay);
    }

    @And("Kaydedilmiş olan Grid Bolge Analizi'nin Sil Ikonuna Tıklar")
    public void kaydedilmişOlanGridBolgeAnaliziNinSilIkonunaTıklar() {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getKayıtlıAnalizListesi()
                .analizeAitIkonaTikla(AnalizIslemleriSabitler.kaydedilenGridbolgeAnalizAdi, KayıtlıAnalizIcon.Sil);
    }

    @And("Silmeyi Onaylamak için Evet Butonuna tıklar")
    public void silmeyiOnaylamakIçinEvetButonunaTıklar() {
        BaseClass.sleep(1);
        BaseClass.click(By.xpath("//button[contains(.,'Evet')]")
                , "Evet Botonuna Tıklandı"
                , "Evet Botonuna TIKLANAMADI");


    }

    @And("Kendi Bölgelerim filresi Olarak {string}  bölge tablosunu Seçer")
    public void kendiBölgelerimFilresiOlarakBölgeTablosunuSeçer(String kayıtlı) {

        switch (kayıtlı) {
            case "kayıtlı":
            Analizler_Grid__BolgeAnaliziPenceresi
                    .getAnalizler_Grid__BolgeAnaliziPenceresi()
                    .getAnalizDuzenlemePenceresi()
                    .kendiBolgelerimSec(PolygonTablosuSabitler.polygonTabloAdi);
            break;
        }
    }

    @And("İlçe filtresi olarak  {string} İlçesini seçer")
    public void ilçeFiltresiOlarakİlçesiniSeçer(String ilceAdi) {
        Analizler_Grid__BolgeAnaliziPenceresi
                .getAnalizler_Grid__BolgeAnaliziPenceresi()
                .getAnalizDuzenlemePenceresi()
                .ilceSec(ilceAdi);
    }
}
