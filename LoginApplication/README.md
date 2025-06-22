
# Login and Registration Web App (Java Servlet + HTML + MySQL)

This is a beginner-friendly web application that allows users to register and login using Java Servlets and MySQL database.

---

## 🚀 Features

- User Registration (Name, Username, Password)
- User Login with validation
- JDBC Database Connectivity (MySQL)
- Clean HTML Forms
- Servlet Mapping using `web.xml`
- PreparedStatement for security (No SQL injection)
- Simple folder structure for deployment in Apache Tomcat

---

## 🗂 Project Structure

```
LoginApplication/
├── Login.html              # Login form
├── Register.html           # Register form
├── src/
│   ├── LoginServlet.java   # Handles user login
│   └── RegisterServlet.java# Handles new registration
├── WEB-INF/
│   ├── web.xml             # Servlet configuration
│   └── classes/            # (Generated automatically after compiling)
├── README.md
```

---

## 🛠 Technologies Used

- Java Servlets (Jakarta)
- HTML5
- MySQL
- Apache Tomcat (Web Server)
- JDBC (Java Database Connectivity)

---

## 📦 How to Run This Project

1. Compile Java files from `src/`:
   ```
   javac -d WEB-INF/classes/ src/*.java
   ```

2. Make sure your MySQL database is running:
   - Database name: `LoginApplicationDB`
   - Table: `LoginApplicationTable` with columns `(name, username, password)`

3. Copy the entire `LoginApplication/` folder into `apache-tomcat/webapps/`

4. Start Tomcat:
   ```
   /bin/startup.bat (Windows) or ./startup.sh (Linux/Mac)
   ```

5. Open in browser:
   ```
   http://localhost:8080/LoginApplication/Register.html
   ```

---

## 🙌 Author

Made with ❤️ by Soojal (Beginner Java Full Stack Developer)

📧 Contact: **soojal.kumar.gangooja@gmail.com**

---

## 📌 Notes

- All fields are required in forms
- Uses basic form validation
- Not using session or security — just for practice and learning

---

## 📚 Want to Learn More?

- [Java Servlets Basics](https://www.javatpoint.com/servlet-tutorial)
- [How to deploy on Tomcat](https://www.geeksforgeeks.org/servlet-application-deployment-in-tomcat/)
- [MySQL Table Tutorial](https://www.w3schools.com/sql/sql_create_table.asp)