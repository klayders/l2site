import Vue from 'vue'
import 'api/resource.js'
import router from "./router/router";
import App from 'pages/App.vue'
import vuetify from "./plugin/vuetify";
import store from "./store/store";
import '@babel/polyfill'
import 'vuetify/dist/vuetify.min.css'


new Vue({
  store,
  router,
  render: a => a(App),
  vuetify,
}).$mount("#app");
