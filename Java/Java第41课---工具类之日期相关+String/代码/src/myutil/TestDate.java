package myutil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {

    public static void main(String[] args){
        //返回当前系统时间与计算机元年之间的毫秒差
        //1970-1-1  00:80:00
        long time = System.currentTimeMillis();
        System.out.println(time);
        //1545364985172
        //1545365000042
        //1545365012877
        Date date1 = new Date(1545364985172L);//15分钟之前的时间
        Date date2 = new Date();//默认就是用当前的系统时间构建的date对象
        System.out.println(date2);//重写了toString  格林威治格式Fri Dec 21 12:12:12 CST 2018

        boolean x = date1.before(date2);//date1是否在date2之前
        boolean y = date1.after(date2);//date1是否在date2之后

        //date对象中应该有一个long的属性 time
        date1.setTime(1545365012877L);//设置date1的时间 毫秒值
        long reTime= date1.getTime();//获取date1的时间 毫秒值
        System.out.println(x+"--"+y);
        System.out.println(date2.compareTo(date1));//按照顺序比较  -1调用在前参数在后  1刚好相反

        //2018-12-21 12:19:16
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String v = sdf.format(date1);//通过sdf对象将date1格式化成你描述的样子
        System.out.println(v);

        Calendar calendar = Calendar.getInstance();//系统当前时间的calendar对象
        //java.util.GregorianCalendar[name=value,name=value]
        System.out.println(calendar);
        calendar.set(Calendar.YEAR,2015);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);//从0开始数
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"--"+month+"--"+day);

        TimeZone tz = calendar.getTimeZone();
        //TimeZone tz = TimeZone.getDefault();
        System.out.println(tz);
        System.out.println(tz.getID());
        System.out.println(tz.getDisplayName());

    }

}
