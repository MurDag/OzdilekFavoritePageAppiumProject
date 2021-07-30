import PageObjectModel.FormPage;
import com.thoughtworks.gauge.Step;

public class StepImplementation extends BaseTest {

    FormPage formPage = new FormPage(appiumDriver, logger);

    @Step("Uygulamanın açıldığı kontrol edilir.")
    public void implementation2() throws InterruptedException {
        formPage.checkOpenApp();
    }

    @Step("<element> adlı elemente tıkla.")
    public void implementation1(String element) {
        formPage.click(element);
    }

    @Step("<element> adlı element içinde <text> yazdığını kontrol et.")
    public void implementation3(String element, String text) {
        formPage.assertion(element, text);
    }

    @Step("Aşağı kaydır.")
    public void implementation4() throws InterruptedException {
        Thread.sleep(1000);
        formPage.swipeWithLastElement();
    }

    @Step("<element> adlı elementin seçildiği kontrol edilir.")
    public void implementation5(String element) {
        formPage.isSelected(element);
    }

    @Step("<element> adlı elementin clickable özelliğini kontrol et.")
    public void implementation6(String element) {
        formPage.isClickable(element);
    }
}
