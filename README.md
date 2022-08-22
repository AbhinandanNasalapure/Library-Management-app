## Library management app
- Read books from library and displays in table structure.
- Update books details like title, author, ISBN , etc.
- Delete books from Library.
- (Currently app provides UI to add books and view books only)
- Note: Refresh page to view books.
## Pre-requisites before running app
- Java 11+
- Node.js
- NPM
- Angular CLI

## Running app on windows
- Run batch file named 'run-library-app.bat' by double clicking on it. It will take care of launching app and backend.

## Running app on Mac/Linux
- Run bash file named 'run-library-app.sh'

Note: You can also run backend and front end app individually if above automation script file is not your preference. For this follow below steps:

```shell
cd library-backend
mvn package
java -jar .\target\library-backend-spring-boot.jar
cd ..
cd library-management-app
npm i
ng serve --open
```

