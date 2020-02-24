<template>

  <div v-if="profile">

    <v-layout row>
      <v-text-field
        v-model="text"
        label="new message"
        hint="Hey!=)"
        placeholder="написать сообщение"
        :outlined="true"
        :rounded="true"
        :solo="true"
        :single-line="false"
        :filled="false"
        :clearable="true"
        :persistent-hint="true"
        :loading="false"
        :flat="false"
        :counter="0"
        :dense="true"
      ></v-text-field>
      <v-btn @click="save">Send</v-btn>
    </v-layout>

  </div>
</template>

<script>
    import {mapActions, mapState} from 'vuex'

    export default {
        name: "MessageForm",
        props: ["messageAttr"],
        computed: mapState(["profile"]),
        data() {
            return {
                text: '',
                id: '',
            }
        },
        watch: {
            messageAttr(newMessage, oldMessage) {
                this.text = newMessage.text;
                this.id = newMessage.id;
            }
        },
        methods: {
            ...mapActions(['updateMessageAction', 'addMessageAction']),
            save() {
                const message = {
                    id: this.id,
                    text: this.text
                };
                if (this.id) {
                    this.updateMessageAction(message);
                } else {
                    this.addMessageAction(message);
                }
                this.id = '';
                this.text = '';
            }
        }
    }
</script>

<style scoped>

</style>
