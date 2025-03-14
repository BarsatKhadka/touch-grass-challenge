<template>
    <nav class="bg-white/90 backdrop-blur-sm shadow-sm sticky top-0 z-50">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex justify-between h-16">
            <div class="flex items-center">
            <div class="flex-shrink-0 flex items-center">
                <div class="w-10 h-10 rounded-full bg-gradient-to-br from-green-400 to-blue-500 flex items-center justify-center mr-2">
                <img src="/logo.png" alt="Touch Grass Logo" class="h-8 w-8 rounded-full" />
                </div>
                <span class="text-xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-green-600 to-blue-600">
                Touch Grass
                </span>
            </div>
            <div class="hidden sm:ml-6 sm:flex sm:space-x-8">
                <router-link to="/home" class="border-transparent text-gray-500 hover:border-green-500 hover:text-green-700 inline-flex items-center px-1 pt-1 border-b-2 text-sm font-medium">Dashboard</router-link>
                <router-link to="/challenges" class="border-transparent text-gray-500 hover:border-green-500 hover:text-green-700 inline-flex items-center px-1 pt-1 border-b-2 text-sm font-medium">Challenges</router-link>
                <router-link to="/community" class="border-transparent text-gray-500 hover:border-green-500 hover:text-green-700 inline-flex items-center px-1 pt-1 border-b-2 text-sm font-medium">Community</router-link>
                <router-link to="/achievements" class="border-transparent text-gray-500 hover:border-green-500 hover:text-green-700 inline-flex items-center px-1 pt-1 border-b-2 text-sm font-medium">Achievements</router-link>
                </div>
            </div>
            <div class="flex items-center">
                <div class="ml-3 relative">
                    <div>
                        <button @click="toggleUserMenu" class="bg-white rounded-full flex text-sm focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-green-500">
                        <span class="sr-only">Open user menu</span>
                        <div class="h-8 w-8 rounded-full bg-gradient-to-br from-purple-400 to-blue-500 flex items-center justify-center text-white font-medium">
                            JD
                        </div>
                        </button>
                    </div>
                    

                    <div v-if="userMenuOpen" class="origin-top-right absolute right-0 mt-2 w-48 rounded-md shadow-lg py-1 bg-white ring-1 ring-black ring-opacity-5 focus:outline-none z-10">
                        <router-link to="/profile" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Your Profile</router-link>
                        <router-link to="/settings" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Settings</router-link>
                        <button @click="logout" class="w-full text-left block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Sign out</button>
                    </div>
                </div>

                <!-- Mobile menu  -->
                <div class="flex items-center sm:hidden ml-4">
                    <button @click="toggleMobileMenu" class="inline-flex items-center justify-center p-2 rounded-md text-gray-500 hover:text-gray-700 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-green-500">
                        <span class="sr-only">Open main menu</span>
                        <svg v-if="!mobileMenuOpen" xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
                        </svg>
                        <svg v-else xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </button>
                </div>
            </div>
        </div>

    
        <div v-if="mobileMenuOpen" class="sm:hidden absolute left-0 right-0 bg-white shadow-lg z-20">
            <div class="pt-2 pb-3 space-y-1 px-4">
                <router-link to="/home" class="block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700 border-l-4 border-transparent hover:border-green-500">Dashboard</router-link>
                <router-link to="/challenges" class="block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700 border-l-4 border-transparent hover:border-green-500">Challenges</router-link>
                <router-link to="/community" class="block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700 border-l-4 border-transparent hover:border-green-500">Community</router-link>
                <router-link to="/achievements" class="block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700 border-l-4 border-transparent hover:border-green-500">Achievements</router-link>
            </div>
            
            
            <div class="pt-4 pb-3 border-t border-gray-200 px-4">
                <div class="flex items-center">
                    <div class="flex-shrink-0">
                        <div class="h-10 w-10 rounded-full bg-gradient-to-br from-purple-400 to-blue-500 flex items-center justify-center text-white font-medium">
                            JD
                        </div>
                    </div>
                    <div class="ml-3">
                        <div class="text-base font-medium text-gray-800">Jamie Doe</div>
                        <div class="text-sm font-medium text-gray-500">jamie@example.com</div>
                    </div>
                </div>
                <div class="mt-3 space-y-1">
                    <router-link to="/profile" class="block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700">Your Profile</router-link>
                    <router-link to="/settings" class="block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700">Settings</router-link>
                    <button @click="logout" class="w-full text-left block py-2 px-3 rounded-md text-base font-medium text-gray-700 hover:bg-green-50 hover:text-green-700">Sign out</button>
                </div>
            </div>
        </div>
      </div>
    </nav>
  </template>

  <script>
  export default {
    name: 'Navbar',
    data() {
      return {
        userMenuOpen: false,
        mobileMenuOpen: false
      }
    },
    methods: {
      toggleUserMenu() {
        this.userMenuOpen = !this.userMenuOpen;
        if (this.userMenuOpen) {
          this.mobileMenuOpen = false; 
        }
      },
      toggleMobileMenu() {
        this.mobileMenuOpen = !this.mobileMenuOpen;
        if (this.mobileMenuOpen) {
          this.userMenuOpen = false; 
        }
      },
      logout() {
        console.log('Logging out...');
        this.$router.push('/login');
      }
    },
    
    mounted() {
      document.addEventListener('click', (e) => {
        if (!this.$el.contains(e.target)) {
          this.userMenuOpen = false;
        }
      });
    }
  }
  </script>
  
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap');

.router-link-active {
  border-color: #10B981;
  color: #047857;
}


.router-link-active, button {
  transition: all 0.2s ease-in-out;
}

button:hover {
  transform: translateY(-1px);
}

button:active {
  transform: translateY(0);
}


@keyframes slideDown {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.sm\:hidden {
  animation: slideDown 0.2s ease-out;
}
</style>
  