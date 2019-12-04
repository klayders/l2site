<template>
  <v-card shaped class="my-2 " color="rgb(0, 0, 0, 0.2)">
    <v-card-text primary>
      <i>({{news.id}})</i>
      {{news.title}}
      Дата: {{news.creationDate}}
      title {{news.description}}
    </v-card-text>
    <v-card-actions>
      <v-btn small rounded @click="edit">
        <v-icon>mdi-comment-edit</v-icon>
      </v-btn>
      <v-btn small rounded @click="del">
        <v-icon>mdi-delete</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
    import {mapActions} from 'vuex'

    export default {
        name: "NewsRow",
        props: ["news"],
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message);
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style scoped>

</style>
