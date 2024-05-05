package ui.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ui.pages.AvatarUploadPage;

import java.io.File;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class AvatarUploadStep {

    AvatarUploadPage avatarUploadPage = new AvatarUploadPage();

    static File file = new File("src/test/resources/java.png");

    @Step("Нажать на редактирование аватара профиля")
    public void openPhotoUploadInEditMode() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        avatarUploadPage.editPhotoProfile.should(hidden.because("Кнопка редактирования не видна"));
        avatarUploadPage.editPhotoProfile.shouldBe(visible.because("Кнопка редактирования не нажата")).click();
    }

    @Step("Загрузить картинку")
    public void uploadAPicture(String imgUpload) {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sleep(1000);
        avatarUploadPage.avatarUpload.uploadFromClasspath(imgUpload);
    }

    @Step("Загрузить картинку")
    public void uploadAPictureTwo() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sleep(1000);
        avatarUploadPage.avatarUpload.uploadFile(file);
    }

    @Step("Проверка, что класс img изменился")
    public void checkTheImgClassHasChang() {
        avatarUploadPage.imgSrc.shouldBe(visible.because("В названии класса не добавилась загрузка изображения"));
    }

    @Step("Сохранить изменения")
    public void savePicture() {
        avatarUploadPage.saveButton.shouldBe(visible.because("Изменения не сохранены")).click();
    }

    @Step("Проверить, что картинка загрузилась")
    public void checkThatTheImageHasLoaded() {
        avatarUploadPage.successMessage.shouldBe(visible.because("Аватар не загружен"));
    }
}
