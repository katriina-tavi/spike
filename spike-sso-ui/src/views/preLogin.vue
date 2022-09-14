<template>

</template>
<script>
  import {logincheck} from "@/api/user"
  export default {
    name: 'preLogin',
    data() {
      return {
        form: {
          username: '',
          password: ''
        },
        loading: false,
      }
    },
    created() {
      let returnUrl = this.$route.query.returnUrl;
      localStorage.removeItem("returnUrl");
      if (returnUrl != undefined && returnUrl !=null && returnUrl != 'null') {
        localStorage.setItem("returnUrl",returnUrl);
      }
      // 查看sso server是否登录,如果登录带着token返回
      let token = localStorage.getItem("token");
      if (token != 'null') {
        // 校验登录
        logincheck(token).then(res=>{
          if (res.data.data != null) {
              window.location.href=returnUrl+"?token="+token;
          }else {
              window.location.href="/login?returnUrl="+returnUrl;
          }
        }).catch((err) => {
        })
        .finally(() => {

        });
      } else {
          window.location.href="/login?returnUrl="+returnUrl;
      }
    },
    methods: {

    }
  }
</script>

<style scoped>
  h1 {
    text-align: center;
    color: #606266;
  }

  form {
    padding: 20px;
    background: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    border-radius: 2px;
  }

  .main {
    width: 400px;
    margin: 0px auto;
  }
</style>
