<template>
<div class="signMain_2">
  <div class="sign2">
    <Form ref="formCustom" :model="formCustom" :rules="ruleCustom" :label-width="60">
         <Form-item label="账号" prop="name">
            <Input type="text" v-model="formCustom.name" placeholder="请输入账号"></Input>
        </Form-item>
        <Form-item label="密码" prop="passwd">
            <Input type="password" v-model="formCustom.passwd" placeholder="请输入密码"></Input>
        </Form-item>
        <Form-item label="确认密码" prop="passwdCheck">
            <Input type="password" v-model="formCustom.passwdCheck" placeholder="请再次输入密码"></Input>
        </Form-item>
       <div class="sign2_sign">
            <Button type="ghost" @click="handleReset('formCustom')">重置</Button>
             <Button type="primary" @click="handleSubmit('formCustom')">提交</Button>
        </div>
    </Form>
</div>
</div>
</template>
<style scoped>
    .signMain_2 {
        position: absolute;
        left: 0px;
        right: 0px;
        top: 0px;
        bottom: 0px;
        overflow: hidden;
        background-image: url('../../assets/newsImgs/logback.png');
    }
    
    .sign2 {
        width: 400px;
        height: 320px;
        position: absolute;
        padding: 50px 60px;
        left: 50%;
        top: 55%;
        margin: -200px 0 0 -200px;
        background-color: white;
        border-radius: 10px;
    }
    
    .sign2 ico {
        border-right-color: gray;
    }
    
    .sign2 a {
        float: right;
        font-size: 16px;
    }
    
    .sign2 .idenfityCode {
        display: inline-block;
        margin-top: 10px;
        float: right;
    }
    
    .sign2_sign Button {
        width: 100px;
        float: left;
        display: inline-block;
        margin: 0 20px;
    }
</style>
<script>
    export default {
        data() {
            const validateName = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入名称'));
                } else {
                    if (this.formCustom.passwdCheck !== '') {
                        this.$refs.formCustom.validateField('passwdCheck');
                    }
                    callback();
                }
            };
            const validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.formCustom.passwdCheck !== '') {
                        // 对第二个密码框单独验证
                        this.$refs.formCustom.validateField('passwdCheck');
                    }
                    callback();
                }
            };
            const validatePassCheck = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.formCustom.passwd) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };

            return {
                formCustom: {
                    passwd: '',
                    passwdCheck: '',
                    name: ''
                },
                ruleCustom: {
                    name: [{
                        required: true,
                        message: '账号不能为空',
                        trigger: 'blur'
                    }, {
                        min: 6,
                        message: '长度不能小于6位',
                        trigger: 'blur'
                    }],
                    passwd: [{
                        validator: validatePass,
                        trigger: 'blur'
                    }, {
                        min: 6,
                        message: '密码长度不能小于6位',
                        trigger: 'blur'
                    }],
                    passwdCheck: [{
                        validator: validatePassCheck,
                        min: 6,
                        trigger: 'blur'
                    }]
                }
            }
        },
        methods: {
            handleSubmit(name) { //提交
                const vm = this
                this.$refs[name].validate((valid) => {
                    console.log(this)
                    if (valid) {
                        this.$http.post(
                            'do/loginController/sign', {
                                userName: this.formCustom.name,
                                passwd: this.formCustom.passwd,
                                phoneCode: this.$store.state.user.phoneCode
                            }, {
                                emulateJSON: true
                            }
                        ).then(function(response) {
                            if (response.data[0] == 'success') {
                                this.$Message.success('注册成功!')
                                this.$store.dispatch('saveUserName', this.formCustom.name)
                                this.$router.push({
                                    path: '/index'
                                })
                            } else {
                                this.$Message.error('注册失败!');
                            }
                        }, function(error) {
                            //error
                            this.$Message.error('注册失败!');
                        })
                    } else {
                        this.$Message.error('请检查账号、密码!');
                    }
                })
            },
            handleReset(name) { //重置
                this.$refs[name].resetFields();
            }
        }
    }
</script>