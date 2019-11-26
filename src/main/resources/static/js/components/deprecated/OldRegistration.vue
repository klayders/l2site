<template>
  <v-content>
    <v-form
      ref="form"
      v-model="valid"
      lazy-validation
    >
      <v-text-field
        v-model="login"
        :counter="10"
        :rules="loginRules"
        label="Name"
        required
      ></v-text-field>

      <v-text-field
        v-model="password"
        :counter="10"
        :rules="passwordRules"
        label="Password"
        required
      ></v-text-field>

      <v-text-field
        v-model="passwordConfirm"
        :counter="10"
        :rules="passwordConfirmRules"
        label="Confirm password"
        required
      ></v-text-field>


      <v-text-field
        v-model="email"
        :rules="emailRules"
        label="E-mail"
        required
      ></v-text-field>

      <v-checkbox
        v-model="checkbox"
        :rules="[v => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="validate"
      >
        Save
      </v-btn>

      <v-btn
        color="error"
        class="mr-4"
        @click="reset"
      >
        Reset Form
      </v-btn>

      <v-btn
        color="warning"
        @click="resetValidation"
      >
        Reset Validation
      </v-btn>
    </v-form>
  </v-content>
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
        }),

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
            reset() {
                this.$refs.form.reset()
            },
            resetValidation() {
                this.$refs.form.resetValidation()
            },
        },
    }
</script>

<style scoped>

</style>
