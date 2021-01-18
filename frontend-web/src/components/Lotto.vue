<template>
  <div>
    <div align="center" style="margin-top:5px;margin-bottom: 5px;">
      로또 자동 추첨기입니다.<br>
      수를 입력하세요.<br>
      행운을 빕니다. -Corn-
    </div>
    <b-input-group>
      <b-form-input type="number" min="0" v-model="count" placeholder="Enter Lotto Count"></b-form-input>
      <b-input-group-append>
        <b-button variant="outline-primary" @click="lottery">추첨하기</b-button>
      </b-input-group-append>
    </b-input-group>
    <div v-for="lottoNumber in lottoList" :key="lottoNumber">
      <span v-for="number in lottoNumber" :key="number">{{number}}</span>
    </div>
  </div>
</template>

<script>
  import $api from "../js/$api"
  export default {
    name: "Lotto",
    data(){
      return {
        count: 1,
        lottoList : []
      }
    },
    methods: {
      lottery(){
        if(this.count < 1){
          alert("1회 이상 입력하셔야 되요~갯");
        }
        $api.fetchWithLoadingProgress(`/api/lotto/${this.count}`).then(response => {
          if(response.data.code === 0){
            this.lottoList = response.data.result;
          }else{
            alert("오류다.");
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>