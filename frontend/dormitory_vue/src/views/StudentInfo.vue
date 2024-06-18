<template>
  <el-form
    class="student-form"
    ref="form"
    :model="form"
    label-width="120px"
    label-position="left"
  >
    <el-form-item label="学号">
      <el-input disabled v-model="form.id"></el-input>
    </el-form-item>
    <el-form-item label="姓名">
      <el-input disabled v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-input disabled v-model="form.sex"></el-input>
    </el-form-item>
    <el-form-item label="联系方式">
      <el-input v-model="form.telephone"></el-input>
    </el-form-item>
    <el-form-item label="宿舍分配意愿">
      <el-input disabled v-model="form.dorm"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">提交</el-button>
    </el-form-item>
  </el-form>
</template>


<style>
.student-form {
  margin: 5% auto;
  height: 50vh;
  width: 40vw;
}
</style>


<script>
import axios from "axios";

export default {
  data() {
    return {
      user: '',
      form: {
        id: '',
        name: '',
        sex: '',
        telephone: '',
        dorm: '',
      },
    };
  },
  methods: {
    // 更改信息(这里就一项联系方式)
    onSubmit() {
      console.log("submit!");
      axios
        .post("api/StudentInfo", {
          telephone: this.telephone,
        })
        .then((result) => {
          if (result.data.code == 1) {
            this.open1();
          } else if (result.data.code == 0) {
            if (result.data.msg == "INFO_NO_MESSAGE") {
              this.open4_2();
            } else if (result.data.msg == "INFO_NOT_SUBMITTED") {
              this.open4();
            }
          }
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
        message: "输入框不能为空",
      });
    },
  },
  beforeCreate() {
    this.user = JSON.parse(localStorage.getItem("user"));
    
  },
};
</script>