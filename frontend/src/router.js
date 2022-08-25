import { createWebHistory, createRouter } from "vue-router";
import Home from './components/views/Home.vue'
import Login from './components/views/Login.vue'
import List from './components/views/List.vue'


const routes = [

    {
        path: '/vue',
        name: 'home',
        component: Home
    }
    , {
        path: '/vue/login',
        name: 'login',
        component: Login
    }
    ,{
        path: '/vue/List',
        name: 'list',
        component: List
    }

];

const router = createRouter({
    history: createWebHistory(),
    base: process.env.BASE_URL,
    routes,
});

export default router;

