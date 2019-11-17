<template>
  <v-card shaped class="my-2 ">
    <v-card-text primary>
      <i>({{message.id}})</i>
      {{message.text}} Дата: {{message.creationDate}}
    </v-card-text>
    <v-card-actions>
      <v-btn small rounded @click="edit">
        <v-icon>{{iconEdit}}</v-icon>
      </v-btn>
      <v-btn small rounded @click="del">
        <v-icon>{{iconDel}}</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
    import {mdiCommentEdit, mdiDelete} from '@mdi/js'

    export default {
        name: "MessageRow",
        props: ["message", "editMessage", "deleteMessage", "messages"],
        data() {
            return {
                iconDel: mdiDelete,
                iconEdit: mdiCommentEdit,
            }
        },
        methods: {
            edit() {
                this.editMessage(this.message);
            },
            del() {
                this.deleteMessage(this.message)
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
