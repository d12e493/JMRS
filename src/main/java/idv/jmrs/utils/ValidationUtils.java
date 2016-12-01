package idv.jmrs.utils;

import java.util.List;

public class ValidationUtils {

	public static boolean CheckListIsNotEmpty(List<?> list) {
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
