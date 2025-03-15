<template>
  <div class="min-h-screen bg-gradient-to-br from-gray-900 via-blue-900 to-indigo-900">
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
          <CreateChallengeForm
            :is-editing="isEditing"
            :current-challenge="challengeForm"
            :is-form-highlighted="isFormHighlighted"
            @submit-form="handleFormSubmit"
            @cancel-edit="resetForm"
            ref="challengeForm"
          />
        </div>
      </div>
      <div v-if="challenges.length === 0" class="text-center py-8">
        <p class="text-gray-300">You haven't created any challenges yet.</p>
        <button @click="resetForm" class="mt-4 bg-green-800 text-green-100 py-2 px-6 rounded-full hover:bg-green-700">
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
import CreateChallengeForm from './CreateChallengeForm.vue';
import ChallengeService from '../../../services/ChallengeService';

export default {
    name: 'HomeAfterLogin',
    components: {
        Navbar,
        ProgressDashboard,
        ChallengesList,
        CreateChallengeForm
    },
    data() {
        return {
            challenges: [],
            challengeForm: {
                challengeName: '',
                status: 'NOT_STARTED'
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
        handleFormSubmit(formData) {
            if (this.isEditing) {
                this.updateChallenge(formData);
            } else {
                this.addChallenge(formData);
            }
        },
        addChallenge(formData) {
            const newChallenge = {
                ...formData,
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
        updateChallenge(formData) {
            ChallengeService.updateChallenge(this.currentChallengeId, formData).then(() => {
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
            
            if (this.$refs.challengeForm) {
                this.$refs.challengeForm.focusInput();
            }
            
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
button {
  transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

button:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
}

button:active {
  transform: translateY(0) scale(0.98);
}
</style>