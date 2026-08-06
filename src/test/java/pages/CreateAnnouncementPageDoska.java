package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateAnnouncementPageDoska {
    private final SelenideElement nameField = $x("//input[@name='name']");
    private final SelenideElement categoryDropdownButton = $x("(//button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')])[1]");
    private final SelenideElement conditionNew = $x("//form/fieldset/div/div[1]/div");
    private final SelenideElement conditionUsed = $x("//form/fieldset/div/div[2]/div");
    private final SelenideElement descriptionField = $x("//textarea[@name='description']");
    private final SelenideElement priceField = $x("//input[@name='price']");
    private final SelenideElement cityDropdownButton = $x("(//button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')])[2]");
    private final SelenideElement publishButton = $x("//button[text()='Опубликовать']");

    public void setName(String name) {
        nameField.setValue(name);
    }

    public void openCategoryDropdown() {
        categoryDropdownButton.click();
    }

    public void selectCategory(String categoryText) {
        $x("//span[text()='" + categoryText + "']").click();
    }

    public void selectConditionNew() {
        conditionNew.click();
    }

    public void selectConditionUsed() {
        conditionUsed.click();
    }

    public void setDescription(String description) {
        descriptionField.setValue(description);
    }

    public void setPrice(String price) {
        priceField.setValue(price);
    }

    public void openCityDropdown() {
        cityDropdownButton.click();
    }

    public void selectCity(String cityText) {
        $x("//span[text()='" + cityText + "']").click();
    }

    public void clickPublish() {
        publishButton.click();
    }
}