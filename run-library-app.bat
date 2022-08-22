
(
   start "library-app-backend" cmd /C "cd library-backend & mvn package & java -jar .\target\library-backend-spring-boot.jar"
   start "library-app-frontend" cmd /C "cd library-management-app & npm i & ng serve --open"
)