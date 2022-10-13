package com.monster.base.develop.common;

import com.monster.base.develop.constant.DefaultConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wuhan
 * @date 2022/10/13 16:54
 */
@Data
@ToString
@ApiModel(description = "统一API响应结果封装")
@NoArgsConstructor
public class R<T> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码", required = true)
    private int code;

    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;

    @ApiModelProperty(value = "承载数据")
    private T data;

    @ApiModelProperty(value = "返回消息", required = true)
    private String message;

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
        this.success = ResultCode.SUCCESS.code == code;
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(T data) {
        return data(data, ResultCode.SUCCESS.getMessage());
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(T data, String msg) {
        return data(HttpServletResponse.SC_OK, data, msg);
    }

    /**
     * 返回R
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(int code, T data, String msg) {
        return new R<>(code, data, data == null ? DefaultConstant.DEFAULT_NULL_MESSAGE.getDesc() : msg);
    }

}
