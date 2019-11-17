<template>
  <div>
    <label>
      <input type="text" placeholder="Введите логин" v-model="username"/>
    </label>
    <label>
      <input type="text" placeholder="Введите пароль" v-model="password"/>
    </label>
    <input type="button" style="position: relative; width: 100px;" value="Войти" @click="auth"/>
  </div>
</template>

<script>
    export default {
        name: "AuthValidation",
        data() {
            return {
                username: '',
                password: '',
            }
        },
        methods: {
            auth() {
                let registrationForm = {
                    username: this.username,
                    password: this.password,
                };
                this.$resource('/login').save(registrationForm, {emulateJSON: true})
                    .then(() => {
                        this.username = '';
                        this.password = '';
                    }, response => {
                        this.username = response.body.message;
                        // error callback
                    });
            }
        }
    }
</script>

<style scoped>

</style>
