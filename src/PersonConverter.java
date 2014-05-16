import org.apache.struts2.util.StrutsTypeConverter;
import java.util.Date;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Created by el1ven on 14-5-16.
 */
public class PersonConverter extends StrutsTypeConverter {
    //两种日期格式
    private static final String date1 = "yyyy-MM-dd";
    private static final String date2 = "yyyy-MM-dd HH:mm:ss";

    public Object convertFromString(Map context, String[] values, Class toClass){
        if(values == null || values.length == 0){
            return null;
        }

        //有时分秒的要先转换
        SimpleDateFormat sdf = new SimpleDateFormat(date2);

        Person p = new Person();

        String dateString = values[0];

        if(dateString != null){
            try{
                p.setBirthday(sdf.parse(dateString));

            }catch(ParseException e){
                p.setBirthday(null);

            }
            if(p.getBirthday() == null){
                sdf = new SimpleDateFormat(date1);
                try{
                    p.setBirthday(sdf.parse(dateString));
                }catch (ParseException e){
                    p.setBirthday(null);
                }
            }
        }

        return p;
    }


    public String convertToString(Map context, Object o) {
        if(o instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(date2);
            return sdf.format((Date)o);
        }
        return "";
    }



}
