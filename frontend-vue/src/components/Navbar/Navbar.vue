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
                <router-link to="/home" class="...">Dashboard</router-link>
                <router-link to="/challenges" class="...">Challenges</router-link>
                <router-link to="/community" class="...">Community</router-link>
                <router-link to="/achievements" class="...">Achievements</router-link>
                </div>
            </div>
            <div class="ml-3 relative mt-4">
                <div>
                    <button @click="toggleUserMenu" class="bg-white rounded-full flex text-sm focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-green-500">
                    <span class="sr-only">Open user menu</span>
                    <div class="h-8 w-8 rounded-full bg-gradient-to-br from-purple-400 to-blue-500 flex items-center justify-center text-white font-medium">
                        JD
                    </div>
                    </button>
                </div>
            </div>

            <!-- Mobile Logic -->
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

            <!-- Mobile menu -->
            <div v-if="mobileMenuOpen" class="sm:hidden">
            <div class="pt-2 pb-3 space-y-1">
                <router-link to="/home" class="...">Dashboard</router-link>
                <router-link to="/challenges" class="...">Challenges</router-link>
                <router-link to="/community" class="...">Community</router-link>
                <router-link to="/achievements" class="...">Achievements</router-link>
            </div>
            </div>




        </div>
      </div>
    </nav>
  </template>
  