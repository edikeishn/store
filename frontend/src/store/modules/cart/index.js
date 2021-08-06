import axios from 'axios';
const state = {
  cartItems: [],

}

const mutations = {
  UPDATE_CART_ITEMS (state, payload) {
   state.cartItems = payload;
  }
}

const actions = {

  getCartItems ({ commit }) {
  axios.get('/api/cart').then((response) => {
    commit('UPDATE_CART_ITEMS', response.data)
  });
},


  addCartItem ({ commit }, cartItem) {
      axios.post('/api/cart', cartItem).then((response) => {
      commit('UPDATE_CART_ITEMS', response.data)
      });

},

  removeCartItem ({ commit }, cartItem) {
    const cartProducts = JSON.parse(JSON.stringify(this.getters.cartItems));
    cartProducts.map((cartProduct) => {
    if (cartProduct.id === cartItem.id && cartProduct.quantity > 1) {
    cartProduct.quantity--;
   }
   else if (cartProduct.id === cartItem.id && cartProduct.quantity === 1) {
        const cartIndexToRemove = cartProducts.findIndex(cartProduct => cartProduct.id === cartItem.id);
        cartProducts.splice(cartIndexToRemove, 1);
      }
});
commit('UPDATE_CART_ITEMS', cartProducts);
  },

  removeAllCartItems ({ commit }) {
    axios.post('/api/cart/removeAllItems').then(() => {
    commit('UPDATE_CART_ITEMS', [])
    });
  }
}

const getters = {
  cartItems: state => state.cartItems,
  cartTotal: state => {
    return state.cartItems.reduce((acc, cartItem) => {
      return (cartItem.quantity * cartItem.item.price) + acc;
    }, 0).toFixed(2);
  },
  cartQuantity: state => {
    return state.cartItems.reduce((acc, cartItem) => {
  return cartItem.quantity + acc;
}, 0);
  }
}

const cartModule = {
  state,
  mutations,
  actions,
  getters
}

export default cartModule;
