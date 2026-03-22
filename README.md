# Library Management System

Simple library management system to practice Java OOP and PostgreSQL integration.

##  Learning Goals
- Java OOP (Classes, Inheritance, Composition, Encapsulation)
- PostgreSQL integration with JDBC
- CRUD operations
- Data validation
- Secure credential management

##  Tech Stack
- Java 11+
- PostgreSQL 15
- JDBC (PostgreSQL Driver 42.7.10)

##  Progress - Week 1

**Day 1 (14/03/2026):**
-  Book class (auto-increment ID, validations)
-  Member class (validations)
-  Library class (composition, ArrayList)
-  Basic CRUD (add, list)
-  Testing with Main

**Day 2 (15/03/2026):**
-  findBookByTitle() method
-  removeBook() method
-  Git workflow and best practices

**Day 3 (Today):**
-  PostgreSQL setup and configuration
-  Database and tables creation
-  JDBC driver integration
-  DatabaseConnection class with Properties
-  Secure credential management (db.properties)

**Next:**
- Save books to PostgreSQL (INSERT)
- Load books from PostgreSQL (SELECT)
- Complete CRUD with database

##  Project Structure
```
library-system-java/
├── src/
│   └── com.library/
│       ├── model/
│       │   ├── Book.java
│       │   ├── Member.java
│       │   └── Library.java
│       ├── main/
│       │   └── Main.java
│       └── util/
│           └── DatabaseConnection.java
├── lib/
│   └── postgresql-42.7.10.jar
├── db.properties (not in git - create your own)
└── README.md
```

##  How to Run

### Prerequisites
- Java 11 or higher
- PostgreSQL 15
- PostgreSQL JDBC Driver

### Setup
1. Clone repository
```bash
git clone https://github.com/RolandGDev/library-system-java.git
cd library-system-java
```

2. Create PostgreSQL database
```sql
CREATE DATABASE library_db;
\c library_db

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE members (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);
```

3. Create `db.properties` file in project root
```properties
db.url=jdbc:postgresql://localhost:5432/library_db
db.user=YOUR_POSTGRES_USER
db.password=YOUR_PASSWORD
```

4. Download PostgreSQL JDBC Driver
- Download from: https://jdbc.postgresql.org/download/
- Place in `lib/` folder
- Add to IntelliJ: File → Project Structure → Libraries

5. Run Main.java

##  Security Note
`db.properties` is ignored by git for security. Each developer must create their own with their local credentials.

##  Learning Resources
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [JDBC Tutorial](https://docs.oracle.com/javase/tutorial/jdbc/)
- [Git Guide](https://rogerdudler.github.io/git-guide/)

## Author
Roland Garcia - [GitHub](https://github.com/RolandGDev)
