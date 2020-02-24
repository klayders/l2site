<template>
  <div>
    <i>({{user.id}})</i>
    {{user.charName}}
    {{user.title}}
  </div>
</template>

<script>
    export default {
        name: "CharacterRow",
        props: ["user"]
    }
</script>

<style scoped>

</style>
