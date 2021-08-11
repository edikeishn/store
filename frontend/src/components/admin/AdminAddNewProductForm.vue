<template>
 <div class="input-form">
  <form @submit="submitForm" class="ui form">
   <div class="field">
     <label class="label">Категория</label>
      <div class="select">
        <select v-model="fields.category" class="ui fluid search dropdown">
          <option v-for="option in options" v-bind:value="option.value" v-bind:key="option.key">{{ option.text }}</option>
        </select>
        <span style="color: red">{{ fieldErrors.category }}</span>
      </div>
   </div>
   <div class="field">
     <label class="label">Наименование</label>
    <input class="input is-normal" v-model="fields.title" type="text" placeholder="Введите наименование!">
    <span style="color: red">{{ fieldErrors.title }}</span>
   </div>
   <div class="field">
     <label class="label">Описание</label>
    <input class="textarea is-normal" v-model="fields.description" type="text" placeholder="Введите описание!">
    <span style="color: red">{{ fieldErrors.description }}</span>
   </div>
   <div class="field">
     <label class="label">Цена</label>
    <input class="input is-normal" v-model="fields.price" type="number" placeholder="Введите наименование!">
    <span style="color: red">{{ fieldErrors.price }}</span>
   </div>
   <div class="field">
     <label class="label">Количество</label>
    <input class="input is-normal" v-model="fields.quantity" type="number" placeholder="Введите наименование!">
   </div>
   <div class="field">
     <div class="file">
      <label class="file-label">
      <input class="file-input" type="file" ref="file" v-on:change="handleFileUpload">
      <span class="file-cta">
        <span class="file-icon">
          <i class="fa fa-upload"></i>
        </span>
        <span class="file-label">
          Загрузить изображение
       </span>
      </span>
    </label>
  </div>
   </div>
   <button class="ui button">Submit</button>
  </form>
</div>
</template>

<script>
import {mapActions} from 'vuex';
 export default {
   name: "AdminAddNewProductForm",
   data() {
     return {
       options: [
        { text: 'Чаи', value: 'tea' },
        { text: 'Напитки', value: 'drinks' },
        { text: 'Косметика', value: 'cosmetics' }
       ],
       fields : {
         category: "",
         title: "",
         description: "",
         price: 0,
         quantity: 0,
         file: ""
       },
       fieldErrors: {
         category: undefined,
         title: undefined,
         description:undefined,
         price: undefined,
         quantity: undefined,
         file: undefined
       }
     }
   },
   methods: {
     submitForm(evt) {
       evt.preventDefault();
       this.fieldErrors = this.validateForm(this.fields);
       if (Object.keys(this.fieldErrors).length) return;
       this.addNewItemToStock(this.fields)
  },
     validateForm(fields) {
       const errors = {};
       if (!fields.category) errors.category = "Необходимо выбрать категорию!";
       if (!fields.title) errors.title = "Необходимо указать наименование!";
       if (!fields.description) errors.description = "Необходимо указать описание!";
       if (!fields.price) errors.price = "Необходимо указать стоимость!";
       return errors;
  },
     handleFileUpload() {
       this.fields.file = this.$refs.file.files[0];
     },
     ...mapActions(['addNewItemToStock'])
   }
 }
</script>

<style scoped>
.input-form {
  height: 100%;
  padding: 30px 10px;

}
</style>
