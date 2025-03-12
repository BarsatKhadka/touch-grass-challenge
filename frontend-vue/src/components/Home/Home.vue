<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 to-emerald-100 text-gray-800 p-6 relative overflow-hidden">

    <div class="absolute top-0 left-0 w-full h-full">
      <div class="absolute top-10 left-10 w-64 h-64 bg-green-200 rounded-full opacity-30 blur-3xl"></div>
      <div class="absolute bottom-20 right-20 w-80 h-80 bg-emerald-200 rounded-full opacity-20 blur-3xl"></div>
    </div>
    
    <div class="flex justify-center mb-8 relative z-10">
      <div class="relative">
        <img src="/logo.png" alt="Touch Grass Challenge Logo" class="w-40 h-40 rounded-full shadow-lg animate-pulse-slow" />
        <div class="absolute -bottom-2 -right-2 w-12 h-12 bg-white rounded-full flex items-center justify-center shadow-md">
          <span class="text-2xl">🌱</span>
        </div>
      </div>
    </div>

    <div class="text-center relative z-10">
      <h1 class="text-5xl font-bold mb-4 ">
        Touch Grass Challenge
      </h1>
      <p class="text-xl mb-6 max-w-xl mx-auto text-gray-700">
        Reconnect with nature, rediscover yourself.
      </p>
      <button class="bg-green-600 text-white py-3 px-6 rounded-lg hover:bg-green-700 transition duration-300 shadow-md">
        Join the Challenge
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
};
</script>

<style scoped>
.animate-pulse-slow {
  animation: pulse 4s cubic-bezier(0.4, 0, 0.6, 1) infinite;
}

@keyframes pulse {
  0%, 100% {
    opacity: 1;
    transform: scale(1);
  }
  50% {
    opacity: 0.9;
    transform: scale(1.05);
  }
}
</style>