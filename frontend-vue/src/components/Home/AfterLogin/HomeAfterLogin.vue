<template>
    <div>
        <h1>Challenges</h1>
        <ul>
            <li v-for="challenge in challenges" :key="challenge.id">
                {{ challenge.challengeName }}
            </li>
        </ul>
    </div>

</template>

<script>
import ChallengeService from '../../../services/ChallengeService';

export default {
    name: 'HomeAfterLogin',
    data() {
        return {
            challenges: []
        }
    },
    mounted() {
        ChallengeService.getChallenges().then((response) => {
            this.challenges = response.data;
        });
    }
}
</script>