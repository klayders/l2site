import Vue from 'vue'

const newsApi = Vue.resource('/api/v1/account/profile');

export default {
  init: () => newsApi.get(),
}
