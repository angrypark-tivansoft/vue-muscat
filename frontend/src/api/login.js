import http from "./http";

export default {
    async getLogin(data) {
        return http.post('vue/test',data);
    }
}