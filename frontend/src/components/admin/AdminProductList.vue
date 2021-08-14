<template>
  <div id="admin">
   <div class="block">
     <router-link to="/admin/addnewproduct">
       <button class="button">Добавить новый товар</button>
     </router-link>
   </div>
   <table class="table is-bordered">
     <thead>
     <tr>
       <th>№№</th>
       <th>Артикул</th>
       <th>Наименование</th>
       <th>Изображение</th>
       <th>Цена</th>
       <th>Количесвто</th>
       <th>Действие</th>
     </tr>
    </thead>
    <tbody v-if="productItems">
      <tr v-for="(item, index) in productItems" :key="item.id" class="cart-item">
        <AdminProductListItem :productItem="item" :index="index"/>
      </tr>
    </tbody>
   </table>

  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import AdminProductListItem from './AdminProductListItem';

export default {
  name: 'AdminProductList',

  computed: {...mapGetters(['productItems'])
  },

  components: {
    AdminProductListItem
  },
    mounted() {
    this.$store.dispatch("getProductItems");
  }
}
</script>

<style scoped>



#admin {
  height: 100%;
  padding: 30px 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}


</style>
