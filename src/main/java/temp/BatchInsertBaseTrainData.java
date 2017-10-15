package temp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * Created by zhao on 2017/10/15.
 * 将数据批量插入数据库
 */
public class BatchInsertBaseTrainData {
    public static void main(String[] args) {

    }

    public static void insertTrainDataToMysql(String path) throws Exception{
        List<String> list = FileUtils.readLines(new File(path));
        for (String line : list) {
            String[] split = line.split(",");
            //停靠站详情
            String stationInfo = split[0];
            String trainNumb = split[1];

        }
    }


}
