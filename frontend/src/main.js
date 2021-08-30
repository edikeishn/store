import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import store from './store'
import router from './router'
import { Quasar } from 'quasar'
import quasarUserOptions from './quasar-user-options'



const app = createApp(App).use(Quasar, quasarUserOptions);
app.use(VueAxios, axios);
app.use(store);

app.use(router);

app.mount('#app');
