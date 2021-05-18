# Java-JFrame-GUI-Using-MySQL-Database
A basic application using Java JFrame GUI mechanism with displaying and editing records from MySQL database table.

#### Context
A user will be able to edit sports activities that are taking place at a park within the Java GUI. The data of the sports actitives are placed in a MySQL database Table.

#### Requirements
This application requires Netbeans, Java Programming Language and a MySQL Database. Two Java jar files are requried which are the JCalender and JDBC connector. 
Links to download are provided below:
https://jar-download.com/artifacts/mysql/mysql-connector-java/5.1.41/source-code
http://www.java2s.com/Code/Jar/j/Downloadjcalendar114jar.htm

#### How to use?
After downloading the requirements, download the Java files and SportsActivities.sql file. Import the SQL file into MySQL Database, test it using "SELECT * From SportsActivies" query to check the file is imported.
To run the Java application in DatabaseManager.java line 24 and line 25 include your MySQL database Username and Password in order for the connection to work. 
After these steps are completed you will be able to run the application. When the program begins, you should see a GUI with the database records displayed. You can add, delete, and update records.

#### Application Features
Data Manipulation: Insert, Update, Delete, Clear
Text Box: A user can use any MySQL query which are relvent to database table to update the records in the GUI Table.
