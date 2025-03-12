<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 to-emerald-100 text-gray-800 p-8 relative overflow-hidden">

    <div class="absolute top-0 left-0 w-full h-full">
      <div class="absolute top-16 left-16 w-72 h-72 bg-green-200 rounded-full opacity-25 blur-3xl animate-pulse-slow"></div>
      <div class="absolute bottom-24 right-24 w-96 h-96 bg-emerald-200 rounded-full opacity-20 blur-3xl animate-pulse-slow"></div>
    </div>

    <div class="flex flex-col items-center justify-center relative z-10">
      <div class="relative mb-10">
        <img
          src="/logo.png"
          alt="Touch Grass Challenge Logo"
          class="w-48 h-48 rounded-full shadow-2xl animate-breathing"
        />
        <div class="absolute -bottom-2 -right-2 w-14 h-14 bg-white rounded-full flex items-center justify-center shadow-xl">
          <span class="text-3xl">🌱</span>
        </div>
      </div>

      <h1 class="text-6xl font-extrabold mb-6 bg-clip-text bg-gradient-to-r from-green-700 to-emerald-600">
        Touch Grass Challenge
      </h1>

      <p class="text-2xl mb-4 max-w-2xl mx-auto text-center text-gray-700 leading-relaxed">
        A daily reminder to embrace things that are real.
      </p>

      <p class="text-lg italic mb-10 text-gray-600 text-center max-w-xl mx-auto">
        Build streaks, build habits, build a better life.
      </p>

      <button class="bg-gradient-to-r from-green-600 to-emerald-500 text-white py-4 px-10 rounded-full hover:shadow-xl transform hover:-translate-y-1 hover:scale-105 transition duration-300 ease-in-out shadow-md">
        Get Started
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

.animate-breathing {
  animation: box-breathing 4s ease-in-out infinite;
}

@keyframes box-breathing {
  0%, 100% {
    transform: scale(1);
    opacity: 1;
  }
  25% {
    transform: scale(1.1);
    opacity: 0.9;
  }
  50% {
    transform: scale(1.2);
    opacity: 0.7;
  }
  75% {
    transform: scale(1.1);
    opacity: 0.9;
  }
}


.animate-pulse-slow {
  animation: pulse 5s cubic-bezier(0.4, 0, 0.6, 1) infinite;
}

@keyframes pulse {
  0%, 100% {
    opacity: 1;
    transform: scale(1);
  }
  50% {
    opacity: 0.85;
    transform: scale(1.1);
  }
}

button:hover {
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
  transform: translateY(-2px) scale(1.05);
}
</style>
