package Steps;


import GeneralLocators.GeneralLocators;
import Utilities.Driver;
import Utilities.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.MessageFormat;
import static Pages.BaseClass.*;

public class GeneralSteps  implements GeneralLocators {


    @And("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String butontext) {
        click(  XPATH(ALLBUTTON, butontext),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }

    @And("Kullanıcı {string} butonuna tıklar-2")
    public void kullaniciSadeceButonunaTiklar(String butontext) {
        sleep(0.5);
        click(XPATH(ONLYBUTTON, butontext),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }
    @And("Kullanıcı {string} butonuna tıklar-3")
    public void kullaniciSadeceButonunaTiklar_2(String butontext) {
        click(XPATH(ONLYBUTTONCONTAİNTEXT, butontext),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }
    @And("Kullanıcı {int} th {string} butonuna tıklar-2")
    public void kullaniciThButonunaTiklar_2(int index, String butontext) {
        String xpath = "((" +
                MessageFormat.format(ONLYBUTTON, butontext) +
                ") | (" +
                MessageFormat.format(ONLYBUTTON, butontext) +
                "))[" + index + "]";
        click(By.xpath(xpath),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }

    @And("Kullanıcı {int} th {string} butonuna tıklar")
    public void kullaniciThButonunaTiklar(int index, String butontext) {
        String xpath = "((" +
                MessageFormat.format(ALLBUTTON, butontext) +
                ") | (" +
                MessageFormat.format(ALLLINK, butontext) +
                "))[" + index + "]";
        click(By.xpath(xpath),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }

    @And("Kullanıcı {string} linkine tıklar")
    public void kullaniciLinkineTiklar(String linkText) {
        click(XPATH(ALLLINK, linkText),
                MessageFormat.format("{0} butonuna tıklandı", linkText),
                MessageFormat.format("{0} butonuna tıklandı", linkText));
    }

    @And("Kullanıcı {string} isimli listeden {string} değerini seçer")
    public void kullaniciIsimliListedenDegeriniSecer(String selectAttirubute, String visibleText) {
        WebElement element = Driver.getWait().until(ExpectedConditions.elementToBeClickable(XPATH(ALLSELECT, selectAttirubute)));
        element.click();
        new Select(element).selectByVisibleText(visibleText);
    }

    @Then("Sistem {string} bildirimini gösterir")
    public void sistemBildiriminiGosterir(String text) {
        try {
            Driver.getWait().until(ExpectedConditions.presenceOfElementLocated(XPATH(ALLELEMENTTEXT, text)));
            Logger.info(MessageFormat.format("{0} bildirimi Görülebildi",text));
        } catch (Exception exception) {
            Assert.fail(MessageFormat.format("{0} bildirimi GÖRÜLEMED;",text),exception);
        }
    }

    @Then("Sistem {string} açıklamasını içeren bir bildirim gösterir")
    public void sistemAciklamasiniIcerenBirBildirimGosterir(String text) {
        try {
            Driver.getWait().until(ExpectedConditions.presenceOfElementLocated(XPATH(ALLELEMENTCONTAINTEXT, text)));
            Logger.info(text +" Bildirimi görülebildi");
        } catch (Exception e) {
            Logger.info(text +" Bildirimi GÖRÜLEMEDİ");
            Assert.fail(e.getMessage());

        }


    }


    @Then("Kullanıcı {string} alanına {string} metnini yazar")
    public void kullaniciInputAlaninaYazar(String attirubuteText, String message) {

        sendKeys(XPATH(ALLINPUT, attirubuteText),
                message,
                MessageFormat.format(attirubuteText + " alanına {0} yazıldı", message),
                MessageFormat.format(attirubuteText + " alanına {0} yazıldı", message)
        );
    }

    @And("Kullanıcı {string} Locatoruna Tıklar")
    public void kullanicilocatoratıklar(String locator) {
        By xpath = By.xpath(locator);
        click(xpath,"","");
    }

    @Then("kullanıcı 1 th {string} alanına {string} metnini yazar")
    public void kullaniciThInputAlaninaYazar(String attirubuteText, String message, int index) {

        String xpath = "(" + XPATH(ALLINPUT, attirubuteText) + ")[" + index + "]";
        sendKeys(By.xpath(xpath),
                message,
                MessageFormat.format(attirubuteText + " alanına {0} yazıldı", message),
                MessageFormat.format(attirubuteText + " alanına {0} yazıldı", message)
        );
    }


    @Then("Ekran Fotosu ile {string} Kontrolu Yapılmalıdır")
    public void ekrarFotosuIleYapılmalıdır(String fotoBasliği) {
        sleep(2);
        Hooks.fotoBaslik=fotoBasliği;
        Hooks.ekranFotoAl=true;
    }

    @And("Kullanıcı {string} elementine tıklar")
    public void kullaniciElementineaTiklar(String butontext) {
        click(XPATH(ALLELEMENTCONTAINTEXT, butontext),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }

    @And("Kullanıcı {string} elementinin {string} th tıklar")
    public void kullaniciElementineIndekIleTiklar(String butontext,String index) {

        String xpath = "(" + MessageFormat.format(ALLELEMENTCONTAINTEXT,butontext) + ")[" + index + "]";
        click(By.xpath(xpath),
                MessageFormat.format("{0} butonuna tıklandı", butontext),
                MessageFormat.format("{0} butonuna TIKLANAMADI", butontext));
    }



    @Then("Bu senaryo Fail Olmaktadır. Hata Talebi açılmalı. message {string}.")
    public void buSenaryoFailOlmaktadırHataTalebiAçılmalıMessage(String arg0) {
        Hooks.ekranFotoAl=true;
        Assert.fail(arg0);
    }

}

