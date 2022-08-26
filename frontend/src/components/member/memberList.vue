<template>

    <div class="d-flex justify-content-between mb-3">
        <h2>Member List</h2>
    </div>

    <div>
        <input class="form-control"  type="text"  v-model="paramData.userId" placeholder="사용자ID">
        <input class="form-control"  type="text"  v-model="paramData.pswd" placeholder="비밀번호">
        <input class="form-control"  type="text"  v-model="paramData.userNm" placeholder="사용자명">
        <input class="form-control"  type="text"  v-model="paramData.pstn" placeholder="직급">
        <input class="form-control"  type="text"  v-model="paramData.blngTo" placeholder="소속">
        <input class="form-control"  type="text"  v-model="paramData.cellNo" placeholder="휴대폰번호">
        <input class="form-control"  type="text"  v-model="paramData.mail" placeholder="이메일">
        <input class="form-control"  type="text"  v-model="paramData.entrDate" placeholder="가입일자">
    </div>
    <button 
        class="btn btn-primary"
        @click="insertMember"
    >저장</button>


    <hr />
    <div>
        <table>
            <tr>
                <td>선택</td>
                <td>사용자ID</td>
                <td>사용자명</td>
                <td>직급</td>
                <td>소속</td>
                <td>휴대폰번호</td>
                <td>이메일</td>
                <td>가입일자</td>
            </tr>
            <tr v-for="(item, index) in this.memeberList" :key="index">
                <td>
                    <input type="checkbox" :value="item" v-model="this.checkMemberList">
                </td>
                <td>{{ item.userId }}</td>
                <td>{{ item.userNm }}</td>
                <td>{{ item.pstn }}</td>
                <td>{{ item.blngTo }}</td>
                <td>{{ item.cellNo }}</td>
                <td>{{ item.mail }}</td>
                <td>{{ item.entrDate }}</td>
            </tr>
        </table>
        <button class="btn btn-primary" @click="setStore">STORE 담기</button>

        <hr />
        <table>
            <tr>
                <td>사용자ID</td>
                <td>사용자명</td>
                <td>직급</td>
                <td>소속</td>
                <td>휴대폰번호</td>
                <td>이메일</td>
                <td>가입일자</td>
            </tr>
            <tr v-for="(item, index) in this.$store.state.cartMemberList" :key="index">
                <td>{{ item.userId }}</td>
                <td>{{ item.userNm }}</td>
                <td>{{ item.pstn }}</td>
                <td>{{ item.blngTo }}</td>
                <td>{{ item.cellNo }}</td>
                <td>{{ item.mail }}</td>
                <td>{{ item.entrDate }}</td>
            </tr>
        </table>

    </div>

</template>

<script>
import { mapGetters } from 'vuex'
import memberAPI from '@/api/member'
  
export default {

    mounted() {
        this.getMemberList();
    },

    computed: mapGetters({
        storeMemberList : 'getcartMemberList'
    }),

    data() {
        return {
            checkMemberList : [],
            memeberList : [],
            storeMemberList : [],

            paramData : {
                userId : '',
                pwd : '',
                userNm : '임양채',
                pstn : '차장',
                blngTo : '티반',
                cellNo : '010-9999-9999',
                mail : 'aaa@naver.com',
                entrDate : '20220825',
            }
        }
    },

    methods : {

        getMemberList : function() {
            let paramData = {

            };
            
            memberAPI.getMemberList(paramData, 
                (response) => {
                    console.log("[ getMemberList ] success");
                    this.memeberList = response.data.memberList;
                }
            );

        },

        insertMember : function() {
            memberAPI.insertMember(this.paramData,
                (response) => {
                    console.log("[ insertMember ] success");
                    console.log(response);
                }
            );
        },

        setStore : function() {
            this.$store.dispatch("setcartMemberList", this.checkMemberList);
        },

    }

}
</script>

<style>

</style>