package com.example.base;

/**
 * @author: Jackson
 * @date: 2019/11/6
 * @description:
 */
public enum ApiResponseEnum implements ApiBaseEnum {

    /**
     * 公共错误码100-操作失败
     */
    FAIL(100, "FAIL", "操作失败"),

    /**
     * 公共成功响应状态码200-操作成功
     */
    SUCCESS(200, "SUCCESS", "操作成功"),

    /**
     * 公共错误码400-错误的请求
     */
    BAD_REQUEST(400, "BAD REQUEST", "错误的请求"),

    /**
     * 公共错误码401-身份认证失败!!!
     */
    TICKET_EMPTY(401, "IDENTITY AUTHENTICATION FAILED", "身份认证失败,请重新登录"),

    /**
     * 公共错误码403-没有权限
     */
    FORBIDDEN(403, "FORBIDDEN", "没有权限"),
    
    /**
     * 公共错误码403-由于和被请求的资源的当前状态之间存在冲突，请求无法完成
     */
    CONFLICT(409,"CONFLICT","由于和被请求的资源的当前状态之间存在冲突，请求无法完成"),

    /**
     * 公共错误码400-资源不存在
     */
    RESOURCE_NOT_FOUND(404, "RESOURCE NOT FOUND", "资源不存在"),

    /**
     * 公共错误码500-服务器处理失败
     */
    INTERNAL_ERROR(500, "INTERNAL ERROR", "服务器处理失败"),

    /**
     * 公共错误码600-缺少必要参数
     */
    PARAMETER_CAN_NOT_NULL(600, "PARAMETER CAN NOT NULL", "缺少必要参数"),

    /**
     * 公共错误码601-非法参数
     */
    PARAMETER_INVALID(601, "PARAMETER INVALID", "非法参数"),

    /**
     * 公共错误码602-数据为空
     */
    DATA_NULL(602, "DATA NULL", "数据为空"),

    /**
     * 公共错误码603-读取excel表格数据异常
     */
    READ_EXCEL_ERROR(603, "READ_EXCEL_ERROR", "读取excel表格数据异常"),

    /**
     * 公共错误码604-数据已经存在
     */
    DB_FIELD_REPETITION(604, "DB FIELD REPETITION", "数据已经存在"),

    /**
     * 公共错误码605-表格导入失败
     */
    FAIL_IMPORT(605, "FAIL IMPORT", "表格导入失败"),

    /**
     * 公共表格导入成功码606-表格导入成功
     */
    SUCCESS_IMPORT(606, "SUCCESS IMPORT", "表格导入成功"),

    /**
     * 内部服务异常！请稍后重试！
     */
    INNER_SERVER_EXCEPTION(607, "INNER SERVER EXCEPTION", "内部服务异常！请稍后重试！"),
    ;

    /**
     * api响应code码
     */
    private int code;

    /**
     * api错误码描述
     */
    private String msg;

    /**
     * 错误详细备注
     */
    private String note;

    ApiResponseEnum(int code, String msg, String note) {
        this.code = code;
        this.msg = msg;
        this.note = note;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getNote() {
        return note;
    }


}
