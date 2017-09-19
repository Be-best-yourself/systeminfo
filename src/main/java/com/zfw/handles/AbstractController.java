package com.zfw.handles;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

import com.zfw.tips.Tips;

public class AbstractController {
	public static final String SUCCESS="success";
	public static final String HTTP_STATUS="httpstatus";
	public static final String RESULT="result";
	public static final String TIP="tip";
	
	protected void success(ModelMap model) {
		model.put(SUCCESS, true);
		model.put(HTTP_STATUS, HttpStatus.OK.toString());
	}
	protected void success(ModelMap model,Tips tip){
		model.put(TIP, tip);
	}
	protected void success(ModelMap model,Object o) {
		this.success(model, RESULT, o);
	}
	protected void success(ModelMap model,String key,Object o) {
		this.success(model);
		model.put(key, o);
	}
	protected void fail(ModelMap model) {
		model.put(SUCCESS, false);
		model.put(HTTP_STATUS, HttpStatus.OK.toString());
	}
	protected void fail(ModelMap model,Object o) {
		this.success(model, RESULT, o);
	}
	protected void fail(ModelMap model,String key,Object o) {
		this.success(model);
		model.put(key, o);
	}
	
}
