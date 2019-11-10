
let registration_url = '/api/registration';
let registrationApi = Vue.resource(registration_url);


Vue.component('reg-form', {
  props: ['messages'],
  data: function () {
    return {
      login: '',
      password: '',
    }
  },
  /**
   * v-model - связывание переменной в аттрибуте data. Для данного примера text = data.text
   */
  template:
    '<div> ' +
    '<input type="text" placeholder="Введите логин" v-model="login"/> ' +
    '<input type="text" placeholder="Введите логин" v-model="password"/> ' +
    '<input type="button"  style="position: relative; width: 100px;" value="Сохранить" @click="save"/> ' +
    '</div>',
  methods: {
    save: function () {
      let registrationForm = {
        login: this.login,
        password: this.password
      };

        registrationApi.save({}, registrationForm).then(result =>
          result.json().then(data => {
            // this.messages.push(data);
            /**
             * Читим поле ввода
             */
            this.text = '';
            this.password = '';
          }))
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


