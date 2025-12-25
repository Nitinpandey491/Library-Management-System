# 📚 Library Management System (Desktop App)

> **Library Management System** is a robust **Java Desktop Application** built using **Java Swing** and **JDBC**. It provides a complete solution for Librarians to manage the library workflow (Issue/Return), while offering a dedicated portal for **Students** to register and check book availability in real-time.

---

## 🚀 Key Features

### 🔐 Authentication & Roles
* **Admin Login:** Full access to manage librarians.
* **Librarian Login:** Access to issue/return books and manage inventory.
* **Student Login:** Secure access for students to view the library catalog.

### 👨‍💼 Admin & Librarian Modules
* **Manage Staff:** Admin can add or delete librarian accounts.
* **Book Inventory:** Add new books and update quantities.
* **Issue & Return:** Librarians manage the issuing and returning of books to students.
* **Track Records:** View logs of issued books and current inventory status.

### 🎓 Student Module
* **Registration:** New students can create an account by entering their details.
* **Login:** Secure entry to the system.
* **View Books:** Students can browse the list of all available books and their details (Author, Publisher, Quantity) to check availability.

---

## 🛠️ Tech Stack Used

* **Language:** Java (JDK 1.8+)
* **GUI Framework:** Java Swing / AWT
* **Database:** MySQL / Oracle
* **Connectivity:** JDBC (Java Database Connectivity)
* **IDE:** Eclipse / NetBeans

---

## 📂 Project Structure

```text
LibraryManagement_Java_GUI/
├── src/
│   ├── Library.java            # Main Landing Page
│   ├── AdminLogin.java         # Admin Auth
│   ├── LibrarianLogin.java     # Librarian Auth
│   ├── StudentLogin.java       # Student Auth
│   ├── StudentRegister.java    # Student Registration Form
│   ├── ViewBooks.java          # Catalog View (Shared/Student)
│   ├── IssueBookForm.java      # Librarian Action
│   ├── ReturnBook.java         # Librarian Action
│   └── DB.java                 # Database Connection
└── database.sql                # SQL Scripts
```

---

📂 Library Management System – UI Screens (Section-wise Grouping)

1️⃣ 🏠 Home Module

---> Main landing page with navigation to Login and Registration.

📄 Screenshots:

---> [Home Page](Application_UI/Home_Page.png)


2️⃣ 🔐 Authentication Module

---> Dedicated login interfaces for Students, and Admins, plus Registration forms.

📄 Screenshots:

---> [User Login Page (Student & Teacher)](Application_UI/Login_Page.png)

---> [Admin Login Page](Application_UI/Admin_Login_Page.png)

---> [Registration Page](Application_UI/Register_Page.png)


3️⃣ 👨‍💼 Admin Panel Module

---> Dashboard for Librarians to add books, manage inventory, and handle book issues.

📄 Screenshots:

---> [Admin Dashboard Panel](Application_UI/Admin_Page_1.png)

---> [Manage Books (Add & Delete)](Application_UI/Admin_Page_2.png)

---> [Issue Books Management](Application_UI/Admin_Page_3.png)

---> [Book Details](Application_UI/Admin_Page_4.png)

---> [Issued Book Details](Application_UI/Admin_Page_5.png)

4️⃣ 🎓 Student Panel Module

---> Student interface to view available books.

📄 Screenshots:

---> [Student Dashboard](Application_UI/Student_Page.png)

5️⃣ 🗄️ Database Module

---> [Database](Application_UI/Database_picture_1.png)

---> [Table: admin](Application_UI/Database_picture_2.png)

---> [Table: books](Application_UI/Database_picture_3.png)

---> [Table: issue](Application_UI/Database_picture_4.png)

6️⃣ 🎥 Project Execution Video

---> [Watch Execution Video](Application_UI/Nitin_Pandey_Project.mp4)

---


## ⚙️ How to Run

1. **Database Setup:**
* Create a database named `library_db`.
* Run the provided SQL script to create `books`, `librarians`, and `issuebooks` tables.
* Update `DB.java` with your database credentials.


2. **Project Setup:**
* Open the project in Eclipse/NetBeans.
* Add `mysql-connector-java.jar` to the project Build Path (Libraries).


3. **Run Application:**
* Right-click on `Library.java` (or the main class).
* Select **Run As > Java Application**.
* The GUI Window will open.



---

## 👤 Author

**Nitin Vinay Pandey**


```