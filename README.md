# 🗃️ Simple Java CSV-Based Database System

A lightweight and educational Java project that simulates basic database functionality using CSV files and object-oriented programming. It allows you to create databases (as folders), manage tables (as CSV files), define columns, insert and search data, and read records — all without using any external libraries.

---

## ✨ Features

- ✅ Create and delete databases (folders)
- ✅ Create and delete tables (CSV files)
- ✅ Define columns for each table
- ✅ Insert single or multiple rows
- ✅ Read and display all table records
- ✅ Search records by column value
- ✅ Recursive deletion of database folders and contents

---

## 🏗️ Project Structure

src/
├── Main.java # Entry point / usage demo
├── DB.java # Handles database creation and access
└── Table.java # Manages table creation, data operations
data/
└── myDB/
└── users.csv # Example table file


---

## 🚀 Getting Started

### Requirements
- Java 8 or higher
- No dependencies (uses standard Java I/O)

### Compile and Run

```bash
javac src/*.java
java src.Main

🧪 Sample Usage

DB db = new DB("myDB");
Table users = db.table("users");

users.defineColumns(new String[] { "id", "name", "email" });

users.insertOne(new String[] { "1", "Mehdi", "mehdi@example.com" });
users.insertMany(new String[][] {
    { "2", "Amina", "amina@example.com" },
    { "3", "Mehdi", "mehdi2@example.com" }
});

users.getAll();                        // Displays all rows
users.getOne("name", "Mehdi");        // Filters rows where name == "Mehdi"

📚 Current Functionalities
Feature	Method
Create DB	new DB("dbName")
Create table	db.table("tableName")
Define columns	table.defineColumns(...)
Insert row	table.insertOne(...)
Insert rows	table.insertMany(...)
Read all rows	table.getAll()
Filter by column	table.getOne(col, value)
Delete table	table.deleteTable()
Delete DB	db.deleteDB()
🚧 Future Improvements

Update and delete specific rows

Column value validation

Import/export functionality

Search with wildcards or partial match

    GUI or CLI interface

📄 License

This project is released under the MIT License.
Feel free to use, modify, and share it.
👨‍💻 Author

Mehdi Elbakouri
Java & Web Developer | Passionate about clean code and building from scratch