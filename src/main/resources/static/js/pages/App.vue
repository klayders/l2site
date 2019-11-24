<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>Lineage 2</v-toolbar-title>
      <v-spacer></v-spacer>

      <div v-if="profile">
        <span>{{profile.displayName}}</span>
        <v-btn icon href="/logout">
          <v-icon>mdi-exit-to-app</v-icon>
        </v-btn>
      </div>
      <div v-else>
        <v-btn icon href="/login">
          <v-icon>mdi-login-variant</v-icon>
        </v-btn>
      </div>

    </v-app-bar>

    <v-content>
      <v-container v-if="profile">
        <!--        <message-list/>-->
      </v-container>


      <!--      <character-list/>-->

    </v-content>
    <router-view></router-view>
  </v-app>
</template>

<script>
    import {mapState} from 'vuex'

    export default {
        name: "App",
        computed: mapState(["profile"]),
    }
</script>

<style scoped>
  /*main {*/
  /*  background: url('https://look.com.ua/pic/201209/1680x1050/look.com.ua-17669.jpg'); !*no-repeat center center fixed;*!*/
  /*  -moz-background-size: 100%; !* Firefox 3.6+ *!*/
  /*  -webkit-background-size: 100%; !* Safari 3.1+ и Chrome 4.0+ *!*/
  /*  -o-background-size: 100%; !* Opera 9.6+ *!*/
  /*  background-size: 100%; !* Современные браузеры *!*/
  /*}*/
</style>
