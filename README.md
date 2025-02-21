# Student API with Docker

This project provides a simple RESTful API to manage student data. It includes functionalities to add, update, retrieve, and delete student information. The application is containerized using Docker.

## Features

- **Add a student** (First Name, Last Name, Age, University ID)
- **Retrieve student details** by ID
- **Update student information** by ID
- **Delete student** by ID

## Prerequisites

Make sure you have the following tools installed on your machine:

- **Docker**: [Download Docker](https://www.docker.com/get-started)
- **Docker Compose**: [Download Docker Compose](https://docs.docker.com/compose/install/)
- **Postman** or another API testing tool (optional for testing)

## Setup and Run Instructions

### 1. Clone the repository

If you haven't cloned the repository already, run:

```bash
git clone <repository_url>
cd <project_folder>
```

### 2. Build and Run the Application

From the project root, run the following command to build the Docker containers and start the application:

```bash
docker-compose up --build
```
This will:

- Build the Java Spring Boot application and package it.
- Set up the PostgreSQL database.
- Start both containers: one for the application (java-app) and one for the PostgreSQL database (postgres).
- Note: The application will be accessible at http://localhost:8080 and PostgreSQL at localhost:5432.

### 3. Test the Application

You can test the API endpoints using Postman or another tool. Here are the available endpoints:

- **POST api/students**: Add a new student
- **GET api/students/{id}**: Retrieve a student's details by ID
- **PUT api/students/{id}**: Update a student's details by ID
- **DELETE api/students/{id}**: Delete a student by ID

### Example using Postman:
- POST request to http://localhost:8080/api/students with body:
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 21,
  "universityId": "12345"
}
```
- GET request to http://localhost:8080/api/students/1 to retrieve student details.

### Database verification
You can verify the database creation by accessing the container using:

```bash
docker exec -it postgres psql -U postgres -d studentsdb
```
and retrieving the data from the student table:

```bash
SELECT * FROM student;
```

### 4. Stop the Containers

Once you're done testing, you can stop the containers by running:

```bash
docker-compose down
```
This will stop and remove the containers, but keep the database volume for future use.

