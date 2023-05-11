<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>网页标题</title>
  <!-- 引入Element UI库 -->
  <script src="//unpkg.com/vue@2/dist/vue.js"></script>
  <script src="//unpkg.com/element-ui@2.15.13/lib/index.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
  <div id="menu">
    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
      <el-radio-button :label="false">展开</el-radio-button>
      <el-radio-button :label="true">收起</el-radio-button>
    </el-radio-group>
    <el-menu :default-active="'user'" @select="handleMenuSelect" class="el-menu-vertical-demo"
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
      <el-table v-show="currentMenu==='goods'" :data="goodsTableData" stripe style="width: 100%">
        <el-table-column prop="goodsId" label="商品id" width="180"></el-table-column>
        <el-table-column prop="goodsCode" label="商品码" width="180"></el-table-column>
        <el-table-column prop="goodsName" label="商品名称"></el-table-column>
        <el-table-column prop="inPrice" label="进价"></el-table-column>
        <el-table-column prop="salePrice" label="售价"></el-table-column>
        <el-table-column prop="goodsQuantity" label="库存"></el-table-column>
        <el-table-column prop="count" v-if="false"></el-table-column>
        <el-table-column label="数量">
          <template slot-scope="scope">
            <el-input v-model="scope.row.count" placeholder="0" :max="scope.row.goodsQuantity" min="0"
                      type="number">
            </el-input>
          </template>
        </el-table-column>
        <el-table-column>
          <el-row>
            <el-button type="success" round @doBuy()>购买</el-button>
          </el-row>
        </el-table-column>

      </el-table>


      <el-table v-show="currentMenu==='order'" :data="orderTableData" stripe style="width: 100%">
        <el-table-column prop="orderId" label="订单号" width="180"></el-table-column>
        <el-table-column prop="createTime" label="订单时间" width="180"></el-table-column>
        <el-table-column prop="username" label="购买者"></el-table-column>
        <el-table-column prop="originPrice" label="原价"></el-table-column>
        <el-table-column prop="discount" label="折扣"></el-table-column>
        <el-table-column prop="paidMoney" label="实收款"></el-table-column>
      </el-table>
      <el-table v-show="currentMenu==='user'" :data="userTableData" stripe style="width: 100%">
        <el-table-column prop="userId" label="用户id" width="180"></el-table-column>
        <el-table-column prop="username" label="用户名" width="180"></el-table-column>
        <el-table-column prop="balance" label="余额"></el-table-column>
        <el-table-column label="充值余额">
          <template slot-scope="scope">
            <el-input v-model="moneyAmount" placeholder="请输入充值金额:"></el-input>
          </template>
        </el-table-column>
        <el-table-column>
          <el-button type="primary" plain @click="addMoney">点击充值</el-button>
        </el-table-column>


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
        moneyAmount: '',


        orderTableData: [{
          orderId: '',
          createTime: '',
          username: '',
          originPrice: '',
          discount: '',
          paidMoney: ''
        }],

        userTableData: [{
          userId: '',
          username: '',
          balance: '',
        }],

        goodsTableData: [{
          goodsId: '',
          goodsCode: '',
          goodsName: '',
          inPrice: '',
          salePrice: '',
          goodsQuantity: '',

        }]


      };
    },
    created() {
      this.pullUserData();
      this.fetchGoodsData();
      this.fetchOrdersData()
    },

    methods: {
      handleMenuSelect(menu) {
        this.currentMenu = menu;
      },

      pullUserData() {
        this.userTableData = [{
          userId: sessionStorage.getItem("userId"),
          username: sessionStorage.getItem("username"),
          balance: sessionStorage.getItem("balance")
        }]
      },

      addMoney() {
        axios.put("http://localhost:80/user/update", {
          "username": sessionStorage.getItem("username"),
          "balance": this.moneyAmount
        }).then((response) => {
          if (response.data.code == '200') {
            sessionStorage.setItem("balance", response.data.data.balance)
            alert("充值成功")
            this.moneyAmount = ""
            this.pullUserData()

          } else {
            alert(新增失败);
          }
        })
      },

      fetchGoodsData() {
        axios.get("http://localhost:80/goods/getAll").then(response => {
          this.goodsTableData = response.data.data
        })
      },

      fetchOrdersData() {
        axios.get("http://localhost:80/order/getAll").then(response => {
          this.orderTableData = response.data.data
        })
      },

      doBuy(){

      }
    }
  }
  var Ctor = Vue.extend(Main)
  new Ctor().$mount('#app')
</script>
</body>
</html>
