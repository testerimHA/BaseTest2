package Steps.Pages.HiyerarsikSorgulama;

import Pages.BaseClass;
import io.cucumber.java.en.And;

public class HiyerarsikSorgulama {
    @And("İl filtresi olarak  {string} seçimi yapar")
    public void ilFiltresiOlarakSeçimiYapar(String il) {
        Pages.HiyerarsikSorgulama.HiyerarsikSorgulama.getHiyerarsikSorgulama()
                .hiyerarsikSorguPenceresiAcilmisOlmalidir()
                .ilSec(il);
    }

    @And("Çalıştır Butonuna Tıklar")
    public void çalıştırButonunaTıklar() {
        Pages.HiyerarsikSorgulama.HiyerarsikSorgulama.getHiyerarsikSorgulama()
                .calistirButonunaTikla();
        BaseClass.haritaYukleneneKadarBekle();
    }

    @And("İlçe filtresi olarak  {string} seçimi yapar")
    public void ilçeFiltresiOlarakSeçimiYapar(String ilçeAdi) {
        Pages.HiyerarsikSorgulama.HiyerarsikSorgulama.getHiyerarsikSorgulama()
                .ilceSec(ilçeAdi);
    }

    @And("Mahalle filtresi olarak {string} seçimi yapar")
    public void mahalleFiltresiOlarakSeçimiYapar(String mahalleAdi) {
        Pages.HiyerarsikSorgulama.HiyerarsikSorgulama.getHiyerarsikSorgulama()
                .mahalleSec(mahalleAdi);
    }
}
