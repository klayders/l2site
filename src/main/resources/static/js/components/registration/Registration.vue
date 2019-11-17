<template>
  <div>
    <label>
      <input type="text" placeholder="Введите логин" v-model="login"/>
    </label>
    <label>
      <input type="text" placeholder="Введите пароль" v-model="password"/>
    </label>
    <label>
      <input type="text" placeholder="Повторите пароль" v-model="passwordConfirm"/>
    </label>
    <div>
      <div class="g-recaptcha" data-sitekey="6LdKbGAUAAAAAOsDMKHHT0_vKHBxk9dpvtp2_bQI" data-theme="dark"></div>
    </div>
    <input type="button" style="position: relative; width: 100px;" value="Зарегистрироваться" @click="save"/>
  </div>
</template>

<script>
    export default {
        name: "Registration",
        data() {
            return {
                login: '',
                password: '',
                captcha: '',
                passwordConfirm: ''
            }
        },
        methods: {
            save() {
                let registrationForm = {
                    login: this.login,
                    password: this.password,
                    passwordConfirm: this.passwordConfirm,
                    captcha: this.captcha
                };
                registrationApi.save({}, registrationForm).then(() => {
                    this.login = '';
                    this.password = '';
                }, response => {
                    this.login = response.body.message;
                    // error callback
                });
            }
        }
    }
</script>

<style scoped>

</style>
