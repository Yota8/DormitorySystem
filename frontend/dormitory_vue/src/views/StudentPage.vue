<template>
  <div id="StudentPage" style="display: flex; height: 100vh">
    <!-- header -->
    <el-container>
      <el-header height="8vh">
        <img
          style="width: auto; height: 8vh; float: left; margin-left: 2vw"
          src="../assets/swust_icon.jpg"
        />
        <div
          class="radius"
          style="
            border-radius: 4px;
            height: 8vh;
            width: 85vw;
            margin-left: auto;
            border: solid;
            color: #dfe4e9;
          "
        >
          <b style="font-size: x-large; color: #409eff">学生宿舍管理系统</b>
        </div>
      </el-header>

      <!-- aside -->
      <el-container>
        <el-aside width="12vw">
          <i class="el-icon-user-solid" style="width: 12vw"></i>

          <el-row class="tac">
            <el-col :span="12">
              <el-menu
                style="width: 12vw; border: 0"
                default-active="1"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                :router="true"
              >
                <el-menu-item
                  index="1"
                  style="border: 0"
                  route="/StudentMainPage"
                >
                  <i class="el-icon-s-home"></i>
                  <span slot="title">首页</span>
                </el-menu-item>
                <el-menu-item route="/StudentMyDormitory" index="2">
                  <i class="el-icon-office-building"></i>
                  <span slot="title">我的宿舍</span>
                </el-menu-item>
                <el-menu-item route="/StudentFixApplication" index="3">
                  <i class="el-icon-chat-round"></i>
                  <span slot="title">报修申请</span>
                </el-menu-item>
                <el-menu-item route="/StudentInfo" index="4">
                  <i class="el-icon-s-tools"></i>
                  <span slot="title">个人信息</span>
                </el-menu-item>
                <el-button
                  id="logout_btn"
                  @click="logOut"
                  type="danger"
                  round
                  style="margin-top: 24vh"
                  >退出</el-button
                >
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>

        <!-- main -->
        <el-main width="88vw">
          <div
            class="demo-shadow"
            style="
              box-shadow: rgba(0, 0, 0, 0.12) 0px 2px 4px,
                rgba(0, 0, 0, 0.04) 0px 0px 6px;
            "
          >
            <!-- 路由视图 -->
            <router-view></router-view>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
    
    
    
  <style>
body {
  height: 100%;
  margin: 0;
}

#StudentPage {
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
}

.box-text {
  font-size: x-large;
  color: #ffffff;
  float: left;
  margin-left: 1vw;
}

.demo-shadow {
  height: 720px;
  justify-content: center;
  border: solid;
  border-color: #e4e9ee;
}

.el-header {
  /* background-color: #f1f7f1; */
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  /* background-color: #f1f7f1; */
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  /* background-color: #ecf1f5; */
  padding-bottom: 0;
  color: #333;
  text-align: center;
  line-height: 100px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
/* .bg-purple {
    background: #d3dce6;
  } */
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
  height: 24vh;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
    
    
    
  <script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    logOut() {
      // 清除jwt令牌
      localStorage.setItem("jwtToken", "");
      // 清除本地存储的userId
      localStorage.setItem("userId", "");
      // 清除其他学生信息
      localStorage.setItem("dormId", "");
      localStorage.setItem("dormBuild", "");
      localStorage.setItem("user","");
      // 关闭此标签页
      // window.close();
      window.location.replace("/");
      window.close();
    },
    open4() {
      this.$notify.error({
        title: "警告",
        message: "未登录",
      });
    },
    beforeunload() {
      // 在页面刷新时执行的操作
      this.$router.push("/StudentMainPage");
    },
  },
  beforeCreate() {
    var appDiv = document.getElementById("app");
    // 有app标签渲染则删除
    if (appDiv != null) {
      appDiv.remove();
    }
    // this.$router.push("StudentMainPage");
  },
  created() {
    // 给学生框架页面添加刷新监听事件
    window.addEventListener("beforeunload", this.beforeunload());
  },
  destroyed() {
    window.removeEventListener("beforeunload", this.beforeunload());
  },
};
</script>