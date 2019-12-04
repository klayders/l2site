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
    import {mapGetters} from 'vuex';

    export default {
        name: "NewsList",
        components: {
            NewsRow
        },
        data() {
            return {
                news: null
            }
        },
        computed: mapGetters(['sortNews']),
        methods: {}
    }
</script>

<style scoped>

</style>
