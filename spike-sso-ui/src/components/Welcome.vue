<template>
  <div class="app">
    欢迎你
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
        "size": this.pageSize,
        "entity": this.form,
      };
      page(data).then((res)=> {
        this.tableData = res.data.data.records;
        this.total = parseInt(res.data.data.total);
      }).finally(()=>{
        this.loading = false;
      });
    }
  },
}
</script>
