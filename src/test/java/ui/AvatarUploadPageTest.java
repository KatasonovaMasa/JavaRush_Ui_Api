package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static help.GenerateRandomPage.generateRockStarText;

@Tag("JRUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
@Story("Загрузка аватара в фото профиля")
@DisplayName("Загрузка аватара в фото профиля")
public class AvatarUploadPageTest extends TestBase {

    String imgUpload = "java.png",
    deleted = "DELETE";

    @Test
    @DisplayName("Загрузка аватара в фото профиля с помощью uploadFromClasspath")
    void uploadingAnAvatarToYourProfilePhoto() {
        startStep.openJavaRush();
        startStep.startLearnOne();
        creatACourseStep.pressStartButton();
        creatACourseStep.selectLanguage();
        String expectedEmail = generateRockStarText();
        creatACourseStep.inputEmail(expectedEmail + "@mail.ru");
        String expectedPassword = generateRockStarText();
        creatACourseStep.inputPassword(expectedPassword);
        creatACourseStep.clickCreatAccount();
        creatACourseStep.checkCreatAccount();
        sidebarStep.scrollDownAndOpenSettings();
        avatarUploadStep.openPhotoUploadInEditMode();
        avatarUploadStep.uploadAPicture(imgUpload);
        avatarUploadStep.checkTheImgClassHasChang();
        avatarUploadStep.savePicture();
        avatarUploadStep.checkThatTheImageHasLoaded();
        creatACourseStep.clickDeletedAccount(deleted);
    }

    @Test
    @DisplayName("Загрузка аватара в фото профиля с помощью uploadFile")
    void uploadingAnAvatarToYourProfilePhotoTwo() {
        startStep.openJavaRush();
        startStep.startLearnOne();
        creatACourseStep.pressStartButton();
        creatACourseStep.selectLanguage();
        String expectedEmail = generateRockStarText();
        creatACourseStep.inputEmail(expectedEmail + "@mail.ru");
        String expectedPassword = generateRockStarText();
        creatACourseStep.inputPassword(expectedPassword);
        creatACourseStep.clickCreatAccount();
        creatACourseStep.checkCreatAccount();
        sidebarStep.scrollDownAndOpenSettings();
        avatarUploadStep.openPhotoUploadInEditMode();
        avatarUploadStep.uploadAPictureTwo();
        avatarUploadStep.checkTheImgClassHasChang();
        avatarUploadStep.savePicture();
        avatarUploadStep.checkThatTheImageHasLoaded();
        creatACourseStep.clickDeletedAccount(deleted);
    }
}
