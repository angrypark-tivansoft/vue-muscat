import { createWebHistory, createRouter } from "vue-router";
import Home from './components/views/Home.vue'
import Login from './components/views/Login.vue'


const routes = [

    {
        path: '/vue',
        name: 'home',
        component: Home
    },
    {
        path: '/vue/login',
        name: 'login',
        component: Login
    }

];

const router = createRouter({
    history: createWebHistory(),
    base: process.env.BASE_URL,
    routes,
});

export default router;

