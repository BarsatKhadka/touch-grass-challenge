<template>
    <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100 text-gray-800 py-12 px-4 sm:px-8 relative overflow-hidden">

      <div class="absolute inset-0 overflow-hidden pointer-events-none">
        <div class="absolute -top-16 -right-16 w-64 h-64 bg-green-100 rounded-full opacity-50"></div>
        <div class="absolute top-1/4 left-1/3 w-48 h-48 bg-blue-100 rounded-full opacity-30"></div>
        <div class="absolute bottom-1/3 right-1/4 w-32 h-32 bg-indigo-100 rounded-full opacity-40"></div>
      </div>
      
      <div class="flex flex-col items-center justify-center min-h-[90vh] relative z-10">
        <div class="relative mb-8">
          <div class="w-24 h-24 rounded-full bg-gradient-to-br from-green-400 to-blue-500 animate-breathing shadow-2xl"></div>
          <div class="absolute inset-3 rounded-full overflow-hidden border-4 border-white">
            <img
              src="/logo.png"
              alt="Touch Grass Challenge Logo"
              class="w-full h-full object-cover"
            />
          </div>
        </div>
        
        <h1 class="text-4xl font-extrabold text-center mb-2">
          <span class="bg-clip-text text-transparent bg-gradient-to-r from-green-600 via-blue-600 to-indigo-600">
            Join the Challenge
          </span>
        </h1>
        
        <p class="text-lg text-gray-600 mb-8 text-center max-w-md">
          Create an account to start your Touch Grass Challenge
        </p>
        

        <div class="w-full max-w-md bg-white rounded-lg shadow-md p-8">
          <form @submit.prevent="handleSignup">
            <div class="space-y-4">
              <div>
                <label for="firstName" class="block text-sm font-medium text-gray-700 mb-1">First Name</label>
                <input 
                  id="firstName"
                  v-model="firstName" 
                  placeholder="Enter your first name" 
                  class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500"
                  required 
                />
              </div>
              
              <div>
                <label for="lastName" class="block text-sm font-medium text-gray-700 mb-1">Last Name</label>
                <input  
                  id="lastName"
                  v-model="lastName" 
                  placeholder="Enter your last name" 
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
            
            <button type="submit" class="w-full bg-green-500 text-white py-2 px-4 rounded mt-6">
              Create Account
            </button>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'SignupPage',
    data() {
      return {
        firstName: '',
        lastName: '',
        email: '',
        password: '',
      }
    },
    methods: {
      handleSignup() {
        this.$router.push('/home');
      }
    }
  }
  </script>

  <style scoped>
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
  </style>