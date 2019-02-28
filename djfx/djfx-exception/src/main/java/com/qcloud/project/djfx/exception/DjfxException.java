package com.qcloud.project.djfx.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class DjfxException extends PiratesRuntimeException {

	public DjfxException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DjfxException(String message) {
		super(message);
	}
}
