package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {

    private final static String THANKS_SUBMITTING_FORM = "Thanks for submitting the form";

    private SelenideElement
            titleInput = $("#example-modal-sizes-title-lg");

    TableComponent tableComponent = new TableComponent();

    public ConfirmationPage confirmPage() {
        titleInput.shouldHave(text(THANKS_SUBMITTING_FORM));
        return this;
    }

    public ConfirmationPage confirmResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;
    }


}
