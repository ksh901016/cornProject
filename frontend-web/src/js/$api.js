import axios from "axios";

const $api = axios.create({timeout: 20000});
$api.interceptors.response.use(response => {
  // 공통오류 처리
  return response;
}, error => alert(error));

export default $api;

