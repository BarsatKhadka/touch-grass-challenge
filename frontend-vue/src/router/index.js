import { createRouter, createWebHistory } from 'vue-router';


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/home',
            component: () => import('../components/Home/AfterLogin/HomeAfterLogin.vue')
        },
        {
            path: '/',
            component: () => import('../components/Home/BeforeLogin/Home.vue')
        },
        {
            path: '/login',
            component: () => import('../components/Login/LoginPage.vue')
        },
        {
            path: '/register',
            component: () => import('../components/Login/SignUpPage.vue')
        },
        {
            path: '/profile',
            component: () => import('../components/Profile/ProfilePage.vue')
        }
    ]
});

export default router