<template>
  <nav>
    <v-app-bar app color="brown darken-4">
      <!--      https://i.ytimg.com/vi/C4z6mpFOvdI/maxresdefault.jpg-->
      <v-img
        class="mx-2"
        src="js/assets/logo.png"
        max-height="40"
        max-width="40"
        contain
      ></v-img>

      <v-toolbar-title>
        <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <!--        <flag iso="us"></flag>-->

      <v-btn icon @click="setLocale('en')">
        EN
      </v-btn>
      <v-btn icon @click="setLocale('ru')">
        RU
      </v-btn>
      <v-btn small text href="https://discord.gg/aXQFmJ">
        {{$t('community')}}
      </v-btn>
      <v-btn small text href="/statistics">
        {{$t('statistics')}}
      </v-btn>
      <v-btn icon text href="/download">
        <v-icon>mdi-cloud-download</v-icon>
      </v-btn>
      <!--      <v-btn small text href="/messages">-->
      <!--        messages-->
      <!--      </v-btn>-->

      <div v-if="profile">
        <v-btn small text href="/profile">
          {{profile.displayName}}
        </v-btn>
        <v-btn small text href="/logout">
          <span class="error">{{$t('signOut')}}</span>
          <v-icon>mdi-logout</v-icon>
        </v-btn>
      </div>
      <div v-else>
        <v-toolbar-items>
          <sign-in></sign-in>
        </v-toolbar-items>
      </div>
    </v-app-bar>


    <v-navigation-drawer app expand-on-hover v-model="drawer">
      <v-img :aspect-ratio="16/9" src="js/assets/nav.jpg">
        <v-list-item>
          <v-list-item-avatar>
            <!--          <v-img-->
            <!--            src=""></v-img>-->
          </v-list-item-avatar>

          <v-list-item-title v-if="profile">
            {{profile.displayName}}
          </v-list-item-title>
          <v-list-item-title v-else>
            Welcome
          </v-list-item-title>
        </v-list-item>
      </v-img>

      <v-divider></v-divider>


      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <router-link :to="item.route" class="router-conf">

              <v-list-item-title>
                {{$t(item.title)}}
              </v-list-item-title>
            </router-link>
          </v-list-item-content>
        </v-list-item>
      </v-list>

    </v-navigation-drawer>

  </nav>
</template>

<script>
    import {mapGetters} from 'vuex'
    import SignIn from "../auth/SignIn.vue";
    import {i18n} from "../../plugin/i18n";

    export default {
        name: "MenuBar",
        components: {
            SignIn,
        },
        computed: mapGetters(["profile"]),
        data() {
            return {
                drawer: false,
                items: [
                    {title: 'home', icon: 'mdi-home-city', route: '/'},
                    {title: 'profile', icon: 'mdi-account', route: '/profile'},
                    {title: 'users', icon: 'mdi-account-group-outline', route: '/'},
                ],
            }
        },
        methods: {
            setLocale(locale) {
                i18n.locale = locale;
            }
        }
    }
</script>

<style scoped>
  .router-conf {
    color: inherit;
    text-decoration: none;
  }

  .v-navigation-drawer {
    transition: none !important;
  }

  .lightbox {
    box-shadow: 0 0 20px inset rgba(0, 0, 0, 0.2);
    background-image: linear-gradient(to top, rgba(0, 0, 0, 0.4) 0%, transparent 72px);
  }
</style>
