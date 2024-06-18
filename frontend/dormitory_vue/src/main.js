import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import welcomebg from './views/WelcomeView.vue'
import app from './App.vue'
import router from './router';
import axios from 'axios';


// 路由之前会调用
router.beforeEach(function (to, from, next) {
  if (to.meta.needLogin) {
    //页面是否登录
    if (localStorage.getItem("jwtToken")) {
      //本地存储中是否有token(uid)数据
      next(); //表示已经登录
    } else {
      //next可以传递一个路由对象作为参数 表示需要跳转到的页面
      next({
        name: "/"
      });
    }
  } else {
    //表示不需要登录
    next(); //继续往后走
  }
});


axios.interceptors.request.use(
  (config) => {
    // 获取请求的URL
    const requestUrl = config.url.substring(3);
    // 提取URL路径部分/qy/Login...
    const urlPath = requestUrl;

    // 在请求头中添加令牌信息
    const jwtToken = localStorage.getItem('jwtToken') // 从本地存储中获取令牌

    // 检查是否是登录请求
    if (urlPath !== '/StudentLogin' && urlPath !== '/StaffLogin') {
      // 如果不是登录请求，添加令牌到请求头
      if (jwtToken) {
        config.headers.jwtToken = jwtToken;
        // 把userId也添加到请求头,方便后端进行逻辑处理
        // config.headers.userId = localStorage.getItem('userId');
      }
    }
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)


Vue.prototype.$axios = axios

Vue.use(ElementUI);
Vue.use(router);
Vue.config.productionTip = false

new Vue({
  router,
  el: '#app',
  render: h => h(app)
}).$mount('#app')
