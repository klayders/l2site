<template>
  <div>
    <i>({{message.id}})</i>
    {{message.text}} Дата: {{message.creationDate}}
    <span style="position: absolute; right: 0">
        <input type="button" value="Редактировать" @click="edit"/>
        <input type="button" value="Удалить" @click="del"/>
    </span>
  </div>
</template>

<script>
    export default {
        name: "MessageRow",
        props: ["message", "editMessage", "deleteMessage", "messages"],
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

</style>
