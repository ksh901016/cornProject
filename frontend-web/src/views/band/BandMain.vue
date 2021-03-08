<template>
  <div>
    I'm band Main
    <b-button variant="outline-primary" @click="login">로그인하기</b-button>
  </div>
</template>

<script>
  import $api from "../../js/$api"
  export default {
    name: "BandMain",
    methods: {
      login(){
        $api.fetchWithLoadingProgress("/api/band/auth/url").then(response => {
          alert(response.data);
          window.open(response.data, "popup", "width=500,height=600");
        });
      }
    }
  }
</script>

<style scoped>

</style>