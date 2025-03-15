<template>
    <Navbar />
    <div class="profile-container">
      <div v-if="loading" class="loading-spinner">
        <div class="spinner"></div>
        <p>Loading...</p>
      </div>
      
      <div v-else-if="userInfo" class="profile-card">
        <div class="profile-header">
          <img :src="userAvatar" alt="User Avatar" class="user-avatar" />
          <h2>{{ userInfo.username || userInfo.sub }}</h2>
        </div>
        
        <div class="profile-tabs">
          <div 
            v-for="tab in tabs" 
            :key="tab.id" 
            @click="activeTab = tab.id" 
            :class="['tab', { active: activeTab === tab.id }]"
          >
            {{ tab.name }}
          </div>
        </div>
        
        <div class="tab-content">
          <div v-if="activeTab === 'info'" class="profile-info">
            <p><strong>Email:</strong> {{ userInfo.email || 'Not available' }}</p>
            <p><strong>User ID:</strong> {{ userInfo.sub }}</p>
          </div>
          
          <div v-if="activeTab === 'token'" class="token-info">
            <p><strong>Issued At:</strong> {{ formatDate(userInfo.iat) }}</p>
            <p><strong>Expires At:</strong> {{ formatDate(userInfo.exp) }}</p>
          </div>
        </div>
      </div>
      
      <div v-else class="error-message">
        <p>No user information available. Please log in.</p>
      </div>
    </div>
  </template>
  
  <script>
  import { jwtDecode } from 'jwt-decode';
  import Navbar from '../Navbar/Navbar.vue';
  export default {
    name: 'Profile',
    components: {
        Navbar
    },
    data() {
      return {
        userInfo: null,
        loading: true,
        userAvatar: 'https://ui-avatars.com/api/?name=User&background=0D8ABC&color=fff',
        activeTab: 'info',
        tabs: [
          { id: 'info', name: 'Profile Info' },
          { id: 'token', name: 'Token Info' }
        ]
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
            
            if (this.userInfo.username) {
              this.userAvatar = `https://ui-avatars.com/api/?name=${encodeURIComponent(this.userInfo.username)}&background=0D8ABC&color=fff`;
            }
            
          } catch (error) {
            console.error('Error decoding token:', error);
          }
        }
        this.loading = false;
      },
      formatDate(timestamp) {
        if (!timestamp) return 'N/A';
        return new Date(timestamp * 1000).toLocaleString();
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
  
  .profile-header {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
  }
  
  .user-avatar {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    margin-right: 20px;
    border: 3px solid #fff;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
  }
  
  .profile-tabs {
    display: flex;
    border-bottom: 1px solid #ddd;
    margin-bottom: 20px;
  }
  
  .tab {
    padding: 10px 15px;
    cursor: pointer;
    margin-right: 5px;
  }
  
  .tab.active {
    border-bottom: 2px solid #3498db;
    color: #3498db;
  }
  
  .tab-content {
    padding: 10px 0;
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