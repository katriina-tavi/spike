<template>
  <div class="app">

    <el-form :inline="true" :model="form" class="demo-form-inline">
      <el-form-item label="账号">
        <el-input v-model="form.userAccount" placeholder="账号" size="small"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.userName" placeholder="姓名" size="small"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" size="small" @click="page()">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table
        v-loading="loading"
        :data="tableData" style="width: 100%">
      <el-table-column prop="userAccount" label="账号" width="180"></el-table-column>
      <el-table-column prop="userName" label="姓名" width="180"></el-table-column>
      <el-table-column prop="phone" label="手机号"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
    </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
import { page } from "@/api/sys/user";
export default {
  data() {
    return {
      form: {},
      tableData: [],
      // 默认显示第一条
      currentPage:1,
      pageSize: 10,
      total: 0,
      loading: false,
      userId: 122222
    }
  },
  created() {
    this.page();
  },
  mounted () {

  },
  methods: {
    handleSizeChange(val) {
      this.pageSize = val;
      this.page();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.page();
    },
    page() {
      this.loading = true;
      let data = {
        "current" : this.currentPage,
        "size": this.pageSize,
        "entity": this.form,
      };
      page(data).then((res)=> {
        this.tableData = res.data.records;
        this.total = res.data.total;
      }).finally(()=>{
        this.loading = false;
      });
    }
  },
}
</script>
