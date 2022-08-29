<template>
	<div>JUST DO IT</div>
	
	<div id="app">
		유저 이름: <input v-model="userName" type="text" >
		<button @click="searchName">검색</button>

		<div v-for="(item, idx) in computedList" :key="idx">
			제목: {{ item.title }} 
			저자: {{ item.author }}
		</div>
	</div>

</template>

<script>
// vuex 라이브러리에서 mapActions, mapGetters 함수를 가져옵니다.
import { mapActions, mapGetters } from 'vuex'

/*
  namespaced: true를 사용했기 때문에 선언해줍니다.
  index.js 에서 modules 객체의 '키' 이름입니다.

  modules: {
    키: 값
    userStore: userStore,
    postStore: postStore
  }  
*/
const userStore = 'userStore'
const postStore = 'postStore'
export default {
	data() {
		return {
			userName: ''
		}
	},

	computed: {
		/* 
			mapGetter는 store의 getters를 가져옵니다.

			네임스페이스를 사용하기 때문에 키 이름을 적어줍니다. (userStore, postStore)

			2가지 방식으로 가져올 수 있습니다.
			1) 이름 지정해서 가져오기
			2) getters 이름 그대로 사용해서 가져오기
		*/

		// 1) 이름 지정해서 가져오기
		...mapGetters(userStore, {
			storeUserName: 'GE_USER_NAME'
		}),

		// 2) getters 이름 그대로 사용해서 가져오기
		...mapGetters(postStore, [
			'GE_POST_LIST'
		]),

		// 스토어의 리스트 중에서 검색한 유저이름의 포스트 목록만 반환합니다.
		computedList() {
			let list = [];

			for( let item of this.GE_POST_LIST ) {
				if( item.author == this.storeUserName ) {
					list.push(item);
				}
			}

			return list;
		}
	},

	watch: {
		storeUserName(val) { // getters에 watch를 걸 수 있습니다.
			this.userName = val;
		}
	},

	created() {
		this.userName = this.storeUserName;
	},

	methods: {
		/* 
			mapGetter는 store의 getters를 가져옵니다.

			네임스페이스를 사용하기 때문에 키 이름을 적어줍니다. (userStore, postStore)

			2가지 방식으로 가져올 수 있습니다.
			1) 이름 지정해서 가져오기
			2) getters 이름 그대로 사용해서 가져오기      

			개인의 취향이지만, getters 이름 그대로 사용하는 것을 추천드립니다.

			다른 메소드 이름으로 매핑 예를 들면, setUserName: AC_USER_NAME 하면,
			setUserName 함수가 나중에는 스토어 함수인지, 현재 파일의 함수인지 헷갈리는 경우가 있습니다.
		*/
		...mapActions(userStore, [
			'AC_USER_NAME'
		]),

		searchName() {
			const payload = {
				userName : this.userName
			}
			this.AC_USER_NAME(payload); // store의 userName을 변경합니다.
		}
	}

}
</script>

<style>

</style>