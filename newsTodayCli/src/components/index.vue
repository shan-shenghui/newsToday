<template>
    <div class="main">
        <mian_header></mian_header>
        <div class="main_body">
            <div class="mian_left"></div>
            <div class="main_right">
                <div class="body_left"></div>
                <div class="body_right"></div>
            </div>
        </div>
    </div>
    </template>
<style scoped>
    .main {
        position: absolute;
        left: 0px;
        right: 0px;
        top: 0px;
        bottom: 0px;
        overflow: auto;
        background-color: #4A374A;
    }
    
    .main_body {
        position: relative;
        width: 80%;
        height: 100%;
        left: 10%;
        right: 10%;
        top: 40px;
        bottom: 0px;
        overflow: auto;
        background-color: green;
    }
    
    .mian_left {
        position: relative;
        width: 16%;
        height: 80%;
        display: inline-block;
        overflow-y: hidden;
        background-color: red;
    }
    
    .main_right {
        position: relative;
        width: 84%;
        height: 99%;
        float: right;
        display: inline-block;
        background-color: pink;
    }
    
    .body_left {
        position: relative;
        width: 70%;
        height: 100%;
        display: inline-block;
        overflow-y: auto;
        background-color: black;
    }
    
    .body_right {
        position: relative;
        width: 30%;
        height: 100%;
        float: right;
        overflow-y: hidden;
        display: inline-block;
        background-color: rebeccapurple;
    }
</style>
<script>
    import header from './commons/heard.vue'
    export default {

        data() {
            return {

            }

        },
        methods: {

        },
        components: {
            'mian_header': header
        }
    }
</script>