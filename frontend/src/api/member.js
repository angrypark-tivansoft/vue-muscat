import httpAPI from './http';

export default{

    async getMemberList(paramData, successCallback, errorCallback) {
        return await httpAPI.post('vue/memberList', paramData, successCallback, errorCallback);
    },

    async insertMember(paramData, successCallback, errorCallback) {
        return await httpAPI.post('vue/insertMember', paramData, successCallback, errorCallback);
    }
}