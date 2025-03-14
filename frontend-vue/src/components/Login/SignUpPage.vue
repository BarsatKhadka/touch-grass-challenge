<template>
    <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100 text-gray-800 py-12 px-4 sm:px-8 relative overflow-hidden">

      <div class="absolute inset-0 overflow-hidden pointer-events-none">
        <div class="absolute -top-16 -right-16 w-64 h-64 bg-green-100 rounded-full opacity-50"></div>
        <div class="absolute top-1/4 left-1/3 w-48 h-48 bg-blue-100 rounded-full opacity-30"></div>
        <div class="absolute bottom-1/3 right-1/4 w-32 h-32 bg-indigo-100 rounded-full opacity-40"></div>
        
        <div v-for="i in 8" :key="`grass-${i}`" 
             :class="`absolute w-8 h-12 origin-bottom opacity-20 animate-sway-${i % 4 + 1}`"
             :style="`bottom: 0; left: ${10 + i * 12}%; transform: rotate(${-10 + i * 3}deg);`">
          <div class="w-full h-full bg-green-500 rounded-t-full"></div>
        </div>
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
        

        <div class="w-full max-w-md bg-white/80 backdrop-blur-sm rounded-lg shadow-md p-8 border border-green-100">
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
            
            <button type="submit" class="w-full bg-gradient-to-r from-green-500 to-blue-500 text-white
              text-lg font-semibold py-3 px-6 rounded-full transform hover:-translate-y-1
              hover:scale-105 transition duration-300 ease-in-out shadow-lg flex items-center
              justify-center gap-2 mt-4">
              Create Account
              <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
              </svg>
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

    <div class="mt-6 bg-blue-50 p-4 rounded-xl border border-blue-100 max-w-md">
      <div class="flex items-center">
        <div class="w-8 h-8 bg-blue-100 rounded-full flex items-center justify-center mr-3">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-blue-500" viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd" />
          </svg>
        </div>
        <p class="text-sm text-blue-800">
          Join our community and start connecting with nature today!
        </p>
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