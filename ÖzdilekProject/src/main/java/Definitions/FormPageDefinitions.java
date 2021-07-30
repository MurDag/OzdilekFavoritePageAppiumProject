package Definitions;

import org.openqa.selenium.By;

public class FormPageDefinitions {

    static final By startToShooping = By.id("tv_startShoppingStore");
    static final By checkShoppingPage = By.xpath("//android.widget.TextView[@text=\"Mağaza\"]");
    static final By categories = By.id("nav_categories");
    static final By checkCategoriesPage = By.id("nav_categories");
    static final By buttonWomanCategori = By.xpath("//android.widget.TextView[@text=\"Kadın\"]");
    static final By buttonPantsCategori = By.xpath("//android.widget.TextView[@text=\"Pantolon\"]");
    static final By lastPantOnList = By.xpath("(//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout)[last()]");
    static final By lastPantFavOnList = By.xpath("(//android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"com.ozdilek.ozdilekteyim:id/ivFavorite\"])[last()]");
    static final By buttonLogin = By.id("btnLogin");
    static final By buttonBack = By.id("ivBack");
    static final By buttonMyAccount = By.id("nav_account");
    static final By buttonMyBasket = By.id("nav_cart");

}
