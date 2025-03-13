<template>
    <div class="max-w-4xl mx-auto mt-12 grid grid-cols-1 gap-8">
      <div class="bg-white/80 backdrop-blur-sm p-8 rounded-xl shadow-md border border-green-100 text-left">
        <div class="flex items-center mb-4">
          <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
            <span class="text-xl">🔥</span>
          </div>
          <h3 class="font-bold text-xl text-green-700">Build Your Streak</h3>
        </div>
        <p class="text-gray-600 mb-4">Consistency is key to forming lasting habits:</p>
        <div class="flex justify-between mb-4">
          <div v-for="(day, index) in days" :key="index" class="text-center">
            <div
              :class="['w-10 h-10 rounded-full flex items-center justify-center mx-auto mb-1', day.status === 'active' ? 'bg-green-500 text-white' : 'bg-green-100 text-gray-400']"
            >
              {{ day.day }}
            </div>
            <div class="text-xs">{{ day.name }}</div>
          </div>
        </div>
        <p class="text-gray-600 italic">Watch your streak grow as you connect with nature daily.</p>
      </div>
      
      <div class="bg-white/80 backdrop-blur-sm p-8 rounded-xl shadow-md border border-green-100 text-left">
        <div class="flex items-center mb-4">
          <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
            <span class="text-xl">👥</span>
          </div>
          <h3 class="font-bold text-xl text-green-700">Community Feed</h3>
        </div>
        <p class="text-gray-600 mb-4">Stay motivated by seeing what your friends are up to:</p>
        <div class="space-y-3 mb-4">
          <div class="flex items-center">
            <div class="w-8 h-8 bg-blue-100 rounded-full mr-2 flex items-center justify-center font-bold text-xs">JD</div>
            <div class="text-sm">
              <span class="font-semibold">Jamie</span> completed "Morning meditation by the lake" 
              <span class="text-gray-500 text-xs">2h ago</span>
            </div>
          </div>
          <div class="flex items-center">
            <div class="w-8 h-8 bg-purple-100 rounded-full mr-2 flex items-center justify-center font-bold text-xs">TK</div>
            <div class="text-sm">
              <span class="font-semibold">Taylor</span> is on a 12-day streak! 
              <span class="text-gray-500 text-xs">5h ago</span>
            </div>
          </div>
        </div>
        <p class="text-gray-600 italic">Share your journey and celebrate each other's progress.</p>
      </div>
      
      <div class="bg-white/80 backdrop-blur-sm p-8 rounded-xl shadow-md border border-green-100 text-left">
        <div class="flex items-center mb-4">
          <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
            <span class="text-xl">📸</span>
          </div>
          <h3 class="font-bold text-xl text-green-700">Daily Nature Challenges</h3>
        </div>
        <p class="text-gray-600 mb-4">Each day brings a new adventure! Complete challenges like:</p>
        <ul class="space-y-2 mb-4">
          <li class="flex items-center">
            <span class="text-green-500 mr-2">✓</span>
            <span>"Take a photo of the sunset"</span>
          </li>
          <li class="flex items-center">
            <span class="text-green-500 mr-2">✓</span>
            <span>"Hug a tree and feel its energy"</span>
          </li>
          <li class="flex items-center">
            <span class="text-green-500 mr-2">✓</span>
            <span>"Find a unique flower in your neighborhood"</span>
          </li>
        </ul>
        <p class="text-gray-600 italic">Capture moments that matter with simple photo proof.</p>
      </div>
      
      <div class="bg-white/80 backdrop-blur-sm p-8 rounded-xl shadow-md border border-green-100 text-left">
        <div class="flex items-center mb-4">
          <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
            <span class="text-xl">✨</span>
          </div>
          <h3 class="font-bold text-xl text-green-700">Create Your Challenges</h3>
        </div>
        <p class="text-gray-600 mb-4">Add your own twist to the experience:</p>
        <div class="bg-green-50 p-4 rounded-lg mb-4 border border-green-200">
          <p class="text-sm font-medium text-green-800 mb-2">"New Challenge Idea"</p>
          <p class="text-sm text-gray-700">Find a spot where you can see the stars and take a moment to appreciate the vastness of the universe.</p>
          <div class="flex justify-end mt-2">
            <button class="bg-green-600 text-white text-xs py-1 px-3 rounded-full">Share with friends</button>
          </div>
        </div>
        <p class="text-gray-600 italic">Create and share your own nature challenges with friends.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
    
        days: [
          { day: 1, name: 'Mon', status: 'active' },
          { day: 2, name: 'Tue', status: 'active' },
          { day: 3, name: 'Wed', status: 'active' },
          { day: 4, name: 'Thu', status: 'active' },
          { day: 5, name: 'Fri', status: 'active' },
          { day: 6, name: 'Sat', status: 'inactive' },
          { day: 7, name: 'Sun', status: 'inactive' },
        ],
      };
    },
  };
  </script>
  
  <style scoped>
  
  </style>
  