<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100">
    <Navbar />
    <div class="max-w-6xl mx-auto px-4 py-8 sm:px-6 lg:px-8">
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8 mb-12">
        <div class="lg:col-span-2">
          <ChallengesList 
            :challenges="challenges"
            @new-challenge="resetForm"
            @edit-challenge="editChallenge"
            @delete-challenge="deleteChallenge"
            @update-status="quickUpdateStatus"
          />
        </div>
        
        <div class="lg:col-span-1">
          <div 
            class="challenge-form bg-white/80 backdrop-blur-sm p-6 rounded-xl shadow-md border sticky top-24 transition-all duration-500"
            :class="[
              isFormHighlighted 
                ? 'border-blue-400 shadow-lg shadow-blue-100 transform scale-105 ring-4 ring-blue-200' 
                : 'border-green-100'
            ]"
          >
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
              
              <div v-if="isEditing">
                <label for="status" class="block text-sm font-medium text-gray-700 mb-1">Status</label>
                <select 
                  id="status"
                  v-model="challengeForm.status" 
                  class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
                >
                  <option value="NOT_STARTED">Not Started</option>
                  <option value="IN_PROGRESS">In Progress</option>
                  <option value="COMPLETED">Completed</option>
                  <option value="CANCELLED">Cancelled</option>
                </select>
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
   
      <ProgressDashboard :challenges="challenges" />
    </div>
  </div>
</template>

<script>
import Navbar from '../../Navbar/Navbar.vue';
import ProgressDashboard from './ProgressDashboard.vue';
import ChallengesList from './ChallengeList.vue';
import ChallengeService from '../../../services/ChallengeService';

export default {
    name: 'HomeAfterLogin',
    components: {
        Navbar,
        ProgressDashboard,
        ChallengesList
    },
    data() {
        return {
            challenges: [],
            challengeForm: {
                challengeName: ''
            },
            currentChallengeId: null,
            isEditing: false,
            isFormHighlighted: false
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
            const newChallenge = {
                ...this.challengeForm,
                status: 'NOT_STARTED'
            };
            
            ChallengeService.createChallenge(newChallenge).then(() => {
                this.fetchChallenges();
                this.resetForm();
            });
        },
        editChallenge(challengeId) {
            const challenge = this.challenges.find(c => c.challengesId === challengeId);
            if (challenge) {
                this.currentChallengeId = challengeId;
                this.challengeForm = { 
                    challengeName: challenge.challengeName,
                    status: challenge.status || 'NOT_STARTED'
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
            this.challengeForm = { 
                challengeName: '',
                status: 'NOT_STARTED'
            };
            this.currentChallengeId = null;
            this.isEditing = false;
            
            
            this.isFormHighlighted = true;
            
            
            this.$nextTick(() => {
                setTimeout(() => {
                    const inputElement = document.getElementById('challengeName');
                    if (inputElement) {
                        inputElement.focus();
                    }
                }, 300);
            });
            
            
            setTimeout(() => {
                this.isFormHighlighted = false;
            }, 2000);
            
            
            if (window.innerWidth < 1024) {
                this.$nextTick(() => {
                    const formElement = document.querySelector('.challenge-form');
                    if (formElement) {
                        formElement.scrollIntoView({ behavior: 'smooth', block: 'start' });
                    }
                });
            }
        },
        quickUpdateStatus({ challengeId, status }) {
            const challenge = this.challenges.find(c => c.challengesId === challengeId);
            if (challenge) {
                const updatedChallenge = {
                    challengeName: challenge.challengeName,
                    status: status
                };
                ChallengeService.updateChallenge(challengeId, updatedChallenge).then(() => {
                    this.fetchChallenges();
                });
            }
        }
    }
}
</script>

<style scoped>
@keyframes highlight-pulse {
  0% {
    box-shadow: 0 0 0 0 rgba(96, 165, 250, 0.4);
  }
  70% {
    box-shadow: 0 0 0 10px rgba(96, 165, 250, 0);
  }
  100% {
    box-shadow: 0 0 0 0 rgba(96, 165, 250, 0);
  }
}

.challenge-form {
  transition: all 0.3s ease-in-out;
}

.challenge-form.transform {
  animation: highlight-pulse 2s 1;
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