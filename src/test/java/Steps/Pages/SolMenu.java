package Steps.Pages;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
public class SolMenu extends BaseClass {
    @When("Sol Menuden {string} menüsünü açar ve {string} butonuna tıklar")
    public void solMenudenMenuacar(String menuAdi,String butontext){
        Pages.SolMenu.solMenudenMenuacar(menuAdi,butontext);
    }



}
