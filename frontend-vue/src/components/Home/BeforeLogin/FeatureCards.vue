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
          
            <div class="p-8 relative z-10">
              <div class="flex items-center mb-4">
                <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
                  <span class="text-xl">✨</span>
                </div>
                <h3 class="font-bold text-xl text-green-700">Create Your Challenges</h3>
              </div>
              <p class="text-gray-600 mb-4">Add your own twist to the experience:</p>
              <div class="bg-gradient-to-br from-green-50 to-green-100 p-6 rounded-xl mb-6 border border-green-200 shadow-inner">
                <div class="mb-4">
                  <label class="block text-sm font-medium text-gray-700 mb-2">Challenge Title</label>
                  <input type="text" placeholder="Night Sky Meditation" class="w-full px-4 py-2 rounded-lg border border-green-200 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent" />
                </div>
                
                <div class="mb-4">
                  <label class="block text-sm font-medium text-gray-700 mb-2">Description</label>
                  <textarea placeholder="Find a spot where you can see the stars..." class="w-full px-4 py-2 rounded-lg border border-green-200 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent h-24"></textarea>
                </div>
                
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
              <div class="bg-white/70 backdrop-blur-sm p-6 rounded-xl border border-green-100 shadow-sm mb-6">
                <div class="flex justify-between mb-2">
                  <div v-for="(day, index) in days" :key="index" class="text-center relative">
                    <div
                      :class="['w-10 h-10 rounded-full flex items-center justify-center mx-auto mb-1', day.status === 'active' ? 'bg-green-500 text-white' : 'bg-green-100 text-gray-400']"
                    >
                      {{ day.day }}
                    </div>
                    <div class="text-xs">{{ day.name }}</div>
                  </div>
                </div>
                
                <div class="flex mt-8 mb-4">
                  <div class="text-center">
                    <div class="text-2xl font-bold">12</div>
                    <div class="text-xs">Days</div>
                  </div>
                  <div class="text-center">
                    <div class="text-2xl font-bold">3</div>
                    <div class="text-xs">Challenges</div>
                  </div>
                  <div class="text-center">
                    <div class="text-2xl font-bold">100%</div>
                    <div class="text-xs">Completion</div>
                  </div>
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
     

    .animate-expand {
      animation: expand 1.5s ease-out forwards;
    }

    @keyframes expand {
      0% {
        transform: scaleX(0);
      }
      100% {
        transform: scaleX(1);
      }
    }

    .animate-ripple {
      animation: ripple 2s linear infinite;
    }

    @keyframes ripple {
      0% {
        opacity: 0.7;
        transform: scale(0);
      }
      100% {
        opacity: 0;
        transform: scale(2.5);
      }
    }

    button {
      transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
    }

    button:hover {
      transform: translateY(-2px);
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
    }

    button:active {
      transform: translateY(0) scale(0.98);
    }
    </style>
    