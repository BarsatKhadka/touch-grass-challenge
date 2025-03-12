import { createRouter, createWebHistory } from 'vue-router';


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/home',
            component: () => import('../components/Home/HomeAfterLogin.vue')
        },
        {
            path: '/',
            component: () => import('../components/Home/Home.vue')
        }
    ]
});

export default router