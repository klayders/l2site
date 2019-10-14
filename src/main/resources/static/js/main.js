var siteApi = Vue.resource()

Vue.component('user-row', {
  props: ['user'],
  template:
    '<div> <i>({{user.lastactive}})</i>' +
    '{{user.name}}' +
    '</div>'
});


Vue.component('user-list', {
  props: ['users'],
  template:
    '<div>' +
    '<user-row v-for="user in users" :key="user.name" :user="user"/>' +
    '</div>'
});

var apps = new Vue({
  el: '#apps',
  template: '<user-list :users="users"/>',
  data: {
    users: [
      {name: "vasya", lastactive: 132},
      {name: "petya", lastactive: 321},
      {name: "nastya", lastactive: 777}
    ]
  }
});
