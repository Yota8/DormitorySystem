<template>
  <div>
    <div id="student-login">
      <div style="display: flex; justify-content: center; margin-top: 150px">
        <el-card style="width: 500px; height: 400px">
          <div
            slot="header"
            class="clearfix"
            style="flex-direction: row; justify-content: center"
          >
            <div class="icon-container">
              <img src="../assets/swust_icon.jpg" width="40px" height="40px" />
            </div>
            <span style="font-size: 26px; font-weight: 700; color: dodgerblue">
              学生登录
            </span>
          </div>
          <table style="margin: 0 auto; border-spacing: 22px">
            <tr>
              <td>账号</td>
              <td>
                <el-input
                  id="idInput"
                  v-model="user.id"
                  type="text"
                  placeholder="学生账号为学号"
                ></el-input>
              </td>
            </tr>
            <tr>
              <td>密码</td>
              <td>
                <el-input
                  id="passwordInput"
                  show-password
                  v-model="user.password"
                  maxlength="15"
                  minlength="6"
                  placeholder="请输入密码"
                  @keydown.enter.native="doLogin"
                >
                </el-input>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <el-button
                  style="width: 320px; margin-top: 15px"
                  type="primary"
                  @click="doLogin"
                >
                  登录
                </el-button>
              </td>
            </tr>
            <tr>
              <td colspan="2" style="text-align: center">
                <el-link style="width: 70px" type="primary" @click="doBind"
                  >绑定手机号</el-link
                >
                <b style="padding: 20px; color: #409eff">|</b>
                <el-link style="width: 70px" type="primary" @click="doForget"
                  >忘记密码</el-link
                >
              </td>
            </tr>
          </table>
        </el-card>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>


<style>
#student-login {
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  position: fixed;
  background-size: 100% 100%;
  background-image: url("../assets/swust_glass.jpg");
  background-repeat: no-repeat;
  display: flex;
  justify-content: center;
}

.clearfix {
  display: flex;
}

.icon-container {
  display: flex;
  margin-right: 10px;
}
</style>


<script>
export default {
  data() {
    return {
      user: {
        id: "",
        password: "",
      },
      isShow: true,
    };
  },
  methods: {
    doLogin() {
      console.log(this.user.id);
      console.log(this.user.password);
      this.$axios
        .post("api/StudentLogin", {
          id: Number(this.user.id),
          password: Number(this.user.password),
        })
        // .then(result=>{console.log(JSON.stringify(result.data.code))})
        .then((result) => {
          console.log(result.data.code);
          if (result.data.code == 1) {
            // code为1,登录成功,携带jwt跳转到管理系统页面
            localStorage.setItem("userId", JSON.stringify(this.user.id));
            localStorage.setItem("jwtToken", JSON.stringify(result.data.data));
            this.user.id = "";
            this.user.password = "";
            window.open("/StudentMainPage");
          } else if (result.data.code == 0) {
            // code为0,登录失败,根据msg内容,渲染相应弹框内容
            this.open4();
          }
        });
    },
    doBind() {
      this.isShow = false;
      console.log(this.isShow);
      this.$router.push("/Bind");
    },
    doForget() {
      this.$router.push("/Forget");
    },
    open4() {
      this.$notify.error({
        title: "登录失败",
        message: "请检查账户密码是否正确",
      });
    },
  },
};
</script>
