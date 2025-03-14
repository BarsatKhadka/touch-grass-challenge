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
          Welcome Back
        </span>
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

@keyframes sway-1 {
  0%, 100% { transform: rotate(-5deg); }
  50% { transform: rotate(5deg); }
}

@keyframes sway-2 {
  0%, 100% { transform: rotate(0deg); }
  50% { transform: rotate(7deg); }
}

@keyframes sway-3 {
  0%, 100% { transform: rotate(-3deg); }
  50% { transform: rotate(3deg); }
}

@keyframes sway-4 {
  0%, 100% { transform: rotate(2deg); }
  50% { transform: rotate(-2deg); }
}

.animate-sway-1 { animation: sway-1 3s ease-in-out infinite; }
.animate-sway-2 { animation: sway-2 3.5s ease-in-out infinite; }
.animate-sway-3 { animation: sway-3 4s ease-in-out infinite; }
.animate-sway-4 { animation: sway-4 4.5s ease-in-out infinite; }
</style>
