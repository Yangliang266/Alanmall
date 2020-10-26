<template>
    <div>
        <y-header></y-header>
        <router-view class="main"></router-view>
        <!-- <a href="" @click="click"></a> -->
        <y-footer></y-footer>
    </div>
</template>

<script>
import YHeader from '../common/header'
import YFooter from '../common/footer'
export default {
   data () {
       return {
           // todo
       }
   }
   ,
   components: {
       YHeader,
       YFooter
   }
}
</script>

