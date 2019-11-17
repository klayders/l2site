<template>
  <div>
    <div v-if="!profile">
      Необходимо авторизоваться или зарегистрироваться
      <login-form/>
      <registration/>
    </div>
    <div v-else>
      <div>{{profile.displayName}}&nbsp;<a href="/logout">Выйти</a></div>
      <character-list/>
      <message-list :messages="messages"/>
    </div>
  </div>
</template>

<script>
    import MessageList from "../components/messages/MessageList.vue";
    import LoginForm from "../components/login/LoginForm.vue";
    import Registration from "../components/registration/Registration.vue";
    import CharacterList from "../components/character/CharacterList.vue";

    export default {
        name: "App",
        components: {
            CharacterList,
            Registration,
            MessageList, LoginForm
        },
        data() {
            return {
                messages: frontendData.messages,
                profile: frontendData.profile
            }
        }
    }
</script>

<style scoped>

</style>
