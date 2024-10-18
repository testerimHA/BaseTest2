package Steps.Pages;


import GeneralLocators.GeneralLocators;
import Pages.BaseClass;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Set;

import static Steps.Pages.HomePage.getHomePage;

public class LoginPage extends BaseClass implements GeneralLocators {



    @Given("Kullanıcı Başarılı Giriş Yapar")
    public void basariliGirisYap() {
        Pages.LoginPage.basariliGirisYap(
                XPATH(ALLINPUT, "username"),
                "merve.web",
                XPATH(ALLINPUT, "password"),
                "46566600Ba.",
                XPATH(ALLBUTTON, "Giriş Yap")
        );
        basariligirisDogrula();

    }

    @Given("Kullanıcı {string} ve {string} Bilgileri ile Başarılı Giriş Yapar")
    public void basariliGirisYap(String username, String password) {
        sendKeys(XPATH(ALLINPUT, "username"), username, "Kullanıcı Adı Yazıldı", "Kullanıcı Adı YAZILAMADI");
        sendKeys(XPATH(ALLINPUT, "password"), password, "Giriş Şifresi Yazıldı", "Giriş Şifresi YAZILAMADI");
        click(XPATH(ALLBUTTON, "Giriş Yap"), "Giriş Yap Butonuna TIKLANDI", "Giriş Yap Butonuna TIKLANAMADI");
        basariligirisDogrula();
    }
    @Given("Kullanıcı şifremi Unutttum Butonuna tıklar")
    public void sifremiUnuttumTikla(){
        Pages.LoginPage.sifremiUnuttumButonunaTikla(XPATH(ALLELEMENTTEXT," Şifremi unuttum"));
    }

    @Then("Başarılı giriş yapıldığı doğrulanır")
    public void basariligirisDogrula(){
        Pages.LoginPage.basariligirisDogrula(XPATH(ALLELEMENTCONTAINTEXT,"Hoşgeldin"));
    }


    @And("Diğer Sekmedeki Oturum da Kapatılmış Olmalıdır")
    public void diğerSekmedekiOturumDaKapatılmışOlmalıdır() {
        String secondWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String window : windows) {
            if (!window.equals(secondWindow)) {
                Driver.getDriver().switchTo().window(window);
            }
        }

        Driver.getDriver().navigate().refresh();
        getHomePage().loginSayfasındaOlduğuDoğrulanır();

    }



}
