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
      downloadClient: 'Download client from',
      downloadPatch: 'Download patch from',
    },
    ru: {
      community: 'Сообщество',
      statistics: 'Статистика',
      signIn: 'Войти',
      signOut: 'Выход',
      home: 'Главная',
      profile: 'Профиль',
      users: 'Пользователи',
      downloadClient: 'Скачать клиент с',
      downloadPatch: 'Скачать патч с',
    }
  }
});
