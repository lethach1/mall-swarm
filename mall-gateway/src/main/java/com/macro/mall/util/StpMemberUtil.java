/*
 * Copyright 2020-2099 sa-token.cc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.macro.mall.util;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.fun.SaFunction;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.listener.SaTokenEventCenter;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpLogic;

import java.util.List;

/**
 * @author macrozheng
 * @description Frontend mall user login authentication utility
 * Copied from default StpUtil, only TYPE changed
 * @date 2024/1/26
 * @github https://github.com/macrozheng
 */
public class StpMemberUtil {

	private StpMemberUtil() {}
	
	/**
	 * Type identifier for multi-account systems
	 */
	public static final String TYPE = "memberLogin";
	
	/**
	 * Underlying StpLogic object used
	 */
	public static StpLogic stpLogic = new StpLogicJwtForSimple(TYPE);

	/**
	 * Get current StpLogic login type
	 *
	 * @return /
	 */
	public static String getLoginType(){
		return stpLogic.getLoginType();
	}

	/**
	 * Securely reset StpLogic object
	 *
	 * 1. Change StpLogic object for this account
	 * 2. Put into global StpLogic collection
	 * 3. Publish event of updating stpLogic object
	 *
	 * @param newStpLogic /
	 */
	public static void setStpLogic(StpLogic newStpLogic) {
		// 1、重置此账户的 StpLogic 对象
		stpLogic = newStpLogic;
		
		// 2、添加到全局 StpLogic 集合中
		//    以便可以通过 SaManager.getStpLogic(type) 的方式来全局获取到这个 StpLogic
		SaManager.putStpLogic(newStpLogic);
		
		// 3、$$ 发布事件：更新了 stpLogic 对象
		SaTokenEventCenter.doSetStpLogic(stpLogic);
	}

	/**
	 * Get StpLogic object
	 *
	 * @return / 
	 */
	public static StpLogic getStpLogic() {
		return stpLogic;
	}
	
	
	// ------------------- get token related -------------------

	/**
	 * Return token name: used for cookie name, param name, and key prefix when storing token
	 *
	 * @return /
	 */
	public static String getTokenName() {
 		return stpLogic.getTokenName();
 	}

	/**
	 * Write specified token value to current session
	 *
	 * @param tokenValue Token value
	 */
	public static void setTokenValue(String tokenValue){
		stpLogic.setTokenValue(tokenValue);
	}

	/**
	 * Write specified token value to current session
	 *
	 * @param tokenValue Token value
	 * @param cookieTimeout Cookie lifetime (seconds)
	 */
	public static void setTokenValue(String tokenValue, int cookieTimeout){
		stpLogic.setTokenValue(tokenValue, cookieTimeout);
	}

	/**
	 * Write specified token value to current session
	 *
	 * @param tokenValue Token value
	 * @param loginModel Login param
	 */
	public static void setTokenValue(String tokenValue, SaLoginModel loginModel){
		stpLogic.setTokenValue(tokenValue, loginModel);
	}

	/**
	 * Get current request's token value
	 *
	 * @return current tokenValue
	 */
	public static String getTokenValue() {
		return stpLogic.getTokenValue();
	}

	/**
	 * Get current request token value (without cutting prefix)
	 *
	 * @return / 
	 */
	public static String getTokenValueNotCut(){
		return stpLogic.getTokenValueNotCut();
	}

	/**
	 * Get current session's token info params
	 *
	 * @return token info params
	 */
	public static SaTokenInfo getTokenInfo() {
		return stpLogic.getTokenInfo();
	}

	
	// ------------------- login related ops -------------------

	// --- login 

	/**
	 * Session login
	 *
	 * @param id account id (recommend type: long | int | String)
	 */
	public static void login(Object id) {
		stpLogic.login(id);
	}

	/**
	 * Session login with device type
	 *
	 * @param id account id
	 * @param device device type
	 */
	public static void login(Object id, String device) {
		stpLogic.login(id, device);
	}

	/**
	 * Session login with [remember me] option
	 *
	 * @param id account id
	 * @param isLastingCookie persistent cookie: true=remember me, false=needs login after browser close
	 */
	public static void login(Object id, boolean isLastingCookie) {
		stpLogic.login(id, isLastingCookie);
	}

	/**
	 * Session login with specified token validity seconds
	 *
	 * @param id account id
	 * @param timeout token validity (seconds)
	 */
	public static void login(Object id, long timeout) {
		stpLogic.login(id, timeout);
	}

	/**
	 * Session login with all params Model
	 *
	 * @param id account id
	 * @param loginModel login param Model
	 */
	public static void login(Object id, SaLoginModel loginModel) {
		stpLogic.login(id, loginModel);
	}

	/**
	 * Create login session data for the specified account id
	 *
	 * @param id account id
	 * @return session token
	 */
	public static String createLoginSession(Object id) {
		return stpLogic.createLoginSession(id);
	}

	/**
	 * Create login session data for specified account id
	 *
	 * @param id account id
	 * @param loginModel this login's param model
	 * @return session token
	 */
	public static String createLoginSession(Object id, SaLoginModel loginModel) {
		return stpLogic.createLoginSession(id, loginModel);
	}
	
	// --- logout 

	/**
	 * Logout current client session
	 */
	public static void logout() {
		stpLogic.logout();
	}

	/**
	 * Logout session by account id
	 *
	 * @param loginId account id
	 */
	public static void logout(Object loginId) {
		stpLogic.logout(loginId);
	}

	/**
	 * Logout session by account id and device type 
	 *
	 * @param loginId account id
	 * @param device device type (null=all device types for this account)
	 */
	public static void logout(Object loginId, String device) {
		stpLogic.logout(loginId, device);
	}

	/**
	 * Logout by specified token
	 *
	 * @param tokenValue specified token
	 */
	public static void logoutByTokenValue(String tokenValue) {
		stpLogic.logoutByTokenValue(tokenValue);
	}

	/**
	 * Kick offline by account id 
	 * <p> Throws NotLoginException (code=-5) upon next access
	 *
	 * @param loginId account id
	 */
	public static void kickout(Object loginId) {
		stpLogic.kickout(loginId);
	}

	/**
	 * Kick offline by account id and device type
	 * <p> Throws NotLoginException (code=-5) upon next access
	 *
	 * @param loginId account id
	 * @param device device type (null=all device types for this account)
	 */
	public static void kickout(Object loginId, String device) {
		stpLogic.kickout(loginId, device);
	}

	/**
	 * Kick offline by specified token
	 * <p> Throws NotLoginException (code=-5) upon next access
	 *
	 * @param tokenValue specified token
	 */
	public static void kickoutByTokenValue(String tokenValue) {
		stpLogic.kickoutByTokenValue(tokenValue);
	}

	/**
	 * Replace offline by account id and device type
	 * <p> Throws NotLoginException (code=-4) upon next access
	 *
	 * @param loginId account id
	 * @param device device type (null=replaces all device types for this account)
	 */
	public static void replaced(Object loginId, String device) {
		stpLogic.replaced(loginId, device);
	}

	// --- session query

	/**
	 * Check if current session is logged in
	 *
	 * @return true=logged in, false=not logged in
	 */
	public static boolean isLogin() {
		return stpLogic.isLogin();
	}

	/**
	 * Check if specified account is logged in
	 *
	 * @return true=logged in, false=not logged in
	 */
	public static boolean isLogin(Object loginId) {
		return stpLogic.isLogin(loginId);
	}

	/**
	 * Check if current session is logged in, throws if not
	 */
 	public static void checkLogin() {
 		stpLogic.checkLogin();
 	}

	/**
	 * Get account id for current session, throws if not logged in
	 *
	 * @return account id
	 */
	public static Object getLoginId() {
		return stpLogic.getLoginId();
	}

	/**
	 * Get account id for current session, returns default if not logged in
	 *
	 * @param <T> return type
	 * @param defaultValue default value
	 * @return login id
	 */
	public static <T> T getLoginId(T defaultValue) {
		return stpLogic.getLoginId(defaultValue);
	}

	/**
	 * Get account id for current session, returns null if not logged in
	 *
	 * @return account id
	 */
	public static Object getLoginIdDefaultNull() {
		return stpLogic.getLoginIdDefaultNull();
 	}

	/**
	 * Get account id for current session as String
	 *
	 * @return account id
	 */
	public static String getLoginIdAsString() {
		return stpLogic.getLoginIdAsString();
	}

	/**
	 * Get account id for current session as int
	 *
	 * @return account id
	 */
	public static int getLoginIdAsInt() {
		return stpLogic.getLoginIdAsInt();
	}

	/**
	 * Get account id for current session as long
	 *
	 * @return account id
	 */
	public static long getLoginIdAsLong() {
		return stpLogic.getLoginIdAsLong();
	}

	/**
	 * Get account id by specified token, returns null if not logged in
	 *
	 * @param tokenValue token
	 * @return account id
	 */
 	public static Object getLoginIdByToken(String tokenValue) {
 		return stpLogic.getLoginIdByToken(tokenValue);
 	}

	/**
	 * Get extra info for the current Token (works in jwt mode only)
	 *
	 * @param key key
	 * @return corresponding extra data
	 */
	public static Object getExtra(String key) {
		return stpLogic.getExtra(key);
	}

	/**
	 * Get extra info for specified Token (works in jwt mode only)
	 *
	 * @param tokenValue Token value
	 * @param key key
	 * @return corresponding extra data
	 */
	public static Object getExtra(String tokenValue, String key) {
		return stpLogic.getExtra(tokenValue, key);
	}
 	
 	
	// ------------------- Account-Session related -------------------

	/**
	 * Get Account-Session by account id, create new if needed (isCreate)
	 *
	 * @param loginId account id
	 * @param isCreate create if does not exist
	 * @return SaSession object
	 */
	public static SaSession getSessionByLoginId(Object loginId, boolean isCreate) {
		return stpLogic.getSessionByLoginId(loginId, isCreate);
	}

	/**
	 * Get SaSession by sessionId, returns null if not exist
	 *
	 * @param sessionId SessionId
	 * @return Session object
	 */
	public static SaSession getSessionBySessionId(String sessionId) {
		return stpLogic.getSessionBySessionId(sessionId);
	}

	/**
	 * Get Account-Session by account id, creates new if not exist
	 *
	 * @param loginId account id
	 * @return SaSession object
	 */
	public static SaSession getSessionByLoginId(Object loginId) {
		return stpLogic.getSessionByLoginId(loginId);
	}

	/**
	 * Get current logged-in account's Account-Session, create new if needed
	 *
	 * @param isCreate create if needed
	 * @return Session object
	 */
	public static SaSession getSession(boolean isCreate) {
		return stpLogic.getSession(isCreate);
	}

	/**
	 * Get current logged-in account's Account-Session, create new if not exist
	 *
	 * @return Session object
	 */
	public static SaSession getSession() {
		return stpLogic.getSession();
	}

	
	// ------------------- Token-Session related -------------------  

	/**
	 * Get Token-Session by specified token, create new if not exist
	 *
	 * @param tokenValue Token value
	 * @return Session object
	 */
	public static SaSession getTokenSessionByToken(String tokenValue) {
		return stpLogic.getTokenSessionByToken(tokenValue);
	}

	/**
	 * Get current token's Token-Session, create new if not exist
	 *
	 * @return Session object
	 */
	public static SaSession getTokenSession() {
		return stpLogic.getTokenSession();
	}

	/**
	 * Get anonymous Token-Session for current session (Token-Session usable without login)
	 *
	 * @return Token-Session object
	 */
	public static SaSession getAnonTokenSession() {
		return stpLogic.getAnonTokenSession();
	}
	

	// ------------------- Active-Timeout token min activity verification -------------------

	/**
	 * Renew current token (updates [last active timestamp] to now)
	 * <h2>
	 *     Note: Even if token is frozen, this can succeed. To force failure, check checkActiveTimeout() first.
	 * </h2>
	 */
	public static void updateLastActiveToNow() {
		stpLogic.updateLastActiveToNow();
	}

	/**
	 * Check if current token is frozen, throws if so
	 */
 	public static void checkActiveTimeout() {
 		stpLogic.checkActiveTimeout();
 	}


	// ------------------- Expiration Related -------------------  

	/**
	 * Get remaining validity of current session token (seconds), -1=never expires, -2=not exist
	 *
	 * @return token remaining validity
	 */
 	public static long getTokenTimeout() {
 		return stpLogic.getTokenTimeout();
 	}

	/**
	 * Get remaining validity of specified token (seconds), -1=never expires, -2=not exist
	 *
	 * @param token specified token
	 * @return token remaining validity
	 */
	public static long getTokenTimeout(String token) {
		return stpLogic.getTokenTimeout(token);
	}

	/**
	 * Get remaining validity of current login account's Account-Session (seconds), -1=never expires, -2=not exist
	 *
	 * @return token remaining validity
	 */
 	public static long getSessionTimeout() {
 		return stpLogic.getSessionTimeout();
 	}

	/**
	 * Get remaining active validity of current token (seconds): how long until frozen, -1=never freezes, -2=not exist or frozen
	 *
	 * @return /
	 */
 	public static long getTokenActiveTimeout() {
 		return stpLogic.getTokenActiveTimeout();
 	}

	/**
	 * Renew timeout value for current token
	 *
	 * @param timeout new validity (seconds)
	 */
 	public static void renewTimeout(long timeout) {
 		stpLogic.renewTimeout(timeout);
 	}

	/**
	 * Renew timeout value for specified token
	 *
	 * @param tokenValue specified token
	 * @param timeout new validity (seconds, -1=never expires)
	 */
 	public static void renewTimeout(String tokenValue, long timeout) {
 		stpLogic.renewTimeout(tokenValue, timeout);
 	}
 	
 	
	// ------------------- Role authentication ops -------------------

	/**
	 * Get: Collection of roles for current account
	 *
	 * @return /
	 */
	public static List<String> getRoleList() {
		return stpLogic.getRoleList();
	}

	/**
	 * Get: Collection of roles for specified account
	 *
	 * @param loginId specified account id
	 * @return /
	 */
	public static List<String> getRoleList(Object loginId) {
		return stpLogic.getRoleList(loginId);
	}

	/**
	 * Check: if current account has specified role, return true or false
	 *
	 * @param role role
	 * @return /
	 */
 	public static boolean hasRole(String role) {
 		return stpLogic.hasRole(role);
 	}

	/**
	 * Check: if specified account has specified role, return true or false
	 *
	 * @param loginId account id
	 * @param role role
	 * @return if has specified role
	 */
 	public static boolean hasRole(Object loginId, String role) {
 		return stpLogic.hasRole(loginId, role);
 	}

	/**
	 * Check: if current account has all of specified roles (AND)
	 *
	 * @param roleArray role array
	 * @return true or false
	 */
 	public static boolean hasRoleAnd(String... roleArray){
 		return stpLogic.hasRoleAnd(roleArray);
 	}

	/**
	 * Check: if current account has any of the specified roles (OR)
	 *
	 * @param roleArray role array
	 * @return true or false
	 */
 	public static boolean hasRoleOr(String... roleArray){
 		return stpLogic.hasRoleOr(roleArray);
 	}

	/**
	 * Assert: if current account has specified role, throw NotRoleException if fails
	 *
	 * @param role role
	 */
 	public static void checkRole(String role) {
 		stpLogic.checkRole(role);
 	}

	/**
	 * Assert: if current account has all of specified roles (AND)
	 *
	 * @param roleArray role array
	 */
 	public static void checkRoleAnd(String... roleArray){
 		stpLogic.checkRoleAnd(roleArray);
 	}

	/**
	 * Assert: if current account has any of the specified roles (OR)
	 *
	 * @param roleArray role array
	 */
 	public static void checkRoleOr(String... roleArray){
 		stpLogic.checkRoleOr(roleArray);
 	}

	
	// ------------------- Permission authentication ops -------------------

	/**
	 * Get: permission code list for current account
	 *
	 * @return / 
	 */
	public static List<String> getPermissionList() {
		return stpLogic.getPermissionList();
	}

	/**
	 * Get: permission code list for specified account
	 *
	 * @param loginId specified account id
	 * @return / 
	 */
	public static List<String> getPermissionList(Object loginId) {
		return stpLogic.getPermissionList(loginId);
	}

	/**
	 * Check: if current account has specified permission, return true or false
	 *
	 * @param permission permission code
	 * @return if has specified permission
	 */
	public static boolean hasPermission(String permission) {
		return stpLogic.hasPermission(permission);
	}

	/**
	 * Check: if specified account id has specified permission, return true or false
	 *
	 * @param loginId account id
	 * @param permission permission code
	 * @return if has specified permission
	 */
	public static boolean hasPermission(Object loginId, String permission) {
		return stpLogic.hasPermission(loginId, permission);
	}

	/**
	 * Check: if current account has all of specified permissions (AND)
	 *
	 * @param permissionArray permission code array
	 * @return true or false
	 */
 	public static boolean hasPermissionAnd(String... permissionArray){
 		return stpLogic.hasPermissionAnd(permissionArray);
 	}

	/**
	 * Check: if current account has any of the specified permissions (OR)
	 *
	 * @param permissionArray permission code array
	 * @return true or false
	 */
 	public static boolean hasPermissionOr(String... permissionArray){
 		return stpLogic.hasPermissionOr(permissionArray);
 	}

	/**
	 * Assert: if current account has specified permission, throw NotPermissionException if fails
	 *
	 * @param permission permission code
	 */
	public static void checkPermission(String permission) {
		stpLogic.checkPermission(permission);
	}

	/**
	 * Assert: if current account has all of specified permissions (AND)
	 *
	 * @param permissionArray permission code array
	 */
	public static void checkPermissionAnd(String... permissionArray) {
		stpLogic.checkPermissionAnd(permissionArray);
	}

	/**
	 * Assert: if current account has any of the specified permissions (OR)
	 *
	 * @param permissionArray permission code array
	 */
	public static void checkPermissionOr(String... permissionArray) {
		stpLogic.checkPermissionOr(permissionArray);
	}


	// ------------------- id reverse lookup token related ops -------------------

	/**
	 * Get token for specified account id
	 * <p>
	 *     When concurrent login is allowed, only returns the last token in the queue.
	 *     If you want all account tokens, call getTokenValueListByLoginId.
	 * </p>
	 *
	 * @param loginId account id
	 * @return token value
	 */
	public static String getTokenValueByLoginId(Object loginId) {
		return stpLogic.getTokenValueByLoginId(loginId);
	}

	/**
	 * Get token for specified account id and device type
	 * <p>
	 *     When concurrent login is allowed, only returns the last token in the queue.
	 *     If you want all account tokens, call getTokenValueListByLoginId.
	 * </p>
	 *
	 * @param loginId account id
	 * @param device device type, null means no limit to device type
	 * @return token value
	 */
	public static String getTokenValueByLoginId(Object loginId, String device) {
		return stpLogic.getTokenValueByLoginId(loginId, device);
	}

	/**
	 * Get all tokens for specified account id
	 *
	 * @param loginId account id
	 * @return all tokens for this loginId
	 */
	public static List<String> getTokenValueListByLoginId(Object loginId) {
		return stpLogic.getTokenValueListByLoginId(loginId);
	}

	/**
	 * Get all tokens for specified account id and device type
	 *
	 * @param loginId account id
	 * @param device device type, null means no limit
	 * @return all login tokens for this loginId
	 */
	public static List<String> getTokenValueListByLoginId(Object loginId, String device) {
		return stpLogic.getTokenValueListByLoginId(loginId, device);
	}

	/**
	 * Get all tokenSigns for specified account id and device type
	 *
	 * @param loginId account id
	 * @param device device type, null means no limit
	 * @return all login tokenSigns for this loginId
	 */
	public static List<TokenSign> getTokenSignListByLoginId(Object loginId, String device) {
		return stpLogic.getTokenSignListByLoginId(loginId, device);
	}

	/**
	 * Get current session's login device type
	 *
	 * @return login device type for current token
	 */
	public static String getLoginDevice() {
		return stpLogic.getLoginDevice(); 
	}

	
	// ------------------- session management -------------------  

	/**
	 * Query all tokens in cache based on condition
	 *
	 * @param keyword keyword
	 * @param start start index
	 * @param size size (-1 to the end)
	 * @param sortType sort type (true=asc, false=desc)
	 * @return token list
	 */
	public static List<String> searchTokenValue(String keyword, int start, int size, boolean sortType) {
		return stpLogic.searchTokenValue(keyword, start, size, sortType);
	}

	/**
	 * Query all SessionId in cache based on condition
	 *
	 * @param keyword keyword
	 * @param start start index
	 * @param size size (-1 to the end)
	 * @param sortType sort type (true=asc, false=desc)
	 * @return sessionId list
	 */
	public static List<String> searchSessionId(String keyword, int start, int size, boolean sortType) {
		return stpLogic.searchSessionId(keyword, start, size, sortType);
	}

	/**
	 * Query all Token-Session-Id in cache based on condition
	 *
	 * @param keyword keyword
	 * @param start start index
	 * @param size size (-1 to the end)
	 * @param sortType sort type (true=asc, false=desc)
	 * @return sessionId list
	 */
	public static List<String> searchTokenSessionId(String keyword, int start, int size, boolean sortType) {
		return stpLogic.searchTokenSessionId(keyword, start, size, sortType);
	}

	
	// ------------------- Account ban -------------------  

	/**
	 * Ban: specified account
	 * <p> This method will not kick this account offline. To do so, call StpUtil.logout(id) after banning.
	 *
	 * @param loginId specified account id
	 * @param time ban duration, seconds (-1=permanently banned)
	 */
	public static void disable(Object loginId, long time) {
		stpLogic.disable(loginId, time);
	}

	/**
	 * Check: if specified account is banned (true=banned, false=not banned) 
	 *
	 * @param loginId account id
	 * @return / 
	 */
	public static boolean isDisable(Object loginId) {
		return stpLogic.isDisable(loginId);
	}

	/**
	 * Assert: if specified account is banned, throws if so
	 *
	 * @param loginId account id
	 */
	public static void checkDisable(Object loginId) {
		stpLogic.checkDisable(loginId);
	}

	/**
	 * Get: banned remaining time for specified account, seconds (-1=permanent, -2=not banned)
	 *
	 * @param loginId account id
	 * @return / 
	 */
	public static long getDisableTime(Object loginId) {
		return stpLogic.getDisableTime(loginId);
	}

	/**
	 * Unban: specified account
	 *
	 * @param loginId account id
	 */
	public static void untieDisable(Object loginId) {
		stpLogic.untieDisable(loginId);
	}

	
	// ------------------- category ban -------------------  

	/**
	 * Ban: specified account for a specific service
	 * <p> This method will not kick offline. Call StpUtil.logout(id) after banning if needed.
	 *
	 * @param loginId account id
	 * @param service specified service
	 * @param time ban duration, seconds (-1=permanent)
	 */
	public static void disable(Object loginId, String service, long time) {
		stpLogic.disable(loginId, service, time);
	}

	/**
	 * Check: if account for a specific service is banned (true=banned, false=not banned)
	 *
	 * @param loginId account id
	 * @param service service
	 * @return / 
	 */
	public static boolean isDisable(Object loginId, String service) {
		return stpLogic.isDisable(loginId, service);
	}

	/**
	 * Assert: if account for some services is banned, throws if so
	 *
	 * @param loginId account id
	 * @param services service(s)
	 */
	public static void checkDisable(Object loginId, String... services) {
		stpLogic.checkDisable(loginId, services);
	}

	/**
	 * Get: banned remaining time for account's service, seconds (-1=permanent, -2=not banned)
	 *
	 * @param loginId account id
	 * @param service service
	 * @return see note
	 */
	public static long getDisableTime(Object loginId, String service) {
		return stpLogic.getDisableTime(loginId, service);
	}

	/**
	 * Unban: account for some services
	 *
	 * @param loginId account id
	 * @param services service(s)
	 */
	public static void untieDisable(Object loginId, String... services) {
		stpLogic.untieDisable(loginId, services);
	}


	// ------------------- Step ban -------------------  

	/**
	 * Ban: specified account with specified level
	 *
	 * @param loginId account id
	 * @param level ban level
	 * @param time ban duration (seconds, -1=permanently banned)
	 */
	public static void disableLevel(Object loginId, int level, long time) {
		stpLogic.disableLevel(loginId, level, time);
	}

	/**
	 * Ban: specified account, specific service, with level
	 *
	 * @param loginId account id
	 * @param service service
	 * @param level ban level
	 * @param time ban duration (seconds, -1=permanently banned)
	 */
	public static void disableLevel(Object loginId, String service, int level, long time) {
		stpLogic.disableLevel(loginId, service, level, time);
	}

	/**
	 * Check if account is banned to given level
	 *
	 * @param loginId account id
	 * @param level ban level
	 * @return / 
	 */
	public static boolean isDisableLevel(Object loginId, int level) {
		return stpLogic.isDisableLevel(loginId, level);
	}

	/**
	 * Check if account, service is banned to given level
	 *
	 * @param loginId account id
	 * @param service service
	 * @param level ban level
	 * @return / 
	 */
	public static boolean isDisableLevel(Object loginId, String service, int level) {
		return stpLogic.isDisableLevel(loginId, service, level);
	}

	/**
	 * Assert: if account is banned to given level, throws if so
	 *
	 * @param loginId account id
	 * @param level ban level (only throws if ban level >= this)
	 */
	public static void checkDisableLevel(Object loginId, int level) {
		stpLogic.checkDisableLevel(loginId, level);
	}

	/**
	 * Assert: if account, service is banned to given level, throws if so
	 *
	 * @param loginId account id
	 * @param service service
	 * @param level ban level (only throws if ban level >= this)
	 */
	public static void checkDisableLevel(Object loginId, String service, int level) {
		stpLogic.checkDisableLevel(loginId, service, level);
	}

	/**
	 * Get: ban level for account, returns -2 if not banned
	 *
	 * @param loginId account id
	 * @return / 
	 */
	public static int getDisableLevel(Object loginId) {
		return stpLogic.getDisableLevel(loginId);
	}

	/**
	 * Get: ban level for account, service, returns -2 if not banned
	 *
	 * @param loginId account id
	 * @param service service
	 * @return / 
	 */
	public static int getDisableLevel(Object loginId, String service) {
		return stpLogic.getDisableLevel(loginId, service);
	}
	
	
	// ------------------- Temp identity switch -------------------

	/**
	 * Temporarily switch identity to specified account id
	 *
	 * @param loginId specified loginId
	 */
	public static void switchTo(Object loginId) {
		stpLogic.switchTo(loginId);
	}

	/**
	 * End temporary identity switch
	 */
	public static void endSwitch() {
		stpLogic.endSwitch();
	}

	/**
	 * Check if current request is in identity temp switch
	 *
	 * @return /
	 */
	public static boolean isSwitch() {
		return stpLogic.isSwitch();
	}

	/**
	 * In a lambda section, temporarily switch identity. Restores after lambda finishes
	 *
	 * @param loginId account id
	 * @param function code to execute
	 */
	public static void switchTo(Object loginId, SaFunction function) {
		stpLogic.switchTo(loginId, function);
	}
	

	// ------------------- Secondary authentication -------------------  

	/**
	 * Open secondary authentication in current session
	 *
	 * @param safeTime maintain time (seconds)
	 */
	public static void openSafe(long safeTime) {
		stpLogic.openSafe(safeTime);
	}

	/**
	 * Open secondary authentication in current session
	 *
	 * @param service identifier
	 * @param safeTime maintain time (seconds)
	 */
	public static void openSafe(String service, long safeTime) {
		stpLogic.openSafe(service, safeTime);
	}

	/**
	 * Check: is current session in 2nd auth
	 *
	 * @return true=passed, false=not passed or timeout
	 */
	public static boolean isSafe() {
		return stpLogic.isSafe();
	}

	/**
	 * Check: is current session for specific service in 2nd auth
	 *
	 * @param service identifier
	 * @return true=passed, false=not passed or timeout
	 */
	public static boolean isSafe(String service) {
		return stpLogic.isSafe(service);
	}

	/**
	 * Check: is specified token for specified service in 2nd auth
	 *
	 * @param tokenValue token value
	 * @param service identifier
	 * @return true=passed, false=not passed or timeout
	 */
	public static boolean isSafe(String tokenValue, String service) {
		return stpLogic.isSafe(tokenValue, service);
	}

	/**
	 * Assert: current session passed 2nd authentication, or throw
	 */
	public static void checkSafe() {
		stpLogic.checkSafe();
	}

	/**
	 * Assert: check if session passed 2nd auth for service, or throw
	 *
	 * @param service identifier
	 */
	public static void checkSafe(String service) {
		stpLogic.checkSafe(service);
	}

	/**
	 * Get: remaining validity seconds for current session's 2nd auth, -2=not passed
	 *
	 * @return remaining seconds
	 */
	public static long getSafeTime() {
		return stpLogic.getSafeTime();
	}

	/**
	 * Get: remaining validity seconds for service's 2nd auth, -2=not passed
	 *
	 * @param service identifier
	 * @return remaining seconds
	 */
	public static long getSafeTime(String service) {
		return stpLogic.getSafeTime(service);
	}

	/**
	 * End 2nd auth in current session
	 */
	public static void closeSafe() {
		stpLogic.closeSafe();
	}

	/**
	 * End 2nd auth for service in current session
	 *
	 * @param service identifier
	 */
	public static void closeSafe(String service) {
		stpLogic.closeSafe(service);
	}

}
