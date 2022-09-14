<template>
  <el-container v-loading="loading">
    <el-header></el-header>
    <el-main class="main">
      <h1>SPIKE SSO</h1>
      <el-form ref="form" :model="form" class="z-depth-2">
        <el-form-item>
          <el-input v-model="form.username" placeholder="username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="form.password" placeholder="password" type="password"></el-input>
        </el-form-item>
        <el-form-item style="text-align:right;">
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer></el-footer>
  </el-container>
</template>
<script>
  import {login} from "@/api/user"
  export default {
    name: 'Login',
    data() {
      return {
        form: {
          username: '',
          password: ''
        },
        loading: false,
      }
    },
    methods: {
      login () {
        this.loading = true;
        let param = {
          ...this.form,
        }
        login(param).then((res) => {
          this.loading = false;
          localStorage.setItem("token",res.data.data);
          let returnUrl = this.$route.query.returnUrl;
          if (res.data.code == 200) {
            if (returnUrl !=undefined && returnUrl != 'null') {
              window.location.href=returnUrl+"?token="+res.data.data;
            } else {
              this.$router.push('/')
            }
          } else {
            this.$message.error(res.data.msg);
          }
        });
      }
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
