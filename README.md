# Blog Management Application

This is a full-stack blog application with:

- **Backend:** Spring Boot (Java)
- **Frontend:** React (JavaScript)
- **Database:** MySQL (via XAMPP / MariaDB)

Users can sign up, log in, create, edit, and view blog posts. This README provides **detailed instructions** to run the project from scratch.

---

## Table of Contents

1. [Prerequisites](#prerequisites)  
2. [Backend Setup (Spring Boot)](#backend-setup-spring-boot)  
3. [Frontend Setup (React)](#frontend-setup-react)  
4. [Database Setup (MySQL)](#database-setup-mysql)  
5. [Running the Application](#running-the-application)  
6. [Testing Default Users](#testing-default-users)  

---

## Prerequisites

Before running the project, make sure you have installed:

1. **Java JDK 17+**  
   - Check installation: `java -version`  

2. **Maven** (comes with IntelliJ sometimes)  
   - Check installation: `mvn -v`  

3. **Node.js & npm**
     --**React**		  
   - Check installation: `node -v` and `npm -v`  

4. **MySQL / XAMPP**  
   - Make sure the MySQL server is running.  

5. **IntelliJ IDEA** (for backend)  
   - Plugins required:
     - **Lombok** (to avoid errors in Spring Boot project)
     - **Spring Boot** plugin (optional but recommended)  

6. **VSCode** (for frontend)  

---

## Backend Setup (Spring Boot)

1. Open **IntelliJ IDEA**.
2. Select **Open** and navigate to the `backend/` folder.
3. Wait for IntelliJ to **import Maven dependencies** automatically.  
   - If Lombok errors appear, install Lombok plugin in IntelliJ:
     - Go to `File -> Settings -> Plugins -> Marketplace -> Lombok -> Install`
     - Restart IntelliJ.
4. Configure the database credentials in:

blog-backend/src/main/resources/application.properties


Update these lines with your MySQL username and password:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run the backend:

Open BlogBackendApplication.java and click Run.

By default, it will start at http://localhost:8080.

Backend API endpoints:

Method	URL	Description
POST	/users/signup	Create new user
POST	/users/login	User login
GET	/blogs	Get all blogs
GET	/blogs/{id}	Get single blog
POST	/blogs	Create blog
PUT	/blogs/{id}	Update blog
DELETE	/blogs/{id}	Delete blog
Frontend Setup (React)
Open VSCode and open the frontend/ folder.

Install dependencies:

npm install
Start the frontend server:

npm run dev
By default, React runs on http://localhost:3000.

Ensure backend is running for API calls to work.

If your backend runs on a different port, update the BASE_URL in frontend/src/services/api.js or wherever you store API URLs.

Database Setup (MySQL)
Open phpMyAdmin or MySQL command line.

Create a new database:

CREATE DATABASE blogdb;
Import the database from database/blogdb.sql:

In phpMyAdmin: Select database → Import → Choose file → Execute

Or via command line:

mysql -u root -p blogdb < database/blogdb.sql
This will create:

users table (with hashed passwords)

blogs table (with sample blogs)

Running the Full Application
Start MySQL server.

Run backend (IntelliJ → BackendApplication.java → Run).

Run frontend (VSCode → npm start).

Open http://localhost:3000 in your browser.

You can now:

Sign up new users

Log in

Create, edit, and view blogs