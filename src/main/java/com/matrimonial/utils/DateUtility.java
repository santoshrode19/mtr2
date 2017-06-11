package com.matrimonial.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class DateUtility {
	
	public Date getCurrentDate() {
		LocalDateTime currentTime = LocalDateTime.now();
		Date todayDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
		return todayDate;
	}
	
	public Date getDate_ddMMMyyyy(String requestDate){
		Date date = null;
		if(StringUtils.isNotBlank(requestDate)){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");			
			try {
				date = (Date) dateFormat.parse(requestDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		return date;
	}

	public Date getDate_ddMMyyyy(String requestDate){
		Date date = null;
		if(StringUtils.isNotBlank(requestDate)){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");			
			try {
				date = (Date) dateFormat.parse(requestDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		return date;
	}
	
	public Date getTomorrowsDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	public Date getTomorrowsDate(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	public static String toddMMyy(Date day){ 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		String date = formatter.format(day); return date;
}

		
/*	public Date getNextValidDate(Date requestDate){
		
		if(requestDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");			
			Calendar tomorrowCalendar = Calendar.getInstance();
			System.out.println("Request Date "+requestDate);
			Date tomorrowDate = getTomorrowsDate(requestDate);
			tomorrowCalendar.setTime(tomorrowDate);
			System.out.println("Tomorrow Date "+tomorrowDate);
			//String nextDay = dateFormat.format(tomDate).toUpperCase();
			//System.out.println(nextDay);
			//System.out.println(tomorrowCalendar.get(Calendar.DAY_OF_WEEK));
			int tomorrowDay = tomorrowCalendar.get(Calendar.DAY_OF_WEEK); //sunday - 1 Monday = 2, Tuesday = 3, thursday = 4
			
			if(tomorrowDay == Calendar.MONDAY || tomorrowDay == Calendar.THURSDAY){ //2  | 5   MON 2, Tuesday 3, Wendsday 4, Thursday 5, friday 6, Sat. 7, Sun 1
				return tomorrowDate;
			}else{ 
				System.out.println("Begin : "+tomorrowDay);
				while(tomorrowDay != Calendar.MONDAY){
					System.out.println(tomorrowCalendar.getTime() +" "+tomorrowDay);
					tomorrowCalendar.add(Calendar.DAY_OF_MONTH, 1);
					tomorrowDay = tomorrowCalendar.get(Calendar.DAY_OF_WEEK);
					//System.out.println("2 : "+tomorrowDay);
				}
				System.out.println(tomorrowCalendar.getTime());
				for(int i = 1; i < 7; i++){
					tomorrowDay = tomorrowCalendar.get(Calendar.DAY_OF_WEEK + i); 
					if(tomorrowDay == Calendar.MONDAY || tomorrowDay == Calendar.THURSDAY){
						Date incrementDate = DateUtils.addDays(tomDate, i);
						return incrementDate;
					}
				}
			}
			
			
		}
		return null;
	}*/
	
/*public static void main(String[] args) {
	    List<String> intitialDays = new ArrayList<>();
	   intitialDays.add("MONDAY");
	  // intitialDays.add("THURSDAY");
	   List<Date> firstDaysOfWeeks = getNextAvailableMassageDates(intitialDays);
	   for(Date nextDate : firstDaysOfWeeks){
		   System.out.println(nextDate);
	   }
		
	}*/


	public List<Date> getNextAvailableMassageDates(List<String> intitialDays) {
		Date todayDate = Calendar.getInstance().getTime();
		YearMonth month = YearMonth.now();
		List<Date> firstDaysOfWeeks = new ArrayList<>();
		for (String days : intitialDays) {
			DayOfWeek dayOfWeek = null;
			if (days.equals(DayOfWeek.MONDAY.toString())) {
				dayOfWeek = DayOfWeek.MONDAY;
			} else if (days.equals(DayOfWeek.TUESDAY.toString())) {
				dayOfWeek = DayOfWeek.TUESDAY;
			} else if (days.equals(DayOfWeek.WEDNESDAY.toString())) {
				dayOfWeek = DayOfWeek.WEDNESDAY;
			} else if (days.equals(DayOfWeek.THURSDAY.toString())) {
				dayOfWeek = DayOfWeek.THURSDAY;
			} else if (days.equals(DayOfWeek.FRIDAY.toString())) {
				dayOfWeek = DayOfWeek.FRIDAY;
			} else if (days.equals(DayOfWeek.SATURDAY.toString())) {
				dayOfWeek = DayOfWeek.SATURDAY;
			} else if (days.equals(DayOfWeek.SUNDAY.toString())) {
				dayOfWeek = DayOfWeek.SUNDAY;
			}
			for (LocalDate day = firstDayOfCalendar(month, dayOfWeek); stillInCalendar(month, day); day = day.plusWeeks(1)) {
				Instant instant = day.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
				Date nextDate = Date.from(instant);
				if (nextDate.after(todayDate)) {
					firstDaysOfWeeks.add(Date.from(instant));
				}
			}
		}

		Collections.sort(firstDaysOfWeeks, new Comparator<Date>() {
				@Override
				public int compare(Date d1, Date d2) {
					return d1.compareTo(d2);
				}
		});
		return firstDaysOfWeeks;
	}

	public static void main(String[] args) {
		List<String> dateList = new ArrayList<>();
		List<String> intitialDays = new ArrayList<>(); intitialDays.add("MONDAY"); intitialDays.add("THURSDAY");
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		DateUtility  u = new DateUtility();
		for(Date date : u.getNextAvailableMassageDates(intitialDays)){
			dateList.add(format.format(date));
		}
		System.out.println(dateList.toString());
		//System.out.println("Get dat "+u.getDate_ddMMMyyyy("13-09-2013"));
		
	}
	private static LocalDate firstDayOfCalendar(YearMonth month, DayOfWeek day) {
		DayOfWeek FIRST_DAY_OF_WEEK = day;
		return month.atDay(1).with(FIRST_DAY_OF_WEEK);
	}

	private static boolean stillInCalendar(YearMonth yearMonth, LocalDate day) {
		return !day.isAfter(yearMonth.atEndOfMonth());
	}
	
	public Date stringToDate(String dateInString) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateInString);
    }
}
