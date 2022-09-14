<template>
  <div class="app">
    <el-table
        v-loading="loading"
        :data="tableData" style="width: 100%">
      <el-table-column prop="menuCode" label="菜单编码" width="180"></el-table-column>
      <el-table-column prop="menuName" label="菜单名称" width="180"></el-table-column>
      <el-table-column prop="menuType" label="类型"></el-table-column>
      <el-table-column prop="path" label="路由地址"></el-table-column>
      <el-table-column prop="component" label="组件"></el-table-column>
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
import { page } from "@/api/sys/menu";
export default {
  data() {
    return {
      tableData: [],
      // 默认显示第一条
      currentPage:1,
      pageSize: 10,
      total: 0,
      loading: false,
    }
  },
  created() {
    this.page();
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
        "size": this.pageSize
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
