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
              <button @click="resetForm" class="bg-green-500 text-white py-2 px-4 rounded-full flex items-center">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-1" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
                </svg>
                New Challenge
              </button>
            </div>
            
            <ul>
              <li v-for="challenge in challenges" :key="challenge.id">
                  {{ challenge.challengeName }}
                  <button @click="editChallenge(challenge.challengesId)">Edit</button>
                  <button @click="deleteChallenge(challenge.challengesId)">Delete</button>
              </li>
            </ul>
          </div>
        </div>
        
        <div class="lg:col-span-1">
          <h2>{{ isEditing ? 'Edit Challenge' : 'Add New Challenge' }}</h2>
          <form @submit.prevent="isEditing ? updateChallenge() : addChallenge()">
              <input v-model="challengeForm.challengeName" placeholder="Challenge Name" required />
              <button type="submit">{{ isEditing ? 'Update' : 'Add' }}</button>
          </form>
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
            isEditing: false
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
        }
    }
}
</script>