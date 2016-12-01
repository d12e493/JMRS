package idv.jmrs.utils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public final static SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat timeForamt = new SimpleDateFormat("HH:mm");

	public static String timeFormat(Time time) {
		if (time != null) {
			Date date = new Date(time.getTime());
			return timeForamt.format(date);
		}
		return null;
	}
}
