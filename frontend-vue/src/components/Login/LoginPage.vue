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
            <div v-if="error" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
              {{ error }}
            </div>
            
            <div>
              <label for="username" class="block text-sm font-medium text-gray-700 mb-1">Username</label>
              <div class="relative">
                <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z" clip-rule="evenodd" />
                  </svg>
                </div>
                <input 
                  id="username"
                  v-model="username" 
                  type="text" 
                  required
                  class="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
                  placeholder="Enter your username"
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
                :disabled="isLoading"
              >
                <span v-if="isLoading">Signing in...</span>
                <template v-else>
                  <span class="mr-2">Sign in</span>
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L12.586 11H5a1 1 0 110-2h7.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                  </svg>
                </template>
              </button>
            </div>
          </form>
          

          <div class="relative mt-8">
            <div class="absolute inset-0 flex items-center">
              <div class="w-full border-t border-gray-300"></div>
            </div>
            <div class="relative flex justify-center text-sm">
              <span class="px-2 bg-white text-gray-500">Coming soon...</span>
            </div>
          </div>
          

          <div class="mt-6 grid grid-cols-2 gap-3">
            <button 
              type="button" 
              class="w-full inline-flex justify-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white text-sm font-medium text-gray-700 hover:bg-gray-50"
            >
              <svg class="h-5 w-5" viewBox="0 0 24 24" fill="currentColor">
                <path d="M12.545,10.239v3.821h5.445c-0.712,2.315-2.647,3.972-5.445,3.972c-3.332,0-6.033-2.701-6.033-6.032s2.701-6.032,6.033-6.032c1.498,0,2.866,0.549,3.921,1.453l2.814-2.814C17.503,2.988,15.139,2,12.545,2C7.021,2,2.543,6.477,2.543,12s4.478,10,10.002,10c8.396,0,10.249-7.85,9.426-11.748L12.545,10.239z"/>
              </svg>
            </button>
            <button 
              type="button" 
              class="w-full inline-flex justify-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white text-sm font-medium text-gray-700 hover:bg-gray-50"
            >
              <svg class="h-5 w-5" viewBox="0 0 24 24" fill="currentColor">
                <path d="M22.675 0H1.325C.593 0 0 .593 0 1.325v21.351C0 23.407.593 24 1.325 24H12.82v-9.294H9.692v-3.622h3.128V8.413c0-3.1 1.893-4.788 4.659-4.788 1.325 0 2.463.099 2.795.143v3.24l-1.918.001c-1.504 0-1.795.715-1.795 1.763v2.313h3.587l-.467 3.622h-3.12V24h6.116c.73 0 1.323-.593 1.323-1.325V1.325C24 .593 23.407 0 22.675 0z"/>
              </svg>
            </button>
          </div>
        </div>
        
        <div class="px-8 py-4 bg-gray-50 border-t border-gray-200 flex items-center justify-center">
          <p class="text-sm text-gray-600">
            Don't have an account?
            <router-link to="/register" class="font-medium text-green-600 hover:text-green-500">
              Sign up
            </router-link>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AuthService from '../../services/AuthService';

export default {
  name: 'LoginPage',
  data() {
    return {
      username: '',
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
      
      const loginRequest = {
        username: this.username,
        password: this.password
      };
      
      AuthService.login(loginRequest)
        .then(response => {
          console.log('Login successful:', response);
          
          if (response.data.token) {
            AuthService.setToken(response.data.token);
          } else {
            console.warn('No token received in response');
          }
          
          this.$router.push('/home');
        })
        .catch(error => {
          console.error('Login error:', error);
          
          if (error.response) {
            if (error.response.data && error.response.data.message) {
              this.error = error.response.data.message;
            } else {
              this.error = `Authentication failed (${error.response.status})`;
            }
          } else if (error.request) {
            this.error = 'No response from server. Please check your connection.';
          } else {
            this.error = 'Error: ' + error.message;
          }
        })
        .finally(() => {
          this.isLoading = false;
        });
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
