import * as types from './mutation-types'

export default {
    saveUserPhoneCode({ commit }, code) {
        commit(types.SAVE_USER_PHONE_CODE, code)
    },
    saveUserName({ commit }, code) {
        commit(types.SAVE_USER_NAME, code)
    }
};