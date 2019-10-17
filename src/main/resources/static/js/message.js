var message_url = '/message{/id}';
var messageApi = Vue.resource(message_url);

Vue.component('message-form', {
  props: ['messages'],
  data: function () {
    return {
      text: ''
    }
  },
  template: '<div> ' +
    '<input type="text" placeholder="write here" v-model="text"/> ' +
    '<input type="button" value="Click for save" @click="save"/> ' +
    '</div>',
  methods: {
    save: function () {
      var message = {text: this.text};
      messageApi.save({}, message).then(result = >
      result.json().then(data = > {
        this.messages.push(data);
      this.text = '';
    }))
    }
  }
})

Vue.component('message-row', {
  props: ['message'],
  template:
    '<div>' +
    ' <i>({{message.id}})</i> {{message.text}}' +
    '<span>' +
    '<input type="button" value="Edit" @click="edit"/>' +
    '</span>' +
    '</div>',
  methods: {
    edit: function () {

    }
  }
});


Vue.component('message-list', {
  props: ['messages', 'editMethod'],
  data: function () {
    return {
      message: null
    }
  },
  template:
    '<div>' + '<message-form :messages="messages"/>' +
    '<message-row v-for="message in messages" :key="message.charName" :message="message" :editMethod="editMethod"/>' +
    '</div>',
  created: function () {
    messageApi.get()
      .then(result = >
    result.json()
      .then(data = > data.forEach(message = > this.messages.push(message)
  )))
  },
  methods: {
    editMethod: function () {
      this.message = message;
    }
  }
});

var messages = new Vue({
  el: '#messages',
  template: '<message-list :messages="messages"/>',
  data: {
    messages: []
  }
});
