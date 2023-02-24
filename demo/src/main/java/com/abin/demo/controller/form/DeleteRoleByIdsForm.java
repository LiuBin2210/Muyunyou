package com.abin.demo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author 啊斌
 * @date 2023/02/24
 */
@Data
@Schema(description = "删除角色表单")
public class DeleteRoleByIdsForm {

    @NotEmpty(message = "ids不能为空")
    @Schema(description = "角色Id")
    private Integer[] ids;
}
