<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100">
    <Navbar />
    <div class="max-w-6xl mx-auto px-4 py-8 sm:px-6 lg:px-8">
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8 mb-12">
        <div class="lg:col-span-2">
          <div class="bg-white/80 backdrop-blur-sm p-6 rounded-xl shadow-md border border-green-100">
            <div class="flex items-center justify-between mb-6">
              <div class="flex items-center">
                <div class="w-12 h-12 bg-gradient-to-br from-green-400 to-green-500 rounded-xl flex items-center justify-center mr-4 shadow-md">
                  <span class="text-xl">🌱</span>
                </div>
                <h2 class="font-bold text-2xl text-green-700">Your Challenges</h2>
              </div>
              <div class="flex items-center">
                <div class="mr-4">
                  <select v-model="statusFilter" class="bg-white border border-gray-300 rounded-lg px-3 py-1.5 text-sm focus:outline-none focus:ring-2 focus:ring-green-500">
                    <option value="ALL">All Statuses</option>
                    <option value="NOT_STARTED">Not Started</option>
                    <option value="IN_PROGRESS">In Progress</option>
                    <option value="COMPLETED">Completed</option>
                    <option value="CANCELLED">Cancelled</option>
                  </select>
                </div>
                <button @click="resetForm" class="bg-green-500 text-white py-2 px-4 rounded-full flex items-center">
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-1" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
                  </svg>
                  New Challenge
                </button>
              </div>
            </div>
            
            <ul class="space-y-4">
              <li v-for="challenge in filteredChallenges" :key="challenge.challengesId" 
                  class="bg-white p-4 rounded-lg border border-gray-100 shadow-sm hover:shadow-md transition-shadow">
                <div class="flex justify-between items-center">
                  <div class="flex items-center">
                    <div class="w-10 h-10 bg-green-100 rounded-full flex items-center justify-center mr-3">
                      <span class="text-lg">🌿</span>
                    </div>
                    <div>
                      <span class="font-medium text-gray-800">{{ challenge.challengeName }}</span>
                      <div class="flex items-center mt-1">
                        <span class="text-xs text-gray-500">
                          Created: {{ formatDate(challenge.createdAt) }}
                        </span>
                        <span v-if="challenge.deadline" class="ml-3 text-xs text-orange-500">
                          Due: {{ formatDate(challenge.deadline) }}
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="flex items-center">
                    <span :class="getStatusBadgeClass(challenge.status)" class="px-2 py-1 rounded-full text-xs font-medium mr-3">
                      {{ formatStatus(challenge.status) }}
                    </span>
                    <div class="flex space-x-2">
                      <button @click="editChallenge(challenge.challengesId)" class="text-blue-500 hover:text-blue-700 p-2 rounded-full hover:bg-blue-50 transition-colors">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                          <path d="M13.586 3.586a2 2 0 112.828 2.828l-.793.793-2.828-2.828.793-.793zM11.379 5.793L3 14.172V17h2.828l8.38-8.379-2.83-2.828z" />
                        </svg>
                      </button>
                      <button @click="deleteChallenge(challenge.challengesId)" class="text-red-500 hover:text-red-700 p-2 rounded-full hover:bg-red-50 transition-colors">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                          <path fill-rule="evenodd" d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z" clip-rule="evenodd" />
                        </svg>
                      </button>
                    </div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
        
        <div class="lg:col-span-1">
          <div class="bg-white/80 backdrop-blur-sm p-6 rounded-xl shadow-md border border-green-100 sticky top-24">
            <div class="flex items-center mb-6">
              <div class="w-12 h-12 bg-gradient-to-br from-blue-400 to-blue-500 rounded-xl flex items-center justify-center mr-4 shadow-md">
                <span class="text-xl">{{ isEditing ? '✏️' : '✨' }}</span>
              </div>
              <h2 class="font-bold text-2xl text-blue-700">{{ isEditing ? 'Edit Challenge' : 'Create Challenge' }}</h2>
            </div>
            
            <form @submit.prevent="isEditing ? updateChallenge() : addChallenge()" class="space-y-4">
              <div>
                <label for="challengeName" class="block text-sm font-medium text-gray-700 mb-1">Challenge Name</label>
                <input 
                  id="challengeName"
                  v-model="challengeForm.challengeName" 
                  placeholder="e.g., Morning meditation by the lake" 
                  class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
                  required 
                />
              </div>
              
              <div class="flex justify-end space-x-3">
                <button 
                  v-if="isEditing" 
                  type="button" 
                  @click="resetForm" 
                  class="px-4 py-2 border border-gray-300 rounded-full text-gray-700 hover:bg-gray-100"
                >
                  Cancel
                </button>
                <button 
                  type="submit" 
                  class="bg-gradient-to-r from-green-500 to-blue-500 text-white py-2 px-6 rounded-full shadow-md hover:shadow-lg transition-shadow flex items-center"
                >
                  <span>{{ isEditing ? 'Update Challenge' : 'Create Challenge' }}</span>
                  <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 ml-2" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
                  </svg>
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div v-if="challenges.length === 0" class="text-center py-8">
        <p class="text-gray-500">You haven't created any challenges yet.</p>
        <button @click="resetForm" class="mt-4 bg-green-100 text-green-700 py-2 px-6 rounded-full hover:bg-green-200">
          Create your first challenge
        </button>
      </div>
      <div class="mt-6 bg-blue-50 p-4 rounded-xl border border-blue-100">
        <div class="flex items-center">
          <div class="w-8 h-8 bg-blue-100 rounded-full flex items-center justify-center mr-3">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-blue-500" viewBox="0 0 20 20" fill="currentColor">
              <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd" />
            </svg>
          </div>
          <p class="text-sm text-blue-800">
            Create meaningful challenges that connect you with nature.
          </p>
        </div>
      </div>
      <div class="bg-white/80 backdrop-blur-sm p-6 rounded-xl shadow-md border border-green-100 mb-12">
        <div class="flex items-center mb-6">
          <div class="w-12 h-12 bg-gradient-to-br from-purple-400 to-purple-500 rounded-xl flex items-center justify-center mr-4 shadow-md">
            <span class="text-xl">📊</span>
          </div>
          <h2 class="font-bold text-2xl text-purple-700">Your Progress</h2>
        </div>
        
        <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
          <div class="bg-gradient-to-br from-green-50 to-green-100 p-6 rounded-xl border border-green-200">
            <div class="text-4xl font-bold text-green-600 mb-2">{{ challenges.length }}</div>
            <div class="text-sm text-gray-600">Active Challenges</div>
          </div>
          
          <div class="bg-gradient-to-br from-blue-50 to-blue-100 p-6 rounded-xl border border-blue-200">
            <div class="text-4xl font-bold text-blue-600 mb-2">5</div>
            <div class="text-sm text-gray-600">Day Streak</div>
          </div>
          
          <div class="bg-gradient-to-br from-purple-50 to-purple-100 p-6 rounded-xl border border-purple-200">
            <div class="text-4xl font-bold text-purple-600 mb-2">37</div>
            <div class="text-sm text-gray-600">Total Completions</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from '../../Navbar/Navbar.vue';
import ChallengeService from '../../../services/ChallengeService';

export default {
    name: 'HomeAfterLogin',
    components: {
        Navbar
    },
    data() {
        return {
            challenges: [],
            challengeForm: {
                challengeName: ''
            },
            currentChallengeId: null,
            isEditing: false,
            statusFilter: 'ALL'
        }
    },
    mounted() {
        this.fetchChallenges();
    },
    methods: {
        fetchChallenges() {
            ChallengeService.getChallenges().then((response) => {
                this.challenges = response.data;
            });
        },
        addChallenge() {
            ChallengeService.createChallenge(this.challengeForm).then(() => {
                this.fetchChallenges();
                this.resetForm();
            });
        },
        editChallenge(challengeId) {
            const challenge = this.challenges.find(c => c.challengesId === challengeId);
            if (challenge) {
                this.currentChallengeId = challengeId;
                this.challengeForm = { 
                    challengeName: challenge.challengeName 
                };
                this.isEditing = true;
            }
        },
        updateChallenge() {
            ChallengeService.updateChallenge(this.currentChallengeId, this.challengeForm).then(() => {
                this.fetchChallenges();
                this.resetForm();
            });
        },
        deleteChallenge(id) {
            ChallengeService.deleteChallenge(id).then(() => {
                this.fetchChallenges();
            });
        },
        resetForm() {
            this.challengeForm = { challengeName: '' };
            this.currentChallengeId = null;
            this.isEditing = false;
        },
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
        getInitials(name) {
            return name.split(' ').map(n => n[0]).join('').toUpperCase();
        },
        getParticipantColor(index) {
            const colors = [
                'bg-blue-500',
                'bg-green-500',
                'bg-purple-500',
                'bg-yellow-500',
                'bg-red-500',
                'bg-indigo-500'
            ];
            return colors[index % colors.length];
        }
    },
    computed: {
        filteredChallenges() {
            if (this.statusFilter === 'ALL') {
                return this.challenges;
            }
            return this.challenges.filter(challenge => challenge.status === this.statusFilter);
        }
    }
}
</script>

<style scoped>

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

input:focus {
  box-shadow: 0 0 0 3px rgba(16, 185, 129, 0.2);
}

.rounded-lg {
  transition: all 0.2s ease;
}

.rounded-lg:hover {
  transform: translateY(-2px);
}
</style>