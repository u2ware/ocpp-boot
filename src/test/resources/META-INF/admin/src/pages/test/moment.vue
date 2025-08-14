<template>

<table>
<tbody>
    <tr>
        <th>$moment:</th>
        <td> {{ $moment.format(timestamp) }}</td>
    </tr>
    <tr>
        <th>$moment:</th>
        <td> {{ $moment.format() }}</td>
    </tr>
    <tr>
        <th>$moment:</th>
        <td> {{ $moment.parse() }}</td>
    </tr>
</tbody>

</table>

</template>


<script >

export default {

  data: () => ({
    timestamp : undefined
  }),

  mounted(){
    console.log(1, "this.$t('locale')", this.$t('locale'));
    this.timestamp = this.$moment.parse();
  }
}


  //
</script>