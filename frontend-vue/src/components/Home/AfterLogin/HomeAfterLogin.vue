<template>
    <div>
        <h1>Challenges</h1>
        <ul>
            <li v-for="challenge in challenges" :key="challenge.id">
                {{ challenge.challengeName }}
                <button @click="editChallenge(challenge)">Edit</button>
                <button @click="deleteChallenge(challenge.challengesId)">Delete</button>
            </li>
        </ul>

        <h2>{{ isEditing ? 'Edit Challenge' : 'Add New Challenge' }}</h2>
        <form @submit.prevent="isEditing ? updateChallenge() : addChallenge()">
            <input v-model="challengeForm.challengeName" placeholder="Challenge Name" required />
            <button type="submit">{{ isEditing ? 'Update' : 'Add' }}</button>
        </form>
    </div>
</template>

<script>
import ChallengeService from '../../../services/ChallengeService';

export default {
    name: 'HomeAfterLogin',
    data() {
        return {
            challenges: [],
            challengeForm: {
                id: null,
                challengeName: ''
            },
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
        editChallenge(challenge) {
            this.challengeForm = { ...challenge };
            this.isEditing = true;
        },
        updateChallenge() {
            ChallengeService.updateChallenge(this.challengeForm.id, this.challengeForm).then(() => {
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
            this.challengeForm = { id: null, challengeName: '' };
            this.isEditing = false;
        }
    }
}
</script>