import Vue from 'vue'
import VueI18n from "vue-i18n";

Vue.use(VueI18n);

export const i18n = new VueI18n({
  locale: 'en',
  fallbackLocale: 'ru',
  messages: {
    en: {
      community: 'Community',
      statistics: 'Statistics',
      signIn: 'Sign in',
      signOut: 'Sign out',
      home: 'Home',
      profile: 'My profile',
      users: 'Users',
      login: 'Login',
      password: 'Password',
      confirmPassword: 'Confirm password',
      email: 'E-mail',
      register: "Register",

      downloadClient: 'Download client from',
      downloadPatch: 'Download patch from',

      inputEmail: 'Input your email. It`s need for restore password',
      inputLogin: 'Login from the game',
      inputPassword: 'Password from the site and the game',

      loginError: 'Email or password is incorrect',
      loginRequired: 'Login is required',
      loginRegexpError: 'The password can contain only 4~14 Latin letters case-insensitive and numbers',
      emailRequired: 'E-mail is required',
      emailNotValid: 'E-mail must be valid',
      passwordRegexpError: 'The password can contain only  6~16 Latin letters case-insensitive and numbers',
      passwordRequired: 'Password is required',

    },

    ru: {
      community: 'Сообщество',
      statistics: 'Статистика',
      signIn: 'Войти',
      signOut: 'Выход',
      home: 'Главная',
      profile: 'Профиль',
      users: 'Пользователи',
      login: 'Логин',
      password: 'Пароль',
      confirmPassword: 'Подтвердите пароль',
      email: 'Емайл',
      register: "Регистрация",

      downloadClient: 'Скачать клиент с',
      downloadPatch: 'Скачать патч с',

      inputEmail: 'Заполните емайл. Это понадобится для восстановления пароля',
      inputLogin: 'Логин от игры',
      inputPassword: 'Пароль от игры и сайта',

      loginError: 'Емайл или пароль введен неправильно',
      loginRequired: 'Логин не заполнен',
      loginRegexpError: 'Логин может содержать только 4~16 латинских букв без учета регистра и цифр',
      emailRequired: 'Емайл не заполнен',
      emailNotValid: 'Емайл введен неверно',
      passwordRegexpError: 'Пароль может содержать только 6~16 латинских букв без учета регистра и цифр',
      passwordRequired: 'Пароль не заполнен',

    }
  }
});
