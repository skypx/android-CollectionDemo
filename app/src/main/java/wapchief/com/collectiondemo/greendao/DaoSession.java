package wapchief.com.collectiondemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import wapchief.com.collectiondemo.greendao.model.User;
import wapchief.com.collectiondemo.greendao.model.Message;
import wapchief.com.collectiondemo.greendao.model.CarShop;

import wapchief.com.collectiondemo.greendao.UserDao;
import wapchief.com.collectiondemo.greendao.MessageDao;
import wapchief.com.collectiondemo.greendao.CarShopDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig messageDaoConfig;
    private final DaoConfig carShopDaoConfig;

    private final UserDao userDao;
    private final MessageDao messageDao;
    private final CarShopDao carShopDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        messageDaoConfig = daoConfigMap.get(MessageDao.class).clone();
        messageDaoConfig.initIdentityScope(type);

        carShopDaoConfig = daoConfigMap.get(CarShopDao.class).clone();
        carShopDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        messageDao = new MessageDao(messageDaoConfig, this);
        carShopDao = new CarShopDao(carShopDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Message.class, messageDao);
        registerDao(CarShop.class, carShopDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        messageDaoConfig.clearIdentityScope();
        carShopDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public CarShopDao getCarShopDao() {
        return carShopDao;
    }

}
