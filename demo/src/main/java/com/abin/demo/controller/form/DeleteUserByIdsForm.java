package com.abin.demo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: 啊斌
 * @Data:2023/2/20 17:40
 */
@Data
@Schema(description = "删除用户表单")
public class DeleteUserByIdsForm {

    @NotEmpty(message = "ids不能为空")
    @Schema(description = "用户ID")
    private Integer[] ids;
}
