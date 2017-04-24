<template>
       <div class="main_header col">
            <div class="col-md col-md-8">
                <span><div id="weather"></div></span>
            </div>
            <div class="col-md col-md-4">
                <span v-for="item in headMess" :key="item.key" >
                    <a class="headMess_child" v-bind:style="item.class" @click="jumpPageOfClickThis(item.key)">{{item.name}}</a>
                </span>
</div>
</div>
</template>
<style scoped>
    .main_header {
        position: absolute;
        width: 100%;
        height: 40px;
        left: 0px;
        right: 0px;
        top: 0px;
        background-color: #222222;
    }
    
    .col-md {
        height: 40px;
    }
    
    #weather {
        height: 40px;
    }
    
    .col-md span {
        color: rgba(255, 255, 255, .9);
        font-size: 16px;
        line-height: 40px;
    }
    
    .col-md span:hover {
        color: rgba(255, 255, 255, .7);
    }
    
    .headMess_child {
        width: 60px;
        display: inline-block;
        /*float: right;*/
    }
</style>
<script>
    import $ from 'jquery'
    export default {
        data() {
            return {
                headMess: [{
                    name: '登陆',
                    key: 1,
                    class: {
                        color: 'red'
                    }
                }, {
                    name: '问答',
                    key: 2,
                    class: {}
                }, {
                    name: '图虫',
                    key: 3,
                    class: {}
                }, {
                    name: '头号',
                    key: 4,
                    class: {}
                }, {
                    name: '反馈',
                    key: 5,
                    class: {}
                }, {
                    name: '更多',
                    key: 6,
                    class: {}
                }]
            }
        },
        mounted: function() { /* 页面初始化的钩子 beforeCreate  */
            this.getWeatherMess()
        },
        methods: {
            'getWeatherMess': function() {
                var cityUrl = 'http://pv.sohu.com/cityjson'
                $.getScript(cityUrl, function(script, textStatus, jqXHR) {
                    var citytq = returnCitySN.cname; // 获取城市 (上海市)
                    if (citytq.substr(citytq.length - 1, citytq.length - 1) == '市') {
                        citytq = citytq.substr(0, citytq.length - 1)
                    }
                    var url = "http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&day=0&dfc=3"
                    $.ajax({
                        url: url,
                        dataType: "script",
                        scriptCharset: "gbk",
                        success: function(data) {
                            debugger
                            var _w = window.SWther.w[citytq][0]
                            var _f = _w.f1 + "_0.png"
                            if (new Date().getHours() > 17) {
                                _f = _w.f2 + "_1.png"
                            }
                            var img = "<img width='16px' height='16px' src='http://i2.sinaimg.cn/dy/main/weather/weatherplugin/wthIco/20_20/" + _f +
                                "' />"
                            var tq = citytq + "&nbsp; " + img + "&nbsp; " + _w.s1 + "&nbsp; " + _w.t1 + "℃～" + _w.t2 + "℃ "
                            $('#weather').html(tq)
                        }
                    })
                })
            },
            'jumpPageOfClickThis': function(key) {
                const vm = this
                switch (key) {
                    case 1:
                        vm.$router.push({
                            path: '/login'
                        })
                        break
                    case 2:
                        vm.$router.push({
                            path: '/login'
                        })
                        break
                    case 3:
                        vm.$router.push({
                            path: '/login'
                        })
                        break
                    case 4:
                        vm.$router.push({
                            path: '/login'
                        })
                        break
                    case 5:
                        vm.$router.push({
                            path: '/login'
                        })
                        break
                    case 6:
                        vm.$router.push({
                            path: '/login'
                        })
                        break
                }
            }
        }
    }
</script>