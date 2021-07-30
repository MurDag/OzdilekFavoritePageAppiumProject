package Definitions;

import org.openqa.selenium.By;

import java.util.HashMap;

import static Definitions.FormPageDefinitions.*;

public class ElementsMap {
    public static HashMap<String, By> elementListMap() {
        HashMap<String, By> elements = new HashMap<String, By>();
        elements.put("startToShooping", startToShooping);
        elements.put("checkShoppingPage", checkShoppingPage);
        elements.put("categories", categories);
        elements.put("checkCategoriesPage", checkCategoriesPage);
        elements.put("buttonWomanCategori", buttonWomanCategori);
        elements.put("buttonPantsCategori", buttonPantsCategori);
        elements.put("lastPantFavOnList", lastPantFavOnList);
        elements.put("lastPantOnList", lastPantOnList);
        elements.put("buttonLogin", buttonLogin);
        elements.put("buttonBack", buttonBack);
        elements.put("buttonMyAccount", buttonMyAccount);
        elements.put("buttonMyBasket", buttonMyBasket);
        return elements;
    }
}
