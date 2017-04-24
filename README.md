# common-services


### Github
1. Checkout project by clicking "Clone or Download" button.
2. Copy URL and clone in Source Tree as a new Repository.

### Build
1. Import as Gradle project in Intellij
2. Open Terminal console in Intellij and Run "gradle clean build".
3. On the right menu of Intellij, click on Gradle and click on Refresh.

### Build
1. To test, run "gradle bootRun"
2. Web service is available at http://localhost:8090/login/{id} i.e. http://localhost:8090/login/1 

### Branch
1. To make changes, create a branch in Source Tree. Edit and test your changes there, 
2. Merge "master" to your branch if there new commits.
3. Create pull request for approval.

#### Reference
https://spring.io/guides/gs/rest-service/


### Embedded Mysql 
1. Run "gradle startEmbeddedMysql" to start the database. 
   Note: You'll get an error if you start the database and the instance is running.
2. Run "gradle stopEmbeddedMysql" to stop.


### Flyway DB Migration
1. Place all database scripts in src/main/resources/db/migration
2. Name the sql in order you want the scripts to be executed. (i.e., V1__a, V2__b, V2.1__c)
3. Run the "gradle flywayMigrate -i" if you have the embedded sql running.
4. Alternatively, if you are running your own database "flyway migrate -url=... -user=... -password=..."


### Run the backend application
1. Build the project "gradle clean build"
2. Run database "gradle startEmbeddedMysql"
3. Create database "gradle flywayMigrate -i"
4. Submit requests to postman.


### Postman requests

#### Login
User exists in the database
GET http://localhost:8090/login/user
Authorization : 
Type = Basic Auth
Username = user
Password = user

#### Register
Create user
POST http://localhost:8090/register
Type : JSON (application/json)
Body:
{
  "username": "user2",
  "password": "user2",
  "enabled": true
}

