<template>
  <div>
    <div id="forget-view" style="display: flex; justify-content: center">
      <el-card style="width: 560px; height: 520px; margin-top: 150px">
        <div
          slot="header"
          class="clearfix"
          style="flex-direction: row; justify-content: center"
        >
          <div class="icon-container">
            <img src="../assets/swust_icon.jpg" width="40px" height="40px" />
          </div>
          <span style="font-size: 26px; font-weight: 700; color: dodgerblue">
            找回密码
          </span>
        </div>
        <table style="margin: 0 auto; border-spacing: 22px">
          <tr>
            <td>手机号</td>
            <td>
              <el-input
                v-model="recovery.telephone"
                type="tel"
                placeholder="请输入手机号"
              ></el-input>
            </td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <el-input
                v-model="recovery.password"
                type="text"
                placeholder="密码"
              ></el-input>
            </td>
          </tr>
          <tr>
            <td>确认密码</td>
            <td>
              <el-input
                v-model="recovery.confirmPassword"
                type="text"
                placeholder="重新输入密码"
              ></el-input>
            </td>
          </tr>
          <tr>
            <td>验证码</td>
            <td>
              <el-input
                type="text"
                v-model="recovery.SMSCode"
                placeholder="请输入验证码"
              >
              </el-input>
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <el-button
                style="width: 320px; margin-top: 15px"
                type="primary"
                @click="doRecovery"
              >
                重置密码
              </el-button>
            </td>
          </tr>
        </table>
      </el-card>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      recovery: {
        telephone: "",
        password: "",
        confirmPassword: "",
        SMSCode: "",
      },
    };
  },

  methods: {
    doRecovery() {
      console.log(this.user.username);
      console.log(this.user.password);
    },
  },
};
</script>


<style>
#forget-view {
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