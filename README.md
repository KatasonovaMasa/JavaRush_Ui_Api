Проект JavaRush Test - это автоматизированный набор тестов для проверки функциональности JavaRush-онлайн курса по обучению JavaRush.
Он включает в себя Mobile-тесты для проверки пользовательского интерфейса.

## JavaRush
<img alt="GIPHY" src=".github/sc/javarush.png">


Инструменты и технологии используемые для данного проекта
<p align="center">  
<a href="https://www.jetbrains.com/idea/"><code><img width="5%" title="IntelliJ IDEA" src=".github/logo/Intelij_IDEA.svg"></code></a>
<a href="https://www.java.com/"><code><img width="5%" title="Java" src=".github/logo/Java.svg"></code></a>
<a href="https://selenide.org/"></a><code><img width="5%" title="Selenide" src=".github/logo/Selenide.svg"></code></a>
<a href="https://aerokube.com/selenoid/"><code><img width="5%" title="Selenoid" src=".github/logo/Selenoid.svg"></code></a>
<a href="https://gradle.org/"><code><img width="5%" title="Gradle" src=".github/logo/Gradle.svg"></code></a>
<a href="https://junit.org/junit5/"><code><img width="5%" title="JUnit5" src=".github/logo/JUnit5.svg"></code></a>
<a href="https://docs.qameta.io/allure/"><code><img width="5%" title="Allure Report" src=".github/logo/Allure_Report.svg"></code></a>
<a href="https://qameta.io/"><code><img width="5%" title="Allure TestOps" src=".github/logo/AllureTestOps.svg"></code></a>
<a href="https://github.com/"><code><img width="5%" title="Github" src=".github/logo/GitHub.svg"></code></a>
<a href="https://git-scm.com/"><code><img width="5%" title="Github" src=".github/logo/Git.svg"></code></a>
<a href="https://www.jenkins.io/"><code><img width="5%" title="Jenkins" src=".github/logo/Jenkins.svg"></code></a>
<a href="https://www.atlassian.com/ru/software/jira"><code><img width="5%" title="Jira" src=".github/logo/Jira.svg"></code></a>
<a href="https://telegram.org/"><code><img width="5%" title="Telegram" src=".github/logo/Telegram.svg"></code></a>
<a href="https://rest-assured.io/"><code><img width="5%" title="REST-Assured" src=".github/logo/rest-assured-logo.svg"></code></a>
<a href="https://www.browserstack.com/"><code><img width="5%" title="Browserstack" src=".github/logo/Browserstack.svg"></code></a>
<a href="https://appium.io/"><code><img width="5%" title="Appium" src=".github/logo/Appium.svg"></code></a>
<a href="https://developer.android.com/studio"><code><img width="5%" title="Android_Studio" src="https://upload.wikimedia.org/wikipedia/commons/9/95/Android_Studio_Icon_3.6.svg"></code></a>
</p>
 

Проект представляет собой набор автоматизированных Mobile- тестов. Он разделен на следующие модули:

<details>
  <summary>Mobile-тесты:</summary>

1. **AuthorizationInTheApplicationTest** - Авторизация в приложении.
   - `authorizationInTheApplication`: авторизация по логину и паролю.
2. **CommentsSectionTest** - Блок Комментариев.
   - `addCommentUnderAnArticle`: добавление комментария под статьёй.
   - `checkCommentBlocks`: проверка блоков комментариев.
3. **CreatingACourseMobileTest** - Создание персонального курса.
   - `creatProgrammingCourseWithoutTakingQuestions`: создание курса БЕЗ прохождения опроса.
   - `creatProgrammingCourseByPassingTheQuestions`: создание курса ПРИ прохождении опроса.
4. **LikesUnderTheArticleTest** - Функциональность Лайков.
   - `addLikeUnderTheArticle`: Добавление лайка.
5. **SectionsInTheApplicationMobileTest** - Разделы в приложении.
   - `openSectionsInTheApplication`: проверка разделов приложения.
</details>

### Локальный запуск

Для локального запуска тестов используйте команду:

```bash
./gradlew clean test
```

### Удаленный запуск

Удаленный запуск тестов с параметрами:

```bash
clean
${TASK}
-DisRemote=true
-DbaseUrl=${BASE_URL}
-DbrowserSize=${BROWSER_SIZE}
-Dbrowser=${BROWSER}
-Dselenoid=https://user1:1234@selenoid.autotests.cloud/wd/hub
-DbrowserVersion=${BROWSER_VERSION}
```

### Запуск с Jenkins
Если вы используете Jenkins для запуска тестов, вы можете использовать параметризованную сборку с следующими
параметрами:

TASK (с какими тегами запускать тесты)
- `test` - тег по умолчанию.

### Файл test.properties

Для запуска тестов локально на вашем компьютере, вам необходимо добавить файл test.properties в папку ресурсов (src/main/resources). В этом файле необходимо указать следующие свойства:

```bash 
login.JavaRush=логин в приложении
password.JavaRush=пароль в приложении

browserstack.deviceName=модель андройда
browserstack.platformName=тип устройства
browserstack.osVersion=версия андройда
browserstack.url=адрес локального сервера
browserstack.appPackage=appPackage мобильного приложения
browserstack.appActivity=appActivity мобильного приложения

browserstack.username=username
browserstack.passwordKey=passwordKey
browserstack.remoteMobileUrl=адрес удалённого запуска
browserstack.app=app
```

### Ссылки и визуализация

Ниже представлены скриншоты основных инструментов и процессов, используемых в ходе разработки и тестирования проекта. Вы
можете развернуть каждый раздел, чтобы увидеть подробности.

<details>
  <summary>IntelliJ IDEA</summary>

![Image1](.github/sc/idea.png)
</details>

<details>
  <summary>Jenkins</summary>

[Перейти к сборке в Jenkins](https://jenkins.autotests.cloud/job/JR/job/JavaRush_Mobile/)

![Image2](.github/sc/jenkins1.png)
![Image3](.github/sc/jenkins2.png)
</details>

<details>
  <summary>AllureReport</summary>

[Перейти к отчету в AllureReport](https://jenkins.autotests.cloud/job/JR/job/JavaRush_Mobile/109/allure/#)

![Image4](.github/sc/allureReport1.png)
![Image5](.github/sc/allureReport2.png)
</details>

<details>
  <summary>AllureTestOps</summary>

[Перейти к отчету AllureTestOps](https://allure.autotests.cloud/launch/38627/tree?treeId=7152)

![Image6](.github/sc/allureTestOps1.png)
![Image7](.github/sc/allureTestOps2.png)
![Image7](.github/sc/allureTestOps3.png)
</details>

<details>
  <summary>BrowserStack</summary>

![Image10](.github/sc/BrowserStack1.png)
![Image10](.github/sc/BrowserStack2.png)
</details>

<details>
  <summary>Уведомление Telegram</summary>

![Image9](.github/sc/telegram.png)
</details>

<details>
  <summary>Демонстрационное видео запуска мобильных тестов</summary>

[Скачать демонстрационное видео](.github/video/MobileTest.mp4)

[//]: # (https://github.com/KatasonovaMasa/JavaRush_Ui_Mobile_Api/assets/44576709/2c50350f-dd8a-43bf-b7b5-8ab9992afac6)
<p align="center">
<img title="Browserstack Video" src=".github/video/MobileTest.gif" width="450" height="500"  alt="video">   
</p>

</details>




### Контакты

   Кликни на изображение

[<img alt="GIPHY" align="center" src=".github/logo/telegram1.png">](https://t.me/QA_marykat)