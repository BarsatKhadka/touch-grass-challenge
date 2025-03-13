<template>
    <div class="max-w-6xl mx-auto mt-16 px-4">

        <div class="max-w-5xl mx-auto mt-12 grid grid-cols-1 md:grid-cols-2 gap-10">
          
            <div class="group relative bg-gradient-to-br from-white to-green-50 rounded-2xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:-translate-y-2 border border-green-100">
                <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
                <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
              
                <!-- card1 -->
                <div class="p-8 relative z-10">
                    <div class="flex items-center mb-6">
                        <div class="w-14 h-14 bg-gradient-to-br from-green-400 to-green-500 rounded-xl flex items-center justify-center mr-4 shadow-md transform group-hover:rotate-6 transition-transform duration-300">
                            <span class="text-2xl">👥</span>
                        </div>
                        <h3 class="font-bold text-2xl text-green-700 group-hover:text-green-600 transition-colors">Community Feed</h3>
                    </div>
                    
                    <div class="space-y-4 mb-8">
                        <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
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
                    </div>
                    
                    <button class="mt-6 bg-gradient-to-r from-green-500 to-blue-500 text-white py-2 px-6 rounded-full shadow-md hover:shadow-lg transition-shadow flex items-center group">
                        <span>View Community</span>
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 ml-2 transform group-hover:translate-x-1 transition-transform" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd" d="M10.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L12.586 11H5a1 1 0 110-2h7.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                        </svg>
                    </button>
                </div>
            </div>


          <!-- card2 -->
          <div class="group relative bg-gradient-to-br from-white to-green-50 rounded-2xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:-translate-y-2 border border-green-100">

            <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
            <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
          
            <div class="p-8 text-left">
              <div class="flex items-center mb-4">
                <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
                  <span class="text-xl">📸</span>
                </div>
                <h3 class="font-bold text-xl text-green-700">Daily Nature Challenges</h3>
              </div>
              <p class="text-gray-600 mb-4">Each day brings a new adventure! Complete challenges like:</p>
              <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
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
              </div>
              <p class="text-gray-600 italic">Capture moments that matter with simple photo proof.</p>
            </div>
          </div>

          <!-- card3 -->
          <div class="group relative bg-gradient-to-br from-white to-green-50 rounded-2xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:-translate-y-2 border border-green-100">
            
            <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
            <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
          
            <div class="p-8 text-left">
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

          <!-- card4 -->
          <div class="group relative bg-gradient-to-br from-white to-green-50 rounded-2xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:-translate-y-2 border border-green-100">
            
            <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
            <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
          
            <div class="p-8 text-left">
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
          </div>
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
    