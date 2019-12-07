import Vue from 'vue'

const messages = Vue.resource('/message{/id}')

export default {
  init: message => messages.get(message),
  add: message => messages.save({}, message),
  update: message => messages.update({id: message.id}, message),
  remove: id => messages.remove({id})
}
