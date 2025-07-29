# CrudOperationsUsingJDBC

A Java application demonstrating **CRUD (Create, Read, Update, Delete) operations** on a relational database using JDBC, with a clean, modular architecture.


- **dao/**: Interfaces for data access objects (`RestaurantDAO`, `UserDAO`).
- **daoimp/**: Implementation classes for DAOs (`RestaurantDAOImpl`, `UserDAOImpl`).
- **models/**: Model classes representing data entities (`Restaurant`, `User`).
- **util/**: Utility class for database connection management (`DBConnection`).
- **lib/**: Contains the MySQL Connector/J JDBC driver.

## Setup & How to Run

1. **Clone this repository.**
2. **Ensure the MySQL JDBC driver** (`mysql-connector-j-9.4.0.jar`) is in the `/lib` directory and referenced in your project build path.
3. **Edit your database connection details** in `DBConnection.java`:
    ```
    String url = "jdbc:mysql://localhost:3306/your_database";
    String user = "your_username";
    String password = "your_password";
    ```
4. **Compile and run**:
    - If using an IDE (e.g., Eclipse), add `/lib/mysql-connector-j-9.4.0.jar` to your project’s build path.
    - If using the command line:
        ```
        javac -cp lib/mysql-connector-j-9.4.0.jar src/com/crudjdbc/**/*.java
        java -cp .:lib/mysql-connector-j-9.4.0.jar com.crudjdbc.Main
        ```
        *(On Windows, use `;` instead of `:` for the classpath separator.)*

## Requirements

- Java 8 or newer (Java SE-21 recommended)
- MySQL Database
- MySQL JDBC Driver (provided in `/lib`)
- Eclipse or another Java IDE (optional but recommended)

## Features

- **CRUD operations** on user-defined database tables via Java interfaces and their implementations.
- Uses **parameterized queries** to prevent SQL injection.
- Organized into separate layers (DAO, model, utility) for maintainability and extensibility.
- Ready to extend with additional entities, features, or switch to other JDBC-compliant databases.

## Notes

- Ensure your target database and tables exist before running the application.
- The code is written for educational and illustrative purposes.
- Project structure and naming follow standard Java practices for clarity and collaboration.

## License

This project is open for educational and learning purposes.
