import http from "./http";

export default {

    async getListHttp(data) {
        return http.post('vue/getListHttp',data);
    },

    async getListRest(data) {
        return http.post('vue/getListRest',data);
    },

    async postListRest(data) {
        return http.post('vue/postListRest',data);
    }

}