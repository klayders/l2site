<template>
  <v-app
    style="background: url('js/assets/DePfho.jpg') no-repeat center center fixed;
  background-size: cover;
">

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

<style>

</style>
