<template>
    <div>
        <h1>Achievements</h1>
        <ul>
            <li v-for="achievement in achievements" :key="achievement.id">
                <span :class="{ unlocked: achievement.unlocked }">{{ achievement.name }}</span>
            </li>
        </ul>
    </div>
</template>

<script>
import ChallengeService from '../../../../services/ChallengeService.js';

export default {
    name: 'Achievements',
    data() {
        return {
            challenges: [],
            achievements: [
                { id: 1, name: "First Step", unlocked: false },
                { id: 2, name: "High Five", unlocked: false },
                { id: 3, name: "Tenacious Ten", unlocked: false },
                { id: 4, name: "Twenty Triumphs", unlocked: false },
                { id: 5, name: "Fifty Finesse", unlocked: false }
            ]
        };
    },
    created() {
        this.loadChallenges();
    },
    methods: {
        async loadChallenges() {
            try {
                const response = await ChallengeService.getChallenges();
                this.challenges = response.data;
                this.evaluateAchievements();
            } catch (error) {
                console.error('Error fetching challenges:', error);
            }
        },
        evaluateAchievements() {
            const challengeCount = this.challenges.length;
            this.achievements.forEach(achievement => {
                if (
                    (achievement.id === 1 && challengeCount >= 1) ||
                    (achievement.id === 2 && challengeCount >= 5) ||
                    (achievement.id === 3 && challengeCount >= 10) ||
                    (achievement.id === 4 && challengeCount >= 20) ||
                    (achievement.id === 5 && challengeCount >= 50)
                ) {
                    achievement.unlocked = true;
                }
            });
        }
    }
};
</script>

<style scoped>
.unlocked {
    color: green;
    font-weight: bold;
}
</style>