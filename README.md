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

## Project Setup Instructions

### Prerequisites

- Node.js (v14 or higher)
- npm or yarn
- Java 17 or higher (for backend)
- MySQL (v8.0 or higher)

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
2. Go to src/main/java/com/barsat/touch_grass/TouchGrassApplication.java
3. Install the extension: Extension pack for java

## Setting up the database
Create a database in mysql. Name your database name.
1. Open the touch-grass-backend
2. Go to resources/application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/{your_db_name} 
spring.datasource.username={your_sql_username}
spring.datasource.password={your_sql_password}
```
The database schema is managed by hibernate which automatically generates schema for you!

### Environment Variables
you can create env files instead of directly putting your db names in place of application.properties for security concerns.
