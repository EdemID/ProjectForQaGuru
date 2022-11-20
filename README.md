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
- [Отчеты](#bar_chart-отчеты-о-прохождении-тестов)
- - [Allure](#-allure)
- - [Telegram](#-telegram)
- <a href="#film_projector-видео-примеры-прохождения-тестов">Видеозапись тестов</a>

UI тесты реализованы на проверке 
## <a name="description">Описание</a>
Данный проект содержит автоматизированные тесты UI, API и Mobile для следующих продуктов соответственно:
> - <a target="_blank" href="https://career.habr.com/">Хабр Карьера</a>
> - <a target="_blank" href="https://hh.ru/">HH</a>
> - <a target="_blank" href="https://career.habr.com/">Хабр Карьера</a>

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
<a href="https://appium.io/"><img alt="Appium" src="images/logo/Appium.svg" width="6%"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" src="images/logo/Browserstack.svg" width="6%"/></a>
</p>

<a id="gradle-launch"></a>
## :computer: Запуск проекта из терминала

Для запуска тестов с помощью Gradle используется команда:
```bash
gradle clean test -Dtag=<tag> -Dplatform=<platform> -Denv=<env>
```
`tag` - выбор вида тестов:
>- *api*
>- *ui*
>- *mobile*

`platform` - платформа:
>- *\<не задаётся\> (для API тестов)*
>- *ui*
>- *mobile*

`env` - окружение, на котором будут выполнятся тесты:
>- *\<не задаётся\> (для API тестов)*
>- *remote (для UI)*
>- *real (для Mobile)*
>- *browserstack (для Mobile)*
>- *local (для UI и Mobile тестов)*

В зависимости от выбранной платформы и окружения, будет использоваться определенный property файл


## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> <a href=https://jenkins.autotests.cloud/job/HomeworkQaGuru/>Запуск проекта из Jenkins</a>

Страница проекта в Jenkins

<a href="https://jenkins.autotests.cloud/job/chitai-gorod/"><img src="https://user-images.githubusercontent.com/110110734/202859544-d8c8b67d-1dcf-48b0-8d80-6170ec8f19a4.png" alt="Jenkins">
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
## <a href="https://jenkins.autotests.cloud/job/chitai-gorod/allure/"><img alt="Allure" height="50" src="external/Allure.svg" width="50"/>Allure</a>

Пример Allure отчёта

<table>
    <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202859651-ba7db225-1307-42d1-a756-acb5ee53464a.png">
        <img src="https://user-images.githubusercontent.com/110110734/202859651-ba7db225-1307-42d1-a756-acb5ee53464a.png">
        </a>
        </td>
        </tr>
        <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202859732-4dc2727f-69bf-4828-9d87-08ead0eb67e4.png">
        <img src="https://user-images.githubusercontent.com/110110734/202859732-4dc2727f-69bf-4828-9d87-08ead0eb67e4.png">
        </a>
        </td>
</table>

<a id="allure-testops"></a>
## <a href="https://allure.autotests.cloud/project/1687/dashboards"><img alt="Allure TestOps" height="50" src="external/Allure TestOps.svg" width="50"/>Allure TestOps</a>

Пример Allure TestOps отчёта

<table>
    <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202862964-974dfa9d-55ef-4a77-8406-2bc6952ea790.png">
        <img src="https://user-images.githubusercontent.com/110110734/202862964-974dfa9d-55ef-4a77-8406-2bc6952ea790.png">
        </a>
        </td>
   </tr>
        <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202862978-f86145e3-4d34-4d7e-a0bb-35af7f5115a3.png">
        <img src="https://user-images.githubusercontent.com/110110734/202862978-f86145e3-4d34-4d7e-a0bb-35af7f5115a3.png">
        </a>
        </td>
        </tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202862981-42f72adc-1519-4a39-bfd6-5f011ea82552.png">
        <img src="https://user-images.githubusercontent.com/110110734/202862981-42f72adc-1519-4a39-bfd6-5f011ea82552.png">
        </a>
        </td>
</table>

<a id="selenoid"></a>
## <img alt="Selenoid" height="50" src="external/Selenoid.svg" width="50"/> Selenoid</a>

Видео-пример выполнения UI-теста с помощью Selenoid

<video src="https://user-images.githubusercontent.com/110110734/202859382-0d5509e0-a5a8-4c7f-9df0-9d8bcf16fc2f.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Selenoid.svg"></video>

<a id="browserstack"></a>
## <img alt="Browserstack" height="45" src="external/Browserstack.svg" width="45"/> Browserstack</a>

Видео-пример выполнения Mobile-теста с помощью Browserstack

<video src="https://user-images.githubusercontent.com/110110734/202863081-112a3796-fd9d-40ce-9684-392458f28ee8.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Browserstack.svg"></video>

<a id="telegram"></a>
## <a href="https://t.me/chitai_gorod_tests_bot"><img alt="Telegram" height="50" src="external/Telegram.svg" width="50"/>Telegram</a>

Пример уведомления в Telegram-бот по окончании выполнения тестов

![Telegram screenshot](https://user-images.githubusercontent.com/110110734/202859925-48e64223-96aa-41b1-9a32-2ca475a547c5.png)

:heart:
:blue_heart: 
