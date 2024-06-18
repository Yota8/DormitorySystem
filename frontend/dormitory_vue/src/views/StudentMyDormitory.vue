<template>
  <div>
    <el-skeleton v-if="isSkeletonShow" :rows="5" animated />
    <h3 v-if="isTableShow">宿舍信息</h3>
    <el-table
      v-if="isTableShow"
      class="tableData"
      :data="tableData"
      stripe
      style="width: 80%"
    >
      <el-table-column prop="name" label="姓名"> </el-table-column>
      <el-table-column prop="telephone" label="联系方式"> </el-table-column>
      <el-table-column prop="liveStatus" label="是否在校居住">
      </el-table-column>
    </el-table>
  </div>
</template>




<style>
.tableData {
  height: 100%;
  position: relative;
  margin: 0 auto;
}
</style>




<script>
import axios from "axios";

export default {
  data() {
    return {
      tableData: [],
      isSkeletonShow: true,
      isTableShow: false,
    };
  },
  methods: {
    open4() {
      this.$notify.error({
        title: "警告",
        message: "未登录",
      });
    },
  },
  beforeCreate() {
    var user = localStorage.getItem("userId");
    user = user.replaceAll('"', "");
    if (user != null) {
      var userId = Number(user);

      axios
        .post("api/StudentMyDormitory", {
          id: userId,
        })
        .then((result) => {
          if (result.data.code != 0) {
            var len = result.data.length;
            for (var i = 0; i < len; i++) {
              if (result.data[i].liveStatus == 1) {
                result.data[i].liveStatus = "校内居住";
              } else if (result.data[i].liveStatus == 0) {
                result.data[i].liveStatus = "校外居住";
              }
              this.tableData.push(result.data[i]);
              console.log(result.data[i]);
            }
            this.isSkeletonShow = false;
            this.isTableShow = true;
          } else {
            this.open4();
          }
        });
    } else {
      // 弹窗未登录错误
      this.open4();
    }
  },
  destroyed() {
    this.isSkeletonShow = true;
    this.isTableShow = false;
  },
};
</script>