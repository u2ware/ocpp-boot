const state = {
  sample: {},
};

const getters = {
  sample: (state, getters, rootState, rootGetters) => {
    return state.sample;
  },
};

const mutations = {
  sample: (state, payload) => {
    state.sample = { ...payload };
  },
};

const actions = {
  sample: ({ dispatch, commit, rootState, rootGetters }, payload) => {
    return Promise.try(() => {
      commit("sample", payload);
    });
  },
};

export default {
  namespaced: true,
  state: state,
  getters: getters,
  mutations: mutations,
  actions: actions,
};