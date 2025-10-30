package com.macro.mall.component;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.macro.mall.common.constant.AuthConstant;
import com.macro.mall.common.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author macrozheng
 * @description Custom permission validation interface extension
 * @date 2024/1/25
 * @github https://github.com/macrozheng
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // Return the list of permissions owned by the loginId
        if(StpUtil.getLoginType().equals(loginType)){
            // For backend users, return
            UserDto userdto = (UserDto) StpUtil.getSession().get(AuthConstant.STP_ADMIN_INFO);
            return userdto.getPermissionList();
        }else{
            // For frontend users, do not return
            return null;
        }
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // Return the list of roles owned by the loginId
        return null;
    }

}

