<template>


    locales
    <v-select label="Select" v-model="$i18n.locale" :items="$i18n.availableLocales" hide-details></v-select>

    <pre>{{ $t('locale') }}</pre>

</template>

<script >

export default {


  mounted(){
    console.log(1, "this.$t('locale')", this.$t('locale'));
  }
}


  //
</script>