package com.example.docmanager.entity;

/** */
@javax.annotation.processing.Generated(value = { "Doma", "2.53.1" }, date = "2025-11-15T18:42:56.758+0900")
@org.seasar.doma.EntityTypeImplementation
public final class _User extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.example.docmanager.entity.User> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.53.1");
    }

    private static final _User __singleton = new _User();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.example.docmanager.entity.User>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __entityPropertyTypeMap;

    @SuppressWarnings("unused")
    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<com.example.docmanager.entity.User, ?>> __embeddedPropertyTypeMap;

    private _User() {
        __listenerSupplier = org.seasar.doma.internal.jdbc.entity.NullEntityListenerSuppliers.of();
        __immutable = false;
        __name = "User";
        __catalogName = "";
        __schemaName = "";
        __tableName = "user";
        __isQuoteRequired = true;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __list = new java.util.ArrayList<>(7);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __map = new java.util.LinkedHashMap<>(7);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<com.example.docmanager.entity.User, ?>> __embeddedMap = new java.util.LinkedHashMap<>(7);
        initializeMaps(__map, __embeddedMap);
        initializeIdList(__map, __idList);
        initializeList(__map, __list);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
        __embeddedPropertyTypeMap = java.util.Collections.unmodifiableMap(__embeddedMap);
    }

    private void initializeMaps(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __map, java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<com.example.docmanager.entity.User, ?>> __embeddedMap) {
        __map.put("id", new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.example.docmanager.entity.User, java.lang.Long, java.lang.Long>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofLong(), "id", "", __namingType, false, __idGenerator));
        __map.put("username", new org.seasar.doma.jdbc.entity.DefaultPropertyType<com.example.docmanager.entity.User, java.lang.String, java.lang.String>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "username", "username", __namingType, true, true, false));
        __map.put("email", new org.seasar.doma.jdbc.entity.DefaultPropertyType<com.example.docmanager.entity.User, java.lang.String, java.lang.String>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "email", "email", __namingType, true, true, false));
        __map.put("passwordHash", new org.seasar.doma.jdbc.entity.DefaultPropertyType<com.example.docmanager.entity.User, java.lang.String, java.lang.String>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "passwordHash", "password_hash", __namingType, true, true, false));
        __map.put("role", new org.seasar.doma.jdbc.entity.DefaultPropertyType<com.example.docmanager.entity.User, java.lang.String, java.lang.String>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "role", "role", __namingType, true, true, false));
        __map.put("createdAt", new org.seasar.doma.jdbc.entity.DefaultPropertyType<com.example.docmanager.entity.User, java.time.LocalDateTime, java.time.LocalDateTime>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofLocalDateTime(), "createdAt", "created_at", __namingType, true, true, false));
        __map.put("updatedAt", new org.seasar.doma.jdbc.entity.DefaultPropertyType<com.example.docmanager.entity.User, java.time.LocalDateTime, java.time.LocalDateTime>(com.example.docmanager.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofLocalDateTime(), "updatedAt", "updated_at", __namingType, true, true, false));
    }

    private void initializeIdList(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __map, java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __idList) {
        __idList.add(__map.get("id"));
    }

    private void initializeList(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __map, java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> __list) {
        __list.addAll(__map.values());
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    @Deprecated
    public String getTableName() {
        return getTableName(org.seasar.doma.internal.jdbc.entity.TableNames.namingFunction);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(com.example.docmanager.entity.User entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.example.docmanager.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.example.docmanager.entity.User entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.example.docmanager.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.example.docmanager.entity.User entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.example.docmanager.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.example.docmanager.entity.User entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.example.docmanager.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.example.docmanager.entity.User entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.example.docmanager.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.example.docmanager.entity.User entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.example.docmanager.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.docmanager.entity.User, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.example.docmanager.entity.User, ?, ?> getGeneratedIdPropertyType() {
        return (org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.example.docmanager.entity.User, ?, ?>)__entityPropertyTypeMap.get("id");
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<com.example.docmanager.entity.User, ?, ?> getVersionPropertyType() {
        return (org.seasar.doma.jdbc.entity.VersionPropertyType<com.example.docmanager.entity.User, ?, ?>)__entityPropertyTypeMap.get("null");
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.example.docmanager.entity.User, ?, ?> getTenantIdPropertyType() {
        return (org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.example.docmanager.entity.User, ?, ?>)__entityPropertyTypeMap.get("null");
    }

    @Override
    public com.example.docmanager.entity.User newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.example.docmanager.entity.User, ?>> __args) {
        com.example.docmanager.entity.User entity = new com.example.docmanager.entity.User();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("username") != null) __args.get("username").save(entity);
        if (__args.get("email") != null) __args.get("email").save(entity);
        if (__args.get("passwordHash") != null) __args.get("passwordHash").save(entity);
        if (__args.get("role") != null) __args.get("role").save(entity);
        if (__args.get("createdAt") != null) __args.get("createdAt").save(entity);
        if (__args.get("updatedAt") != null) __args.get("updatedAt").save(entity);
        return entity;
    }

    @Override
    public Class<com.example.docmanager.entity.User> getEntityClass() {
        return com.example.docmanager.entity.User.class;
    }

    @Override
    public com.example.docmanager.entity.User getOriginalStates(com.example.docmanager.entity.User __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.example.docmanager.entity.User __entity) {
    }

    /**
     * @return the singleton
     */
    public static _User getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _User newInstance() {
        return new _User();
    }

}
