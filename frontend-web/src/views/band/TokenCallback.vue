<template>
  <div>
    Band Token Callback
  </div>
</template>

<script>
export default {
  name: "TokenCallback",
  created() {
    alert("Token Callback Success!!" + this.$route.query.code);
  }
}
</script>

<style scoped>

</style>