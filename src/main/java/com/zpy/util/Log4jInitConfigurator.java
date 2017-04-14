package com.zpy.util;

import org.apache.log4j.xml.DOMConfigurator;

public class Log4jInitConfigurator {

	public void init() {
		DOMConfigurator.configure("src/main/resource/log4j.xml");
	}
}
