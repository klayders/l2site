import Vue from 'vue'
import 'api/resource.js'
import router from "./router/router";
import App from 'pages/App.vue'
import vuetify from "./plugin/vuetify";
import store from "./store/store";
import '@babel/polyfill'
import 'vuetify/dist/vuetify.min.css'
import {i18n} from "./plugin/i18n"
import FlagIcon from 'vue-flag-icon'

let SocialSharing = require('vue-social-sharing');
Vue.use(SocialSharing);
Vue.use(FlagIcon);

new Vue({
  i18n,
  store,
  router,
  render: a => a(App),
  vuetify,
}).$mount("#app");
