Vue.component('auth-form', {
  data: function () {
    return {
      username: '',
      password: '',
    }
  },
  /**
   * v-model - связывание переменной в аттрибуте data. Для данного примера text = data.text
   */
  template:
    '<div> ' +
    '<input type="text" placeholder="Введите логин" v-model="username"/> ' +
    '<input type="text" placeholder="Введите пароль" v-model="password"/> ' +
    '<input type="button"  style="position: relative; width: 100px;" value="Войти" @click="auth"/> ' +
    '</div>'
  ,
  methods: {
    auth: function () {
      let registrationForm = {
        username: this.username,
        password: this.password,
      };

      Vue.http.post('/login', registrationForm, {emulateJSON: true}).then(response => {

        this.username = '';
        this.password = '';

      }, response => {
        this.username = response.body.message;
        // error callback
      });
    }
  }
})

var auth = new Vue({
  el: "#auth",
  template:
    '<div>' +
    '<auth-form v-if="!profile"/>' +

    '<div v-else>' +
    '<div>{{profile.displayName}}&nbsp;<a href="/logout">Выйти</a></div>' +
    '</div>' +

    '</div>',
  data: {
    profile: frontendData.profile
  }
});


