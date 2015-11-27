package businesslogic.systembl;

/**
 * 系统功能对逻辑层内部的辅助类
 */
import po.SystemUserPO;

public class SystemHelper {

	static SystemUserPO UserNow;

	public static void setUser(SystemUserPO user) {
		UserNow = user;
	}

	public static SystemUserPO getUser() {
		return UserNow;
	}
}
