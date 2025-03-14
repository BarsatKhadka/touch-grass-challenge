<template>
    <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100 text-gray-800 py-12 px-4 sm:px-8 relative overflow-hidden">

      <div class="absolute inset-0 overflow-hidden pointer-events-none">
        <div class="absolute -top-16 -right-16 w-64 h-64 bg-green-100 rounded-full opacity-50"></div>
        <div class="absolute top-1/4 left-1/3 w-48 h-48 bg-blue-100 rounded-full opacity-30"></div>
        <div class="absolute bottom-1/3 right-1/4 w-32 h-32 bg-indigo-100 rounded-full opacity-40"></div>
      </div>
      
      <div class="flex flex-col items-center justify-center min-h-[90vh] relative z-10">
        <h1 class="text-4xl font-extrabold text-center mb-2">
          Join the Challenge
        </h1>
        
        <p class="text-lg text-gray-600 mb-8 text-center max-w-md">
          Create an account to start your Touch Grass Challenge
        </p>
        

        <div class="w-full max-w-md bg-white rounded-lg shadow-md p-8">
          <form @submit.prevent="handleSignup">
            <button type="submit" class="w-full bg-green-500 text-white py-2 px-4 rounded">
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