<template>
  <v-app>
    <v-app-bar app>
      <v-app-bar-nav-icon/>
      <v-toolbar-title>Lineage 2</v-toolbar-title>
      <v-spacer></v-spacer>

      <span v-if="profile">{{profile.displayName}}</span>

      <v-btn v-if="profile" icon href="/logout">
        <v-icon>{{ svgPath }}</v-icon>
      </v-btn>
    </v-app-bar>

    <v-content>
      Необходимо авторизоваться или зарегистрироваться
      <login-form/>
      <registration/>

      <character-list/>
      <message-list :messages="messages"/>

    </v-content>
    <div v-if="!profile">

    </div>

  </v-app>
</template>

<script>
    import MessageList from "../components/messages/MessageList.vue";
    import LoginForm from "../components/login/LoginForm.vue";
    import Registration from "../components/registration/Registration.vue";
    import CharacterList from "../components/character/CharacterList.vue";
    import {mdiExitToApp} from '@mdi/js'

    export default {
        name: "App",
        components: {
            CharacterList,
            Registration,
            MessageList, LoginForm
        },
        data() {
            return {
                svgPath: mdiExitToApp,
                messages: frontendData.messages,
                profile: frontendData.profile
            }
        }
    }
</script>

<style scoped>
</style>
