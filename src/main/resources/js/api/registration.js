import Vue from 'vue'

const registration = Vue.resource('/api/registration');

export default {
  addNewUser: regForm => registration.save({}, regForm),
}
