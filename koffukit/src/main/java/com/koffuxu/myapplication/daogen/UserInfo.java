package com.koffuxu.myapplication.daogen;

import com.koffuxu.myapplication.daogen.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER_INFO".
 */
public class UserInfo {

    private String name;
    private Integer age;
    private String hobby;
    private String gender;
    private Long id;
    private Long fatherId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UserInfoDao myDao;

    private FatherUserInfo fatherUserInfo;
    private Long fatherUserInfo__resolvedKey;


    public UserInfo() {
    }

    public UserInfo(Long id) {
        this.id = id;
    }

    public UserInfo(String name, Integer age, String hobby, String gender, Long id, Long fatherId) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.gender = gender;
        this.id = id;
        this.fatherId = fatherId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserInfoDao() : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    /** To-one relationship, resolved on first access. */
    public FatherUserInfo getFatherUserInfo() {
        Long __key = this.fatherId;
        if (fatherUserInfo__resolvedKey == null || !fatherUserInfo__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FatherUserInfoDao targetDao = daoSession.getFatherUserInfoDao();
            FatherUserInfo fatherUserInfoNew = targetDao.load(__key);
            synchronized (this) {
                fatherUserInfo = fatherUserInfoNew;
            	fatherUserInfo__resolvedKey = __key;
            }
        }
        return fatherUserInfo;
    }

    public void setFatherUserInfo(FatherUserInfo fatherUserInfo) {
        synchronized (this) {
            this.fatherUserInfo = fatherUserInfo;
            fatherId = fatherUserInfo == null ? null : fatherUserInfo.getId();
            fatherUserInfo__resolvedKey = fatherId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
