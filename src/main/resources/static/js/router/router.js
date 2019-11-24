import Vue from 'vue'
import VueRouter from 'vue-router'
import MessageList from "../pages/MessageList.vue";
import Login from "../pages/Login.vue";
import Registration from "../pages/Registration.vue";


Vue.use(VueRouter);

const routes = [
  {path: '/', component: MessageList},
  {path: '/login', component: Login},
  {path: '/registration', component: Registration},
];

export default new VueRouter({
  mode: 'history',
  routes
})
