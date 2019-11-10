var character_url = "/api/v1/character{/id}";
var characterApi = Vue.resource(character_url);

Vue.component("user-row", {
  props: ["user"],
  template:
    "<div>" +
    " <i>({{user.id}})</i>" +
    "{{user.charName}}" +
    "  " +
    "{{user.title}}" +
    "</div>"
});

Vue.component("user-list", {
  props: ["users"],
  template:
    "<div>" +
    '<user-row v-for="user in users" :key="user.charName" :user="user"/>' +
    "</div>",
  created: function() {
    characterApi.get().then(result =>
      result.json().then(data => {
        data.forEach(user => this.users.push(user));
      })
    );
  }
});

var users = new Vue({
  el: "#users",
  template: '<user-list :users="users"/>',
  data: {
    users: []
  }
});
