<template>
<div class="signMain">
  <div class="sign">
  <Form ref="formInline" :model="formInline" :rules="ruleInline">
    <Form-item prop="phoneCode">
          <Icon type="person" color="gray" size="25" ></Icon>
         <Input type="text" v-model="formInline.phoneCode" placeholder="请输入手机号" style="width: 200px">  
        </Input>
    </Form-item>
     <Form-item prop="idenfityCode">
       <Icon type="unlocked" color="gray" size="25" ></Icon>
        <Input class="i-name ico" type="text" v-model="formInline.idenfityCode" placeholder="请输入验证码"  style="width: 200px">
        </Input>
         <Button class="idenfityCode" type="info" @click="getidenfityCode('formInline')"  size="small">{{getidenfityCodeContent}}</Button>
    </Form-item>
    <Form-item>
        <div class="sign_sign">
             <Button type="error" @click="handleSignt('formInline')"  size="large">注册</Button>
              <!--<Button type="error" @click="handleSignt2('formInline')"  size="large">获取ip</Button>-->
        </div>
        
    </Form-item>
</Form>
</div>
</div>
</template>
<style scoped>
    .signMain {
        position: absolute;
        left: 0px;
        right: 0px;
        top: 0px;
        bottom: 0px;
        overflow: hidden;
        background-image: url('../../assets/newsImgs/logback.png');
    }
    
    .sign {
        width: 350px;
        height: 300px;
        position: absolute;
        padding: 50px 60px;
        left: 50%;
        top: 55%;
        margin: -200px 0 0 -200px;
        background-color: white;
        border-radius: 10px;
    }
    
    .sign ico {
        border-right-color: gray;
    }
    
    .sign a {
        float: right;
        font-size: 16px;
    }
    
    .sign .idenfityCode {
        display: inline-block;
        margin-top: 10px;
        float: right;
    }
    
    .sign_sign Button {
        width: 200px;
        margin: 0 20px;
    }
</style>
<script>
    import $ from 'jquery'
    export default {
        data() {
            return {
                formInline: {
                    phoneCode: '',
                    idenfityCode: '' //输入的验证码
                },
                randomCode: -1, //随机生成的验证码
                ruleInline: {
                    phoneCode: [{
                        required: true,
                        message: '请填写手机号',
                        trigger: 'blur'
                    }, {
                        min: 11,
                        max: 11,
                        message: '输入手机号不正确',
                        trigger: 'blur'
                    }],
                    idenfityCode: [{
                        required: false,
                        message: '请输入验证码',
                        trigger: 'blur'
                    }, {
                        min: 4,
                        max: 4,
                        message: '验证码不正确',
                        trigger: 'blur'
                    }]
                },
                getidenfityCodeContent: '获取验证码'
            }
        },
        methods: {
            handleSignt(name) { //注册
                const vm = this
                    // vm.$store.dispatch('saveUserPhoneCode', vm.formInline.phoneCode)
                    // vm.$router.push({
                    //     path: '/signPage2'
                    // })
                vm.$refs[name].validate((valid) => {
                    if (valid) {
                        if (vm.formInline.idenfityCode == vm.randomCode && vm.randomCode != -1) {
                            vm.$store.dispatch('saveUserPhoneCode', vm.formInline.phoneCode)
                            vm.$router.push({
                                path: '/signPage2'
                            })
                            this.$http.post(
                                '/do/loginController/userSign', {
                                    userMess: vm.formInline
                                }, {
                                    emulateJSON: true
                                }
                            ).then(function(data) {
                                if (data === 'success') {
                                    vm.$Message.success('注册成功!')
                                    vm.$router.push({
                                        path: '/index'
                                    })
                                }
                            }, function(error) {
                                //error
                            })
                        } else {
                            vm.$Message.error('注册失败，请检查用户名、密码!')
                        }
                    }
                })
            },
            handleSignt2(name) { //获取ip
                $.ajax({
                    url: "do/getRemortIp/getRemortIpFun",
                    type: 'POST',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function(data) {
                        console.log(data)
                    }
                })
            },
            getidenfityCode(name) { //获取验证码
                // vm.GetRTime(10)

                //
                this.randomCode = this.getidenfityCodeFromFunc(1000, 9999)
                if (this.randomCode === -1) {
                    this.$Message.error('验证码获取失败！')
                } else {
                    this.$refs[name].validate((valid) => {
                        if (valid) {
                            $.ajax({
                                url: "http://106.ihuyi.com/webservice/sms.php?method=Submit",
                                type: 'GEt',
                                dataType: 'JSONP',
                                data: {
                                    account: 'C46973219',
                                    password: 'd99fab5b255ae8f7b202b849994cb4c0',
                                    mobile: this.formInline.phoneCode,
                                    format: 'json',
                                    content: '您的验证码是：' + this.randomCode + '。请不要把验证码泄露给其他人。'
                                },
                                success: function(data) {
                                    if (data.code === 2) {
                                        this.$Message.success('验证码已发送到手机!')
                                    }
                                }
                            })
                        } else {
                            this.$Message.error('验证码获取失败！')
                        }

                    })
                }
            },
            getidenfityCodeFromFunc: function(max, min) {
                return Math.floor(Math.random() * (max - min)) + min
            },
            GetRTime: function(time) {
                const vm = this
                window.setTimeout(function() {

                }, 1000)

                if (time == 0) {
                    time = 60
                    vm.getidenfityCodeContent = '获取验证码'
                } else {
                    time--
                    vm.getidenfityCodeContent = time + 's'
                }
            }
        }
    }
</script>