/**
 * plugins/index.js
 *
 * Automatically included in `./src/main.js`
 */

// Plugins
import vuetify from './vuetify'
import router from './router'
import stores from './stores' //vuex
import locales from './locales' //i18n

import moment from './moment' 
import axios from './axios' 
import dialog from './dialog' 


export function registerPlugins (app) {
  app
    .use(vuetify)
    .use(router)
    .use(locales)
    .use(stores)
    .use(moment)
    .use(axios)
    .use(dialog)
}
