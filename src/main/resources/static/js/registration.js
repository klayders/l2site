let registration_url = '/api/registration';
let registrationApi = Vue.resource(registration_url);


Vue.component('reg-form', {
  props: ['messages'],
  data: function () {
    return {
      login: '',
      password: '',
      captcha: ''
    }
  },
  /**
   * v-model - связывание переменной в аттрибуте data. Для данного примера text = data.text
   */
  template:
    '<div> ' +
    '<input type="text" placeholder="Введите логин" v-model="login"/> ' +
    '<input type="text" placeholder="Введите логин" v-model="password"/> ' +
    '<div>' +
    '<div class="g-recaptcha" data-sitekey="6LdKbGAUAAAAAOsDMKHHT0_vKHBxk9dpvtp2_bQI" data-theme="dark"></div>' +
    '</div>' +
    '<input type="button"  style="position: relative; width: 100px;" value="Сохранить" @click="save"/> ' +
    '</div>'
  ,
  methods: {
    save: function () {
      let registrationForm = {
        login: this.login,
        password: this.password,
        captcha: this.captcha
      };

      registrationApi.save({}, registrationForm).then(response => {

        this.login = '';
        this.password = '';

      }, response => {
        this.login = response.body.message;
        // error callback
      });
    }
  }
})

var registration = new Vue({
  el: "#registration",
  template: '<reg-form/>',
  // data: {
  //   users: []
  // }
});


