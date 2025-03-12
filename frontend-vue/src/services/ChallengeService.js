import axios from 'axios';

const CHALLENGES_API_BASE_URL = 'http://localhost:8080/api/challenges';

class ChallengeService {
    getChallenges() {
        return axios.get(CHALLENGES_API_BASE_URL);
    }
}

export default new ChallengeService();