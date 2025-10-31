package com.macro.mall.common.dto;

import lombok.*;

import java.util.List;

/**
 * @author macrozheng
 * @description User information wrapper used in permission framework
 * @date 2024/1/30
 * @github https://github.com/macrozheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String clientId;
    private List<String> permissionList;
}
