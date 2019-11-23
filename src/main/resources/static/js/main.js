import Vue from 'vue'
import 'api/resource.js'
import App from 'pages/App.vue'
import vuetify from './plugin/vuetify'
import '@babel/polyfill'
import store from 'store/store'
import 'vuetify/dist/vuetify.min.css'


new Vue({
  el: '#app',
  store,
  render: a => a(App),
  vuetify,
});
