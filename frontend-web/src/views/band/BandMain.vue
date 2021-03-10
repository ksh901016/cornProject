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
      <label class="mr-1">딜레이 : </label>
      <input type="number" min="10" value="10" style="width:50px;">
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
        coolTime: 10
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
      }
    }
  }
</script>

<style scoped>

</style>