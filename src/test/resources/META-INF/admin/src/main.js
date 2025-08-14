/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Plugins
import { registerPlugins } from '@/plugins'

// Components
// import App from './App.vue'
import main from './main.vue'

// Composables
import { createApp } from 'vue'

// Styles
import 'unfonts.css'

// const app = createApp(App)
const app = createApp(main)

registerPlugins(app)

app.mount('#app')
