<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 to-emerald-100 text-gray-800 p-8 relative overflow-hidden">
    
    <div class="flex flex-col items-center justify-center min-h-[90vh] relative z-10">
      <div class="relative mb-12 transform hover:rotate-3 transition-transform duration-300">
        <div class="absolute -left-24 top-1/2 -translate-y-1/2">
          <div class="w-16 h-16 rounded-full border-2 border-green-500 flex items-center justify-center relative">
            <div class="absolute inset-2 bg-green-100 rounded-full opacity-70"></div>
            <span class="text-green-700 text-xs font-medium relative z-10">Breathe</span>
          </div>
        </div>
        
        <img
          src="/logo.png"
          alt="Touch Grass Challenge Logo"
          class="w-48 h-48 rounded-full shadow-2xl animate-breathing relative z-10 border-4 border-white"
        />
        <div class="absolute -bottom-2 -right-2 w-14 h-14 bg-white rounded-full flex items-center justify-center shadow-xl z-20">
          <span class="text-3xl animate-bounce-subtle">🌱</span>
        </div>
      </div>
      
      <h1 class="sm:text-6xl text-4xl font-extrabold mb-6 text-center text-gray-800 ">
         touch-grass Challenge
      </h1>
      
      <p class="sm:text-2xl text-xl mb-6 max-w-2xl mx-auto text-center text-gray-700 leading-relaxed font-light">
        Daily reminder to embrace things that are <span class="font-medium text-green-700">real</span>.
      </p>
      
      <p class="sm:text-lg italic mb-12 text-gray-600 text-center max-w-xl mx-auto">
        Build streaks, build habits, build a better life.
      </p>
      
      <router-link to="/home" class="bg-gradient-to-r from-green-600 to-emerald-500 text-white 
      text-lg font-semibold py-4 px-12 rounded-full transform hover:-translate-y-1 
      hover:scale-105 transition duration-300 ease-in-out shadow-lg flex items-center 
      justify-center gap-2">
        Get Started
        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
          <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
        </svg>
      </router-link>

      <!-- feature cards -->
      <FeatureCards />

    </div>
   
  </div>
</template>

<script>
import FeatureCards from './FeatureCards.vue';
export default {
  name: 'Home',
  components: {
    FeatureCards,
  },
};
</script>

<style scoped>
.animate-breathing {
  animation: box-breathing 8s ease-in-out infinite;
}

@keyframes box-breathing {
  0%, 100% {
    transform: scale(1);
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
  }
  25% {
    transform: scale(1.05);
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
  }
  50% {
    transform: scale(1.1);
    box-shadow: 0 20px 35px rgba(0, 0, 0, 0.2);
  }
  75% {
    transform: scale(1.05);
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
  }
}

.animate-pulse-slow {
  animation: pulse 8s cubic-bezier(0.4, 0, 0.6, 1) infinite;
}

@keyframes pulse {
  0%, 100% {
    opacity: 0.3;
    transform: scale(1);
  }
  50% {
    opacity: 0.6;
    transform: scale(1.1);
  }
}

.animate-float {
  animation: float 12s ease-in-out infinite;
}

@keyframes float {
  0%, 100% {
    transform: translateY(0) translateX(0);
  }
  25% {
    transform: translateY(-20px) translateX(10px);
  }
  50% {
    transform: translateY(0) translateX(20px);
  }
  75% {
    transform: translateY(20px) translateX(10px);
  }
}

.animate-bounce-subtle {
  animation: bounce-subtle 2s infinite;
}

@keyframes bounce-subtle {
  0%, 100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-3px);
  }
}

button {
  transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

button:hover {
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
}

button:active {
  transform: translateY(1px) scale(0.98);
}

.animate-breath-sync {
  animation: breath-sync 8s ease-in-out infinite;
}

@keyframes breath-sync {
  0%, 100% {
    transform: scale(0.8);
    opacity: 0.5;
  }
  25% {
    transform: scale(1);
    opacity: 0.7;
  }
  50% {
    transform: scale(1.2);
    opacity: 0.9;
  }
  75% {
    transform: scale(1);
    opacity: 0.7;
  }
}
</style>