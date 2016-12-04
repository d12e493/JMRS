package idv.jmrs.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
	public final static int DURATION_INTERVAL = 30;

	public static String timeFormat(Time time) {
		if (time != null) {
			Date date = new Date(time.getTime());
			return TIME_FORMAT.format(date);
		}
		return null;
	}

	public static Calendar getCalendar(String hourAndMinute) {
		Calendar c = Calendar.getInstance();

		Date date;
		try {
			date = TIME_FORMAT.parse(hourAndMinute);
			c.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static int getRowSpan(String start, String end) {
		int duration = 0;

		if (start != null && end != null) {
			long timeDuraion = getCalendar(end).getTimeInMillis() - getCalendar(start).getTimeInMillis();
			duration = (int) timeDuraion / 1000 / 60;
			duration = duration / DURATION_INTERVAL;
		}

		return duration;
	}
}
