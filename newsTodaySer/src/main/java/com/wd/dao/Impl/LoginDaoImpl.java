package com.wd.dao.Impl;

import com.wd.dao.LoginDao;
import com.wd.model.LoginEntity;
import com.wd.untils.createUUIdUntil;
import com.wonders.hs.pd.basic.dao.impl.GenericDaoImpl;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import static net.sf.json.JSONObject.fromObject;

/**
 * Created by ssh on 2017/4/8.
 */
@Repository("loginDao")
public class LoginDaoImpl extends GenericDaoImpl implements LoginDao {
    private static Log logger = LogFactory.getLog(LoginDaoImpl.class);

    public String handleLogin(String userMess) {
        JSONObject jsonObject = fromObject(userMess);
        String userName = jsonObject.getString("user");
        String password = jsonObject.getString("password");

        Session session = super.getSession();
        String hql = "from LoginEntity log where log.userName = :userName";
        if (logger.isDebugEnabled()) {
            logger.debug(hql);
        }
        try {
            Query query = session.createQuery(hql);
            query.setParameter("userName", userName);
            List<LoginEntity> list = query.list();
            if (list.size() <= 0) {
                return "userError";
            } else {
                if (password.equals(list.get(1))) {
                    return "success";
                } else {
                    return "passError";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String userSign(String userName, String passwd, String phoneCode) {
        LoginEntity loginEntity = new LoginEntity();
        //
        String uuid = createUUIdUntil.createUUid();
        loginEntity.setUserId(uuid);
        loginEntity.setUserName(userName);
        loginEntity.setPassWord(passwd);
        loginEntity.setPhoneCode(phoneCode);

        try {
            LoginEntity index = (LoginEntity) super.save(loginEntity);
            if (index != null) {
                return "success";
            } else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
