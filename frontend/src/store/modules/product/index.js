import axios from 'axios';

const state = {
  productItems: []
}

const mutations = {
  UPDATE_PRODUCT_ITEMS (state, payload) {
    state.productItems = payload;

  }
}

const actions = {
  getProductItems ({commit}) {
    axios.get(`/api/items`).then((response) => {
    commit('UPDATE_PRODUCT_ITEMS', response.data);
    });
  },
  addNewItemToStock ({commit}, newItem) {
    let bodyFormData = new FormData();
    var jsonObjectData = JSON.stringify(newItem);
    const blob = new Blob([jsonObjectData], {
    type: 'application/json'
    });
    bodyFormData.append('item',blob);
    if(newItem.file != null) bodyFormData.append('file',newItem.file, newItem.file.name);

    axios.post(`/api/items/addnewitem`,bodyFormData).then((response) => {
    commit('UPDATE_PRODUCT_ITEMS', response.data);

    });

  },

    editItemInStock (store,itemToEdit) {
    let bodyFormData = new FormData();
    var jsonObjectData = JSON.stringify(itemToEdit);
    const blob = new Blob([jsonObjectData], {
    type: 'application/json'
    });
    bodyFormData.append('item',blob);
    if(itemToEdit.file) bodyFormData.append('file',itemToEdit.file, itemToEdit.file.name);
    axios.post(`/api/items/edititem`,bodyFormData);
  }

}

const getters = {
  productItems: state => state.productItems,
  productItemFromId: (state) => (id) => {
      return state.productItems.find(productItem => productItem.id === id)
  }
}

const productModule = {
  state,
  mutations,
  actions,
  getters
}

export default productModule;
