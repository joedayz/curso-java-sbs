import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource'
import dt from 'datatables.net'
import 'datatables.net-dt/css/jquery.dataTables.css'

Vue.use(VueResource)

import router from './router'

// ===== Bootstrap components integration (JQuery needed) ======
window.$ = window.jQuery = require('jquery')
require('bootstrap-sass')

// ======================== Vue Instance =======================
/* eslint-disable no-new */
new Vue({
  router,
  el: '#app',
  render: h => h(App)
})
