<template>
  <el-container>
    <div id="main-page-content">
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
            <b class="box-text"> 未归次数 </b>
            <br />
            <b
              class="box-text"
              style="margin-left: 1.5vw; font-size: xx-large; line-height: 60px"
            >
              {{ box1 }}
            </b>
          </div>
        </el-col>
        <el-col
          :span="6"
          style="margin-left: 10vw; width: 16vw; background-color: #40a0ff8c"
        >
          <div class="grid-content">
            <b class="box-text"> 寝室号 </b>
            <br />
            <b
              class="box-text"
              style="margin-left: 1.5vw; font-size: xx-large; line-height: 60px"
            >
              {{ box2 }}
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
            <b class="box-text"> 居住状态 </b>
            <br />
            <b
              class="box-text"
              style="margin-left: 1.5vw; font-size: xx-large; line-height: 60px"
            >
              {{ box3 }}
            </b>
          </div>
        </el-col>
      </el-row>
    </div>
  </el-container>
</template>
  
  
  
<style>
body {
  height: 100%;
  margin: 0;
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
import axios from "axios";

export default {
  data() {
    return {
      jwtToken: "",
      box1: "",
      box2: "",
      box3: "",
    };
  },
  beforeCreate() {
    var user = localStorage.getItem("userId");
    user = user.replaceAll('"', "");
    if (user != null) {
      var userId = Number(user);
      // 👇👇main.js中通过axios拦截器已经解决了
      // 拿到储存在本地的jwt令牌,并赋值给请求头
      // this.jwtToken = localStorage.getItem("jwtToken");
      axios
        .post("api/StudentMainPage", {
          id: userId,
        })
        .then((result) => {
          if (result.data.msg != "PARSE_ERROR") {
            this.box1 = result.data.recordTimes;
            this.box2 = result.data.dormBuild + " " + result.data.dormId;
            this.box3 = result.data.liveStatus == 1 ? "校内居住" : "在外居住";
            localStorage.setItem("dormId", result.data.dormId);
            localStorage.setItem("dormBuild", result.data.dormBuild);
            localStorage.setItem("user",JSON.stringify(result.data));
            console.log(result.data)
          } else {
            this.open_parse_error();
          }
        });
    } else {
      // 弹窗未登录错误
      this.open4();
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    open4() {
      this.$notify.error({
        title: "警告",
        message: "未登录",
      });
    },
    open_parse_error() {
      this.$notify.error({
        title: "警告",
        message: "登录过期,请重新登录",
      });
    },
  },
};
</script>