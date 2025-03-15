import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/home',
        component: () => import('../components/Home/AfterLogin/HomeAfterLogin.vue'),
        meta: { requiresAuth: true }
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
        component: () => import('../components/Profile/Profile.vue'),
        meta: { requiresAuth: true }
    },
    {
        path: '/achievements',
        component: () => import('../components/Home/AfterLogin/Achievments/Achievments.vue'),
        meta: { requiresAuth: true }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    const isAuthenticated = !!localStorage.getItem('jwt');

    if (to.matched.some(record => record.meta.requiresAuth)) {
        if (!isAuthenticated) {
            next('/login');
        } else {
            next();
        }
    } else {
        next();
    }
});

export default router