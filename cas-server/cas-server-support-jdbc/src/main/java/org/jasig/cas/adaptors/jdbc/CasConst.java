package org.jasig.cas.adaptors.jdbc;

import java.util.concurrent.ConcurrentHashMap;

public class CasConst {
    public static ConcurrentHashMap<String,String> errorMap = new ConcurrentHashMap<String,String>();
    public static final String SESSION_KEY_AUTH_CODE="session_key_auth_code";
    public static final String CAS_REDIS_PREFIX = "cas_redis:";

    public static String CAS_REQUIRED_AUTHCODE="required.authcode";
    public static String CAS_ERROR_AUTHCODE_BAD="error.authentication.authcode.bad";

}