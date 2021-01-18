<template>
  <div id="app">
    <router-view/>
    <div :style="getLoading? '' : 'display:none'">
      <b-spinner></b-spinner>
    </div>
  </div>
</template>
<script>
  import {mapGetters} from "vuex";
  export default{
    name: 'App',
    computed: {
      ...mapGetters(['getLoading'])
    },
    created() {
      console.log(process.env);
    }
  }
</script>
<style>
  #app{
    margin: 5px;
  }
</style>
