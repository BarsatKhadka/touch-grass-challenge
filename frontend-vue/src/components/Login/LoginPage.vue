<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100 text-gray-800 py-12 px-4 sm:px-8 relative overflow-hidden">
    <div class="flex flex-col items-center justify-center min-h-[90vh] relative z-10">
      <h1 class="text-4xl font-extrabold text-center mb-2">
        Welcome Back
      </h1>
      
      <p class="text-lg text-gray-600 mb-8 text-center max-w-md">
        Sign in to continue your journey to a more balanced life
      </p>
      

      <div class="w-full max-w-md bg-white rounded-lg shadow-md p-8">
        <form @submit.prevent="handleLogin">
          <button type="submit" class="w-full bg-green-500 text-white py-2 px-4 rounded">
            Sign in
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginPage',
  data() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    handleLogin() {
      this.$router.push('/home');
    }
  }
}
</script>
