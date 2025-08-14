import { createI18n } from "vue-i18n";

const resources = import.meta.glob("/src/plugins/locales/*.json", {
  eager: true,
});
const messages = {};

for (const path in resources) {
  const name = path
    .replace("/src/plugins/locales/", "")
    .replace(".json", "")
    .toUpperCase();
  const locale = resources[path];
  console.log("locales", name, locale);
  messages[name] = locale;
}
// console.log(messages);

const i18n = createI18n({
  warnHtmlMessage: false,
  legacy: false,
  locale: "KO",
  fallbackLocale: "KO",
  messages: messages,
});

export default i18n;
