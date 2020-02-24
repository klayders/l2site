import newsApi from "../../api/news";

export default {
  state: {
    news: [],
  },
  getters: {
    sortNews: state => (state.news || []).sort((a, b) => -(a.id - b.id))
  },
  mutations: {
    initNews(state, news) {
      state.news = news;
    },
  },
  actions: {
    async initNewsAction({commit}) {
      const result = await newsApi.init();
      const data = await result.json();
      commit('initNews', data)
    },
  }
};
