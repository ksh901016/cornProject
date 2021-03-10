<template>
  <div>
    Login Success!!
  </div>
</template>

<script>
import $api from "../../js/$api"
export default {
  name: "TokenCallback",
  created() {
    console.log("Token Callback Success!!" + this.$route.query.code);
    $api.fetchWithLoadingProgress(`/api/band/auth/token/${this.$route.query.code}`).then(response =>{
      if(response.data.code === 0){
        alert("로그인 성공!");
        window.close();
      }else{
        alert("로그인 오류");
      }
    });
  }
}
</script>

<style scoped>

</style>