<template>
<div class="loginMain">
  <div class="login">
  <Form ref="formInline" :model="formInline" :rules="ruleInline">
    <Form-item prop="user">
          <Icon type="person" color="gray" size="25" ></Icon>
        <Input type="text" v-model="formInline.user" placeholder="请输入手机号"  style="width: 200px">
        </Input>
    </Form-item>
    <Form-item prop="password">
       <Icon type="locked" color="gray" size="25" ></Icon>
        <Input type="password" v-model="formInline.password" placeholder="请输入密码"  style="width: 200px">
        </Input>
        
    </Form-item>
    <Form-item>
        <div class="Login_sign">
             <Button type="error" @click="handleSubmit('formInline')"  size="large">登录</Button>
        </div>
        <a type="error" @click="handleSignt('formInline')"  size="large">注册</a>
    </Form-item>
</Form>
</div>
</div>
</template>
<style scoped>
    .loginMain {
        position: absolute;
        left: 0px;
        right: 0px;
        top: 0px;
        bottom: 0px;
        overflow: hidden;
        background-image: url('../../assets/newsImgs/logback.png');
    }
    
    .login {
        width: 350px;
        height: 340px;
        position: absolute;
        padding: 60px 60px;
        left: 50%;
        top: 55%;
        margin: -200px 0 0 -200px;
        background-color: white;
        border-radius: 10px;
    }
    
    .login ico {
        border-right-color: gray;
    }
    
    .login a {
        float: right;
        font-size: 16px;
    }
    
    .Login_sign Button {
        width: 200px;
        margin: 0 20px;
    }
</style>
<script>
    export default {
        data() {
            return {
                formInline: {
                    user: '',
                    password: ''
                },
                ruleInline: {
                    user: [{
                        required: true,
                        message: '请填写手机号',
                        trigger: 'blur'
                    }, {
                        max: 11,
                        min: 11,
                        message: '手机号输入错误',
                        trigger: 'blur'
                    }],
                    password: [{
                        required: true,
                        message: '请填写密码',
                        trigger: 'blur'
                    }, {
                        min: 6,
                        message: '密码长度不能小于6位',
                        trigger: 'blur'
                    }]
                }
            }
        },
        methods: {
            handleSubmit(name) {
                var vm = this
                console.log(vm.formInline)
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$http.post(
                            'do/loginController/login', vm.formInline, {
                                emulateJSON: true
                            }
                        ).then(function(data) {
                            if (data.data == 'success') {
                                this.$Message.success('登陆成功!');
                            } else if (data === 'userError') {
                                this.$Message.success('登陆失败，请检查用户名!');
                            } else {
                                this.$Message.success('登陆失败，请检查密码!');
                            }
                        }, function(error) {
                            //error
                        })
                    } else {
                        this.$Message.error('登陆失败，请检查用户名、密码!');
                    }
                })
            },
            handleSignt(name) {
                this.$router.push({
                    path: '/signPage2'
                })
            }
        }
    }
</script>