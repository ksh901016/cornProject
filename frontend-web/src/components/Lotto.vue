<template>
  <div>
    <div>
      <b-card title="로또 무료 추첨기" img-src="http://localhost:9090/lotto_main.jpg" img-top class="m-2">
        <b-card-text text-align="center">
          로또 번호를 추첨해드립니다.<br>
          행운을 빌께요.^^<br>
          ※ 당첨은 장담해드릴 수가 없습니다.(__)
        </b-card-text>
      </b-card>
    </div>
    <b-input-group>
      <b-form-input type="number" min="0" v-model="count" placeholder="Enter Lotto Count"></b-form-input>
      <b-input-group-append>
        <b-button variant="outline-primary" @click="lottery">추첨하기</b-button>
      </b-input-group-append>
    </b-input-group>
    <div style="width:300px;"v-for="(lottoBallList, index) in lottoList" :key="index" class="lotto m-2">
      <span v-for="(lottoBall, index) in lottoBallList" :key="index" :style="{'background-color': lottoBall.color.code}">{{lottoBall.number}}</span>
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
  .lotto span {
    background-image: url('http://i.imgur.com/gvS0kEU.png');
    height: 45px; width: 47px; padding-top: 13px;
    font-size: 12pt; color: #fff;
    text-align: center;  font-weight: bold;
    float: left
  }
</style>