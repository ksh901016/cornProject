<template>
  <div>
    <h1 @click="onClick">Hello Vue!</h1>
    <div @click="onSetLoading">
      setLoading : {{getLoading}}
    </div>
  </div>
</template>

<script>
  import {mapGetters, mapMutations} from "vuex";
  import $api from "../js/$api"
  export default {
    name: "Sample",
    methods: {
      ...mapMutations(['setLoading']),
      onClick(){
        $api.fetchWithLoadingProgress("/api/greeting").then(response => {
          alert(response.data);
        });
      },
      onSetLoading(){
        console.log(this.$store);
        this.setLoading(!this.getLoading);
      }
    },
    computed: {
      ...mapGetters(['getLoading'])
    }
  }
</script>

<style scoped>

</style>