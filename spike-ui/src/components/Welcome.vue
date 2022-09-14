<template>
  <div class="app">
    欢迎你
  </div>
</template>

<script>
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
  methods: {

  },
}
</script>
