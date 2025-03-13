import axios from 'axios';

const CHALLENGES_API_BASE_URL = 'http://localhost:8080/api/challenges';

class ChallengeService {
    getChallenges() {
        return axios.get(CHALLENGES_API_BASE_URL);
    }
    createChallenge(challenge) {
        return axios.post(CHALLENGES_API_BASE_URL, challenge);
    }
    updateChallenge(id, challenge) {
        return axios.put(`${CHALLENGES_API_BASE_URL}/${id}`, challenge);
    }
    deleteChallenge(id) {
        return axios.delete(`${CHALLENGES_API_BASE_URL}/${id}`);
    }

}

export default new ChallengeService();