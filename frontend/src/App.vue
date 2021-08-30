<template>
 <MainLayout/>
</template>

<script>
import { ref } from 'vue'
import MainLayout from './components/layout/MainLayout.vue'

export default {
  name: 'App',

  components: {
    MainLayout
  },

  setup () {
    return {
      leftDrawerOpen: ref(false)
    }
  }
}
</script>
