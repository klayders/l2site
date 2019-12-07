<template>
  <v-content>
    <v-layout align-space-around column>
      <news-row v-for="news in sortNews"
                :key="news.id"
                :news="news"/>
    </v-layout>
  </v-content>
</template>

<script>
    import NewsRow from "../components/news/NewsRow.vue";
    import {mapActions, mapGetters} from 'vuex';

    export default {
        name: "NewsList",
        components: {
            NewsRow
        },
        computed: mapGetters(['sortNews']),
        methods: {
            ...mapActions(['initNewsAction'])
        },
        mounted() {
            this.initNewsAction();
        }
    }
</script>

<style scoped>

</style>
