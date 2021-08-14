<template>
<div class="columns is-mobile">
  <div class="column is-half is-offset-one-quarter">
    <ProductItemEditForm/>
  </div>
</div>
</template>

<script>

import ProductItemEditForm from '../form/ProductItemEditForm';

export default {
  name: 'AdminAddProductItem',
  components: {
    ProductItemEditForm
  },

}
</script>

<style scoped>

</style>
