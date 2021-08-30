<template>
  <q-card class="my-card" >
    <router-link :to="{name: 'itemdetails', params: { id: productItem.id } }">
        <q-img :src="productItem.image" />
    </router-link>
        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              {{productItem.title}}
            </div>
          </div>
          <q-rating icon="favorite_border" color="red" v-model="stars" :max="5" size="32px" icon-selected="favorite" icon-half="favorite"/>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            Цена: {{productItem.price}}
          </div>
          <div class="text-caption text-grey">

          </div>
        </q-card-section>

        <q-separator />
        <q-card-actions align="center">
          <q-btn color="primary" round icon="shopping_cart"  @click="addCartItem(productItem)">

          </q-btn>
        </q-card-actions>
      </q-card>
</template>

<script>
import { ref } from 'vue'
import { mapActions } from 'vuex';

export default {
  name: 'ProductListItem',
  props: ['productItem'],
  methods: {
    ...mapActions(['addCartItem'])
  },
  computed: {
    available() {
      return this.productItem.quantity>0;
      }

    },
    setup () {
  return {
    stars: ref(4)
  }
}
}
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  width: 280px
</style>
