<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>网页标题</title>
  <!-- 引入Element UI库 -->
  <script src="//unpkg.com/vue@2/dist/vue.js"></script>
  <script src="//unpkg.com/element-ui@2.15.13/lib/index.js"></script>
  <style>
    @import url("//unpkg.com/element-ui@2.15.13/lib/theme-chalk/index.css");

    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      min-height: 400px;
    }
  </style>
  <style>
    /* 左侧菜单样式 */
    #menu {
      float: left;

    }
    /* 右侧table样式 */
    #table {
      margin-left: 220px;
      padding: 10px;
    }
  </style>
</head>
<body>
<div id="app">
  <div id="menu" >
    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
      <el-radio-button :label="false">展开</el-radio-button>
      <el-radio-button :label="true">收起</el-radio-button>
    </el-radio-group>
    <el-menu :default-active="'user'" @select="handleMenuSelect" class="el-menu-vertical-demo"
             @open="handleOpen" @close="handleClose"
             :collapse="isCollapse">
      <el-menu-item index="goods">
        <i class="el-icon-menu"></i>
        <span slot="title">goods</span>
      </el-menu-item>
      <el-menu-item index="order">
        <i class="el-icon-document"></i>
        <span slot="title">order</span>
      </el-menu-item>
      <el-menu-item index="user">
        <i class="el-icon-setting"></i>
        <span slot="title">user</span>
      </el-menu-item>
    </el-menu>
  </div>
  <div id="table">
    <template>
      <el-table v-show="currentMenu==='goods'" :data="tableData" stripe style="width: 100%">
        <el-table-column prop="date" label="日期" width="180"></el-table-column>
        <el-table-column prop="name" label="姓名" width="180"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
      </el-table>
      <el-table v-show="currentMenu==='order'" :data="tableData" stripe style="width: 100%">
        <el-table-column prop="date" label="日期" width="180"></el-table-column>
        <el-table-column prop="name" label="姓名" width="180"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
      </el-table>
      <el-table v-show="currentMenu==='user'" :data="userTableData" stripe style="width: 100%">
        <el-table-column prop="userId"   label="用户id" width="180"></el-table-column>
        <el-table-column prop="username" label="用户名" width="180"></el-table-column>
        <el-table-column prop="balance"  label="余额"></el-table-column>
      </el-table>
    </template>
  </div>
</div>
<script>
  var Main = {
    data() {
      return {
        isCollapse: false,
        currentMenu: 'user',

        userTableData:[{
          userId:'',
          username:'',
          balance:''
        }],

        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      };
    },
    beforeCreated(){
      let sessionUname=sessionStorage.getItem("username")

      this.fetchUserData()

    },

    methods: {
      // handleOpen(key, keyPath) {
      //   console.log(key, keyPath);
      // },
      // handleClose(key, keyPath) {
      //   console.log(key, keyPath);
      // },
      handleMenuSelect(menu) {
        this.currentMenu = menu;
      },
      fetchUserData:function (username){
          this.userId=sessionStorage.getItem("userId")
          this.username=sessionStorage.getItem("sessionStorage")
          this.balance=sessionStorage.getItem("balance")
      }
    }
  }
  var Ctor = Vue.extend(Main)
  new Ctor().$mount('#app')
</script>
</body>
</html>
