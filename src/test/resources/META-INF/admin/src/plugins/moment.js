
import moment from 'moment'

const _moment = {
  
  parse : (val)=>{
    return moment(val);
  },
  format : (val, f)=>{
    var format = (f == undefined) ? "YYYY-MM-DD hh:mm:ss" : f;
    return moment(val).format(format);
  }
}


export default {
  install: (app, options) => {

    app.config.globalProperties.$moment = _moment; 
    app.provide('$moment', _moment)                

  }
}