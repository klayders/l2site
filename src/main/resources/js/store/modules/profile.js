import accountApi from "../../api/account";

const tokenName = 'Authorization' + "=";


export default {
  state: {
    profile: null,
    token: getCookie(),
  },
  getters: {
    isAuthenticated: state => !!state.token,
    profile: state => state.profile
  },
  mutations: {
    initProfile(state, profile) {
      state.profile = profile;
    },
    updToken(state) {
      state.profile = getCookie();
    },
  },
  actions: {
    async loginAction({commit}) {
      commit('updToken');
      await updProfile(commit);
    },
    async initProfileAction({commit, state}) {
      if (!!state.token) {
        await updProfile(commit);
      }
    },
  }
};

async function updProfile(commit) {
  try {
    let result = await accountApi.init();
    const data = await result.json();
    commit('initProfile', data)
  } catch {
    deleteAllCookies();

    console.log('error fetch profile');
  }

}

function getCookie() {
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');

  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) === ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(tokenName) === 0) {
      return c.substring(tokenName.length, c.length);
    }
  }
  return "";
}

function deleteAllCookies() {
  const cookies = document.cookie.split(";");

  for (let i = 0; i < cookies.length; i++) {
    var cookie = cookies[i];
    var eqPos = cookie.indexOf("=");
    var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
    document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
  }
}
