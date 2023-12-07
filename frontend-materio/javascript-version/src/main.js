/* eslint-disable import/order */
import '@/@iconify/icons-bundle'
import App from '@/App.vue'
import vuetify from '@/plugins/vuetify'
import { loadFonts } from '@/plugins/webfontloader'
import router from '@/router'
import '@/styles/styles.scss'
import '@core/scss/index.scss'
import { createPinia } from 'pinia'
import { createApp } from 'vue'
import axios from 'axios';
import { Icon } from '@iconify/vue';
import VCalendar from 'v-calendar';
import 'v-calendar/style.css';


axios.defaults.baseURL = ''


loadFonts()

const app = createApp(App)

app.config.globalProperties.$axios = axios;

app.use(vuetify)

app.use(createPinia())

app.use(router)

app.use(VCalendar, {})

app.component('Icon',Icon)

app.mount('#app')
