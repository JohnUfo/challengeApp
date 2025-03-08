# Challenge App

A full-stack web application for managing monthly challenges. Built with **Spring Boot** (backend), **React** (frontend), and deployed on **AWS** using **RDS**, **EC2**, and **S3**.

## Live Demo

You can access the live application here:  
[http://challenge-app-front.s3-website.eu-north-1.amazonaws.com/](http://challenge-app-front.s3-website.eu-north-1.amazonaws.com/)

---

## Features

- **Create, Read, Update, and Delete (CRUD)** challenges.
- Each challenge includes:
  - **Month**: The month for which the challenge is set.
  - **Description**: A detailed description of the challenge.
- Responsive and user-friendly interface.

---

## Technologies Used

### Backend
- **Spring Boot**: Java framework for building the REST API.
- **PostgreSQL**: Database for storing challenges (hosted on AWS RDS).
- **AWS EC2**: Hosting the backend application.

### Frontend
- **React**: JavaScript library for building the user interface.
- **Axios**: For making HTTP requests to the backend.
- **AWS S3**: Hosting the frontend application.

### Deployment
- **AWS RDS**: Managed PostgreSQL database.
- **AWS EC2**: Virtual server for hosting the Spring Boot backend.
- **AWS S3**: Static website hosting for the React frontend.

---

## Project Structure

### Backend
- **`Challenge` Entity**: Represents a challenge with `id`, `month`, and `description`.
- **`ChallengeRepository`**: Handles database operations using Spring Data JPA.
- **`ChallengeService`**: Contains business logic for CRUD operations.
- **`ChallengeController`**: Exposes REST endpoints for managing challenges.

### Frontend
- **`AddChallenge`**: Form for adding a new challenge.
- **`Challenge`**: Displays a single challenge with edit and delete options.
- **`ChallengeList`**: Lists all challenges and handles updates/deletions.
- **`EditChallenge`**: Form for editing an existing challenge.

---

## API Endpoints

| Method | Endpoint                  | Description                          |
|--------|---------------------------|--------------------------------------|
| GET    | `/challenges`             | Get all challenges.                  |
| GET    | `/challenges/{id}`        | Get a challenge by ID.               |
| GET    | `/challenges/by-month/{month}` | Get a challenge by month.        |
| POST   | `/challenges`             | Add a new challenge.                 |
| PUT    | `/challenges/{id}`        | Update an existing challenge.        |
| DELETE | `/challenges/{id}`        | Delete a challenge.                  |

---

