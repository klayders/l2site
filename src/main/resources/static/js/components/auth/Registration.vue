<template>
  <v-dialog v-model="dialog" width="500">

    <template v-slot:activator="{ on }">
      <v-btn color="success" v-on="on">
        Register
      </v-btn>
    </template>
    <v-form
      ref="form"
      v-model="valid"
      lazy-validation
    >
      <v-card class="mx-auto mt-auto">

        <v-card-title class="title font-weight-regular justify-space-between">
          <span>{{ currentTitle }}</span>
          <v-avatar
            color="primary lighten-2"
            class="subheading white--text"
            size="24"
            v-text="step"
          ></v-avatar>
        </v-card-title>

        <v-window v-model="step">
          <v-window-item :value="1">
            <v-card-text>

              <v-text-field
                v-model="login"
                :counter="10"
                :rules="loginRules"
                label="Login"
                hint="login from the site and the game"
                persistent-hint
                required>
              </v-text-field>


              <v-text-field
                v-model="email"
                :rules="emailRules"
                label="E-mail"
                hint="Input your email for restore password"
                persistent-hint
                required>
              </v-text-field>


              <v-text-field
                v-model="password"
                :counter="10"
                :rules="passwordRules"
                label="Password"
                hint="Password from the site and the game"
                persistent-hint
                required>
              </v-text-field>


              <v-text-field
                v-model="passwordConfirm"
                :counter="10"
                :rules="passwordConfirmRules"
                label="Confirm password"
                persistent-hint
                required>
              </v-text-field>

            </v-card-text>
          </v-window-item>

          <v-window-item :value="2">
            <div class="pa-4 text-center">
              <v-img
                class="mb-4"
                contain
                height="128"
                src="https://cdn.vuetifyjs.com/images/logos/v.svg"
              ></v-img>
              <h3 class="title font-weight-light mb-2">Welcome to Vuetify</h3>
              <span class="caption grey--text">Thanks for signing up!</span>
            </div>
          </v-window-item>
        </v-window>

        <v-divider></v-divider>

        <v-card-actions>
          <v-btn
            :disabled="step === 1"
            text
            @click="step--"
          >
            Back
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            :disabled="step === 3"
            color="primary"
            depressed
            @click="step++"
          >
            Next
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-form>
  </v-dialog>
</template>

<script>
    import regApi from 'api/registration.js'


    export default {
        name: "Registration",
        data: () => ({
            valid: true,
            login: '',
            loginRules: [
                v => !!v || 'Name is required',
                v => (v && v.length >= 6) || 'Name must be more than 6 characters',
            ],
            password: '',
            passwordRules: [
                v => !!v || 'password is required',
                v => (v && v.length >= 6) || 'Password must be more than 6 characters',
            ],
            passwordConfirm: '',
            passwordConfirmRules: [
                // TODO : add validation
                // v => v !== password
            ],
            email: '',
            emailRules: [
                v => !!v || 'E-mail is required',
                v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
            ],
            select: null,
            checkbox: false,
            dialog: false,
            step: 1,
        }),

        computed: {
            currentTitle() {
                switch (this.step) {
                    case 1:
                        return 'Sign-up'
                    case 2:
                        return 'Create a password'
                    default:
                        return 'Account created'
                }
            },
        },
        methods: {
            validate() {
                if (this.$refs.form.validate()) {
                    this.snackbar = true;

                    let registrationForm = {
                        login: this.login,
                        password: this.password,
                        passwordConfirm: this.passwordConfirm,
                        // captcha: this.captcha
                    };
                    regApi.addNewUser(registrationForm).then(() => {
                        this.login = '';
                        this.password = '';
                    }, response => {
                        this.login = response.body.message;
                        // error callback
                    });
                }
            },
            // reset() {
            //     this.$refs.form.reset()
            // },
            // resetValidation() {
            //     this.$refs.form.resetValidation()
            // },
        },
    }
</script>

<style scoped>

</style>
