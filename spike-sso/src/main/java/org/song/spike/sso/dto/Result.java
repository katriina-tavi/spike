package org.song.spike.sso.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果
 * 
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

//	private static final String SUC_CODE = "200";
//	private static final String ERR_CODE = "500";
	/** 状态 */
	private Boolean flag = true;
	/** 返回信息 */
	private String msg = "SUCCESS";
	/** 数据集 */
	private T data;
	/** 状态码 */
	private String code = "200";

	public Result() {
	}

	public void setErrMsg(String msg) {
		this.flag = false;
		this.msg = msg;
		this.code = "500";
	}

	public static <T> Result<T> setErrorMsg(String msg) {
		Result<T> result = new Result<>();
		result.setErrMsg(msg);
		result.setCode("500");
		return result;
	}

	public static <T> Result<T> setErrorMsg(String msg, T data) {
		Result<T> result = new Result<>();
		result.setErrMsg(msg);
		result.setData(data);
		result.setCode("500");
		return result;
	}

	public static <T> Result<T> setSucMsg(String msg) {
		Result<T> result = new Result<>();
		result.setMsg(msg);
		return result;
	}

	public static <T> Result<T> setSucMsg(String msg, T data) {
		Result<T> result = new Result<>();
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	public static <T> Result<T> setSucData(T data) {
		Result<T> result = new Result<>();
		result.setData(data);
		return result;
	}
}
