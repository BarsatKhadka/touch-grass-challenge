<template>
    <Navbar />
    <div class="min-h-screen bg-gradient-to-br from-gray-900 via-blue-900 to-indigo-900">
      <div class="profile-container">
        <div v-if="loading" class="loading-spinner">
          <div class="spinner"></div>
          <p class="text-gray-200">Loading...</p>
        </div>
        
        <div v-else-if="userInfo" class="profile-card">
          <div class="profile-header">
            <img :src="userAvatar" alt="User Avatar" class="user-avatar" />
            <h2 class="text-gray-800 font-bold text-xl">{{ userInfo.username || userInfo.sub }}</h2>
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
              <p class="text-gray-700"><strong class="text-gray-900">Email:</strong> {{ userInfo.email || 'Not available' }}</p>
              <p class="text-gray-700"><strong class="text-gray-900">User ID:</strong> {{ userInfo.sub }}</p>
            </div>
            
            <div v-if="activeTab === 'token'" class="token-info">
              <p class="text-gray-700"><strong class="text-gray-900">Issued At:</strong> {{ formatDate(userInfo.iat) }}</p>
              <p class="text-gray-700"><strong class="text-gray-900">Expires At:</strong> {{ formatDate(userInfo.exp) }}</p>
            </div>
          </div>
        </div>
        
        <div v-else class="error-message">
          <p>No user information available. Please log in.</p>
        </div>
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
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
    border: 1px solid #fff;
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
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
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
    color: #6c757d;
    transition: all 0.2s ease;
  }
  
  .tab:hover {
    color: #495057;
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
    border: 3px solid rgba(75, 85, 99, 0.3);
    border-top: 3px solid #34d399;
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
    border: 1px solid #f5c2c7;
  }
  </style>