# Lab-s
Описание классов:
### ToDo
Класс представляет модель данных ToDo, содержащую описание задачи, дату создания и модификации, и флаг завершенности.

### ToDoRepository
Реализация интерфейса `CommonRepository<ToDo>`, предоставляющая базовые операции для работы с сущностями ToDo. Для простоты примера, для имтации базы данных используется `Map` для хранения задач в памяти.

### ToDoController
REST-контроллер, обрабатывающий HTTP-запросы и взаимодействующий с сервисом. Логирует выполненные операции.

### ToDoBuilder
Класс-билдер для удобного создания экземпляров ToDo с возможностью задания описания и идентификатора.

### ToDoValidationError
Класс для представления сообщений об ошибках валидации.

### ToDoValidationErrorBuilder
Класс-билдер для удобного создания экземпляров ToDoValidationError.

### Описание работы
1. **ToDo:** Модель данных для представления задачи.
2. **ToDoRepository:** Имитация репозитория для хранения и обработки задач в памяти.
3. **ToDoController:** REST-контроллер для обработки HTTP-запросов.
5. **ToDoBuilder:** Билдер для удобного создания задач с возможностью установки описания и идентификатора.
6. **ToDoValidationError и ToDoValidationErrorBuilder:** Классы для представления и построения сообщений об ошибках валидации.

### Логика работы
1. **ToDo:** Описание модели данны, включает уникальный идентификатор, описанием задачи, временем создания, временем последней модификации и флагом обозначающий завершенность. Предоставляет конструкторы для создания задач с автоматическим проставлением идентификатора и времени создания.
   
2. **ToDoRepository:** Имитирует репозиторий для хранения задач в памяти. Реализует основные методы для сохранения, удаления, поиска задач.

3. **ToDoController:** Обрабатывает HTTP-запросы, взаимодействуя с ToDoService. Реализует методы для получения всех задач, получения задачи по идентификатору, установки флага завершенности и создания/обновления задачи.

4. **ToDoBuilder:** Билдер для удобного создания экземпляров ToDo с возможностью задания описания и идентификатора.

5. **ToDoValidationError и ToDoValidationErrorBuilder:** Используются для представления и построения сообщений об ошибках при проверках.

### Журналирование
Добавлено журналирование в методы ToDoController для отслеживания выполненных операций.

Сделали большую часть, но не получилось 6 и 7 пункт не удалось подключить.
com.fasterxml.jackson.core
Отдельно cделали клиент для провеки, он ляжит в папке client.
