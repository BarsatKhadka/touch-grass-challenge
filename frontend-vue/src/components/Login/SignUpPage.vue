<template>
    <div class="min-h-screen bg-gradient-to-br from-gray-900 via-blue-900 to-indigo-900 text-gray-800 py-12 px-4 sm:px-8 relative overflow-hidden">

      <div class="absolute inset-0 overflow-hidden pointer-events-none">
        <div class="absolute -top-16 -right-16 w-64 h-64 bg-green-900 rounded-full opacity-30"></div>
        <div class="absolute top-1/4 left-1/3 w-48 h-48 bg-blue-900 rounded-full opacity-20"></div>
        <div class="absolute bottom-1/3 right-1/4 w-32 h-32 bg-indigo-900 rounded-full opacity-30"></div>
        
        <div v-for="i in 8" :key="`grass-${i}`" 
             :class="`absolute w-8 h-12 origin-bottom opacity-20 animate-sway-${i % 4 + 1}`"
             :style="`bottom: 0; left: ${10 + i * 12}%; transform: rotate(${-10 + i * 3}deg);`">
          <div class="w-full h-full bg-green-500 rounded-t-full"></div>
        </div>
      </div>
      
      <div class="flex flex-col items-center justify-center min-h-[90vh] relative z-10">
        <div class="relative mb-8">
          <div class="w-24 h-24 rounded-full bg-gradient-to-br from-green-600 to-blue-700 animate-breathing shadow-2xl"></div>
          <div class="absolute inset-3 rounded-full overflow-hidden border-4 border-gray-800">
            <img
              src="/logo.png"
              alt="Touch Grass Challenge Logo"
              class="w-full h-full object-cover"
            />
          </div>
        </div>
        
        <h1 class="text-4xl font-extrabold text-center mb-2">
          <span class="bg-clip-text text-transparent bg-gradient-to-r from-green-400 via-blue-400 to-indigo-400">
            Join the Challenge
          </span>
        </h1>
        
        <p class="text-lg text-gray-300 mb-8 text-center max-w-md">
          Create an account to start your Touch Grass Challenge
        </p>
        

        <div class="w-full max-w-md bg-white/90 backdrop-blur-sm rounded-lg shadow-xl p-8 border border-gray-200">
          <form @submit.prevent="handleSignup">
            <div v-if="error" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
              {{ error }}
            </div>
            
            <div class="space-y-4">
              <div>
                <label for="username" class="block text-sm font-medium text-gray-700 mb-1">Username</label>
                <input 
                  id="username"
                  v-model="username" 
                  placeholder="Choose a username" 
                  class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500"
                  required 
                />
              </div>
              
              <div>
                <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                <input 
                  id="email"
                  type="email"
                  v-model="email" 
                  placeholder="Enter your email" 
                  class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500"
                  required 
                />
              </div>
              
              <div>
                <label for="password" class="block text-sm font-medium text-gray-700 mb-1">Password</label>
                <input 
                  id="password"
                  type="password"
                  v-model="password" 
                  placeholder="Create a password" 
                  class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500"
                  required 
                />
              </div>
            </div>
            
            <button 
              type="submit" 
              class="w-full bg-gradient-to-r from-green-600 to-blue-600 text-white py-2 px-4 rounded-lg mt-6 shadow-md hover:shadow-lg"
              :disabled="loading"
            >
              <span v-if="loading">Creating Account...</span>
              <span v-else>Create Account</span>
            </button>
          </form>
          
          <div class="text-center mt-4">
            <p class="text-gray-600">
              Already have an account? 
              <router-link to="/login" class="text-blue-600 hover:text-blue-800 font-medium">
                Sign In
              </router-link>
            </p>
          </div>
        </div>
      </div>
    </div>

    <div class="mt-6 bg-gray-800 p-4 rounded-xl border border-gray-700 max-w-md mx-auto text-gray-200">
      <div class="flex items-center">
        <div class="w-8 h-8 bg-blue-900 rounded-full flex items-center justify-center mr-3">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-blue-400" viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd" />
          </svg>
        </div>
        <p class="text-sm text-blue-200">
          Join our community and start connecting with nature today!
        </p>
      </div>
    </div>
  </template>
  
  <script>
  import AuthService from '../../services/AuthService';
  
  export default {
    name: 'SignupPage',
    data() {
      return {
        username: '',
        email: '',
        password: '',
        loading: false,
        error: null
      }
    },
    methods: {
      handleSignup() {
        this.loading = true;
        this.error = null;
        
        const signUpRequest = {
          username: this.username,
          email: this.email,
          password: this.password
        };
        
        AuthService.signup(signUpRequest)
          .then(response => {
            this.$toast?.success('Account created successfully! Please log in.', {
              duration: 3000
            });
            
            this.$router.push('/login');
          })
          .catch(error => {
            console.error('Signup error:', error);
            this.error = error.response?.data?.message || 'Failed to create account. Please try again.';
          })
          .finally(() => {
            this.loading = false;
          });
      }
    }
  }
  </script>

  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap');

  body {
    font-family: 'Inter', sans-serif;
  }

  .animate-breathing {
    animation: box-breathing 8s ease-in-out infinite;
  }

  @keyframes box-breathing {
    0%, 100% {
      transform: scale(1);
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
    }
    25% {
      transform: scale(1.05);
      box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
    }
    50% {
      transform: scale(1.1);
      box-shadow: 0 20px 35px rgba(0, 0, 0, 0.2);
    }
    75% {
      transform: scale(1.05);
      box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
    }
  }

  button {
    transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  }

  button:hover {
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
  }

  button:active {
    transform: translateY(1px) scale(0.98);
  }

  input:focus {
    box-shadow: 0 0 0 3px rgba(16, 185, 129, 0.2);
  }

  /* Animation for grass elements */
  @keyframes sway-1 {
    0%, 100% { transform: rotate(-10deg); }
    50% { transform: rotate(-5deg); }
  }
  @keyframes sway-2 {
    0%, 100% { transform: rotate(-5deg); }
    50% { transform: rotate(0deg); }
  }
  @keyframes sway-3 {
    0%, 100% { transform: rotate(0deg); }
    50% { transform: rotate(5deg); }
  }
  @keyframes sway-4 {
    0%, 100% { transform: rotate(5deg); }
    50% { transform: rotate(10deg); }
  }

  .animate-sway-1 { animation: sway-1 3s ease-in-out infinite; }
  .animate-sway-2 { animation: sway-2 3.5s ease-in-out infinite; }
  .animate-sway-3 { animation: sway-3 4s ease-in-out infinite; }
  .animate-sway-4 { animation: sway-4 4.5s ease-in-out infinite; }
  </style>