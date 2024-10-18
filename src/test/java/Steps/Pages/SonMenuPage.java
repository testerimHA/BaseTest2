package Steps.Pages;


import GeneralLocators.GeneralLocators;
import Pages.BaseClass;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.text.MessageFormat;


public class SonMenuPage extends BaseClass implements GeneralLocators {

    private static SonMenuPage instance;


    public static SonMenuPage getSolMenu() {
        if (instance == null) {
            instance = new SonMenuPage();
        }
        return instance;
    }

    @Given("Kullanıcı Sol Menuden {string} linkine tıklar")
    public void solmenudenBirLinkeTıkla(String linktext) {
        click(XPATH("//span[contains(.,\"{0}\")]",linktext),
                MessageFormat.format("{0} linkine tıklandı",linktext),
                MessageFormat.format("{0} linkine TIKLANAMADI",linktext));
    }

    @Then("Kullanıcı Login Sayfasına Yönlendirilir")
    public void kullanıcıLoginSayfasınaYönlendirilir() {

        Driver.getWait().until(ExpectedConditions.urlContains("login"));
    }

    @And("Kullanıcı Üst Menuden Oturumu Kapat linkine tıklar")
    public void kullanıcıÜstMenudenLinkineTıklar() {
        click(By.xpath("//a[@role=\"button\"]"),"","");
        click(By.xpath("(//span[contains(.,'Oturumu Kapat')])[2]"),"","");


    }

    @And("Kullanıcı Üst Menuden Kullanıcı Bilgileri linkine tıklar")
    public void kullanıcıÜstMenudenKullanıcıBilgileriLinkineTıklar() {
        clickByAction(By.xpath("//img[@alt='Image placeholder']"),"","");
        click(By.xpath("//a[@class='dropdown-item'][contains(.,'Kullanıcı Bilgileri')]"),"","");
    }
}
