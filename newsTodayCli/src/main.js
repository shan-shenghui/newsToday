import Vue from 'vue'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import 'bootstrap/dist/css/bootstrap.css'
import App from './App.vue'
//引入vuex 的store
import store from './store'

import vueResource from 'vue-resource'
import VueRouter from 'vue-router'
import routerConfig from './router.js'

Vue.use(iView)
Vue.use(vueResource)
Vue.use(VueRouter)

const router = new VueRouter(routerConfig)

new Vue({
    el: '#app',
    router,
    store,
    render: h => h(App)
})