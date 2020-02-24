<template>
  <v-dialog v-model="dialog" width="500">

    <template v-slot:activator="{ on }">
      <v-btn color="success" v-on="on">
        {{$t('register')}}
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
                v-model="email"
                :rules="emailRules"
                :label="$t('email')"
                :hint="$t('inputEmail')"
                persistent-hint
                required>
              </v-text-field>


              <v-text-field
                v-model="login"
                :counter="14"
                :rules="loginRules"
                :label="$t('login')"
                :hint="$t('inputLogin')"
                persistent-hint
                required>
              </v-text-field>


              <v-text-field
                v-model="password"
                :counter="16"
                :rules="passwordRules"
                :label="$t('password')"
                :hint="$t('inputPassword')"
                :type="showPassword ? 'text' : 'password'"
                :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showPassword = !showPassword"
                persistent-hint
                required>
              </v-text-field>


              <v-text-field
                v-model="passwordConfirm"
                :counter="16"
                :rules="[passwordConfirmationRule]"
                :label="$t('confirmPassword')"
                :type="showConfirmPassword ? 'text' : 'password'"
                :append-icon="showConfirmPassword ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showConfirmPassword = !showConfirmPassword"
                persistent-hint
                required>
              </v-text-field>

            </v-card-text>
          </v-window-item>


          <v-window-item :value="2">
            <div class="pa-4 text-center">
              <vue-recaptcha
                sitekey="6LdKbGAUAAAAAOsDMKHHT0_vKHBxk9dpvtp2_bQI"
                :loadRecaptchaScript="true"
                ref="recaptcha"
                @verify="onVerify()">
              </vue-recaptcha>
            </div>
          </v-window-item>


          <v-window-item :value="3">
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
    import VueRecaptcha from 'vue-recaptcha';

    export default {
        name: "Registration",
        components: {VueRecaptcha},
        data() {
            return {
                valid: true,
                login: '',
                showPassword: false,
                showConfirmPassword: false,
                loginRules: [
                    v => !!v || this.$i18n.t('loginRequired'),
                    v => /^[A-Za-z0-9]{4,14}$/.test(v) || this.$i18n.t('loginRegexpError'),
                ],
                password: '',
                passwordRules: [
                    v => !!v || this.$i18n.t('passwordRequired'),
                    v => /^[A-Za-z0-9]{6,16}$/.test(v) || this.$i18n.t('passwordRegexpError'),
                ],
                passwordConfirm: '',
                email: '',
                emailRules: [
                    v => !!v || this.$i18n.t('emailRequired'),
                    v => /.+@.+\..+/.test(v) || this.$i18n.t('emailNotValid'),
                ],
                select: null,
                checkbox: false,
                dialog: false,
                step: 1,
            }
        },

        computed: {
            passwordConfirmationRule() {
                return () => (this.password === this.passwordConfirm) || 'Password must match'
            },
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
        },
        onVerify: async function (response) {
            console.log('Verify: ' + response)
        },
    }
</script>

<style scoped>

</style>
