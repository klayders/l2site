<template>
  <v-dialog v-model="dialog" width="500">

    <template v-slot:activator="{ on }">
      <v-btn small text v-on="on">
        <span class="success">Sign in</span>
        <v-icon>mdi-login-variant</v-icon>
      </v-btn>
    </template>

    <v-card class="mx-auto mt-auto">
      <v-card-title class="pb-0">
        <h1>Login</h1>
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-text-field
            label="Login"
            prepend-icon="mdi-account-circle"
            v-model="username"
            :rules="userNameRules"
          />
          <v-text-field
            :type="showPassword ? 'text' : 'password'"
            label="Password"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"
            v-model="password"
          />
        </v-form>
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <registration></registration>
        <v-spacer></v-spacer>
        <v-btn color="info" @click="authorization">Login</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
    import loginApi from 'api/login'
    import Registration from "./Registration.vue";
    import {mapActions} from 'vuex'

    export default {
        name: 'SignIn',
        components: {
            Registration
        },
        data() {
            return {
                dialog: false,
                showPassword: false,
                username: '',
                password: '',
                userNameRules: [],
                passwordRules: []
            }
        },
        methods: {
            ...mapActions(['loginAction']),

            authorization() {
                let loginForm = {
                    username: this.username,
                    password: this.password
                };
                loginApi.authentication(loginForm)
                    .then(() => {
                        this.username = '';
                        this.password = '';

                        this.loginAction();

                        this.dialog = false;
                    }, response => {
                        this.userNameRules = ['Username or password is incorrect'];
                        this.username = '';
                        this.password = '';
                        // Username or password is incorrect
                        console.log(response);
                        this.username = response.body.message;
                        // error callback
                    });
            }
        }
    }
</script>
