import Vue from 'vue'
import VueRouter from 'vue-router'
import MessageList from "../pages/MessageList.vue";
import Profile from "../pages/Profile.vue";
import App from "../pages/App.vue";


Vue.use(VueRouter);

const routes = [
  {path: '*', component: App},
  {path: '/messages', component: MessageList},
  {path: '/profile', component: Profile},
  // {path: '/registration', component: Registration},
];

export default new VueRouter({
  mode: 'history',
  routes
})
