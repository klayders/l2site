<template>
  <v-app style="background: url('https://i.artfile.me/wallpaper/18-05-2019/2560x1600/video-igry-heavenly-sword-mech-devushka--1459272.jpg') no-repeat center center fixed;
  -moz-background-size: 100%;
  -webkit-background-size: 100%;
  -o-background-size: 100%;
  background-size: 100%;">

    <v-app-bar app>
      <v-toolbar-title>
        <v-btn text color="primary" href="/">Lineage 2</v-btn>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn small text href="/messages">
        messages
      </v-btn>

      <div v-if="profile">
        <v-btn small text href="/profile">
          {{profile.displayName}}
        </v-btn>
        <v-btn icon href="/logout">
          <v-icon>mdi-exit-to-app</v-icon>
        </v-btn>

      </div>
      <div v-else>

        <v-toolbar-items>
          <login></login>
        </v-toolbar-items>

      </div>
    </v-app-bar>
    <v-footer app></v-footer>
    <router-view></router-view>

  </v-app>
</template>

<script>
    import {mapState} from 'vuex'
    import Login from "../components/auth/Login.vue";

    export default {
        name: "App",
        components: {
            Login
        },
        computed: mapState(["profile"]),
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
