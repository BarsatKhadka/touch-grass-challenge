<template>
    <div class="min-h-screen bg-gradient-to-br from-gray-900 via-blue-900 to-indigo-900">
        <Navbar />
        <div class="max-w-6xl mx-auto px-4 py-8 sm:px-6 lg:px-8">
            <h1 class="text-4xl font-extrabold text-gray-100 mb-8">Achievements</h1>
            <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
                <div v-for="achievement in achievements" :key="achievement.id" class="bg-white rounded-lg shadow-lg p-6 flex items-center space-x-4">
                    <div class="flex-shrink-0">
                        <div class="h-12 w-12 rounded-full border-2 border-gray-300 flex items-center justify-center text-gray-700 font-bold">
                            {{ achievement.icon }}
                        </div>
                    </div>
                    <div>
                        <h2 :class="{ unlocked: achievement.unlocked }" class="text-lg font-semibold">{{ achievement.name }}</h2>
                        <p v-if="achievement.unlocked" class="text-green-500">Unlocked</p>
                        <p v-else class="text-gray-500">Locked</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import ChallengeService from '../../../../services/ChallengeService.js';
import Navbar from '../../../Navbar/Navbar.vue';

export default {
    name: 'Achievements',
    components: {
        Navbar
    },
    data() {
        return {
            challenges: [],
            achievements: [
                { id: 1, name: "First Step", icon: "🌱", unlocked: false },
                { id: 2, name: "High Five", icon: "🌿", unlocked: false },
                { id: 3, name: "Tenacious Ten", icon: "🌳", unlocked: false },
                { id: 4, name: "Twenty Triumphs", icon: "🌻", unlocked: false },
                { id: 5, name: "Fifty Finesse", icon: "🏞️", unlocked: false }
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
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap');

body {
    font-family: 'Inter', sans-serif;
}

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

.unlocked {
    color: green;
    font-weight: bold;
}
</style>