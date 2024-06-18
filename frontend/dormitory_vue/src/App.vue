<template>
  <div>
    <div id="app" style="display: flex;">
      <el-carousel @change="handleArrowClick" :autoplay="false" type="card" class="choose_who" indicator-position="none">
        <el-carousel-item v-for="item in imagebox" :key="item.id"  @click.native="handleImgClick(item.name)">
          <img :src="item.idView" class="image" width="100%" height="100%" style="object-fit: scale-down;">
        </el-carousel-item>
      </el-carousel>
      <br>
      <el-row id="choose_btn">
        <el-button type="primary" @click="goCharacter">{{ buttontext }}</el-button>
      </el-row>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imagebox:[
        {id:0,name:"我是学生",idView:require('./assets/studentIcon.png')},
        {id:1,name:"我是宿管",idView:require('./assets/dormitoryStaff.png')},
      ],
      buttontext:"我是学生",
      // 用弹性布局就可以不用isShow来控制页面是否显示了
      // isShow: true,
    }
  },
  
  methods: {
    handleImgClick(name){
      this.buttontext=name;
    },
    handleArrowClick(index){
      if (index==0) {
        this.buttontext="我是学生";
      } else {
        this.buttontext="我是宿管";
      }
    },
    goCharacter(){
      if(this.buttontext=="我是学生"){
          // this.isShow=false;
          // console.log(this.isShow)
          this.$router.push("/StudentLogin");
          
      }else if(this.buttontext=="我是宿管"){
          // this.isShow=false;
          // console.log(this.isShow)
          this.$router.push("/StaffLogin");
          
      }
    },
  },

  
};
</script>



<style>
#app {
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  position: fixed;
  background-size: 100% 100%;
  background-image: url("./assets/swust_glass.jpg");
  background-repeat: no-repeat;
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center;     /* 垂直居中 */
  flex-direction: column;  /* 设定垂直方向 */
  
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.choose_who{
  background-repeat: no-repeat;
  width: 1000px;
  height: auto;
  max-height: 100%;
  max-width: 100%;
  overflow-y: hidden;
}


</style>
