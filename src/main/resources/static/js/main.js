import Vue from 'vue'
import App from 'pages/App.vue'
import VueResource from 'vue-resource'

Vue.use(VueResource);

new Vue({
  el: '#messages',
  render: a => a(App)
})
