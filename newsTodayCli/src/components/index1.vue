<template>
    <div class="main">
        <div class="main-head">
        </div>
        <div class="main-body">
            <div class="main-left"></div>
            <div class="main-center"></div>
            <div class="main-right"></div>
        </div>
    </div>
    </template>
<style scoped>
    .main {
        left: 10000px;
        right: 0px;
        top: 0px;
        bottom: 0px;
        overflow: auto;
    }
    
    .main-head {
        position: absolute;
        width: 100%;
        height: 15%;
        background-color: red;
    }
    
    .main-body {
        position: absolute;
        width: 100%;
        height: 85%;
        top: 15%;
        background-color: green;
    }
    
    .main-left {
        position: absolute;
        width: 15%;
        min-width: 223px;
        height: 100%;
        left: 0px;
        background-color: pink;
    }
    
    .main-center {
        position: absolute;
        width: 70%;
        min-width: 410px;
        height: 98%;
        margin-left: 223px;
        background-color: #ebebeb;
    }
    
    .main-right {
        position: absolute;
        width: 15%;
        min-width: 223px;
        height: 100%;
        right: 0px;
        background-color: pink;
    }


</style>
<script>
</script>