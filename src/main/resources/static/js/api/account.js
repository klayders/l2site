import Vue from 'vue'

const profileApi = Vue.resource('/api/v1/account/profile');

export default {
  init: () => profileApi.get(),
}
