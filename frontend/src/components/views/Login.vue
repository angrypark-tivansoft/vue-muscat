<template>
    <div class="wrap">
        <li>
            <router-link :to="{name: 'Home'}">
                Home
            </router-link>
        </li>
        <div class="loginBox">
            <h1><img src="/img/loginLogo.png" alt=""/></h1>
                <ul class="">
                    <li><label>아이디</label><input type="text" v-model="userId" /></li>
                    <li><label>패스워드</label><input type="password" v-model="pswd" /></li>
                </ul>
                <p>
                    <button @click="getLogin">로그인</button>
                </p>
                <p>
                    <label>{{common.msg}}</label>
                </p>
        </div>



    </div>
</template>

<script>
    import loginApi from '@/api/login';
    export default {
        name: 'login',
        components : {

        },
        data() {
            return  {
                common: [],

                paramData : {
                   userId : '',
                   pswd : ''
                }
            }
        },
        created() {

        },

        methods: {
            getLogin: function(){

                loginApi.getLogin(this.paramData,
                    (res) => {
                        console.log(res);
                    },
                    (error) => {
                        console.log(error);
                    }
                );
            }
        }
    }

</script>
