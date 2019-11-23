<template>
  <v-app>
    <v-card width="400" class="mx-auto mt-5">
      <v-card-title class="pb-0">
        <h1>Login</h1>
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-text-field
            label="Username"
            prepend-icon="mdi-account-circle"
            v-model="username"
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
        <v-btn color="success">Register</v-btn>
        <v-spacer></v-spacer>
        <v-btn color="info" @click="authorization">Login</v-btn>
      </v-card-actions>
    </v-card>
  </v-app>
</template>

<script>
    import loginApi from 'api/login'

    export default {
        name: 'App',
        data() {
            return {
                showPassword: false,
                username: '',
                password: ''
            }
        },
        methods: {
            authorization() {
                let loginForm = {
                    username: this.username,
                    password: this.password
                };
                loginApi.authentication(loginForm)
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
