# User Management System

A full-stack web application that provides robust CRUD operations for managing user information. Built with Angular, TypeScript, and Bootstrap 5 on the frontend, and Spring Boot with PostgreSQL on the backend, this project delivers a modern, responsive, and secure user management solution.

## Features

- CRUD Operations: Create, Read, Update, and Delete user records efficiently.
- Responsive UI: Leverages Angular, TypeScript, and Bootstrap 5 for a modern design that works across devices.
- RESTful API: Spring Boot-powered backend exposing secure REST endpoints.
- Persistent Data: PostgreSQL handles the storage and management of user data.

## Tech Stack

- Frontend: Angular, TypeScript, Bootstrap 5
- Backend: Spring Boot (Java)
- Database: PostgreSQL

## Installation

### Prerequisites

- [Node.js & npm](https://nodejs.org)  
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Git](https://git-scm.com/)

### Frontend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Prithviraj-Koparde/User-Management-System.git
Change to the frontend directory:

bash
cd User-Management-System/frontend
Install dependencies:

bash
npm install
Start the Angular development server:

bash
ng serve
Navigate to http://localhost:4200 in your browser to see the app running.

Backend Setup
Change to the backend directory:

bash
cd User-Management-System/backend
Edit the application.properties file (or application.yml) to configure your PostgreSQL connection:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
Build the project using Maven:

bash
mvn clean install
Run the Spring Boot application:

bash
mvn spring-boot:run
The API will be accessible at http://localhost:8081.

API Endpoints
The backend exposes several RESTful endpoints for user management:

Create User: POST /api/users

Retrieve Users: GET /api/users

Retrieve a Specific User: GET /api/users/{id}

Update User: PUT /api/users/{id}

Delete User: DELETE /api/users/{id}

Usage
After starting both the frontend and backend services, you can manage users through the application’s UI or interact directly with the REST API using tools like Postman or cURL.

Contributing
Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request. For major changes, open an issue first to discuss what you would like to change.

License
Distributed under the MIT License. See the LICENSE file for details.

Contact
For questions or support, please contact [your-email@example.com]. Feel free to suggest improvements or report any issues.

Acknowledgements
Angular

Spring Boot

PostgreSQL

Bootstrap 5
>>>>>>> 1df8faa3bf09dac96540694f008f8741d4e8d2e1
