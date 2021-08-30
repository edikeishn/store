<template>
  <p/>
  <main-baner/>
  <q-list class="row justify-center q-gutter-lg">
      <div v-for="productItem in productItems" :key="productItem.id">
        <ProductListItem :productItem="productItem"/>
      </div>
  </q-list>
</template>

<script>
import { mapGetters } from 'vuex';
import ProductListItem from './ProductListItem';
import MainBaner from '../viewelements/MainBaner';

export default {
  name: 'ProductList',

  computed: {...mapGetters(['productItems'])
  },

  components: {
    ProductListItem,
    MainBaner
  },
  mounted() {
  this.$store.dispatch("getProductItems");
}

}
</script>

<style >

</style>
