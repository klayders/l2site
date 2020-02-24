import Vue from 'vue';
import Vuex from 'vuex';
import news from "./modules/news";
import messages from "./modules/messages";
import profile from "./modules/profile";


Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    messages,
    news,
    profile
  }
})
