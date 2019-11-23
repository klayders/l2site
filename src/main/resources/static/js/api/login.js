import Vue from 'vue'

const auth = Vue.resource('/login')

export default {
  authentication: loginForm => auth.save(loginForm, {emulateJSON: true})
}
