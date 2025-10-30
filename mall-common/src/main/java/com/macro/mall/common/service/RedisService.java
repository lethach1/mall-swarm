package com.macro.mall.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis operation Service
 * Created by macro on 2020/3/3.
 */
public interface RedisService {

    /**
     * Save property
     */
    void set(String key, Object value, long time);

    /**
     * Save property
     */
    void set(String key, Object value);

    /**
     * Get property
     */
    Object get(String key);

    /**
     * Delete property
     */
    Boolean del(String key);

    /**
     * Batch delete properties
     */
    Long del(List<String> keys);

    /**
     * Set expiration time
     */
    Boolean expire(String key, long time);

    /**
     * Get expiration time
     */
    Long getExpire(String key);

    /**
     * Check if property exists
     */
    Boolean hasKey(String key);

    /**
     * Increment by delta
     */
    Long incr(String key, long delta);

    /**
     * Decrement by delta
     */
    Long decr(String key, long delta);

    /**
     * Get property from Hash structure
     */
    Object hGet(String key, String hashKey);

    /**
     * Add property to Hash structure
     */
    Boolean hSet(String key, String hashKey, Object value, long time);

    /**
     * Add property to Hash structure
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * Get whole Hash structure
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * Set whole Hash structure
     */
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    /**
     * Set whole Hash structure
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * Delete property in Hash structure
     */
    void hDel(String key, Object... hashKey);

    /**
     * Check if key exists in Hash structure
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Increment property in Hash structure
     */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * Decrement property in Hash structure
     */
    Long hDecr(String key, String hashKey, Long delta);

    /**
     * Get Set structure
     */
    Set<Object> sMembers(String key);

    /**
     * Add property to Set structure
     */
    Long sAdd(String key, Object... values);

    /**
     * Add property to Set structure
     */
    Long sAdd(String key, long time, Object... values);

    /**
     * Is member of Set
     */
    Boolean sIsMember(String key, Object value);

    /**
     * Get length of Set structure
     */
    Long sSize(String key);

    /**
     * Delete from Set structure
     */
    Long sRemove(String key, Object... values);

    /**
     * Get List structure properties
     */
    List<Object> lRange(String key, long start, long end);

    /**
     * Get length of List structure
     */
    Long lSize(String key);

    /**
     * Get property of List by index
     */
    Object lIndex(String key, long index);

    /**
     * Add property to List structure
     */
    Long lPush(String key, Object value);

    /**
     * Add property to List structure
     */
    Long lPush(String key, Object value, long time);

    /**
     * Batch add to List structure
     */
    Long lPushAll(String key, Object... values);

    /**
     * Batch add to List structure
     */
    Long lPushAll(String key, Long time, Object... values);

    /**
     * Remove property from List structure
     */
    Long lRemove(String key, long count, Object value);
}