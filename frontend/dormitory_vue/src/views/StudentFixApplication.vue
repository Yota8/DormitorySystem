<template>
  <div class="input-text">
    <el-input
      type="textarea"
      :autosize="{ minRows: 6, maxRows: 255 }"
      placeholder="请输入内容"
      v-model="textarea1"
    />
    <el-button @click="submit" type="primary">提交</el-button>
  </div>
</template>



<style>
.input-text {
  margin-top: 20vh;
  margin-left: 24vw;
  width: 32vw;
  height: 32vh;
}
</style>




<script>
import axios from "axios";
export default {
  data() {
    return {
      textarea1: "",
    };
  },
  methods: {
    submit() {
      var dormId = localStorage.getItem("dormId");
      var dormBuild = localStorage.getItem("dormBuild");
      axios
        .post("api/StudentFixApplication", {
          dormId: dormId,
          dormBuild: dormBuild,
          detail: this.textarea1,
        })
        .then((result) => {
          if (result.data.code == 1) {
            this.open1();
          } else if (result.data.code == 0) {
            if (result.data.msg == "FIX_NO_MESSAGE") {
              this.open4_2();
            } else if (result.data.msg == "FIX_NOT_SUBMITTED") {
              this.open4();
            }
          }
          this.textarea1 = "";
        });
    },
    open1() {
      this.$notify({
        title: "成功",
        message: "提交成功",
        type: "success",
      });
    },
    open4() {
      this.$notify.error({
        title: "错误",
        message: "提交失败",
      });
    },
    open4_2() {
      this.$notify.error({
        title: "错误",
        message: "请输入报修内容",
      });
    },
  },
};
</script>