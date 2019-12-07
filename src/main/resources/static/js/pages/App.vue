<template>
  <v-app style="background: url('https://i.artfile.me/wallpaper/18-05-2019/2560x1600/video-igry-heavenly-sword-mech-devushka--1459272.jpg') no-repeat center center fixed;
  -moz-background-size: 100%;
  -webkit-background-size: 100%;
  -o-background-size: 100%;
  background-size: 100%;">

    <menu-bar></menu-bar>

    <v-footer app></v-footer>
    <router-view></router-view>

  </v-app>
</template>

<script>
    import MenuBar from "../components/menu/MenuBar.vue";
    import {mapActions, mapGetters} from 'vuex';

    export default {
        name: "Main-App",
        components: {MenuBar},
        computed: mapGetters(['getProfile']),
        methods: {
            ...mapActions(['initProfileAction'])
        },
        mounted() {
            this.initProfileAction();
        }
    }
</script>

<style scoped>
  /*background: url('https://i.yapx.ru/EdgG6.gif') no-repeat center center fixed;*/
  /*-moz-background-size: 100%;*/
  /*-webkit-background-size: 100%;*/
  /*-o-background-size: 100%;*/
  /*background-size: 100%;*/

  /*main {*/
  /*  background: url('https://look.com.ua/pic/201209/1680x1050/look.com.ua-17669.jpg'); !*no-repeat center center fixed;*!*/
  /*  -moz-background-size: 100%; !* Firefox 3.6+ *!*/
  /*  -webkit-background-size: 100%; !* Safari 3.1+ и Chrome 4.0+ *!*/
  /*  -o-background-size: 100%; !* Opera 9.6+ *!*/
  /*  background-size: 100%; !* Современные браузеры *!*/
  /*}*/
</style>
