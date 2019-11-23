<template>
  <v-card shaped class="my-2 ">
    <v-card-text primary>
      <i>({{message.id}})</i>
      {{message.text}} Дата: {{message.creationDate}}
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
        name: "MessageRow",
        props: ["message", "editMessage"],
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
  .transparent {
    /*background-color: #ff3642 !important;*/
    /*opacity: 0.95;*/
    /*border-color: transparent!important;*/
  }
</style>
