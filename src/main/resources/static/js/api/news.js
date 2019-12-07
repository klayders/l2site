import Vue from 'vue'

const newsApi = Vue.resource('/api/v1/news{/id}')

export default {
  init: () => newsApi.get(),
  add: message => newsApi.save({}, message),
  update: message => newsApi.update({id: message.id}, message),
  remove: id => newsApi.remove({id})
}
