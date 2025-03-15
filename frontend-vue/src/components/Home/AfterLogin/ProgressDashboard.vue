<template>
    <div class="bg-white/80 backdrop-blur-sm p-6 rounded-xl shadow-md border border-green-100 mb-12 lg:mt-[220px] mt-8 relative z-0">
      <div class="flex items-center mb-6">
        <div class="w-12 h-12 bg-gradient-to-br from-purple-400 to-purple-500 rounded-xl flex items-center justify-center mr-4 shadow-md">
          <span class="text-xl">📊</span>
        </div>
        <h2 class="font-bold text-2xl text-purple-700">Your Progress</h2>
      </div>
      
      <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div class="bg-gradient-to-br from-green-50 to-green-100 p-6 rounded-xl border border-green-200">
          <div class="text-4xl font-bold text-green-600 mb-2">{{ challengeCount }}</div>
          <div class="text-sm text-gray-600">Active Challenges</div>
        </div>
        
        <div class="bg-gradient-to-br from-purple-50 to-purple-100 p-6 rounded-xl border border-purple-200">
          <div class="text-4xl font-bold text-purple-600 mb-2">{{ completedCount }}</div>
          <div class="text-sm text-gray-600">Total Completions</div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ProgressDashboard',
    props: {
      challenges: {
        type: Array,
        required: true
      }
    },
    computed: {
      challengeCount() {
        return this.challenges.length;
      },
      completedCount() {
        return this.challenges.filter(challenge => challenge.status === 'COMPLETED').length;
      }
    }
  }
  </script>
  
  <style scoped>
  .rounded-xl {
    transition: all 0.3s ease;
  }
  
  .rounded-xl:hover {
    transform: translateY(-5px);
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
  }
  
  @media (max-width: 768px) {
    .grid {
      gap: 1rem;
    }
    
    .p-6 {
      padding: 1rem;
    }
    
    .text-4xl {
      font-size: 1.75rem;
    }
  }
  </style>