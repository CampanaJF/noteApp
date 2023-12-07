# NotesApp

### Technologies
 - Java 17
 - Angular 16
 - MySQL Server 8
 
### Before Running the Script:
- Docker must be opened
- The database is dockerized, should work as long as port 3307 is available
- In case the bootRun fails, execute the script again, this is due to the composing part taking too long, depends on the system running the script

### Functionality
- The app does eveything stated in phase 1 and 2 of the user story, to delete and edit notes they must not be archived
 
### Run Script
```shell
./script.sh
```

### Run
```shell
backend/gradlew bootRun
```

### Test
```shell
backend/gradlew test
```

