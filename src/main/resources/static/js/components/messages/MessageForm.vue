<template>
  <div>
    <input type="text" placeholder="напиши сюда текст" v-model="text"/>
    <input type="button" style="position: relative; width: 100px;" value="Сохранить" @click="save"/>
  </div>
</template>

<script>
    function getIndex(list, id) {
        for (let i = 0; i < list.length; i++) {
            if (list[i].id === id) {
                return i;
            }
        }
        return -1;
    }

    export default {
        name: "MessageForm",
        props: ['messages', "messageAttr"],
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
            save() {
                const message = {text: this.text};
                if (this.id) {
                    this.$resource('/message{/id}').update({id: this.id}, message)
                        .then(result => result.json().then(data => {
                            const index = getIndex(this.messages, data.id);
                            this.messages.splice(index, 1, data);
                            this.id = '';
                            this.text = '';
                        }));
                } else {
                    this.$resource('/message{/id}').save({}, message).then(result =>
                        result.json().then(data => {
                            this.messages.push(data);
                            this.text = '';
                        }))
                }
            }
        }
    }
</script>

<style scoped>

</style>
