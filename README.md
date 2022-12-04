# Проект по автоматизированному тестированию
<p align="center">
<img title="GitHub Test Page" src="images/logo/auto.gif">
</p>

## Содержание:
- <a href="#description">Описание</a>
- <a href="#технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#gradle-launch">Запуск проекта из терминала</a>
- <a href="#jenkins-launch">Запуск проекта из Jenkins</a>
- <a href="#notebook_with_decorative_cover-реализованные-проверки">Реализованные проверки</a>
- [Отчеты](#-отчеты)
- - [Allure](#-allure)
- - [Allure TestOps](#-allure-testops)
- - [Telegram](#-telegram)
- <a href="#видеозапись-тестов">Видеозапись тестов</a>

## <a name="description">Описание</a>
Данный проект является многомодульным и содержит автоматизированные тесты UI, API и Mobile. Сборка -  Gradle. CI/CD - Jenkins

## Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="RestAssured" src="images/logo/Rest-Assured.png">
<a href="https://qameta.io/"><img alt="Allure TestOps" src="images/logo/Allure_EE.svg" width="6%"/></a>
<a href="https://appium.io/"><img alt="Appium" src="images/logo/Appium.svg" width="5%"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" src="images/logo/Browserstack.svg" width="5%"/></a>
</p>

<a id="gradle-launch"></a>
## :computer: Запуск проекта из терминала

Запуск UI тестов:
```bash
gradle clean ui_test -Dbrowser.name=<name> -Dbrowser.size=<size>
```
Запуск API тестов:
```bash
gradle clean api_test
```
Запуск Mobile тестов на локальном эмуляторе:
```bash
gradle clean mobile_test -Denv=local -DdeviceHost=emulation
```
Запуск Mobile тестов в browserstack:
```bash
gradle clean mobile_test -Denv=remote -DdeviceHost=browserstack 
```

В зависимости от выбранных env и deviceHost, будет использоваться определенный property файл


## <a id="jenkins-launch"></a><img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"> <a href=https://jenkins.autotests.cloud/job/HomeworkQaGuru/>Запуск проекта из Jenkins</a>

<img src="https://user-images.githubusercontent.com/110110734/202859544-d8c8b67d-1dcf-48b0-8d80-6170ec8f19a4.png" alt="Jenkins">

Параметризованная сборка проекта

<a href="https://jenkins.autotests.cloud/job/HomeworkQaGuru/build?delay=0sec"><img src="https://user-images.githubusercontent.com/110110734/202859544-d8c8b67d-1dcf-48b0-8d80-6170ec8f19a4.png" alt="Jenkins">
</a>

Параметры сборки:
>- *`tag` - выбор вида тестов*
>- *`platform` - платформа*
>- *`env` - окружение, на котором будут выполнятся тесты*
>- *`browser` - браузер*
>- *`REMOTE_URL` - адрес Selenoid*
>- *`VIDEO_STORAGE` - адрес хранилища видео Selenoid*

```bash
gradle clean ...
```
## Отчеты о прохождении тестов

<a id="allure"></a>
## <a href="https://jenkins.autotests.cloud/job/HomeworkQaGuru/allure/"><img alt="Allure" src="images/logo/Allure_Report.svg" width="5%"/> Allure</a>

Пример Allure отчёта

<img src="img/screen/AllureTests.jpg" alt="Allure"/>

<a id="allure-testops"></a>
## <a href="https://allure.autotests.cloud/project/1687/dashboards"><img alt="Allure TestOps" src="images/logo/Allure_EE.svg" width="5%"/> Allure TestOps</a>

Пример Allure TestOps отчёта

<img width="3%" title="Allure" src="img/logo/Allure_TO.svg"> 

<a id="telegram"></a>
## <a href="https://t.me/qaGguruHw_14_edemID_bot"><img alt="Telegram" src="images/logo/Telegram.svg" width="5%"/> Telegram</a>

Пример уведомления в Telegram-бот по окончании выполнения тестов

<img src="img/screen/Bot.jpg" alt="Telegram"/>

## Видеозапись тестов
<a id="selenoid"></a>
## <img alt="Selenoid" src="images/logo/Selenoid.svg" width="5%"/> Selenoid</a>

Видеозапись UI-теста в Selenoid

<p align="center">
  <img title="Video" src="img/gif/test.gif">
</p>

<a id="browserstack"></a>
## <img alt="Browserstack" src="images/logo/Browserstack.svg" width="4%"/> Browserstack</a>

Видеозапись Mobile-теста в Browserstack

<video src="https://user-images.githubusercontent.com/110110734/202863081-112a3796-fd9d-40ce-9684-392458f28ee8.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Browserstack.svg"></video>


:heart:
:blue_heart: 
