# Touch Grass Challenge

A web application designed to help users reconnect with nature and track their outdoor activities through personalized challenges.

## Project Overview

Touch Grass Challenge is a modern, responsive web application built with Vue.js that encourages users to spend more time outdoors and engage with nature. The application allows users to create, track, and complete various outdoor challenges, helping them maintain a healthier balance between digital life and real-world experiences.

## Features

- **User Authentication**: Secure login and registration system
- **Challenge Management**: Create, edit, update, and delete personal challenges
- **Progress Tracking**: Monitor your progress with visual indicators and statistics
- **Status Updates**: Mark challenges as Not Started, In Progress, Completed, or Cancelled
- **Responsive Design**: Optimized for both desktop and mobile devices
- **Dark Mode**: Elegant dark theme for comfortable viewing in low-light conditions

## Tech Stack

- **Frontend**: Vue.js with Tailwind CSS
- **Backend**: RESTful API with Spring Boot
- **Authentication**: JWT (JSON Web Tokens)
- **Database**: MySQL

## Main entity
Challenge entity at `touch-grass-backend/src/main/java/com/barsat/touch_grass/Entity/challengesEntity.java`

## Project Setup Instructions

### Prerequisites

- Node.js (v14 or higher)
- npm or yarn
- Java 17 or higher (for backend)
- MySQL (v8.0 or higher)

### Video Setup Guide

For a step-by-step visual guide on how to set up the project, check out the following video tutorial:

[**Touch Grass Challenge Setup Video**](https://youtu.be/SM26sIJaRMs?si=GfAg6G6cQv3MUPkp)


### Frontend Setup

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/touch-grass-challenge.git
   cd touch-grass-challenge
   ```

2. Install frontend dependencies
   ```bash
   cd frontend-vue
   npm install
   ```

3. Run the development server
   ```bash
   npm run dev
   ```

4. The application will be available at `http://localhost:5173`

### Backend Setup (with VS CODE) 

1. Open the touch-grass-backend with VS Code
2. Go to `src/main/java/com/barsat/touch_grass/TouchGrassApplication.java`
3. Install the Extension Pack for Java from the Extensions Marketplace.
4. Follow the Database Setup instructions below.

### Backend Setup (with Intellij Idea)
1. Open IntelliJ IDEA and go to File → Open.
2. Locate the `touch-grass-backend` project folder and select the `pom.xml` file.
3. When prompted, choose "Open as a Project".
4. Follow the Database Setup instructions below.
5. Press Ctrl + Alt + S to open Settings, navigate to Plugins, and install Lombok from the marketplace.
7. Go to `src/main/java/com/barsat/touch_grass/TouchGrassApplication.java` and run the application. If a notification appears at the bottom right asking to "Enable annotation processing", click on it. Your application should now start.

## Setting up the database
1. Create a database in MySQL. Name your database as you prefer.
2. Open the `touch-grass-backend` in your code editor.
3. Navigate to `resources/application.properties` and update the database credentials with your MySQL Details:
```
spring.datasource.url=jdbc:mysql://localhost:3306/{your_db_name (the db you just created)} 
spring.datasource.username={your_sql_username}
spring.datasource.password={your_sql_password}
```
* Hibernate will automatically generate the database schema for you.

 Finally go to `src/main/java/com/barsat/touch_grass/TouchGrassApplication.java` and click the run button to start the application.

### Environment Variables
For added security, it is recommended to store your database credentials in environment variables instead of directly placing them in the `application.properties` file. You can create a .env file to manage these variables as per your code editor.
