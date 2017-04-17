import * as types from './mutation-types'

export default {
    // 保存登陆人的tel
    [types.SAVE_USER_PHONE_CODE](state, code) {
        state.user.phoneCode = code
    },
    // 保存登陆人的名称
    [types.SAVE_USER_NAME](state, name) {
        state.user.name = name
    }
};