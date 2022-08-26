import Vuex from 'vuex'

const store = new Vuex.Store({
    state: {
// State는 쉽게 생각하면 공통으로 참조하기 위한 변수를 정의한 것이다.
// 프로젝트의 모든 곳에서 이를 참조하고 사용할 수 있다.
// 모든 컴포넌트들에서 공통된 값을 사용할 수 있다.
        loginState : false,
        cartMemberList : []
    },

    mutations: {
// State 변경을 담당한다. 반드시 Mutation을 통해서만 State를 변경해야 한다.
// 동기 처리 기준이다. commit('함수명, '전달인자') 방식으로 호출한다.

        UPDATE_LOGIN_STATE(state, payload) {
            state.loginState = payload;
        },

        UPDATE_CART_MEMBER_LIST(state, payload) {
            state.cartMemberList = payload;
        }
    },

    actions: {

        setLoginState : function() {

        },

        setcartMemberList : function({ commit }, cartMemberList) {
            commit('UPDATE_CART_MEMBER_LIST', cartMemberList);
        }

    },

    getters : {

        getcartMemberList : function(state) {
            return state.cartMemberList;
        }
    }

});

export default store;