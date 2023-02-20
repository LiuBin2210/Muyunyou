package com.abin.demo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: 啊斌
 * @Data:2023/2/12 13:26
 */
@Data
@Schema(description = "用户表单")
public class UserForm {

    @NotBlank(message = "username不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,9}$",message = "username内容不正确")
    @Schema(description = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,9}$",message = "password内容不正确")
    @Schema(description = "密码")
    private String password;

}
