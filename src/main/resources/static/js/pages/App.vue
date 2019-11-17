<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>Lineage 2</v-toolbar-title>
      <v-spacer></v-spacer>

      <span v-if="profile">{{profile.displayName}}</span>

      <v-btn v-if="profile" icon href="/logout">
        <v-icon>{{ svgPath }}</v-icon>
      </v-btn>
    </v-app-bar>

    <v-content>
      <v-container v-if="profile">
        <message-list :messages="messages"/>
      </v-container>
      <v-container v-else>
        Необходимо авторизоваться или зарегистрироваться
        <login-form/>
        <registration/>
      </v-container>

      <character-list/>
    </v-content>
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
  main {
    background: url('https://look.com.ua/pic/201209/1680x1050/look.com.ua-17669.jpg'); /*no-repeat center center fixed;*/
    -moz-background-size: 100%; /* Firefox 3.6+ */
    -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
    -o-background-size: 100%; /* Opera 9.6+ */
    background-size: 100%; /* Современные браузеры */
  }
</style>
