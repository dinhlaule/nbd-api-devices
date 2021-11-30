<template>
  <div id="app">
    <QLDHeader/>
    <QLDBody/>
  </div>
</template>

<script>
//import QLDAdd from './components/QLDAdd.vue'
import QLDBody from './components/QLDBody.vue'
import QLDHeader from './components/QLDHeader.vue'


export default {
  name: 'App',
  components: {
    QLDHeader,
    QLDBody
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
