<template>
  <v-dialog v-model="dialog" width="500">

    <template v-slot:activator="{ on }">
      <v-btn small text v-on="on">
        <span>{{$t('signIn')}}</span>
        <v-icon>mdi-login-variant</v-icon>
      </v-btn>
    </template>

    <v-card class="mx-auto mt-auto">
      <v-card-title class="pb-0">
        <h1>{{$t('login')}}</h1>
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-text-field
            :label="$t('email')"
            prepend-icon="mdi-account-circle"
            v-model="username"
            :rules="emailRules"
          />
          <v-text-field
            :type="showPassword ? 'text' : 'password'"
            :label="$t('password')"
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
        <v-btn color="info" @click="authorization">{{$t('login')}}</v-btn>
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
                emailRules: [
                    v => !!v || this.$i18n.t('emailRequired'),
                    v => /.+@.+\..+/.test(v) || this.$i18n.t('emailNotValid'),
                ],
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
                        this.emailRules = [(this.$i18n.t('loginError'))];
                        this.username = '';
                        this.password = '';
                        // Username or password is incorrect
                        this.username = response.body.message;
                        // error callback
                    });
            }
        }
    }
</script>
