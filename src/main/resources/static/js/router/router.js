import Vue from 'vue'
import VueRouter from 'vue-router'
import MessageList from "../pages/MessageList.vue";
import Profile from "../pages/Profile.vue";
import NewsList from "../pages/NewsList.vue";
import Download from "../pages/Download.vue";


Vue.use(VueRouter);

const routes = [
  {path: '*', component: NewsList},
  {path: '/news', component: NewsList},
  {path: '/messages', component: MessageList},
  {path: '/profile', component: Profile},
  {path: '/download', component: Download},
  // {path: '/registration', component: Registration},
];

export default new VueRouter({
  mode: 'history',
  routes
})
