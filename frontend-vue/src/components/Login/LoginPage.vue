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
        Don't worry, we will help you get back on track.
      </p>
      
      <div class="w-full max-w-md bg-white/80 backdrop-blur-sm rounded-2xl shadow-xl border border-green-100 overflow-hidden">
        <div class="p-8">
          <form @submit.prevent="handleLogin" class="space-y-6">
            <div>
              <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
              <div class="relative">
                <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M2.003 5.884L10 9.882l7.997-3.998A2 2 0 0016 4H4a2 2 0 00-1.997 1.884z" />
                    <path d="M18 8.118l-8 4-8-4V14a2 2 0 002 2h12a2 2 0 002-2V8.118z" />
                  </svg>
                </div>
                <input 
                  id="email"
                  v-model="email" 
                  type="email" 
                  required
                  class="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
                  placeholder="your.email@example.com"
                />
              </div>
            </div>
            
            <div>
              <div class="flex items-center justify-between mb-1">
                <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                <!-- <a href="#" class="text-sm text-green-600 hover:text-green-500">Forgot password?</a> -->
              </div>
              <div class="relative">
                <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z" clip-rule="evenodd" />
                  </svg>
                </div>
                <input 
                  id="password"
                  v-model="password" 
                  type="password" 
                  required
                  class="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
                  placeholder="••••••••"
                />
              </div>
            </div>
            
            <div>
              <button 
                type="submit" 
                class="w-full bg-gradient-to-r from-green-500 to-blue-500 text-white py-3 px-4 rounded-lg shadow-md hover:shadow-lg transition-shadow flex items-center justify-center"
              >
                <span class="mr-2">Sign in</span>
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M10.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L12.586 11H5a1 1 0 110-2h7.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                </svg>
              </button>
            </div>
          </form>
        </div>
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
      rememberMe: false,
      isLoading: false,
      error: null
    }
  },
  methods: {
    handleLogin() {
      this.isLoading = true;
      this.error = null;
      
      
      setTimeout(() => {
        this.isLoading = false;
        this.$router.push('/home');
      }, 1000);
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

input:focus {
  box-shadow: 0 0 0 3px rgba(16, 185, 129, 0.2);
}

button {
  transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

button:hover {
  transform: translateY(-2px);
}

button:active {
  transform: translateY(0) scale(0.98);
}
</style>
