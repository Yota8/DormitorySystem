<template>
  <div id="staff-login">
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
            宿管登录
          </span>
        </div>
        <table style="margin: 0 auto; border-spacing: 22px">
          <tr>
            <td>账号</td>
            <td>
              <el-input
                v-model="user.username"
                type="text"
                placeholder="请输入账号"
              ></el-input>
            </td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <el-input
                show-password
                v-model="user.password"
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
          <td colspan="2" style="text-align: center">
            <el-link type="primary" @click="doForget">忘记密码</el-link>
          </td>
        </table>
      </el-card>
    </div>
  </div>
</template>


<style>
#staff-login {
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
        username: "",
        password: "",
      },
    };
  },

  methods: {
    doLogin() {
      console.log("登录中");
    },
    doForget() {
      this.$router.push("/Forget/");
    },
  },
};
</script>
