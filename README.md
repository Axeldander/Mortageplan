
**MortgageCalculator**

This tool calculates fixed monthly payments for a provided list of customers.

**Getting Started**

These instructions will guide you to set up the project on your local machine for development and testing purposes.

**Requirements**

- Java 1.8+
  
- Maven


**Running the Tests**

To execute the tests and verify the correctness of the loan payment calculations, use the following command:
```java
mvn verify
```
These tests ensure the accuracy of the loan payment calculations.

**Running the Tool**

1. Prepare a CSV file in the following format: `Customer,Total loan,Interest,Years`.
   The tool will skip the first line in the file.

   For example:
   ```
   Customer,Total loan,Interest,Years
   Johnny,1000,5,2
   Deedee,4356,1.27,6
   Marilyn Manson,1300.55,8.67,2
   "Roger,Rabbit",2000,6,4
   ```

2. Set the file path in `src/main/resources/application.properties` under the `prospects.file.csv` property.

   For example:
   ```
   prospects.file.csv=prospects.txt
   ```
   The path can be relative to the root folder of the project.

3. Navigate to the target directory: Open a command prompt or terminal and navigate to the 'target' directory of your project using the 'cd' command.

   For example:
   ```bash
    cd path/to/your/project/target
   ```
  
3. Launch the tool by running the command:
     ```java
     java -jar target/MortageCalculator-1.0-SNAPSHOT.jar
     ```


     
**License**

This project is open-source and free to use.


