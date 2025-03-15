<template>
    <div class="profile-container">
      <div v-if="loading" class="loading-spinner">
        <div class="spinner"></div>
        <p>Loading...</p>
      </div>
      
      <div v-else-if="userInfo" class="profile-card">
        <h2>User Profile</h2>
        <div class="profile-info">
          <p><strong>Username:</strong> {{ userInfo.sub }}</p>
          <p><strong>Email:</strong> {{ userInfo.email || 'Not available' }}</p>
        </div>
      </div>
      
      <div v-else class="error-message">
        <p>No user information available. Please log in.</p>
      </div>
    </div>
  </template>
  
  <script>
  import { jwtDecode } from 'jwt-decode';
  
  export default {
    name: 'Profile',
    data() {
      return {
        userInfo: null,
        loading: true
      }
    },
    created() {
      this.decodeToken();
    },
    methods: {
      decodeToken() {
        const jwt = localStorage.getItem('jwt') || sessionStorage.getItem('jwt');
        if (jwt) {
          try {
            this.userInfo = jwtDecode(jwt);
            console.log('Decoded token:', this.userInfo);
          } catch (error) {
            console.error('Error decoding token:', error);
          }
        }
        this.loading = false;
      }
    }
  }
  </script>
  
  <style scoped>
  .profile-container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .profile-card {
    background-color: #f8f9fa;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .profile-info {
    margin-top: 20px;
  }
  
  .loading-spinner {
    text-align: center;
    padding: 40px;
  }
  
  .spinner {
    border: 3px solid #f3f3f3;
    border-top: 3px solid #3498db;
    border-radius: 50%;
    width: 30px;
    height: 30px;
    animation: spin 1s linear infinite;
    margin: 0 auto 15px;
  }
  
  @keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
  }
  
  .error-message {
    text-align: center;
    color: #dc3545;
    padding: 20px;
    background-color: #f8d7da;
    border-radius: 8px;
  }
  </style>