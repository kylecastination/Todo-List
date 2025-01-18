# Todo List Application

## Overview

The **Todo List Application** is a full-stack web application designed to manage daily tasks efficiently. It enables users to perform basic CRUD operations (Create, Read, Update, Delete) on tasks with a user-friendly interface.

---

## Features

- Add tasks with a **name** and **description**.
- View all tasks in a structured and responsive layout.
- Update tasks to reflect changes.
- Delete tasks by their unique IDs.

---

## Technologies Used

### Backend
- **Java**
- **Spring Boot**: For RESTful API development.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: In-memory database for local testing.
- **Maven**: For dependency management.

### Frontend
- **Angular**: For building the user interface.
- **TypeScript**: For application logic and components.
- **HTML/CSS**: For structuring and styling the web pages.

---

## Prerequisites

- **Java 17** or later.
- **Node.js** and **npm** installed.
- **Angular CLI** installed globally (`npm install -g @angular/cli`).
- IDEs such as **IntelliJ IDEA** or **Visual Studio Code** (optional).

---

## Installation and Setup

### Backend
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/todo-list.git
   cd todo-list/backend
   ```
2. Build and run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
3. Access the API at `http://localhost:8080`.

### Frontend
1. Navigate to the frontend folder:
   ```bash
   cd ../frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the Angular development server:
   ```bash
   ng serve
   ```
4. Access the application at `http://localhost:4200`.

---

## API Endpoints

### Task Endpoints
- **GET** `/tasks`: Retrieve all tasks.
- **POST** `/tasks`: Add a new task.
- **PUT** `/tasks/{id}`: Update an existing task.
- **DELETE** `/tasks/{id}`: Delete a task.

---

## Future Enhancements

- User authentication and role-based access.
- Integrate a persistent database (e.g., MySQL, PostgreSQL).
- Add a feature to prioritize tasks.
- Implement search and filter functionality.

---

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for review.


## License

This project is licensed under the [MIT License](LICENSE).
