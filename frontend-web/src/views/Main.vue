<template>
  <div>
    <b-nav tabs>
      <b-nav-item active to="/main/lotto">로또추첨기</b-nav-item>
      <b-nav-item to="/main/portfolio">Portfolio</b-nav-item>
    </b-nav>
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: "Main"
  }
</script>

<style scoped>

</style>