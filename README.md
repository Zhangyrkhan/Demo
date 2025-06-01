Проект представляет собой REST API для управления задачами с использованием Spring Boot, JWT-аутентификации, Spring Security и встроенной базы данных H2.

---
Как запустить

git clone https://github.com/Zhangyrkhan/demo.git

cd demo

mvn spring-boot:run

И можете тестировать через postman
Приложение будет доступно на http://localhost:8080

Примеры запросов
Аутентификация

POST /api/auth/register — регистрация
{
  "username": "user",
  "password": "user",
  "role": "USER"
}
{
  "username": "admin",
  "password": "admin",
  "role": "ADMIN"
}
![image](https://github.com/user-attachments/assets/97a14191-a11e-4030-9b58-2f58f0d740d6)


POST /api/auth/login — вход (возвращает токен)

{
  "username": "user",
  "password": "user"
}

{
  "username": "admin",
  "password": "admin"
}


Пример вывода 

{
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzQ4Nzg0MTg3LCJleHAiOjE3NDg3ODQ3ODd9.BHC50XltbWvDfmKHRicfMfccCrVjxTSM7vjUeTqjTv0",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzQ4Nzg0MTg3LCJleHAiOjE3NDg4NzA1ODd9.YzWxG9IqUC-iT3z850Vke9a8KwUg3-pQeWNk84B_tMQ"
}

![image](https://github.com/user-attachments/assets/8dfdefba-a15a-4ebc-8608-1227131cd48f)


POST /api/auth/refresh обновление токена 
![image](https://github.com/user-attachments/assets/a8571bd7-16f6-4a1f-9592-dd5210e07a37)

Нужно вставить refresh token и он обновит токены


GET /api/admin/users - получить всех зарегистрированных юзеров (доступно только для роли ADMIN)
JWT-токен передаётся в заголовке:
Authorization: Bearer <токен>
![image](https://github.com/user-attachments/assets/07684e1a-87b2-4974-866a-d196729ff426)





Задачи (нужен токен)
GET /api/tasks — все задачи

GET /api/tasks/by-status/<TODO, IN_PROGRESS, DONE> — по статусу

POST /api/tasks — создать
{
  "title": "Задача 6",
  "description": "description",
  "status": "IN_PROGRESS"  
}

PUT /api/tasks/{id} — обновить
{
  "title": "put задача",
  "description": "description",
  "status": "IN_PROGRESS"  
}

DELETE /api/tasks/{id} — удалить

JWT-токен передаётся в заголовке:
Authorization: Bearer <токен>


Технологии

- Java 21
- Spring Boot 3.5
- Spring Security
- JWT (JJWT)
- H2 Database (в памяти)
- Maven
- Lombok

---

Возможности

- Регистрация и вход с JWT
- CRUD по задачам (Task)
- Поиск задач по статусу (TODO, IN_PROGRESS, DONE)
- Роли пользователей (ADMIN, USER)
- Защита API: доступ к задачам только с токеном

- ---

Защита и доступ

- /api/auth/** — открытые маршруты (регистрация, вход)
- /api/tasks/** — только для авторизованных пользователей
- /api/admin/** — только для пользователей с ролью ADMIN
