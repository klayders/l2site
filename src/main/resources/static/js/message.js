function getIndex(list, id) {
  for (var i = 0; i < list.length; i++) {
    if (list[i].id === id) {
      return i;
    }
  }
  return -1;
}

/**
 * обращение на бэк по заданному мапингу, в фигурных скобках указан не обязательный параметр и название переменной.
 * https://github.com/pagekit/vue-resource/blob/develop/docs/resource.md
 */
let message_url = '/message{/id}';
let messageApi = Vue.resource(message_url);

/**
 * форма ввода сообщения (редктиование или добавление нового)
 */
Vue.component('message-form', {
  props: ['messages', "messageAttr"],
  /**
   * в data хранятся временные переменные. (уникальны для каждого компонента)
   * @returns {{text: string, id: string}}
   */
  data: function () {
    return {
      text: '',
      id: '',
    }
  },
  /**
   * наблюдение за messageAttr. приходит из 'message-row'
   */
  watch: {
    messageAttr: function (newMessage, oldMessage) {
      this.text = newMessage.text;
      this.id = newMessage.id;
    }
  },
  /**
   * v-model - связывание переменной в аттрибуте data. Для данного примера text = data.text
   */
  template:
    '<div> ' +
    '<input type="text" placeholder="напиши сюда текст" v-model="text"/> ' +
    /**
     * v-on:click - тоже самое что @click. В качестве параметра передается название метода
     */
    '<input type="button"  style="position: relative; width: 100px;" value="Сохранить" @click="save"/> ' +
    '</div>',
  methods: {
    // это сохранение и обновление
    save: function () {
      let message = {text: this.text};
      /**
       * если id не пустое - это апдейт
       */
      if (this.id) {
        messageApi.update({id: this.id}, message)
          .then(result => result.json().then(data => {
            /**
             * получаем список индекс в массиве сообщений
             */
            let index = getIndex(this.messages, data.id);
            /**
             * заменяем старое сообщение на новое, где index - порядковый номер,
             * второй параметр - количество элементов, которые будут изменено
             * data - сам список
             */
            this.messages.splice(index, 1, data)
            /**
             * чистим форму
             */
            this.id = '';
            this.text = '';
          }));
        /**
         * если id пустое - это сохранение
         */
      } else {
        messageApi.save({}, message).then(result =>
          result.json().then(data => {
            /**
             * Добавляем сообщение в список, которое пришло с бэка
             */
            this.messages.push(data);
            /**
             * Читим поле ввода
             */
            this.text = '';
          }))
      }
    }
  }
})

/**
 * компонент - опиание отображения одной строчки
 */
Vue.component('message-row', {
  /**
   * описание аттрибутов, которые будут передаваться
   */
  props: ['message', "editMethod", "messages"],
  /**
   * темплейт для отображение одной строчки сообщения
   */
  template:
    '<div>' +
    ' <i>({{message.id}})</i> {{message.text}} {{message.creationDate}}' +
    '<span style="position: absolute; right: 0">' +
    '<input type="button" value="Редактировать" @click="edit"/>' +
    '<input type="button" value="Удалить" @click="del"/>' +
    '</span>' +
    '</div>',
  methods: {
    /**
     * метод редактирования сообщений
     */
    edit: function () {
      this.editMethod(this.message);
    },
    del: function () {
      messageApi.remove({id: this.message.id}).then(result => {
        if (result.ok) {
          this.messages.splice(this.messages.indexOf(this.message), 1)
        }
      })
    }
  }
});

/**
 * список всех объектов
 */
Vue.component('message-list', {
  props: ['messages'],
  /**
   * нужно для editMethod. При нажатии на editMethod, вызывается этот метод и message -> выставляется текущее
   * сообщение в data.message
   * @returns {{message: null}}
   */
  data: function () {
    return {
      message: null
    }
  },
  template:
    '<div style="position: relative; width: 300px;">' +
    /**
     * Приходит при нажатии из editMessage
     */
    '<message-form :messages="messages" :messageAttr="message" />' +
    /**
     * v-for - цикл, справа пишем коллецию, слева один объект.
     * (Получаем сообщение из коллекции messageS )
     * Обязательно должен быть объявлен внутри <div>, Потому что этот атрибут будет возращать можество узлов(объектов)
     * в результате чего получим бесконечную рекурсию. Плюс vue рекомендует указывать ключи 'key'
     */
    '<message-row v-for="message in messages" :key="message.id" :message="message" :editMethod="editMethod" :messages="messages" />' +
    '</div>',
  /**
   * жизненный цикл, при инициализации этого компонента, мы обращаемся на бэк за данными
   */
  created: function () {
    messageApi.get()
      .then(result => result.json()
        /**
         * после получения респонса от бэка, мы обращаемся в коллекцию, которая приходит в 'props.messages'
         * и добавляем все данные которые пришли с бекенда
         */
          .then(data => data.forEach(message => this.messages.push(message)
        )))
  },
  methods: {
    editMethod: function (message) {
      this.message = message;
    },
    deleteMethod: function (message) {
      this.message.delete(message)
    }
  }
});

/**
 * главный компонент для отрисовки
 */
let messages = new Vue({
  /**
   * название айдишника элемента в index.html -> <div id='messages'/>
   */
  el: '#messages',
  /**
   * используется компонент, который описан выше под названием 'message-list'
   * двоеточие перед messages нужно для того, чтобы vue понимал, что тут передается значение,
   * а не текст рандомный. За это ответ 'props' у 'message-list'.
   */
  template: '<message-list :messages="messages"/>',
  /**
   * список сообщений, которые будут рендерится.
   * Для теста можно вручную прописать в массив объекты
   */
  data: {
    messages: []
  }
});
