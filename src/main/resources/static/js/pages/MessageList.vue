<template>
  <v-content>
    <v-layout align-space-around column>
      <message-form :messageAttr="message"/>
      <message-row v-for="message in sortMessages"
                   :key="message.id"
                   :message="message"
                   :editMessage="editMessage"/>
    </v-layout>
  </v-content>
</template>

<script>
    import MessageRow from "../components/messages/MessageRow.vue";
    import MessageForm from "../components/messages/MessageForm.vue";
    import {mapGetters} from 'vuex';

    export default {
        name: "MessageList",
        components: {
            MessageRow, MessageForm
        },
        data() {
            return {
                message: null
            }
        },
        computed: mapGetters(['sortMessages']),
        methods: {
            editMessage(message) {
                this.message = message;
            },

        }
    }
</script>

<style scoped>

</style>
