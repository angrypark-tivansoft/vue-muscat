import httpAPI from "./http";

export default {
    async getLogin(paramData, successCallback, errorCallback) {
        return await httpAPI.post('vue/login', paramData, successCallback, errorCallback);
    }
}