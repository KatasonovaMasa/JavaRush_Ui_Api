package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AvatarUploadPage {

    public final SelenideElement avatarUpload = $x("//input[contains(@id, 'me-profile-upload')]");
    public final SelenideElement getCourse = $x("//button[@id='id_button_jr_welcome_get_course']");
    public final SelenideElement editPhotoProfile = $x("//button[contains(@Class,'button') and contains(@Class,'button--sm') and contains(@Class,'avatar-upload-button') and contains(@Class,'ng-star-inserted')]");
    public final SelenideElement saveButton = $x("//button[contains(@class, 'button') and contains(@Class, 'button--success') and contains(@Class, 'button--md-wide')]");
    public final SelenideElement imgSrc = $x("//img[@src= '/api/1.0/rest/me/pictures-private/avatar-source?cache=1']");
    public final SelenideElement successMessage = $x("//*[contains(text(),'Изображение загружается на сервер')]");
}