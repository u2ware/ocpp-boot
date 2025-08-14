import Vue3ConfirmDialog from "vue3-confirm-dialog";
import "vue3-confirm-dialog/style";


import $i18n from "./locales";
const $t = $i18n.global.t;

class ConfirmDialog {
  
  constructor($confirm) {
    this.$confirm = $confirm;
  }

  confirm(code, formattings) {

    return new Promise((resolve, reject) => {

      var isError = typeof code == "object";

      let g_title = $t("$dialog.confirm.title");
      let g_message = $t("$dialog.confirm.message");
      let g_yes = $t("$dialog.confirm.yes");
      let g_no = $t("$dialog.confirm.no");

      let p_title = $t(`${code}.title`, formattings);
      let p_message = $t(`${code}.message`, formattings);
      let p_yes = $t(`${code}.yes`, formattings);
      let p_no = $t(`${code}.no`, formattings);

      let title = `${code}.title` == p_title ? g_title : p_title;
      let message = `${code}.message` == p_message ? g_message : p_message;
      let yes = `${code}.yes` == p_yes ? g_yes : p_yes;
      let no = `${code}.no` == p_no ? g_no : p_no;

      this.$confirm({
        title: title,
        message: message,
        button: {
          yes: yes,
          no: no,
        },
        callback: (confirm, auth) => {
          if(true == confirm) {
            resolve({message:yes, confirm:confirm});
          }else{
            if(isError) {
              reject(code);
            }else{
              resolve({message:no, confirm:confirm});
            }
          }
        },
      });
    });
  }

  alert(code, formattings) {

    return new Promise((resolve, reject) => {

      let g_title = $t("$dialog.alert.title");
      let g_message = $t("$dialog.alert.message");
      let g_yes = $t("$dialog.alert.yes");

      let p_title = $t(`${code}.title`, formattings);
      let p_message = $t(`${code}.message`, formattings);
      let p_yes = $t(`${code}.yes`, formattings);

      let title = `${code}.title` == p_title ? g_title : p_title;
      let message = `${code}.message` == p_message ? g_message : p_message;
      let yes = `${code}.yes` == p_yes ? g_yes : p_yes;

      this.$confirm({
        title: title,
        message: message,
        button: {
          yes: yes,
        },
        callback: (confirm, auth) => {
          if(isError) {
            reject(code);
          }else{
            resolve({message:no, confirm:confirm});
          }
        },
      });
    });
  }
}

export default {


  install: (app, options) => {


    app.use(Vue3ConfirmDialog);
    app.component("vue3-confirm-dialog", Vue3ConfirmDialog.default);

    const _dialog = new ConfirmDialog(app["$confirm"]);

    app.config.globalProperties.$dialog = _dialog;
    app.provide("$dialog", _dialog);
  },
};
