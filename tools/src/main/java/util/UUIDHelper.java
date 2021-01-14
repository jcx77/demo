package util;

import java.util.UUID;
/**
* @Description: TODO(生成uuid)
* @Param: 
* @return: 
* @Author: zcx
* @Date: 2020/12/5 12:42
*/
public class UUIDHelper {

	public static UUID newUUID() {
		return UUID.randomUUID();
	}

	public static String newUUIDString() {
		return newUUID().toString();
	}

	public static String get32UUID() {
		return newUUIDString().replaceAll("-", "");
	}

	public static UUID parse(String name) {
		return UUID.fromString(name);
	}

	public static boolean equalsUUID(UUID u1, UUID u2) {
		return (u1 == null) ? (u2 == null) : u1.equals(u2);
	}
}
