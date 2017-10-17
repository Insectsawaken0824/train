package temp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by zhao on 2017/10/15.
 * 将数据批量插入数据库
 */
public class BatchInsertBaseTrainData {

    public static final String url = "jdbc:mysql://127.0.0.1/train?useUnicode=true&characterEncoding=UTF-8";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "123456";

    public static Connection conn = null;
    public static PreparedStatement pst = null;

    public static void main(String[] args) throws Exception {
        Class.forName(name);
        conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(false);
        insertTrainDataToMysql("D:\\train\\Data.txt");
        pst.close();
        conn.close();
    }

    public static void insertTrainDataToMysql(String path) throws Exception{
        pst = conn.prepareStatement("INSERT INTO train.train_number_stations_info (train_number,sequence_number,stations_name,distance,total_distance,arrive_time,leave_time,runtime,total_runtime,other_day) VALUE (?,?,?,?,?,?,?,?,?,?)");
        List<String> list = FileUtils.readLines(new File(path));
        for (String line : list) {
            String[] split = line.split(",");
            //车次
            String trainNumb = split[1];
            //停靠站详情 -----start
            String[] stationInfos = split[0].split("@");
            //初始里程
            int dis = 0;
            //初始时间
            long runtime = 0l;
            //初始天数
            int day = 0;
            int hourinit = 0;
            for (String info : stationInfos) {
                String[] split1 = info.split("\\|");
                //序号
                int numb = Integer.parseInt(split1[0]);
                //名称
                String name = split1[1];
                //到站时间
                String arrTime = split1[2];
                int hour = Integer.parseInt(split1[2].split(":")[0]);
                //离开时间
                String leaveTime = split1[3];
                //行驶时间
                String time = split1[4];
                String[] tsplit = time.split(":");
                //小时
                long hourStamp = Long.parseLong(tsplit[0]) * 60 * 60 * 1000;
                //分钟
                long minStamp = Long.parseLong(tsplit[1]) * 60 * 1000;
                long timeStamp = hourStamp + minStamp;
                long thisTimeStamp = timeStamp - runtime;
                //行驶里程
                int distance;
                if ("-".equals(split1[5])) {
                    distance = 0;
                } else {
                    distance = Integer.parseInt(split1[5]);
                }
                int thisDistance = distance - dis;
                pst.setString(Integer.parseInt("1"),trainNumb);
                pst.setInt(Integer.parseInt("2"),numb);
                pst.setString(Integer.parseInt("3"),name);
                pst.setInt(Integer.parseInt("4"),thisDistance);
                pst.setInt(Integer.parseInt("5"),distance);
                dis = distance;
                pst.setString(Integer.parseInt("6"),arrTime);
                pst.setString(Integer.parseInt("7"),leaveTime);
                pst.setLong(Integer.parseInt("8"),thisTimeStamp);
                pst.setLong(Integer.parseInt("9"),timeStamp);
                runtime = timeStamp;
                if (hour < hourinit && thisTimeStamp <= 24 * 60 * 60 * 1000 ) {
                    day += 1;
                } else if (hour < hourinit && thisTimeStamp > 24 * 60 * 60 * 1000 && thisTimeStamp <= 48 * 60 * 60 * 1000) {
                    day += 2;
                }else if (hour > hourinit && thisTimeStamp > 24 * 60 * 60 * 1000 && thisTimeStamp <= 48 * 60 * 60 * 1000) {
                    day += 1;
                }else if (hour > hourinit && thisTimeStamp > 48 * 60 * 60 * 1000 && thisTimeStamp <= 72 * 60 * 60 * 1000) {
                    day += 2;
                }
                pst.setInt(Integer.parseInt("10"),day);
                pst.addBatch();
                hourinit = hour;
            }
            //停靠站详情 -----end
        }
        int[] ints = pst.executeBatch();
        for (int i : ints) {
            if (i != 1) {
                System.out.println(i);
            }
        }
        conn.commit();
    }


}
