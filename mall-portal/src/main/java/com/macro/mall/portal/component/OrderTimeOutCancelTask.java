package com.macro.mall.portal.component;

import com.macro.mall.portal.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by macro on 2018/8/24.
 * Scheduled task to cancel timed-out orders and unlock inventory
 */
//@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER =LoggerFactory.getLogger(OrderTimeOutCancelTask.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    /**
     * Cron expression: Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * Scan every 10 minutes; for orders placed before the timeout threshold, cancel if unpaid
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        Integer count = portalOrderService.cancelTimeOutOrder();
        LOGGER.info("取消订单，并根据sku编号释放锁定库存，取消订单数量：{}",count);
    }
}
