<template>
  <div>
    <div class="mb-3">
      <b-button class="mr-1" variant="outline-primary" @click="login">로그인하기</b-button>
      <b-button variant="outline-primary" @click="getBandList">밴드조회</b-button>
    </div>
    <div class="mb-1">
      <b-form-checkbox-group
        v-model="selected"
        :options="bandList"
        class="mb-2"
        value-field="value"
        text-field="text"></b-form-checkbox-group>
      <div>Selected : <strong>{{selected}}</strong></div>
    </div>
    <div>
      <b-form-checkbox
        v-model="isInfinite">
        무한 전송 하기(최소 딜레이 10초) : {{isInfinite}}
      </b-form-checkbox>
      <b-form-textarea
        v-model="content"
        placeholder="내용"
        rows="5"
        no-resize>
      </b-form-textarea>
      <b-button class="mt-1" @click="post">전송</b-button>
    </div>
  </div>
</template>

<script>
  import $api from "../../js/$api"
  export default {
    name: "BandMain",
    data(){
      return{
        selected : [],
        bandList: [],
        coolTime: 10,
        isInfinite: false,
        contents: ""
      }
    },
    methods: {
      login(){
        $api.fetchWithLoadingProgress("/api/band/auth/url").then(response => {
          if(response.data.code === 0){
            window.open(response.data.result, "popup", "width=500,height=600");
          }else{
            alert("오류 발생");
          }
        });
      },
      getBandList(){
        $api.fetchWithLoadingProgress("/api/bands").then(response => {
          if(response.data.code === 0){
            const bandList = response.data.result.result_data.bands;
            bandList.forEach(band => this.bandList.push({text: band.name, value: band.band_key}));
          }else{
            alert("오류 발생");
          }
        });
      },
      post(){
        if(this.selected.length === 0){
          alert("밴드를 선택해 주세요.");
          return;
        }
        if(this.content.trim() === ''){
          alert("전송할 내용을 적어주세요.");
          return;
        }

        $api.post("/api/band/post", {"bandKeyList": this.selected, "content" : this.content}).then(response => {
          if(response.data.code === 0){
            alert("성공 !!");
          }
        });
      }
    }
  }
</script>

<style scoped>

</style>