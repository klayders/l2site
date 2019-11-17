<template>
  <div>
    <character-row v-for="user in users" :key="user.charName" :user="user"/>
  </div>
</template>

<script>
    import CharacterRow from "./CharacterRow.vue";

    export default {
        props: ["users"],
        name: "CharacterList",
        components: {
            CharacterRow
        },
        created() {
            this.$resource('/api/v1/character{/id}').get().then(result =>
                result.json().then(data => {
                    data.forEach(user => this.users.push(user));
                })
            );
        }
    }
</script>

<style scoped>

</style>
