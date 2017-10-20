package temp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/10/20.
 */
public class Arrange {
    public static void main(String[] args) throws IOException {
        List<String> list = FileUtils.readLines(new File("F:\\train\\Data\\test\\stations_city.txt"));
        ArrayList<Object> out = new ArrayList<>();
        ArrayList<Object> error = new ArrayList<>();
        for (String line : list) {
            boolean flag = true;
            String[] split = line.split("\t");
            for (String str : split) {
                if (str.trim().length() > 5 || str.trim().equals("县市") || str.trim().equals("（市") || str.trim().equals("区市")
                        || str.trim().equals("历市") || str.trim().equals("下辖市")
                        || str.trim().equals("两市")|| str.trim().equals("设市") || str.trim().equals("渡市")|| str.trim().equals("新市")
                        || str.trim().equals("市市")|| str.trim().contains("森林城市")|| str.trim().contains("地级市")) {
                    error.add(split[split.length - 1]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                line = split[0].trim().replace("在","").replace("中国","") +"\t" + split[1].trim() +"\t" + split[2].trim() +"\t" + split[3].trim();
                out.add(line);
            }
        }
        FileUtils.writeLines(new File("F:\\train\\Data\\test\\stations_city.txt"),out,false);
        FileUtils.writeLines(new File("F:\\train\\Data\\test\\stations_wait.txt"),error,true);
    }
}
