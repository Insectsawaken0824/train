import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhao on 2017/10/13.
 */
public class a {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Date parse = simpleDateFormat.parse("2017-10-16 08:10:10");
        System.out.println(parse.getTime());
    }
}
