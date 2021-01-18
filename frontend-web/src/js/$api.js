import axios from "axios";
import common from "../store/modules/common"

const $api = axios.create({timeout: 20000});

$api.interceptors.response.use(response => {
  // 공통오류 처리
  return response;
}, error => alert(error));

$api.fetchWithLoadingProgress = function(apiUrl){
  common.state.loading = true;
  return $api.get(apiUrl).then(response => {
      common.state.loading = false;
      return response;
  });
};
export default $api;