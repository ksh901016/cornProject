<template>
  <div>
    <div align="center" style="margin-top:5px;margin-bottom: 5px;">
      로또 자동 추첨기입니다.<br>
      수를 입력하세요.<br>
      행운을 빕니다.
    </div>
    <b-input-group>
      <b-form-input type="number" min="0" v-model="count" placeholder="Enter Lotto Count"></b-form-input>
      <b-input-group-append>
        <b-button variant="outline-primary" @click="lottery">추첨하기</b-button>
      </b-input-group-append>
    </b-input-group>
    <div v-for="(lottoBallList, index) in lottoList" :key="index" class="lotto">
      <div v-for="(lottoBall, index) in lottoBallList" :key="index" :style="{'background-color': lottoBall.color.code}">{{lottoBall.number}}</div>
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
          alert("1회 이상 필수로 입력하셔야 되요~");
        }
        $api.fetchWithLoadingProgress(`/api/lotto/${this.count}`).then(response => {
          if(response.data.code === 0){
            //console.log(response.data.result);
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
  .lotto div {
    background-image: url('http://i.imgur.com/gvS0kEU.png');
    height: 45px; width: 47px; padding-top: 13px;
    font-size: 12pt; color: #fff;
    text-align: center;  font-weight: bold;
    float: left
  }
</style>