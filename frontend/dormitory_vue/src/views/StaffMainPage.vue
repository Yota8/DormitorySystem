<template>
  <div id="StudentMainPage" style="display: flex; height: 100vh">
    <el-container>
      <el-header height="10vh">
        <img
          style="width: auto; height: 10vh; float: left; margin-left: 2vw"
          src="../assets/swust_icon.jpg"
        />
        <div
          class="radius"
          style="
            border-radius: 4px;
            height: 10vh;
            width: 85.6vw;
            margin-left: auto;
            border: solid;
            color: #dfe4e9;
          "
        >
          <b style="font-size: x-large; color: #409eff">学生宿舍管理系统</b>
        </div>
      </el-header>

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
              >
                <el-menu-item index="1" style="border: 0">
                  <i class="el-icon-s-home"></i>
                  <span slot="title">首页</span>
                </el-menu-item>
                <el-menu-item index="2">
                  <i class="el-icon-office-building"></i>
                  <span slot="title">宿舍未归处理</span>
                </el-menu-item>
                <el-menu-item index="3">
                  <i class="el-icon-chat-round"></i>
                  <span slot="title">报修申请处理</span>
                </el-menu-item>
                <el-menu-item index="4">
                  <i class="el-icon-s-tools"></i>
                  <span slot="title">个人信息</span>
                </el-menu-item>
                <el-button
                  id="logout_btn"
                  type="danger"
                  round
                  style="margin-top: 30vh"
                  >退出</el-button
                >
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>

        <el-main width="88vw">
          <div
            class="demo-shadow"
            style="
              box-shadow: rgba(0, 0, 0, 0.12) 0px 2px 4px,
                rgba(0, 0, 0, 0.04) 0px 0px 6px;
            "
          >
            <el-row :gutter="20" style="margin-top: 16vh">
              <el-col
                :span="6"
                style="
                  margin-left: 10vw;
                  width: 16vw;
                  background-color: rgba(95, 158, 160, 0.459);
                "
              >
                <div class="grid-content">
                  <b class="box-text"> 学生统计 </b>
                  <br />
                  <b
                    class="box-text"
                    style="
                      margin-left: 2vw;
                      font-size: xx-large;
                      line-height: 60px;
                    "
                  >
                  </b>
                </div>
              </el-col>
              <el-col
                :span="6"
                style="
                  margin-left: 10vw;
                  width: 16vw;
                  background-color: #40a0ff8c;
                "
              >
                <div class="grid-content">
                  <b class="box-text"> 住宿人数 </b>
                  <br />
                  <b
                    class="box-text"
                    style="
                      margin-left: 2vw;
                      font-size: xx-large;
                      line-height: 60px;
                    "
                  >
                  </b>
                </div>
              </el-col>
              <el-col
                :span="6"
                style="
                  margin-left: 10vw;
                  width: 16vw;
                  background-color: rgba(134, 235, 33, 0.637);
                "
              >
                <div class="grid-content">
                  <b class="box-text"> 报修统计 </b>
                  <br />
                  <b
                    class="box-text"
                    style="
                      margin-left: 2vw;
                      font-size: xx-large;
                      line-height: 60px;
                    "
                  >
                  </b>
                </div>
              </el-col>
            </el-row>
          </div>
        </el-main>
      </el-container>
    </el-container>
    <router-view></router-view>
  </div>
</template>
  
  
  
<style>
body {
  height: 100%;
  margin: 0;
}

#StudentMainPage {
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
  beforeCreate() {
    var appDiv = document.getElementById("app");
    appDiv.remove();
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>