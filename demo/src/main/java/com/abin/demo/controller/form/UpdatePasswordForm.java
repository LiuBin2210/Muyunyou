package com.abin.demo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: 啊斌
 * @Data:2023/2/14 11:50
 */
@Schema(description = "修改密码表单")
@Data
public class UpdatePasswordForm {

    @NotBlank(message = "password不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,9}$",message = "password内容不正确")
    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "newPassword不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,9}$",message = "newPassword内容不正确")
    @Schema(description = "新密码")
    private String newPassword;
}
