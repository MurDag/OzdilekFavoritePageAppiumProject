package PageObjectModel;

import io.appium.java_client.AppiumDriver;

import java.util.logging.Logger;

import static Definitions.ElementsMap.elementListMap;

public class FormPage extends AbstractClass {

    public FormPage(AppiumDriver appiumDriver, Logger logger) {
        super(appiumDriver, logger);
    }

    public void checkOpenApp() throws InterruptedException {
        Thread.sleep(3000);
        String context = appiumDriver.getContext();
        if (context.equals("NATIVE_APP")) {
            logger.info("Uygulama Başarılı bir şekilde açıldı.");
        } else {
            logger.warning("Uygulama açılamadı !");
        }
    }

    public void click(String element) {
        click(elementListMap().get(element));
    }

    public void assertion(String element, String text) {
        assertion(elementListMap().get(element), text);
    }

    public void swipeWithLastElement() throws InterruptedException {
        swipeWithLastElement(elementListMap().get("lastPantOnList"));
    }

    public void isSelected(String element) {
        isSelected(elementListMap().get(element));
    }

    public void isClickable(String element) {
        isClickable(elementListMap().get(element));
    }
}
