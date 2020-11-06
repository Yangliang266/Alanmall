<template>
  <div id="app">
    <router-view class="main" v-if="isRouterAlive"></router-view>
  </div>
</template>

//  <script>
// export default {
//   name: 'App'
// }
// </script>


<script>
export default {
  name: 'App',
  provide (){
     return {
       reload:this.reload
     }
  },
  data(){
    return {
       isRouterAlive:true
    }
  },
  methods:{
    reload (){
       this.isRouterAlive = false
       this.$nextTick(function(){
          this.isRouterAlive = true
       })
    }
  }
}
</script>

<style>
#app {
  height: 100%;
}

.main {
    background: #ededed;;
  }
</style>
