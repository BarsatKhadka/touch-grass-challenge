<template>
  <div class="min-h-screen bg-gradient-to-br from-green-50 via-blue-50 to-indigo-100">
    <Navbar />
    <div class="max-w-6xl mx-auto px-4 py-8 sm:px-6 lg:px-8">
      <h1>Challenges</h1>
      <ul>
          <li v-for="challenge in challenges" :key="challenge.id">
              {{ challenge.challengeName }}
              <button @click="editChallenge(challenge.challengesId)">Edit</button>
              <button @click="deleteChallenge(challenge.challengesId)">Delete</button>
          </li>
      </ul>

      <h2>{{ isEditing ? 'Edit Challenge' : 'Add New Challenge' }}</h2>
      <form @submit.prevent="isEditing ? updateChallenge() : addChallenge()">
          <input v-model="challengeForm.challengeName" placeholder="Challenge Name" required />
          <button type="submit">{{ isEditing ? 'Update' : 'Add' }}</button>
      </form>
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