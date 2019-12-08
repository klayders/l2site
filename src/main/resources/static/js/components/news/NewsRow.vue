<template>
  <v-card
    class="mx-auto my-2 pa-md-4 "
    outlined
    v-ripple="{ center: true }"
    width="500"
    color="rgb(0, 0, 0, 0.2)">


    <v-card-title>{{news.title}}</v-card-title>

    <v-card-subtitle class="pb-0">{{news.creationDate}}</v-card-subtitle>

    <v-card-text class="text--primary">
      <div>{{news.description}}</div>
    </v-card-text>

    <v-card-actions>
      <social-helper></social-helper>

      <v-btn color="orange" text>
        Explore
      </v-btn>
    </v-card-actions>
  </v-card>

</template>

<script>
    import SocialHelper from "../social/SocialHelper.vue";

    export default {
        name: "NewsRow",
        components: {SocialHelper},
        props: ["news"],
        methods: {
        }
    }
</script>

<style scoped>

</style>
