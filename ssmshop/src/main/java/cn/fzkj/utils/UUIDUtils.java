package cn.fzkj.utils;

import java.util.UUID;

//工具类
public class UUIDUtils {

	//获取一个随机字符串
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
