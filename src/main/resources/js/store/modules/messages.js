import messageApi from "../../api/messages";

export default {
  state: {
    messages: [],
  },
  getters: {
    sortMessages: state => (state.messages || []).sort((a, b) => -(a.id - b.id)),
  },
  mutations: {
    initMessages(state, message) {
      state.messages = message;
    },
    addMessageMutation(state, message) {
      state.messages = [
        ...state.messages,
        message
      ]
    },
    updateMessageMutation(state, message) {
      const updateIndex = state.messages.findIndex(item => item.id === message.id);
      state.messages = [
        ...state.messages.splice(0, updateIndex),
        message,
        ...state.messages.splice(updateIndex + 1)
      ]
    },
    removeMessageMutation(state, message) {
      const deleteIndex = state.messages.findIndex(item => item.id === message.id);

      if (deleteIndex > -1) {
        state.messages = [
          ...state.messages.splice(0, deleteIndex),
          ...state.messages.splice(deleteIndex + 1)
        ]
      }
    }
  },
  actions: {
    async addMessageAction({commit, state}, message) {
      const result = await messageApi.add(message);
      const data = await result.json();
      if (state.messages == null) {
        console.log('error write message')
      } else {
        const index = state.messages.findIndex(item => item.id === data.id);

        if (index > -1) {
          commit('updateMessageMutation', data)
        } else {
          commit('addMessageMutation', data)
        }
      }
    },
    async initMessagesAction({commit}) {
      const result = await messageApi.init();
      const data = await result.json();
      commit('initMessages', data)
    },
    async updateMessageAction({commit}, message) {
      const result = await messageApi.update(message);
      const data = await result.json();
      commit('updateMessageMutation', data)
    },
    async removeMessageAction({commit}, message) {
      const result = await messageApi.remove(message.id);

      if (result.ok) {
        commit('removeMessageMutation', message)
      }
    }
  }
};
