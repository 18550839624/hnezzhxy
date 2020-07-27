package com.iflytek.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author 叶清
 * @create 2020-07-13-16:30
 **/
public class DateUtils {

    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

        /** 标准日期格式：yyyy-MM-dd */
        public final String NORM_DATE_PATTERN = "yyyy-MM-dd";

        /** 国际标准日期格式：dd-MM-yyyy  */
        public final String NORM_I18N_DATE_PATTERN = "dd-MM-yyyy";

        /** 标准时间格式：HH:mm:ss */
        public final String NORM_TIME_PATTERN = "HH:mm:ss";

        /** 标准日期时间格式，精确到分：yyyy-MM-dd HH:mm */
        public final String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

        /** 标准日期时间格式，精确到秒：yyyy-MM-dd HH:mm:ss */
        public final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

        /** 国际标准时间格式， 精确到秒 dd/MM/yyy HH:mm:ss */
        public static final String NORM_I18N_DATETIME_FORMAT = "dd/MM/yyy HH:mm:ss";

        /** 标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS */
        public final String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

        /** 标准日期格式：yyyy年MM月dd日 */
        public final String CHINESE_DATE_PATTERN = "yyyy年MM月dd日";

        //-------------------------------------------------------------------------------------------------------------------------------- Pure
        /** 标准日期格式：yyyyMMdd */
        public final String PURE_DATE_PATTERN = "yyyyMMdd";

        /** 标准日期格式：HHmmss */
        public final String PURE_TIME_PATTERN = "HHmmss";

        /** 标准日期格式：yyyyMMddHHmmss */
        public final String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";

        /** 标准日期格式：yyyyMMddHHmmssSSS */
        public final String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";

        //-------------------------------------------------------------------------------------------------------------------------------- Others
        /** HTTP头中日期时间格式：EEE, dd MMM yyyy HH:mm:ss z */
        public final String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";

        /** JDK中日期时间格式：EEE MMM dd HH:mm:ss zzz yyyy */
        public final String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";

        /** UTC时间：yyyy-MM-dd'T'HH:mm:ss'Z' */
        public final String UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";


        /**
         * now
         *
         * @author fxbin
         * @return 当前时间
         */
        public Date now() {
            return parseLocalDateTime2Date(LocalDateTime.now());
        }


        /**
         * 获取两个日期之间相差天数
         *
         * @author fxbin
         * @param start 开始日期
         * @param end 结束日期
         * @return 天数
         */
        public long getDaysOfBetweenDate(String start, String end) {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            return ChronoUnit.DAYS.between(startDate, endDate);
        }


        /**
         * 获取两个日期之间相差天数
         *
         * @author fxbin
         * @param start 开始日期
         * @param end 结束日期
         * @return 天数
         */
        public long getDaysOfBetweenDate(Date start, Date end) {
            LocalDate startDate = parseDate2LocalDate(start);
            LocalDate endDate = parseDate2LocalDate(end);
            return ChronoUnit.DAYS.between(startDate, endDate);
        }


        /**
         * 是否为当天
         *
         * @author fxbin
         * @author fxbin
         * @param date 日期
         * @return true|false
         */
        public Boolean isToday(String date) {
            LocalDate localDate = LocalDate.parse(date);
            if(LocalDate.now().getYear() == localDate.getYear()) {
                MonthDay monthDay = MonthDay.from(localDate);
                MonthDay today = MonthDay.from(LocalDate.now());
                return monthDay.equals(today);
            }
            return false;
        }


        /**
         * 获取当前年月日
         *
         * @author fxbin
         * @author fxbin
         * @return 格式化之后的日期 yyyy-MM-dd
         */
        public String getCurDateOfNormDatePattern () {
            return getCurDateTime(NORM_DATE_PATTERN);
        }


        /**
         * 获取当前年月日时分秒
         *
         * @author fxbin
         * @return 格式化之后的日期 yyyy-MM-dd HH:mm:ss
         */
        public String getCurDateOfNormDateTimePattern () {
            return getCurDateTime(NORM_DATETIME_PATTERN);
        }


        /**
         * 获取当前日期，自定义格式
         *
         * @author fxbin
         * @param format 日期格式
         * @return 格式化之后的日期
         */
        public String getCurDateTime(String format){
            return parse(LocalDateTime.now(), format);
        }


        /**
         * 日期类型转换 默认 yyyy-MM-dd HH:mm:ss
         *
         * @author fxbin
         * @param date {@code Date}
         * @return 格式化之后的日期字符
         */
        public String parse(Date date) {
            return parse(parseDate2LocalDateTime(date), NORM_DATETIME_PATTERN);
        }


        /**
         * 日期类型转换
         *
         * @author fxbin
         * @param date {@code Date}
         * @param format 日期格式
         * @return 格式化之后的日期字符
         */
        public String parse(Date date, String format) {
            return parse(parseDate2LocalDateTime(date), format);
        }


        /**
         * 日期类型转换
         *
         * @author fxbin
         * @param localDateTime {@code LocalDateTime}
         * @param format 日期格式
         * @return 格式化之后的日期字符
         */
        public String parse(LocalDateTime localDateTime, String format) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return localDateTime.format(formatter);
        }


        /**
         * 日期类型转换
         *
         * @author fxbin
         * @param localDate {@code LocalDate}
         * @param format 日期格式
         * @return 格式化之后的日期字符
         */
        public String parse(LocalDate localDate, String format) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return localDate.format(formatter);
        }


        // ---------------------------------------------- 获取固定时间段内日期 LocalDateTime ----------------------------------------------------------------------------------


        /**
         * nanoseconds add
         *
         * @author fxbin
         * @param nanos nanoseconds
         * @return N nanoseconds {@code LocalDateTime#plusNanos(long)}
         */
        public LocalDateTime plusNanos (long nanos) {
            return LocalDateTime.now().plusNanos(nanos);
        }


        /**
         * N 秒之后
         *
         * @author fxbin
         * @param seconds 添加的秒数，可能为负
         * @return N 秒之后 {@code LocalDateTime}
         */
        public LocalDateTime plusSeconds(long seconds) {
            return LocalDateTime.now().plusSeconds(seconds);
        }


        /**
         * N 分钟之后
         *
         * @author fxbin
         * @param minutes 添加的分钟数, 可能为负
         * @return N 分钟之后 {@code LocalDateTime}
         */
        public LocalDateTime plusMinutes(long minutes) {
            return LocalDateTime.now().plusMinutes(minutes);
        }


        /**
         * N 小时之后
         *
         * @author fxbin
         * @param hours 添加的小时数, 可能为负
         * @return N 小时之后 {@code LocalDateTime}
         */
        public LocalDateTime plusHours(long hours) {
            return LocalDateTime.now().plusHours(hours);
        }


        /**
         * 获取当天起始时间  2019-09-23 00:00:00
         *
         * @author fxbin
         * @return {@code LocalDateTime}
         */
        public LocalDateTime getTodayStart () {
            return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        }

        // ---------------------------------------------- 获取固定时间段内日期 LocalDate ------------------------------------------------------------------------

        /**
         * 增加|减少天数
         *
         * @author fxbin
         * @param days 天数
         * @return {@link LocalDate}
         */
        public LocalDate plusDays(Integer days) {
            return LocalDate.now().plusDays(days);
        }


        /**
         * 昨天
         *
         * @author fxbin
         * @return 昨天
         */
        public LocalDate yesterday() {
            return LocalDate.now().plusDays(-1);
        }


        /**
         * 明天
         *
         * @author fxbin
         * @return 明天
         */
        public LocalDate tomorrow() {
            return LocalDate.now().plusDays(1);
        }


        /**
         * 上周
         *
         * @author fxbin
         * @return 上周
         */
        public LocalDate lastWeek() {
            return LocalDate.now().plusWeeks(-1);
        }


        /**
         * 下周
         *
         * @author fxbin
         * @return 下周
         */
        public LocalDate nextWeek() {
            return LocalDate.now().plusWeeks(1);
        }


        /**
         * 上个月
         *
         * @author fxbin
         * @return 上个月
         */
        public LocalDate lastMonth() {
            return LocalDate.now().plusMonths(-1);
        }


        /**
         * 下个月
         *
         * @author fxbin
         * @return 下个月
         */
        public LocalDate nextMonth() {
            return LocalDate.now().plusMonths(1);
        }


        /**
         * 获取上月最后一天
         *
         * @author fxbin
         * @return 上月最后一天日期{@code LocalDate}
         */
        public LocalDate lastDayOfLastMonth() {
            return lastDayOfMonth(-1);
        }


        /**
         * 获取当前月最后一天
         *
         * @author fxbin
         * @return 当前月最后一天日期{@code LocalDate}
         */
        public LocalDate lastDayOfThisMonth() {
            return lastDayOfMonth(0);
        }


        /**
         * 获取下月最后一天
         *
         * @author fxbin
         * @return 下月最后一天日期{@code LocalDate}
         */
        public LocalDate lastDayOfNextMonth() {
            return lastDayOfMonth(1);
        }


        /**
         * 获取上月第一天
         *
         * @author fxbin
         * @return 上月第一天日期{@code LocalDate}
         */
        public LocalDate firstDayOfLastMonth() {
            return firstDayOfMonth(-1);
        }


        /**
         * 获取传入日期 月份的第一天
         *
         * @author fxbin
         * @param date 日期
         * @return {@code LocalDate}
         */
        public LocalDate firstDayOfDateMonth(Date date) {
            LocalDate reqDate = parseDate2LocalDate(date);
            int year = reqDate.getYear();
            int month = reqDate.getMonthValue();
            return LocalDate.of(year, month, 1);
        }


        /**
         * 获取当前月第cc一天
         *
         * @author fxbin
         * @return 当前月第一天日期{@code LocalDate}
         */
        public LocalDate firstDayOfThisMonth() {
            return firstDayOfMonth(0);
        }


        /**
         * 获取下月第一天
         *
         * @author fxbin
         * @return 下月第一天日期{@code LocalDate}
         */
        public LocalDate firstDayOfNextMonth() {
            return LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        }


        /**
         * 本年度第一天
         *
         * @author fxbin
         * @return 本年度第一天
         */
        public LocalDate firstDayOfYear() {
            return firstDayOfYear(0);
        }


        /**
         * 获取某月月份第一天日期
         *
         * @author fxbin
         * @param monthsToAdd 添加的月份数, 可能为负
         * @return 基于{@code LocalDate} 添加得到的月份，不为null(a {@code LocalDate} based on this date with the months added, not null)
         */
        public LocalDate firstDayOfMonth(long monthsToAdd) {
            return LocalDate.now().plusMonths(monthsToAdd).with(TemporalAdjusters.firstDayOfMonth());
        }


        /**
         * 获取某月月份最后一天日期
         *
         * @author fxbin
         * @param monthsToAdd 添加的月份数, 可能为负
         * @return 基于{@code LocalDate} 添加得到的月份，不为null(a {@code LocalDate} based on this date with the months added, not null)
         */
        public LocalDate lastDayOfMonth(long monthsToAdd) {
            return LocalDate.now().plusMonths(monthsToAdd).with(TemporalAdjusters.lastDayOfMonth());
        }


        /**
         * 某年第一天
         *
         * @author fxbin
         * @param yearsToAdd 添加的年，可能为负
         * @return 某年第一天
         */
        public LocalDate firstDayOfYear(long yearsToAdd) {
            return LocalDate.now().plusYears(yearsToAdd).with(TemporalAdjusters.firstDayOfYear());
        }


        /**
         * 某年最后一天
         *
         * @author fxbin
         * @param yearsToAdd 添加的年，可能为负
         * @return 某年最后一天
         */
        public LocalDate lastDayOfYear(long yearsToAdd) {
            return LocalDate.now().plusYears(yearsToAdd).with(TemporalAdjusters.lastDayOfYear());
        }


        /**
         * 当前时间是否为闰年
         *
         * @author fxbin
         * @return 是否闰年
         */
        public boolean isLeapYear() {
            YearMonth yearMonth = YearMonth.from(LocalDate.now());
            return yearMonth.isLeapYear();
        }


        /**
         * Date -> LocalDate
         *
         * @author fxbin
         * @param date {@code Date}
         * @return {@code LocalDate}
         */
        public LocalDate parseDate2LocalDate(Date date) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            log.info("localDate by Instant: {}", localDate);
            return localDate;
        }


        /**
         * Date -> LocalDateTime
         *
         * @author fxbin
         * @param date {@code Date}
         * @return {@code LocalDateTime}
         */
        public LocalDateTime parseDate2LocalDateTime(Date date) {
            LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            log.info("localDateTime by Instant: {}", localDateTime);
            return localDateTime;
        }


        /**
         * Date -> LocalTime
         *
         * @author fxbin
         * @param date {@code Date}
         * @return {@code LocalTime}
         */
        public LocalTime parseDate2LocalTime(Date date) {
            LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            log.info("localTime by Instant: {}", localTime);
            return localTime;
        }


        /**
         * LocalDate -> Date
         *
         * @author fxbin
         * @param localDate {@code LocalDate}
         * @return {@code Date}
         */
        public Date parseLocalDate2Date(LocalDate localDate) {
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            log.info("LocalDate -> Date: {}", date);
            return date;
        }


        /**
         * LocalDateTime -> Date
         *
         * @author fxbin
         * @param localDateTime {@code LocalDateTime}
         * @return {@code Date}
         */
        public Date parseLocalDateTime2Date(LocalDateTime localDateTime) {
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            log.info("LocalDateTime -> Date: {}", date);
            return date;
        }
}
