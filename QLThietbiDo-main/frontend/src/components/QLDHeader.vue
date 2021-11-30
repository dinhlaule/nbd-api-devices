<template>
    <header style="background-color: #CCFFFF;">
        <div class="text-logo">{{msg}}</div>

    </header>
</template>
<script>

export default {
   name: 'qld-header',
   data(){
       return{
           msg: 'Quản lý thiết bị đo'
       }
   }
}
</script>
<style>
  header{
      height: 70px;
      position: absolute;
      width: 100%;
      top : 0;
      left: 0;
      padding: 0 20px;
      z-index: 1;
      box-sizing: border-box;

  }
  .text-logo {
      display: inline-block;
      vertical-align: middle;
      border-style: none;
      position: relative;
      top : 15px;
      left: 20px;
      font-size: 30px;
      font-style: italic;
      color: #000;
  }

</style>
