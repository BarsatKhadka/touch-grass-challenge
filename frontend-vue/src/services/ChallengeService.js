import axios from 'axios';

const CHALLENGES_API_BASE_URL = 'http://localhost:8080/api/challenges';

class ChallengeService {
    getChallenges() {
        return axios.get(CHALLENGES_API_BASE_URL, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('jwt')}`
            }
        });
    }
    createChallenge(challenge) {
        return axios.post(CHALLENGES_API_BASE_URL, challenge, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('jwt')}`
            }
        });
    }
    updateChallenge(id, challenge) {
        return axios.put(`${CHALLENGES_API_BASE_URL}/${id}`, challenge, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('jwt')}`
            }
        });
    }
    deleteChallenge(id) {
        return axios.delete(`${CHALLENGES_API_BASE_URL}/${id}`, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('jwt')}`
            }
        });
    }

}

export default new ChallengeService();