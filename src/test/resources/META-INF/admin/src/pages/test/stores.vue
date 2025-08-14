<template>

    stores

    xxx<pre>{{ getSample }}</pre>xxx

</template>

<script>
import { mapState, mapGetters, mapMutations, mapActions } from "vuex";

export default {


  data: () => ({

  }),

  computed: {
    ...mapGetters({getSample : 'sample/sample'}),
  },

  methods: {
    ...mapMutations({ setSample: "sample/sample" }),

  },

  mounted(){
    this.setSample({hello:"world"})
  }

}
//
</script>