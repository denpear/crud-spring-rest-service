# crud-spring-rest-service
Elaborate CRUD methods for a complete user profile.
There is a user profile consisting of first name, patronymic, surname, date of birth, sex. The user has contacts (phone number, email, VK account, Odnoklassniki account, etc.). A user may have several phone numbers, emails and other contacts. User's profile and contacts form user's complete profile.

H2 (in-memory), sqlite, Postgres can be used as a database.

Task:
1.	Takes less time. Add two users and his contacts. Implement a GET method that takes user id as a parameter, which gives full user profile. If the parameter is not passed, the method should return full profiles of all users.
2.	Takes more time. Develop CRUD methods for full user profile.

It should be possible to call API methods via http client, e.g. curl or postman, once the application is running.
