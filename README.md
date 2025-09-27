# Blog Management Application

This is a **full-stack blog application** built with:

* **Backend:** Spring Boot (Java)
* **Frontend:** React (JavaScript)
* **Database:** MySQL (via XAMPP / MariaDB)

Users can **sign up, log in, create, edit, and view blog posts**.
This README provides **step-by-step instructions** to run the project from scratch.

---

## 📑 Table of Contents

1. [Prerequisites](#prerequisites)
2. [Backend Setup (Spring Boot)](#backend-setup-spring-boot)
3. [Frontend Setup (React)](#frontend-setup-react)
4. [Database Setup (MySQL)](#database-setup-mysql)
5. [Running the Application](#running-the-application)
6. [Notes](#notes)

---

## ✅ Prerequisites

Install the following before starting:

1. **Java JDK 17+**

   * Verify:

     ```bash
     java -version
     ```

2. **Maven** (comes bundled with IntelliJ in most cases)

   * Verify:

     ```bash
     mvn -v
     ```

3. **Node.js & npm** (required for React frontend)

   * Verify:

     ```bash
     node -v
     npm -v
     ```

4. **MySQL / XAMPP (MariaDB)**

   * Ensure the MySQL server is running.

5. **IntelliJ IDEA** (for backend)

   * Required plugins:

     * **Lombok** (mandatory, otherwise project will not compile)
     * **Spring Boot** plugin (recommended)

6. **Visual Studio Code** (for frontend development)

---

## ⚙️ Backend Setup (Spring Boot)

1. Open **IntelliJ IDEA**.

2. Select **Open** and navigate to the `blog-backend/` folder.

3. Let IntelliJ **import Maven dependencies** automatically.

   * If Lombok errors appear:

     * Go to `File → Settings → Plugins → Marketplace`
     * Install **Lombok** plugin
     * Restart IntelliJ

4. Configure database credentials in
   `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
   spring.datasource.username=root
   spring.datasource.password=your_password_here
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

   ⚠️ Change `username` and `password` to match your MySQL setup.

5. Run the backend by starting the `BlogBackendApplication.java` file.

6. The backend will start on:

   ```
   http://localhost:8080
   ```

---

## 🎨 Frontend Setup (React)

1. Open **VS Code**.
2. Navigate to the `blog-frontend/` folder.
3. Install dependencies:

   ```bash
   npm install
   ```
4. Start the development server:

   ```bash
   npm run dev
   ```
5. The frontend will run at:

   ```
   http://localhost:3000
   ```

---

## 🗄️ Database Setup (MySQL)

1. Start **XAMPP** and enable the **MySQL module**.
2. Open **phpMyAdmin** (`http://localhost/phpmyadmin`).
3. Create a new database called `blogdb`.
4. Import the SQL file:

   * Go to **Import** tab
   * Choose `blog-database/blogdb.sql`
   * Click **Go**
5. Verify that tables are created successfully.

---

## 🚀 Running the Application

1. Start **MySQL (XAMPP)**.
2. Run the **backend** (`BlogBackendApplication.java`) → [http://localhost:8080](http://localhost:8080).
3. Run the **frontend** with `npm run dev` → [http://localhost:3000](http://localhost:3000).
4. Open the frontend in browser → Sign up, log in, and create blogs.

---

## 📝 Notes

* If you face errors with Lombok, ensure the **Lombok plugin** is installed in IntelliJ.
* Make sure the backend (`8080`) and frontend (`3000`) ports are not blocked.
* If MySQL credentials differ, update them in `application.properties`.
* The project uses **Spring Data JPA**, so most queries are auto-generated.

---

