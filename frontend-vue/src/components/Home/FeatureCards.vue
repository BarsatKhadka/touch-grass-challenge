<template>
    <div class="max-w-4xl mx-auto mt-12 grid grid-cols-1 gap-8">
      <div class="bg-white/80 backdrop-blur-sm p-8 rounded-xl shadow-md border border-green-100 text-left">
        <div class="flex items-center mb-4">
          <div class="w-12 h-12 bg-green-100 rounded-full flex items-center justify-center mr-4">
            <span class="text-xl">🔥</span>
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
  