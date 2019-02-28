package com.qcloud.project.djfx.util;

import org.springframework.stereotype.Component;

@Component
public class GetOrderUtil {

	public long getOrder() {
		String s = RandomUtils.randomNumber(16);
		long orderNumber = Long.parseLong(s);
		return orderNumber;
	}

}
