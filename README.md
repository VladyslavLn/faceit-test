# :eyes: About project:
The application has the ability:
- Uploading a file via Rest API with data saving to the database.
- All uploaded data can be retrieved in JSON format via Rest API.
- Sorting and pagination for received data.

# :abacus: Technologies used:
- Java 17
- Spring Boot JPA
- REST
- H2
- Lombok
- Swagger

# :computer: If you want to run this project on your computer, you need:
1. To have or install IDE([IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/))
2. Clone this project:
```bash
git clone https://github.com/VladyslavLn/faceit-test.git
```
3. Add [Lombok](https://projectlombok.org/setup/overview) plugin to your IDE
4. Run (Shift+F10) application

After all these steps you will be able to run this project locally.
- You can upload your CSV file via [Postman](https://www.postman.com/) on :
```
http://localhost:8080/educationalinstitution/upload
```
- You can get all data from db :
```
http://localhost:8080/educationalinstitution
```