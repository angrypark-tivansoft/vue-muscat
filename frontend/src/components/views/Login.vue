<template>
    <div class="wrap">
        <li>
            <router-link :to="{name: 'home'}">
                Home
            </router-link>
        </li>
        <div class="loginBox">
            <h1><img src="/img/loginLogo.png" alt=""/></h1>
                <ul class="">
                    <li><label>아이디</label><input type="text" :value="userId" @input="userId = $event.target.value"/></li>
                    <li><label>패스워드</label><input type="password" :value="pswd" @input="pswd = $event.target.value"/></li>
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
                 common: []
             }
        },
        created() {

        },

        methods: {
         getLogin: function(){

             const data = {
                 userId : this.userId,
                 pswd: this.pswd,
                 msg: '로그인입니다.'
             }

             loginApi.getLogin(data).then(response => {
                 alert(JSON.stringify(response.data));
                this.common = response.data.commonVO;
             });

         }

        }

    }

</script>
