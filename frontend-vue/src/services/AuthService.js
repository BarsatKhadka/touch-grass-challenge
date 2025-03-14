import axios from 'axios';

const AUTH_API_BASE_URL = 'http://localhost:8080/public/auth';

class AuthService {
    
    signup(signUpRequest) {
        return axios.post(`${AUTH_API_BASE_URL}/register`, signUpRequest);
    }
    

    login(loginRequest) {
        return axios.post(`${AUTH_API_BASE_URL}/login`, loginRequest);
    }
    
    setToken(token) {
        localStorage.setItem('jwt', token);
    }
    

    getToken() {
        return localStorage.getItem('jwt');
    }
    
    
    isAuthenticated() {
        return this.getToken() != null;
    }
    

    logout() {
        localStorage.removeItem('jwt');
    }
}

export default new AuthService();