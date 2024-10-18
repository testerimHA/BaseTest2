package GeneralLocators;


import org.openqa.selenium.By;

import java.text.MessageFormat;

public interface GeneralLocators {

    String ALLATTIRUBUTE = "//*[@*=\"{0}\"]";
    String ALLELEMENTTEXT = "//*[text()=\"{0}\"]";
    String ALLELEMENTCONTAINTEXT = "//*[contains(text(),\"{0}\")]";
    String ALLBUTTON = "//button[contains(., \"{0}\")] | //*[contains(text(),\"{0}\")] | //*[@*=\"{0}\"]";
    String ALLLINK = "//a[contains(.,\"{0}\")] | //a[@*=\"{0}\"]";
    String ALLSELECT = "//select[@*=\"{0}\"]";
    String ALLINPUT = "//input[@*=\"{0}\"] | //textarea[@*=\"{0}\"]";
    String ONLYBUTTON="//button[contains(., \"{0}\")]";
    String ONLYBUTTONCONTAİNTEXT ="//button[contains(text(), \"{0}\")]";
    String ONLYBUTTON2="//button[text()= \"{0}\")]";

    default By XPATH(String formatlLocator, String formatText) {
        return By.xpath(MessageFormat.format(formatlLocator, formatText));
    }
}
