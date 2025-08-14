import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";

const VITE_STORAGE_PREFIX = import.meta.env["VITE_STORAGE_PREFIX"]

const persistedState = createPersistedState({
  key: `persistedState_${VITE_STORAGE_PREFIX}`,
  paths: ['persistedState'],
});



const resources = import.meta.glob("/src/plugins/stores/*", {
  import: "default",
  eager: true,
});
const modules = {};


for (const path in resources) {

  const name = path
    .replace("/src/plugins/stores/", "")
    .replace(".js", "");
    // .toUpperCase();
  const module = resources[path];
  console.log("stores", name, module);
  modules[name] = module;
}
// console.log(messages);

// import { mapState, mapGetters, mapMutations, mapActions } from "vuex";


const store = createStore({
  state: {},

  getters: {},
  //this.count 를 this.$store.getters['경로명/함수명']에 매핑한다.
  //
  // computed : {
  //   ...mapGetters({count : '경로명/함수명'})
  // }

  mutations: {},
  //this.add()를this.$store.commit('경로명/함수명')에 매핑한다.
  //
  // methods: { 
  //   ...mapMutations({add: '경로명/함수명'}),
  // }

  actions: {},
  // methods: {
  // 	 ...mapActions({ add: '경로명/함수명'}),
  // }
  //
  // this.add()를this.$store.dispatch('경로명/함수명')에 매핑한다.
  modules: modules,


  plugins: [persistedState]
});

export default store;
