export default ({
    routes: [
        { path: '/index', component: require('./components/index.vue') },
        { path: "/", redirect: '/index' },
        { path: '/login', component: require('./components/login/login.vue') },
        { path: '/signPage', component: require('./components/login/signPage.vue') },
        { path: '/signPage2', component: require('./components/login/signPage2.vue') }
    ]
})