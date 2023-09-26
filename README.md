## ShiftLabTask

#Для тестирования этой задачи выполните следующие шаги:

1. Скачайте файлы.
2. Загрузите их в IntelliJ IDEA.
3. Запустите проект.

#База данных H2 

Вы можете получить доступ к базе данных H2 по следующему адресу:

http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Стандартный порт: 8080

Логин: shiftDB
Пароль: 123
Были созданы две отдельные таблицы для хранения данных разных типов. intervals_int и intervals_string

#Настройка базы данных

Откройте файл resources/application.properties

spring.datasource.username=shiftDB - Настройка имени 
spring.datasource.password=123 - Настройка пароля
spring.datasource.url=jdbc:h2:mem:testdb - Настройка JDBC URL

#Описание проекта
На сервер приходит POST запрос -> Массивы сортируются по первому элементу -> Происходит объединение интервалов (массивов) -> Загрузка в базу данных -> GET запрос на получение минимального элемента

Класс Sorter отвечает за сортировку. Класс IntervalCombiner отвечает за объединение интервалов. Через класс классы IntervalsStringService и IntervalsIntService происходит добавление данных в базу данных
AlgorithmChain отвечает за выполнение этих 3-х действий в нужном порядке при POST запросе.

За обработку GET запросов отвечает класс IntervalPostController, за обработку POST запросов отвечает класс IntervalGetController.

#Тестирование

Вы можете использовать любой клиент REST API (например, Postman или curl) для взаимодействия с приложением.
POST-запросы:
Для цифровых данных: http://localhost:8080/api/v1/intervals/merge?kind=digits

Для буквенных данных: http://localhost:8080/api/v1/intervals/merge?kind=letters

GET-запросы:
Для цифровых данных: http://localhost:8080/api/v1/intervals/min?kind=digits

Для буквенных данных: http://localhost:8080/api/v1/intervals/min?kind=letters

