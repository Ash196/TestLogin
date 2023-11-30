## Автоматизация тестирования демо-сайта Test Login
### Документация
* <a href="https://github.com/Ash196/TestLogin/blob/main/Documents/Plan.md">План автоматизации тестирования;</a>
* <a href="https://github.com/Ash196/TestLogin/blob/main/Documents/Report.md">Отчёт по итогам автоматизированного тестирования;</a>
* <a href="https://github.com/Ash196/TestLogin/blob/main/Documents/Summary.md">Отчёт по итогам автоматизации;</a>
### Инструкция по запуску
1. Склонировать проект из репозитория
* Открыть Git Bash и выполнить команду git clone https://github.com/Ash196/TestLogin.git
2. Открыть проект в IDEA
* Открыть проект с помощью IntelliJ IDEA
3. Запустить тестовый набор
* Открыть терминал и выполнить команду mvn test clean
4. Сформировать отчёт
* В терминале выполнить команду allure serve allure-results