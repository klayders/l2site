<template>
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
        <v-icon>mdi-logout</v-icon>
      </v-btn>

    </div>
    <div v-else>

      <v-toolbar-items>
        <login></login>
      </v-toolbar-items>

    </div>
  </v-app-bar>
</template>

<script>
    import Login from "../auth/Login.vue";
    import {mapGetters} from 'vuex'

    export default {
        name: "MenuBar",
        components: {
            Login
        },
        computed: mapGetters(["profile"]),
    }
</script>

<style scoped>

</style>
