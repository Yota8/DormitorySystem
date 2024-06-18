import Vue from 'vue'
import VueRouter from 'vue-router'

const originalPush = VueRouter.prototype.push

VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter)

const routes = [
  // 这个地方害的我花了一天时间,原因是如果/路径也路由的话，会导致有两个app.vue的主标签生成，从而导致页面混乱
  // {
  //   path:'/',
  //   name:'home',
  //   component: () => import('../App.vue')
  // },
  {
    path: '/StudentLogin',
    name: 'StudentLogin',
    component: () => import('../views/StudentLogin.vue')
  },
  {
    path: '/StaffLogin',
    name: 'StaffLogin',
    component: () => import('../views/StaffLogin.vue')
  },
  {
    path: '/Bind',
    name: 'Bind',
    component: () => import('../views/BindView.vue')
  },
  {
    path: '/Forget',
    name: 'Forget',
    component: () => import('../views/ForgetView.vue')
  },
  {
    path: '/StudentPage',
    name: 'StudentPage',
    component: () => import('../views/StudentPage.vue'),
    meta: {
      needLogin: true
    },
    children: [{
        path: '/StudentMainPage',
        name: 'StudentMainPage',
        component: () => import('../views/StudentMainPage.vue'),
      },
      {
        path: '/StudentMyDormitory',
        component: () => import('../views/StudentMyDormitory.vue')
      },
      {
        path: '/StudentFixApplication',
        component: () => import("../views/StudentFixApplication.vue")
      },
      {
        path: '/StudentInfo',
        component: () => import("../views/StudentInfo.vue")
      },
    ]
  },
  {
    path: '/StaffPage',
    name: 'StaffPage',
    component: () => import('../views/StaffPage.vue'),
    meta: {
      needLogin: true
    },
  },
]

const router = new VueRouter({
  mode: 'history',
  routes
})


export default router
