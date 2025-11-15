package com.example.docmanager.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.processing.Generated(value = { "Doma", "2.53.1" }, date = "2025-11-15T18:42:56.842+0900")
@org.seasar.doma.DaoImplementation
public class UserDaoImpl implements com.example.docmanager.dao.UserDao, org.seasar.doma.jdbc.ConfigProvider {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.53.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "findById", java.lang.Long.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "findByEmail", java.lang.String.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "findByUsername", java.lang.String.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "findAll");

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "insert", com.example.docmanager.entity.User.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "update", com.example.docmanager.entity.User.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(com.example.docmanager.dao.UserDao.class, "delete", com.example.docmanager.entity.User.class);

    private final org.seasar.doma.internal.jdbc.dao.DaoImplSupport __support;

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public UserDaoImpl(org.seasar.doma.jdbc.Config config) {
        __support = new org.seasar.doma.internal.jdbc.dao.DaoImplSupport(config);
    }

    @Override
    public org.seasar.doma.jdbc.Config getConfig() {
        return __support.getConfig();
    }

    @Override
    public java.util.Optional<com.example.docmanager.entity.User> findById(java.lang.Long id) {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "findById", id);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("META-INF/com/example/docmanager/dao/UserDao/findById.sql");
            __query.setEntityType(com.example.docmanager.entity._User.getSingletonInternal());
            __query.addParameter("id", java.lang.Long.class, id);
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("findById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.example.docmanager.entity.User>> __command = __support.getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.example.docmanager.entity.User>(com.example.docmanager.entity._User.getSingletonInternal()));
            java.util.Optional<com.example.docmanager.entity.User> __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "findById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "findById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.example.docmanager.entity.User> findByEmail(java.lang.String email) {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "findByEmail", email);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("META-INF/com/example/docmanager/dao/UserDao/findByEmail.sql");
            __query.setEntityType(com.example.docmanager.entity._User.getSingletonInternal());
            __query.addParameter("email", java.lang.String.class, email);
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("findByEmail");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.example.docmanager.entity.User>> __command = __support.getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.example.docmanager.entity.User>(com.example.docmanager.entity._User.getSingletonInternal()));
            java.util.Optional<com.example.docmanager.entity.User> __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "findByEmail", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "findByEmail", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.example.docmanager.entity.User> findByUsername(java.lang.String username) {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "findByUsername", username);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method2);
            __query.setMethod(__method2);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("META-INF/com/example/docmanager/dao/UserDao/findByUsername.sql");
            __query.setEntityType(com.example.docmanager.entity._User.getSingletonInternal());
            __query.addParameter("username", java.lang.String.class, username);
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("findByUsername");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.example.docmanager.entity.User>> __command = __support.getCommandImplementors().createSelectCommand(__method2, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.example.docmanager.entity.User>(com.example.docmanager.entity._User.getSingletonInternal()));
            java.util.Optional<com.example.docmanager.entity.User> __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "findByUsername", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "findByUsername", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<com.example.docmanager.entity.User> findAll() {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "findAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method3);
            __query.setMethod(__method3);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("META-INF/com/example/docmanager/dao/UserDao/findAll.sql");
            __query.setEntityType(com.example.docmanager.entity._User.getSingletonInternal());
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("findAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.example.docmanager.entity.User>> __command = __support.getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.example.docmanager.entity.User>(com.example.docmanager.entity._User.getSingletonInternal()));
            java.util.List<com.example.docmanager.entity.User> __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "findAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "findAll", __e);
            throw __e;
        }
    }

    @Override
    public int insert(com.example.docmanager.entity.User user) {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "insert", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.example.docmanager.entity.User> __query = __support.getQueryImplementors().createAutoInsertQuery(__method4, com.example.docmanager.entity._User.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(__support.getConfig());
            __query.setEntity(user);
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = __support.getCommandImplementors().createInsertCommand(__method4, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.example.docmanager.entity.User user) {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "update", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.example.docmanager.entity.User> __query = __support.getQueryImplementors().createAutoUpdateQuery(__method5, com.example.docmanager.entity._User.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(__support.getConfig());
            __query.setEntity(user);
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = __support.getCommandImplementors().createUpdateCommand(__method5, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.example.docmanager.entity.User user) {
        __support.entering("com.example.docmanager.dao.UserDaoImpl", "delete", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.example.docmanager.entity.User> __query = __support.getQueryImplementors().createAutoDeleteQuery(__method6, com.example.docmanager.entity._User.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(__support.getConfig());
            __query.setEntity(user);
            __query.setCallerClassName("com.example.docmanager.dao.UserDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = __support.getCommandImplementors().createDeleteCommand(__method6, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("com.example.docmanager.dao.UserDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("com.example.docmanager.dao.UserDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
