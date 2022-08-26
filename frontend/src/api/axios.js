import axios from 'axios';

// Add a request interceptor
axios.interceptors.request.use(
    (config) => {
        // Do something before request is sent
        config.headers["Content-Type"] = "application/json; charset=utf-8";
        
        console.log('request interceptor!!!!');
        return config;
    },
    (error) => {
        // Do something with request error
        return Promise.reject(error);
    }
);
  
// Add a response interceptor
axios.interceptors.response.use(
    (response) => {
        // Any status code that lie within the range of 2xx cause this function to trigger
        // Do something with response data
        console.log('response interceptor!!!!');
        return response;
    }, 
    (error) => {
        // Any status codes that falls outside the range of 2xx cause this function to trigger
        // Do something with response error
        return Promise.reject(error);
    }
);

export default axios;