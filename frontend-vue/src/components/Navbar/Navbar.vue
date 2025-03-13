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


        </div>
      </div>
    </nav>
  </template>
  