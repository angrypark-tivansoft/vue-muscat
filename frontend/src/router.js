import { createWebHistory, createRouter } from "vue-router";
import Home from './components/views/Home.vue'
import Login from './components/views/Login.vue'

const routes = [

    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },

    {
        path: '/memberList',
        name: 'MemberList',
        component: () => import('@/components/member/memberList.vue'),
        meta: { auth : false }
    }


];

const router = createRouter({
    history: createWebHistory(),
    base: process.env.BASE_URL,
    routes,
});

/* router 화면 전환 시 */
router.beforeEach((to, from, next) => {
    // console.log('to -> ' + JSON.stringify(to)); // {"fullPath":"/memberList","hash":"","query":{},"name":"MemberList","path":"/memberList","params":{},"matched":[{"path":"/memberList","name":"MemberList","meta":{"auth":true},"props":{"default":false},"children":[],"instances":{},"leaveGuards":{},"updateGuards":{},"enterCallbacks":{},"components":{"default":{"methods":{},"__file":"src/components/member/memberList.vue","__hmrId":"b2f652e6"}}}],"meta":{"auth":true},"href":"/memberList"}
    // console.log('from -> ' + JSON.stringify(from)); // {"path":"/","params":{},"query":{},"hash":"","fullPath":"/","matched":[],"meta":{}}
    // console.log('next -> ' + next);

    if( to.meta.auth ){
        alert('로그인 해주세요.');
        next('/login');
        return;
    }

    next();
});

export default router;

