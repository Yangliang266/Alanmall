<template>
    <div>
        <y-header></y-header>
        <p>this is test</p>
        <a href="" @click="test">test</a>
        <y-footer></y-footer>
    </div>
</template>

<script>
import { getAllTest } from '../../api/index.js'
import YHeader from '../../common/header'
import YFooter from '../../common/footer'
export default {
   data () {
       return {
           // todo
       }
   },
   methods: {
        test() {
           getAllTest().then(res => {
               if (res.success) {
                    this.$router.push({
                        path: '/user'
                    })
               }
           })
       }
    },
    // mounted () {
    //     this.test();
    // },
    components: {
        YHeader,
        YFooter
    }
}
</script>

