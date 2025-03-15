<template>
  <div class="bg-white/80 backdrop-blur-sm p-4 sm:p-6 rounded-xl shadow-md border border-green-100 hover:shadow-lg transition-all duration-300">
    <div class="flex flex-col sm:flex-row sm:items-center justify-between mb-6 gap-4">
      <div class="flex items-center">
        <div class="w-10 h-10 sm:w-12 sm:h-12 bg-gradient-to-br from-green-400 to-green-500 rounded-xl flex items-center justify-center mr-3 sm:mr-4 shadow-md transform hover:scale-105 transition-transform">
          <span class="text-lg sm:text-xl">🌱</span>
        </div>
        <h2 class="font-bold text-xl sm:text-2xl text-green-700">Your Challenges</h2>
      </div>
      <div class="flex flex-col sm:flex-row items-start sm:items-center gap-3 sm:gap-0">
        <div class="w-full sm:w-auto sm:mr-4 relative">
          <select v-model="statusFilter" class="w-full sm:w-auto bg-white border border-gray-300 rounded-lg px-3 py-1.5 text-sm focus:outline-none focus:ring-2 focus:ring-green-500 appearance-none pr-8">
            <option value="ALL">All Statuses</option>
            <option value="NOT_STARTED">Not Started</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="COMPLETED">Completed</option>
            <option value="CANCELLED">Cancelled</option>
          </select>
          <div class="absolute inset-y-0 right-0 flex items-center pr-2 pointer-events-none">
            <svg class="h-4 w-4 text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor">
              <path fill-rule="evenodd" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd" />
            </svg>
          </div>
        </div>
        <button @click="$emit('new-challenge')" class="w-full sm:w-auto bg-gradient-to-r from-green-500 to-green-600 text-white py-2 px-4 rounded-full flex items-center justify-center shadow-md hover:shadow-lg transform hover:translate-y-[-2px] transition-all">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-1" viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
          </svg>
          New Challenge
        </button>
      </div>
    </div>
    
    <div v-if="filteredChallenges.length === 0" class="text-center py-8 bg-gray-50 rounded-lg border border-gray-100">
      <div class="text-gray-400 mb-2">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-12 w-12 mx-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="1" d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2" />
        </svg>
      </div>
      <p class="text-gray-500">No challenges found with the selected filter.</p>
      <button @click="statusFilter = 'ALL'" class="mt-3 text-green-600 underline hover:text-green-800">View all challenges</button>
    </div>
    
    <ul v-else class="space-y-4">
      <li v-for="challenge in filteredChallenges" :key="challenge.challengesId" 
          class="bg-white p-3 sm:p-4 rounded-lg border border-gray-100 shadow-sm hover:shadow-md transition-all duration-300 hover:border-green-200 group">
        <div class="flex flex-col sm:flex-row justify-between sm:items-center gap-3 sm:gap-0">
          <div class="flex items-center">
            <div class="w-8 h-8 sm:w-10 sm:h-10 bg-green-100 rounded-full flex items-center justify-center mr-3 group-hover:bg-green-200 transition-colors">
              <span class="text-base sm:text-lg">{{ getEmoji(challenge.status) }}</span>
            </div>
            <div>
              <span class="font-medium text-gray-800 group-hover:text-green-700 transition-colors">{{ challenge.challengeName }}</span>
              <div class="flex flex-wrap items-center mt-1">
                <span class="text-xs text-gray-500 flex items-center">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-3 w-3 mr-1" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
                  </svg>
                  {{ formatDate(challenge.createdAt) }}
                </span>
                <span v-if="challenge.deadline" class="ml-0 sm:ml-3 mt-1 sm:mt-0 text-xs text-orange-500 w-full sm:w-auto flex items-center">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-3 w-3 mr-1" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z" />
                  </svg>
                  Due: {{ formatDate(challenge.deadline) }}
                </span>
              </div>
            </div>
          </div>
          <div class="flex items-center justify-between sm:justify-end w-full sm:w-auto">
            <span :class="getStatusBadgeClass(challenge.status)" class="px-2 py-1 rounded-full text-xs font-medium mr-3 flex items-center">
              <span class="w-1.5 h-1.5 rounded-full mr-1" :class="getStatusDotClass(challenge.status)"></span>
              {{ formatStatus(challenge.status) }}
            </span>
            <div class="flex items-center">
              <div class="dropdown relative">
                <button @click="toggleStatusDropdown(challenge.challengesId)" class="text-gray-500 hover:text-gray-700 p-2 rounded-full hover:bg-gray-50 transition-colors">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M6 10a2 2 0 11-4 0 2 2 0 014 0zM12 10a2 2 0 11-4 0 2 2 0 014 0zM16 12a2 2 0 100-4 2 2 0 000 4z" />
                  </svg>
                </button>
                <div v-if="activeDropdown === challenge.challengesId" class="absolute right-0 mt-2 w-48 bg-white rounded-md shadow-lg z-10 py-1 border border-gray-100 animate-fadeIn">
                  <button @click="quickUpdateStatus(challenge.challengesId, 'NOT_STARTED')" class="block w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 flex items-center">
                    <span class="w-2 h-2 rounded-full bg-gray-300 mr-2"></span>
                    Not Started
                  </button>
                  <button @click="quickUpdateStatus(challenge.challengesId, 'IN_PROGRESS')" class="block w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 flex items-center">
                    <span class="w-2 h-2 rounded-full bg-blue-400 mr-2"></span>
                    In Progress
                  </button>
                  <button @click="quickUpdateStatus(challenge.challengesId, 'COMPLETED')" class="block w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 flex items-center">
                    <span class="w-2 h-2 rounded-full bg-green-400 mr-2"></span>
                    Completed
                  </button>
                  <button @click="quickUpdateStatus(challenge.challengesId, 'CANCELLED')" class="block w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 flex items-center">
                    <span class="w-2 h-2 rounded-full bg-red-400 mr-2"></span>
                    Cancelled
                  </button>
                </div>
              </div>
              <div class="flex space-x-1 sm:space-x-2">
                <button @click="$emit('edit-challenge', challenge.challengesId)" class="text-blue-500 hover:text-blue-700 p-1 sm:p-2 rounded-full hover:bg-blue-50 transition-colors">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M13.586 3.586a2 2 0 112.828 2.828l-.793.793-2.828-2.828.793-.793zM11.379 5.793L3 14.172V17h2.828l8.38-8.379-2.83-2.828z" />
                  </svg>
                </button>
                <button @click="$emit('delete-challenge', challenge.challengesId)" class="text-red-500 hover:text-red-700 p-1 sm:p-2 rounded-full hover:bg-red-50 transition-colors">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z" clip-rule="evenodd" />
                  </svg>
                </button>
              </div>
            </div>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'ChallengesList',
  props: {
    challenges: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      statusFilter: 'ALL',
      activeDropdown: null
    }
  },
  computed: {
    filteredChallenges() {
      if (this.statusFilter === 'ALL') {
        return this.challenges;
      }
      return this.challenges.filter(challenge => challenge.status === this.statusFilter);
    }
  },
  methods: {
    formatDate(dateString) {
      if (!dateString) return 'N/A';
      const date = new Date(dateString);
      return date.toLocaleDateString('en-US', { 
        month: 'short', 
        day: 'numeric',
        year: 'numeric'
      });
    },
    formatStatus(status) {
      if (!status) return 'Not Started';
      return status.replace('_', ' ').toLowerCase()
        .split(' ')
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(' ');
    },
    getStatusBadgeClass(status) {
      if (!status) return 'bg-gray-100 text-gray-800';
      
      switch(status) {
        case 'NOT_STARTED':
          return 'bg-gray-100 text-gray-800';
        case 'IN_PROGRESS':
          return 'bg-blue-100 text-blue-800';
        case 'COMPLETED':
          return 'bg-green-100 text-green-800';
        case 'CANCELLED':
          return 'bg-red-100 text-red-800';
        default:
          return 'bg-gray-100 text-gray-800';
      }
    },
    getStatusDotClass(status) {
      if (!status) return 'bg-gray-400';
      
      switch(status) {
        case 'NOT_STARTED':
          return 'bg-gray-400';
        case 'IN_PROGRESS':
          return 'bg-blue-500';
        case 'COMPLETED':
          return 'bg-green-500';
        case 'CANCELLED':
          return 'bg-red-500';
        default:
          return 'bg-gray-400';
      }
    },
    getEmoji(status) {
      if (!status) return '🌿';
      
      switch(status) {
        case 'NOT_STARTED':
          return '🌱';
        case 'IN_PROGRESS':
          return '🌿';
        case 'COMPLETED':
          return '🌳';
        case 'CANCELLED':
          return '🍂';
        default:
          return '🌿';
      }
    },
    toggleStatusDropdown(challengeId) {
      this.activeDropdown = this.activeDropdown === challengeId ? null : challengeId;
    },
    quickUpdateStatus(challengeId, status) {
      this.$emit('update-status', { challengeId, status });
      this.activeDropdown = null;
    }
  },
  mounted() {
    document.addEventListener('click', (e) => {
      if (!this.$el.contains(e.target)) {
        this.activeDropdown = null;
      }
    });
  },
  beforeUnmount() {
    document.removeEventListener('click', this.closeDropdowns);
  }
}
</script>

<style scoped>
.animate-fadeIn {
  animation: fadeIn 0.2s ease-in-out;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style>