cd library-backend
mvn package
java -jar .\target\library-backend-spring-boot.jar
cd ..
cd library-management-app
npm i
ng serve --open