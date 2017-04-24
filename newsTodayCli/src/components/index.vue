<template>
    <div class="main">
        <mian_header></mian_header>
        <div class="main_body"></div>
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