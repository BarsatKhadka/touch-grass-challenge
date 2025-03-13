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
                    
                    <p class="text-gray-600 mb-6">Stay motivated by seeing what your friends are up to:</p>
                    
                    <div class="space-y-4 mb-8">
                        <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
                            <div class="flex items-center">
                                <div class="w-10 h-10 bg-gradient-to-br from-blue-400 to-blue-500 rounded-full mr-3 flex items-center justify-center font-bold text-xs text-white shadow-sm">JD</div>
                                <div>
                                    <div class="flex items-center mb-1">
                                        <span class="font-semibold text-gray-800">Jamie</span>
                                        <span class="ml-2 px-2 py-0.5 bg-blue-100 text-blue-700 text-xs rounded-full">Pro Member</span>
                                    </div>
                                    <p class="text-gray-700">Completed "Morning meditation by the lake"</p>
                                    <div class="flex items-center mt-1">
                                        <span class="text-gray-500 text-xs">2h ago</span>
                                        <div class="flex ml-3">
                                            <span class="text-green-500 mr-1">🌱</span>
                                            <span class="text-xs text-gray-600">+15 points</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
                            <div class="flex items-center">
                                <div class="w-10 h-10 bg-gradient-to-br from-purple-400 to-purple-500 rounded-full mr-3 flex items-center justify-center font-bold text-xs text-white shadow-sm">TK</div>
                                <div>
                                    <div class="flex items-center mb-1">
                                        <span class="font-semibold text-gray-800">Taylor</span>
                                        <div class="ml-2 flex items-center">
                                            <span class="text-yellow-500 mr-1">🔥</span>
                                            <span class="text-xs font-medium text-yellow-600">12-day streak!</span>
                                        </div>
                                    </div>
                                    <p class="text-gray-700">Captured a stunning sunset at the beach</p>
                                    <div class="mt-2 rounded-lg overflow-hidden h-16 w-full bg-gray-100">
                                        <div class="h-full w-full bg-cover bg-center opacity-90 hover:opacity-100 transition-opacity" style="background-image: url('../../../src/assets/image/sun_5.jpg')"></div>
                                    </div>
                                    <div class="flex items-center mt-2">
                                        <span class="text-gray-500 text-xs">5h ago</span>
                                        <div class="flex ml-3 items-center">
                                            <span class="text-xs text-gray-600 mr-2">23 ❤️</span>
                                            <span class="text-xs text-gray-600">8 💬</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <p class="text-gray-600 italic">Share your journey and celebrate each other's progress.</p>
                    
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
        <!-- Decorative elements -->
        <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
        <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
        
        <!-- Card content -->
        <div class="p-8 relative z-10">
          <div class="flex items-center mb-6">
            <div class="w-14 h-14 bg-gradient-to-br from-green-400 to-green-500 rounded-xl flex items-center justify-center mr-4 shadow-md transform group-hover:rotate-6 transition-transform duration-300">
              <span class="text-2xl">📸</span>
            </div>
            <h3 class="font-bold text-2xl text-green-700 group-hover:text-green-600 transition-colors">Daily Nature Challenges</h3>
          </div>
          
          <p class="text-gray-600 mb-6">Each day brings a new adventure! Complete challenges like:</p>
          
          <div class="space-y-4 mb-8">
            <!-- Challenge items with enhanced styling -->
            <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
              <div class="flex">
                <div class="w-10 h-10 bg-gradient-to-br from-green-400 to-green-500 rounded-full mr-3 flex items-center justify-center text-white shadow-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div>
                  <div class="font-medium text-gray-800 mb-1">Take a photo of the sunset</div>
                  <div class="flex items-center">
                    <span class="text-xs text-gray-500">Today's Challenge</span>
                    <span class="ml-2 px-2 py-0.5 bg-yellow-100 text-yellow-700 text-xs rounded-full">+20 points</span>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
              <div class="flex">
                <div class="w-10 h-10 bg-gradient-to-br from-blue-400 to-blue-500 rounded-full mr-3 flex items-center justify-center text-white shadow-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M5 4a2 2 0 012-2h6a2 2 0 012 2v14l-5-2.5L5 18V4z" />
                  </svg>
                </div>
                <div>
                  <div class="font-medium text-gray-800 mb-1">Hug a tree and feel its energy</div>
                  <div class="flex items-center">
                    <span class="text-xs text-gray-500">Tomorrow's Challenge</span>
                    <span class="ml-2 px-2 py-0.5 bg-blue-100 text-blue-700 text-xs rounded-full">+15 points</span>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-green-100 shadow-sm hover:shadow-md transition-shadow">
              <div class="flex">
                <div class="w-10 h-10 bg-gradient-to-br from-purple-400 to-purple-500 rounded-full mr-3 flex items-center justify-center text-white shadow-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M3.172 5.172a4 4 0 015.656 0L10 6.343l1.172-1.171a4 4 0 115.656 5.656L10 17.657l-6.828-6.829a4 4 0 010-5.656z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div>
                  <div class="font-medium text-gray-800 mb-1">Find a unique flower in your neighborhood</div>
                  <div class="flex items-center">
                    <span class="text-xs text-gray-500">Community Favorite</span>
                    <span class="ml-2 px-2 py-0.5 bg-purple-100 text-purple-700 text-xs rounded-full">+25 points</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          <p class="text-gray-600 italic">Capture moments that matter with simple photo proof.</p>
          
          <button class="mt-6 bg-gradient-to-r from-green-500 to-blue-500 text-white py-2 px-6 rounded-full shadow-md hover:shadow-lg transition-shadow flex items-center group">
            <span>See All Challenges</span>
            <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 ml-2 transform group-hover:translate-x-1 transition-transform" viewBox="0 0 20 20" fill="currentColor">
              <path fill-rule="evenodd" d="M10.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L12.586 11H5a1 1 0 110-2h7.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd" />
            </svg>
          </button>
        </div>
      </div>


          <!-- card3 -->
          <div class="group relative bg-gradient-to-br from-white to-green-50 rounded-2xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:-translate-y-2 border border-green-100">
            
            <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
            <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
          
            <div class="p-8 relative z-10">
              <div class="flex items-center mb-6">
                <div class="w-14 h-14 bg-gradient-to-br from-green-400 to-green-500 rounded-xl flex items-center justify-center mr-4 shadow-md transform group-hover:rotate-6 transition-transform duration-300">
                  <span class="text-2xl">✨</span>
                </div>
                <h3 class="font-bold text-2xl text-green-700 group-hover:text-green-600 transition-colors">Create Your Challenges</h3>
              </div>
              <p class="text-gray-600 mb-6">Add your own twist to the experience with custom challenges:</p>
              <div class="bg-gradient-to-br from-green-50 to-green-100 p-6 rounded-xl mb-6 border border-green-200 shadow-inner">
                <div class="mb-4">
                  <label class="block text-sm font-medium text-gray-700 mb-2">Challenge Title</label>
                  <input type="text" placeholder="Night Sky Meditation" class="w-full px-4 py-2 rounded-lg border border-green-200 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent" />
                </div>
                
                <div class="mb-4">
                  <label class="block text-sm font-medium text-gray-700 mb-2">Description</label>
                  <textarea placeholder="Find a spot where you can see the stars and take a moment to appreciate the vastness of the universe." class="w-full px-4 py-2 rounded-lg border border-green-200 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent h-24"></textarea>
                </div>
                
                <div class="flex flex-wrap gap-2 mb-4">
                  <span class="px-3 py-1 bg-white rounded-full text-sm text-gray-700 border border-green-200 cursor-pointer hover:bg-green-500 hover:text-white hover:border-transparent transition-colors">#stargazing</span>
                  <span class="px-3 py-1 bg-white rounded-full text-sm text-gray-700 border border-green-200 cursor-pointer hover:bg-green-500 hover:text-white hover:border-transparent transition-colors">#meditation</span>
                  <span class="px-3 py-1 bg-white rounded-full text-sm text-gray-700 border border-green-200 cursor-pointer hover:bg-green-500 hover:text-white hover:border-transparent transition-colors">#evening</span>
                  <span class="px-3 py-1 bg-green-500 text-white rounded-full text-sm border border-transparent cursor-pointer">#mindfulness</span>
                  <span class="px-3 py-1 bg-white rounded-full text-sm text-gray-700 border border-green-200 cursor-pointer hover:bg-green-500 hover:text-white hover:border-transparent transition-colors">+ Add Tag</span>
                </div>
                
                <div class="flex justify-end">
                  <button class="bg-gradient-to-r from-green-600 to-green-500 text-white py-2 px-6 rounded-full shadow-md hover:shadow-lg transition-shadow flex items-center group">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 mr-2" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z" clip-rule="evenodd" />
                    </svg>
                    <span>Create & Share</span>
                  </button>
                </div>
              </div>
              
              <div class="bg-white/70 backdrop-blur-sm p-4 rounded-xl border border-blue-100 shadow-sm hover:shadow-md transition-shadow">
                <div class="flex items-center mb-2">
                  <div class="w-6 h-6 bg-blue-100 rounded-full mr-2 flex items-center justify-center">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-blue-500" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd" />
                    </svg>
                  </div>
                  <p class="text-sm text-blue-800 font-medium">Community challenges get featured on the homepage!</p>
                </div>
              </div>
            </div>
          </div>

          <!-- card4 -->
          <div class="group relative bg-gradient-to-br from-white to-green-50 rounded-2xl shadow-lg overflow-hidden transition-all duration-300 hover:shadow-xl hover:-translate-y-2 border border-green-100">
            
            <div class="absolute top-0 right-0 w-32 h-32 bg-green-100 rounded-full -translate-x-16 -translate-y-16 opacity-50 group-hover:opacity-70 transition-opacity"></div>
            <div class="absolute bottom-0 left-0 w-24 h-24 bg-blue-100 rounded-full translate-x-1/2 translate-y-1/2 opacity-50 group-hover:opacity-70 transition-opacity"></div>
          
            <div class="p-8 relative z-10">
              <div class="flex items-center mb-6">
                <div class="w-14 h-14 bg-gradient-to-br from-orange-400 to-red-500 rounded-xl flex items-center justify-center mr-4 shadow-md transform group-hover:rotate-6 transition-transform duration-300">
                  <span class="text-2xl">🔥</span>
                </div>
                <h3 class="font-bold text-2xl text-green-700 group-hover:text-green-600 transition-colors">Build Your Streak</h3>
              </div>
              <p class="text-gray-600 mb-6">Consistency is key to forming lasting habits:</p>
              
              
              <div class="bg-white/70 backdrop-blur-sm p-6 rounded-xl border border-green-100 shadow-sm mb-6">
                <div class="flex justify-between mb-2">
                  <div v-for="(day, index) in days" :key="index" class="text-center relative">
                    <div class="relative">
                      <div
                        :class="[
                          'w-12 h-12 rounded-full flex items-center justify-center mx-auto mb-2 transition-all duration-300 relative overflow-hidden',
                          day.status === 'active' ? 'bg-gradient-to-br from-green-400 to-green-500 text-white shadow-md' : 'bg-gray-100 text-gray-400'
                        ]"
                      >
                        
                        <div v-if="day.status === 'active'" class="absolute inset-0 rounded-full bg-white animate-ripple"></div>
                        <span class="relative z-10 text-lg font-medium">{{ day.day }}</span>
                      </div>

                      <div v-if="index < days.length - 1" 
                        :class="[
                          'absolute top-1/2 -right-4 h-0.5 w-8 -translate-y-1/2',
                          day.status === 'active' && days[index + 1].status === 'active' ? 'bg-gradient-to-r from-green-400 to-green-500' : 'bg-gray-200' 
                        ]">
                      </div>
                    </div>
                    <div class="text-xs font-medium" :class="day.status === 'active' ? 'text-green-600' : 'text-gray-500'">{{ day.name }}</div>
                  </div>
                </div>
                
                
                <div class="flex mt-8 mb-4">
                  <div class="flex-1 border-r border-gray-200 pr-4">
                    <div class="text-xs text-gray-500 mb-1">Current Streak</div>
                    <div class="text-2xl font-bold text-green-600">5 days</div>
                  </div>
                  <div class="flex-1 px-4 border-r border-gray-200">
                    <div class="text-xs text-gray-500 mb-1">Longest Streak</div>
                    <div class="text-2xl font-bold text-blue-600">21 days</div>
                  </div>
                  <div class="flex-1 pl-4">
                    <div class="text-xs text-gray-500 mb-1">Challenges Completed</div>
                    <div class="text-2xl font-bold text-purple-600">37</div>
                  </div>
                </div>
              </div>
              
              
              <div class="mb-6">
                <h4 class="font-medium text-gray-800 mb-3">Your Achievements</h4>
                <div class="grid grid-cols-4 gap-2">
                  <div class="bg-white/70 backdrop-blur-sm p-2 rounded-lg border border-yellow-100 flex flex-col items-center">
                    <div class="text-2xl mb-1">🌱</div>
                    <div class="text-xs text-center text-gray-600">First Step</div>
                  </div>
                  <div class="bg-white/70 backdrop-blur-sm p-2 rounded-lg border border-yellow-100 flex flex-col items-center">
                    <div class="text-2xl mb-1">🌳</div>
                    <div class="text-xs text-center text-gray-600">Tree Hugger</div>
                  </div>
                  <div class="bg-white/70 backdrop-blur-sm p-2 rounded-lg border border-yellow-100 flex flex-col items-center">
                    <div class="text-2xl mb-1">🔥</div>
                    <div class="text-xs text-center text-gray-600">7-Day Streak</div>
                  </div>
                  <div class="bg-gray-100 p-2 rounded-lg border border-gray-200 flex flex-col items-center opacity-70">
                    <div class="text-2xl mb-1">🌟</div>
                    <div class="text-xs text-center text-gray-500">Explorer</div>
                  </div>
                </div>
              </div>
              
              <p class="text-gray-600 italic">Watch your streak grow as you connect with nature daily.</p>
              
              <button class="mt-6 bg-gradient-to-r from-green-500 to-blue-500 text-white py-2 px-6 rounded-full shadow-md hover:shadow-lg transition-shadow flex items-center group">
                <span>Check In Today</span>
                <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 ml-2" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd" />
                </svg>
              </button>
            </div>
          </div>
        </div>
      </div>
    </template>
    
    <script>
    import sun_5 from '../../../assets/image/sun_5.jpg';
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
    @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap');

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

    /* Enhance button hover effects */
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
    