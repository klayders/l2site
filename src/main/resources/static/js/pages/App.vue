<template>
  <v-app>
    <v-toolbar dense max-height="50">

      <v-toolbar-title>
        <v-btn href="/">Lineage 2</v-btn>
      </v-toolbar-title>

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
    </v-toolbar>
    <!--    <v-parallax-->
    <!--      dark-->
    <!--      src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"-->
    <!--    >-->
    <router-view></router-view>
    <!--    </v-parallax>-->
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
</style>
