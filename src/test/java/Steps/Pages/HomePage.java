package Steps.Pages;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static Utilities.Driver.*;


public class HomePage extends BaseClass {

    private static HomePage instance;
    private static final String homePageUrl = "https://geomarkettest.basarsoft.com.tr/web/Login";

    public static HomePage getHomePage() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }

    @Given("Kullanıcı Login Sayfasındadır")
    public void userOnHomepage() {
        Pages.HomePage.userOnHomepage(homePageUrl);
    }


    @And("Anasayfa Admin Panel Butonuna tıklar")
    public void anasayfaAdminPanelButonunaTıklar() {
        By adminpanelButton = By.xpath("//span[contains(.,'Hoşgeldin')]");
        click(adminpanelButton, "Admin panel Buttonuna tıklandı", "Admin panel Buttonuna tıklanamadı");
    }

    @And("Anasayfa Yönetim Paneli Butonuna tıklar")
    public void anasayfaYönetimPaneliButonunaTıklar() {
        By yonetimPaneliButton = By.xpath("//div[contains(text(),'Yönetim Paneli')]");
        click(yonetimPaneliButton, "Yönetim Paneli Buttonuna tıklandı", "Yönetim Panel Buttonuna tıklanamadı");
        swichToSecondWindow();
    }

    @And("Yönetim Panelindeki Çıkış Yap butonuna Tıklar")
    public void yönetimPanelindekiÇıkışYapButonunaTıklar() {
        By yonetimPanelindenCikisButton = By.xpath("//a[@href='/web/Home/Logout']");
        click(yonetimPanelindenCikisButton, "Yönetim Panelinden Çıkış Butonuna Tıklandı", "Yönetim Panelinden Çıkış Butonuna TIKLANAMADI");
    }

    @Then("Login sayfasında olduğu doğrulanır")
    public void loginSayfasındaOlduğuDoğrulanır() {
        By cikisYapildiginiDogrula = By.xpath("//a[contains(.,'Şifremi unuttum ?')]");
        visibleOlanaKadarBekle(cikisYapildiginiDogrula, "Başarıya Çıkış Yapıldı", "Başarıya Çıkış YAPILAMADI");
    }

    @And("Oturumu Sonlandır Butonuna tıklar")
    public void oturumuSonlandırButonunaTıklar() {
        By oturumusonlandirButton = By.xpath("//a[contains(.,'Oturumu Sonlandır')]");
        click(oturumusonlandirButton,"Oturumu Sonlandır Buttonuna tıklandı","Oturumu Sonlandır Buttonuna tıklanamadı");
    }

    @And("Çıkış işlemini Onayla Butonuna Tıklar")
    public void çıkışIşleminiOnaylaButonunaTıklar() {
        By cikisYapOnayButonu = By.xpath("//button[contains(.,'Evet')]");
        click(cikisYapOnayButonu,"Çıkışyap Onay Butonuna tıklandı","Çıkışyap Onay Butonuna tıklanamadı");
    }

    @And("Anasayfa {string} koordinatına bir pimn atılır")
    public void anasayfaKoordinatınaBirPimnAtılır(String koordinat) {
        haritaYukleneneKadarBekle();
        By xpath = By.xpath("//input[@id='geoAddresInput']");
        sendKeys(xpath,koordinat,koordinat+" koordinatları yazıldı",koordinat+" koordinatları YAZILAMADI");
        sleep(5);
    }

    @And("Anasayfa Eklenen Pinin Bilgi Kartı Açılır")
    public void anasayfaEklenenPininBilgiKartıAçılır() {

        By haritaLocator = By.xpath("//canvas");
        clickByAction(haritaLocator,"","");



    }



}
