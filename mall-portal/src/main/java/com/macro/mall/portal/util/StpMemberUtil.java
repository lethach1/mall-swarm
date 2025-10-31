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
package com.macro.mall.portal.util;

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
 * @auther macrozheng
 * @description Frontend mall member login authentication utility class
 * Copied from the default StpUtil, only modified TYPE and stpLogic objects
 * @date 2024/1/26
 * @github https://github.com/macrozheng
 */
public class StpMemberUtil {

	private StpMemberUtil() {}
	
	/**
	 * Type identifier in multi-account system
	 */
	public static final String TYPE = "memberLogin";
	
	/**
	 * The underlying StpLogic object used
	 */
	public static StpLogic stpLogic = new StpLogicJwtForSimple(TYPE);

	/**
	 * Get the account type of the current StpLogic
	 *
	 * @return /
	 */
	public static String getLoginType(){
		return stpLogic.getLoginType();
	}

	/**
	 * Safely reset the StpLogic object
	 *
	 * <br> 1. Change the StpLogic object for this account
	 * <br> 2. Put it into the global StpLogic collection
	 * <br> 3. Send log
	 * 
	 * @param newStpLogic / 
	 */
	public static void setStpLogic(StpLogic newStpLogic) {
		// 1. Reset the StpLogic object for this account
		stpLogic = newStpLogic;
		
		// 2. Add to the global StpLogic collection
		//    so that this StpLogic can be retrieved globally via SaManager.getStpLogic(type)
		SaManager.putStpLogic(newStpLogic);
		
		// 3. $$ Publish event: stpLogic object updated
		SaTokenEventCenter.doSetStpLogic(stpLogic);
	}

	/**
	 * Get the StpLogic object
	 *
	 * @return / 
	 */
	public static StpLogic getStpLogic() {
		return stpLogic;
	}
	
	
	// ------------------- Token retrieval related -------------------

	/**
	 * Return the token name, which appears in the following places: Cookie name when saving token, parameter name when submitting token, key prefix when storing token
	 *
	 * @return /
	 */
	public static String getTokenName() {
 		return stpLogic.getTokenName();
 	}

	/**
	 * Write the specified token value to the current session
	 *
	 * @param tokenValue Token value
	 */
	public static void setTokenValue(String tokenValue){
		stpLogic.setTokenValue(tokenValue);
	}

	/**
	 * Write the specified token value to the current session
	 *
	 * @param tokenValue Token value
	 * @param cookieTimeout Cookie survival time (seconds)
	 */
	public static void setTokenValue(String tokenValue, int cookieTimeout){
		stpLogic.setTokenValue(tokenValue, cookieTimeout);
	}

	/**
	 * Write the specified token value to the current session
	 *
	 * @param tokenValue Token value
	 * @param loginModel Login parameters
	 */
	public static void setTokenValue(String tokenValue, SaLoginModel loginModel){
		stpLogic.setTokenValue(tokenValue, loginModel);
	}

	/**
	 * Get the token value of the current request
	 *
	 * @return Current tokenValue
	 */
	public static String getTokenValue() {
		return stpLogic.getTokenValue();
	}

	/**
	 * Get the token value of the current request (without trimming prefix)
	 *
	 * @return / 
	 */
	public static String getTokenValueNotCut(){
		return stpLogic.getTokenValueNotCut();
	}

	/**
	 * Get the token parameter information of the current session
	 *
	 * @return Token parameter information
	 */
	public static SaTokenInfo getTokenInfo() {
		return stpLogic.getTokenInfo();
	}

	
	// ------------------- Login-related operations -------------------

	// --- Login 

	/**
	 * Session login
	 *
	 * @param id Account ID, recommended types: (long | int | String)
	 */
	public static void login(Object id) {
		stpLogic.login(id);
	}

	/**
	 * Session login and specify login device type
	 *
	 * @param id Account ID, recommended types: (long | int | String)
	 * @param device Device type
	 */
	public static void login(Object id, String device) {
		stpLogic.login(id, device);
	}

	/**
	 * Session login and specify whether to [Remember Me]
	 *
	 * @param id Account ID, recommended types: (long | int | String)
	 * @param isLastingCookie Whether it is a persistent cookie, true means remember me, false means need to log in again when closing browser
	 */
	public static void login(Object id, boolean isLastingCookie) {
		stpLogic.login(id, isLastingCookie);
	}

	/**
	 * Session login and specify the validity period of this login token, unit: seconds
	 *
	 * @param id      Account ID, recommended types: (long | int | String)
	 * @param timeout Validity period of this login token, unit: seconds
	 */
	public static void login(Object id, long timeout) {
		stpLogic.login(id, timeout);
	}

	/**
	 * Session login and specify all login parameter Model
	 *
	 * @param id Account ID, recommended types: (long | int | String)
	 * @param loginModel Parameter Model for this login
	 */
	public static void login(Object id, SaLoginModel loginModel) {
		stpLogic.login(id, loginModel);
	}

	/**
	 * Create login session data for the specified account ID
	 *
	 * @param id Account ID, recommended types: (long | int | String)
	 * @return Returns session token
	 */
	public static String createLoginSession(Object id) {
		return stpLogic.createLoginSession(id);
	}

	/**
	 * Create login session data for the specified account ID
	 *
	 * @param id Account ID, recommended types: (long | int | String)
	 * @param loginModel Parameter Model for this login
	 * @return Returns session token
	 */
	public static String createLoginSession(Object id, SaLoginModel loginModel) {
		return stpLogic.createLoginSession(id, loginModel);
	}
	
	// --- Logout 

	/**
	 * Logout from the current client session
	 */
	public static void logout() {
		stpLogic.logout();
	}

	/**
	 * Session logout by account ID
	 *
	 * @param loginId Account ID
	 */
	public static void logout(Object loginId) {
		stpLogic.logout(loginId);
	}

	/**
	 * Session logout by account ID and device type
	 *
	 * @param loginId Account ID
	 * @param device Device type (null means logout all device types for this account)
	 */
	public static void logout(Object loginId, String device) {
		stpLogic.logout(loginId, device);
	}

	/**
	 * Session logout by specified Token
	 *
	 * @param tokenValue Specified token
	 */
	public static void logoutByTokenValue(String tokenValue) {
		stpLogic.logoutByTokenValue(tokenValue);
	}

	/**
	 * Kick user offline by account ID
	 * <p> When the user accesses the system again, NotLoginException will be thrown with scenario value=-5 </p>
	 *
	 * @param loginId Account ID
	 */
	public static void kickout(Object loginId) {
		stpLogic.kickout(loginId);
	}

	/**
	 * Kick user offline by account ID and device type
	 * <p> When the user accesses the system again, NotLoginException will be thrown with scenario value=-5 </p>
	 *
	 * @param loginId Account ID
	 * @param device Device type (null means kick out all device types for this account)
	 */
	public static void kickout(Object loginId, String device) {
		stpLogic.kickout(loginId, device);
	}

	/**
	 * Kick user offline by specified token
	 * <p> When the user accesses the system again, NotLoginException will be thrown with scenario value=-5 </p>
	 *
	 * @param tokenValue Specified token
	 */
	public static void kickoutByTokenValue(String tokenValue) {
		stpLogic.kickoutByTokenValue(tokenValue);
	}

	/**
	 * Replace user offline by account ID and device type
	 * <p> When the user accesses the system again, NotLoginException will be thrown with scenario value=-4 </p>
	 *
	 * @param loginId Account ID
	 * @param device Device type (null means replace all device types for this account)
	 */
	public static void replaced(Object loginId, String device) {
		stpLogic.replaced(loginId, device);
	}
	
	// Session query

	/**
	 * Determine whether the current session is logged in
	 *
	 * @return Returns true if logged in, false if not logged in
	 */
	public static boolean isLogin() {
		return stpLogic.isLogin();
	}

	/**
	 * Determine whether the specified account is logged in
	 *
	 * @return Returns true if logged in, false if not logged in
	 */
	public static boolean isLogin(Object loginId) {
		return stpLogic.isLogin(loginId);
	}

	/**
	 * Check if the current session is logged in, if not logged in, throw an exception
	 */
 	public static void checkLogin() {
 		stpLogic.checkLogin();
 	}

	/**
	 * Get the current session account ID, if not logged in, throw an exception
	 *
	 * @return Account ID
	 */
	public static Object getLoginId() {
		return stpLogic.getLoginId();
	}

	/**
	 * Get the current session account ID, if not logged in, return default value
	 *
	 * @param <T> Return type
	 * @param defaultValue Default value
	 * @return Login ID
	 */
	public static <T> T getLoginId(T defaultValue) {
		return stpLogic.getLoginId(defaultValue);
	}

	/**
	 * Get the current session account ID, if not logged in, return null
	 *
	 * @return Account ID
	 */
	public static Object getLoginIdDefaultNull() {
		return stpLogic.getLoginIdDefaultNull();
 	}

	/**
	 * Get the current session account ID and convert to String type
	 *
	 * @return Account ID
	 */
	public static String getLoginIdAsString() {
		return stpLogic.getLoginIdAsString();
	}

	/**
	 * Get the current session account ID and convert to int type
	 *
	 * @return Account ID
	 */
	public static int getLoginIdAsInt() {
		return stpLogic.getLoginIdAsInt();
	}

	/**
	 * Get the current session account ID and convert to long type
	 *
	 * @return Account ID
	 */
	public static long getLoginIdAsLong() {
		return stpLogic.getLoginIdAsLong();
	}

	/**
	 * Get the account ID corresponding to the specified token, if not logged in, return null
	 *
	 * @param tokenValue Token
	 * @return Account ID
	 */
 	public static Object getLoginIdByToken(String tokenValue) {
 		return stpLogic.getLoginIdByToken(tokenValue);
 	}

	/**
	 * Get extension information of the current Token (this function only works in JWT mode)
	 *
	 * @param key Key value
	 * @return Corresponding extension data
	 */
	public static Object getExtra(String key) {
		return stpLogic.getExtra(key);
	}

	/**
	 * Get extension information of the specified Token (this function only works in JWT mode)
	 *
	 * @param tokenValue Specified Token value
	 * @param key Key value
	 * @return Corresponding extension data
	 */
	public static Object getExtra(String tokenValue, String key) {
		return stpLogic.getExtra(tokenValue, key);
	}
 	
 	
	// ------------------- Account-Session related -------------------

	/**
	 * Get the Account-Session for the specified account ID, if the SaSession has not been created, isCreate=whether to create and return
	 *
	 * @param loginId Account ID
	 * @param isCreate Whether to create
	 * @return SaSession object
	 */
	public static SaSession getSessionByLoginId(Object loginId, boolean isCreate) {
		return stpLogic.getSessionByLoginId(loginId, isCreate);
	}

	/**
	 * Get the SaSession for the specified key, if the SaSession has not been created, return null
	 *
	 * @param sessionId SessionId
	 * @return Session object
	 */
	public static SaSession getSessionBySessionId(String sessionId) {
		return stpLogic.getSessionBySessionId(sessionId);
	}

	/**
	 * Get the Account-Session for the specified account ID, if the SaSession has not been created, create and return
	 *
	 * @param loginId Account ID
	 * @return SaSession object
	 */
	public static SaSession getSessionByLoginId(Object loginId) {
		return stpLogic.getSessionByLoginId(loginId);
	}

	/**
	 * Get the Account-Session of the current logged-in account, if the SaSession has not been created, isCreate=whether to create and return
	 *
	 * @param isCreate Whether to create
	 * @return Session object
	 */
	public static SaSession getSession(boolean isCreate) {
		return stpLogic.getSession(isCreate);
	}

	/**
	 * Get the Account-Session of the current logged-in account, if the SaSession has not been created, create and return
	 *
	 * @return Session object
	 */
	public static SaSession getSession() {
		return stpLogic.getSession();
	}

	
	// ------------------- Token-Session related -------------------  

	/**
	 * Get the Token-Session for the specified token, if the SaSession has not been created, create and return
	 *
	 * @param tokenValue Token value
	 * @return Session object
	 */
	public static SaSession getTokenSessionByToken(String tokenValue) {
		return stpLogic.getTokenSessionByToken(tokenValue);
	}

	/**
	 * Get the Token-Session of the current token, if the SaSession has not been created, create and return
	 *
	 * @return Session object
	 */
	public static SaSession getTokenSession() {
		return stpLogic.getTokenSession();
	}

	/**
	 * Get the current anonymous Token-Session (Token-Session that can be used when not logged in)
	 *
	 * @return Token-Session object
	 */
	public static SaSession getAnonTokenSession() {
		return stpLogic.getAnonTokenSession();
	}
	
	
	// ------------------- Active-Timeout token minimum activity verification related -------------------

	/**
	 * Renew the current token: (update [last operation time] to current timestamp)
	 * <h2>
	 * 		Note: Even if the token has been frozen, the renewal can succeed,
	 * 		if you need to prompt renewal failure in this scenario, you can call checkActiveTimeout() before this to force check if it is frozen
	 * </h2>
	 */
	public static void updateLastActiveToNow() {
		stpLogic.updateLastActiveToNow();
	}

	/**
	 * Check if the current token has been frozen, if yes, throw an exception
	 */
 	public static void checkActiveTimeout() {
 		stpLogic.checkActiveTimeout();
 	}

	
	// ------------------- Expiration time related -------------------

	/**
	 * Get the remaining valid time of the current session token (unit: seconds, return -1 means permanently valid, -2 means no such value)
	 *
	 * @return Token remaining valid time
	 */
 	public static long getTokenTimeout() {
 		return stpLogic.getTokenTimeout();
 	}

	/**
	 * Get the remaining valid time of the specified token (unit: seconds, return -1 means permanently valid, -2 means no such value)
	 *
	 * @param token Specified token
	 * @return Token remaining valid time
	 */
	public static long getTokenTimeout(String token) {
		return stpLogic.getTokenTimeout(token);
	}

	/**
	 * Get the remaining valid time of the current logged-in account's Account-Session (unit: seconds, return -1 means permanently valid, -2 means no such value)
	 *
	 * @return Token remaining valid time
	 */
 	public static long getSessionTimeout() {
 		return stpLogic.getSessionTimeout();
 	}

	/**
	 * Get the remaining valid time of the current token's Token-Session (unit: seconds, return -1 means permanently valid, -2 means no such value)
	 *
	 * @return Token remaining valid time
	 */
 	public static long getTokenSessionTimeout() {
 		return stpLogic.getTokenSessionTimeout();
 	}

	/**
	 * Get the remaining active validity period of the current token: how much time is left before the current token is frozen (unit: seconds, return -1 means never frozen, -2 means no such value or token has been frozen)
	 *
	 * @return /
	 */
 	public static long getTokenActiveTimeout() {
 		return stpLogic.getTokenActiveTimeout();
 	}

	/**
	 * Renew the timeout value of the current token
	 *
	 * @param timeout The valid time to modify to (unit: seconds)
	 */
 	public static void renewTimeout(long timeout) {
 		stpLogic.renewTimeout(timeout);
 	}

	/**
	 * Renew the timeout value of the specified token
	 *
	 * @param tokenValue Specified token
	 * @param timeout The valid time to modify to (unit: seconds, fill -1 means renew to permanently valid)
	 */
 	public static void renewTimeout(String tokenValue, long timeout) {
 		stpLogic.renewTimeout(tokenValue, timeout);
 	}
 	
 	
	// ------------------- Role authentication operations -------------------

	/**
	 * Get: Role collection of the current account
	 *
	 * @return /
	 */
	public static List<String> getRoleList() {
		return stpLogic.getRoleList();
	}

	/**
	 * Get: Role collection of the specified account
	 *
	 * @param loginId Specified account ID
	 * @return /
	 */
	public static List<String> getRoleList(Object loginId) {
		return stpLogic.getRoleList(loginId);
	}

	/**
	 * Determine: Whether the current account has the specified role, returns true or false
	 *
	 * @param role Role
	 * @return /
	 */
 	public static boolean hasRole(String role) {
 		return stpLogic.hasRole(role);
 	}

	/**
	 * Determine: Whether the specified account contains the specified role identifier, returns true or false
	 *
	 * @param loginId Account ID
	 * @param role Role identifier
	 * @return Whether it contains the specified role identifier
	 */
 	public static boolean hasRole(Object loginId, String role) {
 		return stpLogic.hasRole(loginId, role);
 	}

	/**
	 * Determine: Whether the current account contains the specified role identifier [Specify multiple, all must be verified]
	 *
	 * @param roleArray Role identifier array
	 * @return true or false
	 */
 	public static boolean hasRoleAnd(String... roleArray){
 		return stpLogic.hasRoleAnd(roleArray);
 	}

	/**
	 * Determine: Whether the current account contains the specified role identifier [Specify multiple, any one verification passes]
	 *
	 * @param roleArray Role identifier array
	 * @return true or false
	 */
 	public static boolean hasRoleOr(String... roleArray){
 		return stpLogic.hasRoleOr(roleArray);
 	}

	/**
	 * Verify: Whether the current account contains the specified role identifier, if verification fails, throw exception: NotRoleException
	 *
	 * @param role Role identifier
	 */
 	public static void checkRole(String role) {
 		stpLogic.checkRole(role);
 	}

	/**
	 * Verify: Whether the current account contains the specified role identifier [Specify multiple, all must be verified]
	 *
	 * @param roleArray Role identifier array
	 */
 	public static void checkRoleAnd(String... roleArray){
 		stpLogic.checkRoleAnd(roleArray);
 	}

	/**
	 * Verify: Whether the current account contains the specified role identifier [Specify multiple, any one verification passes]
	 *
	 * @param roleArray Role identifier array
	 */
 	public static void checkRoleOr(String... roleArray){
 		stpLogic.checkRoleOr(roleArray);
 	}

	
	// ------------------- Permission authentication operations -------------------

	/**
	 * Get: Permission code collection of the current account
	 *
	 * @return /
	 */
	public static List<String> getPermissionList() {
		return stpLogic.getPermissionList();
	}

	/**
	 * Get: Permission code collection of the specified account
	 *
	 * @param loginId Specified account ID
	 * @return /
	 */
	public static List<String> getPermissionList(Object loginId) {
		return stpLogic.getPermissionList(loginId);
	}

	/**
	 * Determine: Whether the current account contains the specified permission, returns true or false
	 *
	 * @param permission Permission code
	 * @return Whether it contains the specified permission
	 */
	public static boolean hasPermission(String permission) {
		return stpLogic.hasPermission(permission);
	}

	/**
	 * Determine: Whether the specified account ID contains the specified permission, returns true or false
	 *
	 * @param loginId Account ID
	 * @param permission Permission code
	 * @return Whether it contains the specified permission
	 */
	public static boolean hasPermission(Object loginId, String permission) {
		return stpLogic.hasPermission(loginId, permission);
	}

	/**
	 * Determine: Whether the current account contains the specified permission [Specify multiple, all must be present]
	 *
	 * @param permissionArray Permission code array
	 * @return true or false
	 */
 	public static boolean hasPermissionAnd(String... permissionArray){
 		return stpLogic.hasPermissionAnd(permissionArray);
 	}

	/**
	 * Determine: Whether the current account contains the specified permission [Specify multiple, any one verification passes]
	 *
	 * @param permissionArray Permission code array
	 * @return true or false
	 */
 	public static boolean hasPermissionOr(String... permissionArray){
 		return stpLogic.hasPermissionOr(permissionArray);
 	}

	/**
	 * Verify: Whether the current account contains the specified permission, if verification fails, throw exception: NotPermissionException
	 *
	 * @param permission Permission code
	 */
	public static void checkPermission(String permission) {
		stpLogic.checkPermission(permission);
	}

	/**
	 * Verify: Whether the current account contains the specified permission [Specify multiple, all must be verified]
	 *
	 * @param permissionArray Permission code array
	 */
	public static void checkPermissionAnd(String... permissionArray) {
		stpLogic.checkPermissionAnd(permissionArray);
	}

	/**
	 * Verify: Whether the current account contains the specified permission [Specify multiple, any one verification passes]
	 *
	 * @param permissionArray Permission code array
	 */
	public static void checkPermissionOr(String... permissionArray) {
		stpLogic.checkPermissionOr(permissionArray);
	}

	
	// ------------------- ID reverse lookup token related operations -------------------

	/**
	 * Get the token for the specified account ID
	 * <p>
	 * 		When configured to allow concurrent login, this method will only return the last token in the queue,
	 * 		if you need to return all tokens for this account ID, please call getTokenValueListByLoginId
	 * </p>
	 *
	 * @param loginId Account ID
	 * @return Token value
	 */
	public static String getTokenValueByLoginId(Object loginId) {
		return stpLogic.getTokenValueByLoginId(loginId);
	}

	/**
	 * Get the token for the specified account ID and device type
	 * <p>
	 * 		When configured to allow concurrent login, this method will only return the last token in the queue,
	 * 		if you need to return all tokens for this account ID, please call getTokenValueListByLoginId
	 * </p>
	 *
	 * @param loginId Account ID
	 * @param device Device type, fill null means no device type limit
	 * @return Token value
	 */
	public static String getTokenValueByLoginId(Object loginId, String device) {
		return stpLogic.getTokenValueByLoginId(loginId, device);
	}

	/**
	 * Get the token collection for the specified account ID
	 *
	 * @param loginId Account ID
	 * @return All related tokens for this loginId
	 */
	public static List<String> getTokenValueListByLoginId(Object loginId) {
		return stpLogic.getTokenValueListByLoginId(loginId);
	}

	/**
	 * Get the token collection for the specified account ID and device type
	 *
	 * @param loginId Account ID
	 * @param device Device type, fill null means no device type limit
	 * @return All login tokens for this loginId
	 */
	public static List<String> getTokenValueListByLoginId(Object loginId, String device) {
		return stpLogic.getTokenValueListByLoginId(loginId, device);
	}

	/**
	 * Get the tokenSign collection for the specified account ID and device type
	 *
	 * @param loginId Account ID
	 * @param device Device type, fill null means no device type limit
	 * @return All login tokenSigns for this loginId
	 */
	public static List<TokenSign> getTokenSignListByLoginId(Object loginId, String device) {
		return stpLogic.getTokenSignListByLoginId(loginId, device);
	}

	/**
	 * Return the login device type of the current session
	 *
	 * @return Login device type of the current token
	 */
	public static String getLoginDevice() {
		return stpLogic.getLoginDevice(); 
	}

	
	// ------------------- Session management -------------------  

	/**
	 * Query all tokens in the cache based on conditions
	 *
	 * @param keyword Keyword
	 * @param start Starting index
	 * @param size Number to get (-1 means get to the end)
	 * @param sortType Sort type (true=ascending, false=descending)
	 *
	 * @return Token collection
	 */
	public static List<String> searchTokenValue(String keyword, int start, int size, boolean sortType) {
		return stpLogic.searchTokenValue(keyword, start, size, sortType);
	}

	/**
	 * Query all SessionIds in the cache based on conditions
	 *
	 * @param keyword Keyword
	 * @param start Starting index
	 * @param size Number to get (-1 means get to the end)
	 * @param sortType Sort type (true=ascending, false=descending)
	 *
	 * @return SessionId collection
	 */
	public static List<String> searchSessionId(String keyword, int start, int size, boolean sortType) {
		return stpLogic.searchSessionId(keyword, start, size, sortType);
	}

	/**
	 * Query all Token-Session-Ids in the cache based on conditions
	 *
	 * @param keyword Keyword
	 * @param start Starting index
	 * @param size Number to get (-1 means get to the end)
	 * @param sortType Sort type (true=ascending, false=descending)
	 *
	 * @return SessionId collection
	 */
	public static List<String> searchTokenSessionId(String keyword, int start, int size, boolean sortType) {
		return stpLogic.searchTokenSessionId(keyword, start, size, sortType);
	}

	
	// ------------------- Account ban -------------------  

	/**
	 * Ban: Specified account
	 * <p> This method will not directly kick this account ID offline. If you need to go offline immediately after banning, please additionally call StpUtil.logout(id)
	 *
	 * @param loginId Specified account ID
	 * @param time Ban time, unit: seconds (-1=permanent ban)
	 */
	public static void disable(Object loginId, long time) {
		stpLogic.disable(loginId, time);
	}

	/**
	 * Determine: Whether the specified account has been banned (true=banned, false=not banned)
	 *
	 * @param loginId Account ID
	 * @return /
	 */
	public static boolean isDisable(Object loginId) {
		return stpLogic.isDisable(loginId);
	}

	/**
	 * Verify: Whether the specified account has been banned, if banned, throw an exception
	 *
	 * @param loginId Account ID
	 */
	public static void checkDisable(Object loginId) {
		stpLogic.checkDisable(loginId);
	}

	/**
	 * Get: Remaining ban time for the specified account, unit: seconds (-1=permanent ban, -2=not banned)
	 *
	 * @param loginId Account ID
	 * @return /
	 */
	public static long getDisableTime(Object loginId) {
		return stpLogic.getDisableTime(loginId);
	}

	/**
	 * Unban: Specified account
	 *
	 * @param loginId Account ID
	 */
	public static void untieDisable(Object loginId) {
		stpLogic.untieDisable(loginId);
	}

	
	// ------------------- Category ban -------------------  

	/**
	 * Ban: Specified service for the specified account
	 * <p> This method will not directly kick this account ID offline. If you need to go offline immediately after banning, please additionally call StpUtil.logout(id)
	 *
	 * @param loginId Specified account ID
	 * @param service Specified service
	 * @param time Ban time, unit: seconds (-1=permanent ban)
	 */
	public static void disable(Object loginId, String service, long time) {
		stpLogic.disable(loginId, service, time);
	}

	/**
	 * Determine: Whether the specified service for the specified account has been banned (true=banned, false=not banned)
	 *
	 * @param loginId Account ID
	 * @param service Specified service
	 * @return /
	 */
	public static boolean isDisable(Object loginId, String service) {
		return stpLogic.isDisable(loginId, service);
	}

	/**
	 * Verify: Whether the specified service for the specified account has been banned, if banned, throw an exception
	 *
	 * @param loginId Account ID
	 * @param services Specified service, can specify multiple
	 */
	public static void checkDisable(Object loginId, String... services) {
		stpLogic.checkDisable(loginId, services);
	}

	/**
	 * Get: Remaining ban time for the specified service of the specified account, unit: seconds (-1=permanent ban, -2=not banned)
	 *
	 * @param loginId Account ID
	 * @param service Specified service
	 * @return See note
	 */
	public static long getDisableTime(Object loginId, String service) {
		return stpLogic.getDisableTime(loginId, service);
	}

	/**
	 * Unban: Specified account and specified service
	 *
	 * @param loginId Account ID
	 * @param services Specified service, can specify multiple
	 */
	public static void untieDisable(Object loginId, String... services) {
		stpLogic.untieDisable(loginId, services);
	}

	
	// ------------------- Tier ban -------------------

	/**
	 * Ban: Specified account and specify ban level
	 *
	 * @param loginId Specified account ID
	 * @param level Specified ban level
	 * @param time Ban time, unit: seconds (-1=permanent ban)
	 */
	public static void disableLevel(Object loginId, int level, long time) {
		stpLogic.disableLevel(loginId, level, time);
	}

	/**
	 * Ban: Specified service for the specified account, and specify ban level
	 *
	 * @param loginId Specified account ID
	 * @param service Specified ban service
	 * @param level Specified ban level
	 * @param time Ban time, unit: seconds (-1=permanent ban)
	 */
	public static void disableLevel(Object loginId, String service, int level, long time) {
		stpLogic.disableLevel(loginId, service, level, time);
	}

	/**
	 * Determine: Whether the specified account has been banned to the specified level
	 *
	 * @param loginId Specified account ID
	 * @param level Specified ban level
	 * @return /
	 */
	public static boolean isDisableLevel(Object loginId, int level) {
		return stpLogic.isDisableLevel(loginId, level);
	}

	/**
	 * Determine: Whether the specified service of the specified account has been banned to the specified level
	 *
	 * @param loginId Specified account ID
	 * @param service Specified ban service
	 * @param level Specified ban level
	 * @return /
	 */
	public static boolean isDisableLevel(Object loginId, String service, int level) {
		return stpLogic.isDisableLevel(loginId, service, level);
	}

	/**
	 * Verify: Whether the specified account has been banned to the specified level (if reached, throw an exception)
	 *
	 * @param loginId Specified account ID
	 * @param level Ban level (only when ban level ≥ this value will throw an exception)
	 */
	public static void checkDisableLevel(Object loginId, int level) {
		stpLogic.checkDisableLevel(loginId, level);
	}

	/**
	 * Verify: Whether the specified service of the specified account has been banned to the specified level (if reached, throw an exception)
	 *
	 * @param loginId Specified account ID
	 * @param service Specified ban service
	 * @param level Ban level (only when ban level ≥ this value will throw an exception)
	 */
	public static void checkDisableLevel(Object loginId, String service, int level) {
		stpLogic.checkDisableLevel(loginId, service, level);
	}

	/**
	 * Get: The ban level of the specified account, if not banned, return -2
	 *
	 * @param loginId Specified account ID
	 * @return /
	 */
	public static int getDisableLevel(Object loginId) {
		return stpLogic.getDisableLevel(loginId);
	}

	/**
	 * Get: The ban level of the specified service for the specified account, if not banned, return -2
	 *
	 * @param loginId Specified account ID
	 * @param service Specified ban service
	 * @return /
	 */
	public static int getDisableLevel(Object loginId, String service) {
		return stpLogic.getDisableLevel(loginId, service);
	}
	
	
	// ------------------- Temporary identity switch -------------------

	/**
	 * Temporarily switch identity to the specified account ID
	 *
	 * @param loginId Specified loginId
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
	 * Determine whether the current request is in [temporary identity switch]
	 *
	 * @return /
	 */
	public static boolean isSwitch() {
		return stpLogic.isSwitch();
	}

	/**
	 * In a lambda code segment, temporarily switch identity to the specified account ID, automatically restore after lambda ends
	 *
	 * @param loginId Specified account ID
	 * @param function Method to execute
	 */
	public static void switchTo(Object loginId, SaFunction function) {
		stpLogic.switchTo(loginId, function);
	}
	
	
	// ------------------- Secondary authentication -------------------

	/**
	 * Enable secondary authentication in the current session
	 *
	 * @param safeTime Maintenance time (unit: seconds)
	 */
	public static void openSafe(long safeTime) {
		stpLogic.openSafe(safeTime);
	}

	/**
	 * Enable secondary authentication in the current session
	 *
	 * @param service Business identifier
	 * @param safeTime Maintenance time (unit: seconds)
	 */
	public static void openSafe(String service, long safeTime) {
		stpLogic.openSafe(service, safeTime);
	}

	/**
	 * Determine: Whether the current session is within the secondary authentication time
	 *
	 * @return true=Secondary authentication passed, false=Secondary authentication not performed or authentication timed out
	 */
	public static boolean isSafe() {
		return stpLogic.isSafe();
	}

	/**
	 * Determine: Whether the current session is within the secondary authentication time for the specified business
	 *
	 * @param service Business identifier
	 * @return true=Secondary authentication passed, false=Secondary authentication not performed or authentication timed out
	 */
	public static boolean isSafe(String service) {
		return stpLogic.isSafe(service);
	}

	/**
	 * Determine: Whether the specified token is within the secondary authentication time
	 *
	 * @param tokenValue Token value
	 * @param service Business identifier
	 * @return true=Secondary authentication passed, false=Secondary authentication not performed or authentication timed out
	 */
	public static boolean isSafe(String tokenValue, String service) {
		return stpLogic.isSafe(tokenValue, service);
	}

	/**
	 * Verify: Whether the current session has passed secondary authentication, if not, throw an exception
	 */
	public static void checkSafe() {
		stpLogic.checkSafe();
	}

	/**
	 * Verify: Check whether the current session has passed secondary authentication for the specified business, if not, throw an exception
	 *
	 * @param service Business identifier
	 */
	public static void checkSafe(String service) {
		stpLogic.checkSafe(service);
	}

	/**
	 * Get: Remaining valid time of secondary authentication for the current session (unit: seconds, return -2 means secondary authentication not passed yet)
	 *
	 * @return Remaining valid time
	 */
	public static long getSafeTime() {
		return stpLogic.getSafeTime();
	}

	/**
	 * Get: Remaining valid time of secondary authentication for the current session (unit: seconds, return -2 means secondary authentication not passed yet)
	 *
	 * @param service Business identifier
	 * @return Remaining valid time
	 */
	public static long getSafeTime(String service) {
		return stpLogic.getSafeTime(service);
	}

	/**
	 * End secondary authentication in the current session
	 */
	public static void closeSafe() {
		stpLogic.closeSafe();
	}

	/**
	 * End secondary authentication for the specified business identifier in the current session
	 *
	 * @param service Business identifier
	 */
	public static void closeSafe(String service) {
		stpLogic.closeSafe(service);
	}

}
