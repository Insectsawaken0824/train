package temp;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.*;

/**
 * Created by zhao on 2017/10/20.
 */
public class Station {
    public static void main(String[] args) throws Exception {
        String url = "https://baike.baidu.com/item/";
        List<String> list = FileUtils.readLines(new File("F:\\train\\Data\\test\\stations_wait.txt"));
        List<String> list_city = FileUtils.readLines(new File("F:\\train\\Data\\city.txt"));

        HashMap<String, String> city_pro = new HashMap<>();

        HashMap<String, HashMap<String,Set<String>>> addr_map = new HashMap<>();
        for (String addr : list_city) {
            String[] add = addr.split("\t");
            city_pro.put(add[1], add[0]);
            HashMap<String,Set<String>> amap = addr_map.containsKey(add[0]) ? addr_map.get(add[0]) : new HashMap<String,Set<String>>();
            Set<String> strings = amap.containsKey(add[1]) ? amap.get(add[1]) : new HashSet<String>();
            if (add.length == 2) {
                amap.put(add[1], null);
                System.out.println(addr);
                continue;
            }
            strings.add(add[2]);
            amap.put(add[1], strings);
            addr_map.put(add[0], amap);
        }

        ArrayList<Object> out = new ArrayList<>();
        ArrayList<Object> error = new ArrayList<>();
        for (String station : list) {
            String province = "未知";
            String city = "未知";
            String county = "未知";
            Document document = null;
            try {
                document = Jsoup.connect(url + station + "站").ignoreContentType(true).timeout(1000000).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (document == null) {
                continue;
            }
            Elements elements = document.select("div");
            ArrayList<String> strings = new ArrayList<>();
            for (int i =0 ; i<elements.size(); i++) {
                Element element = elements.get(i);
                String text = element.text();
                if (text.contains("省")) {
                    StringTokenizer st = new StringTokenizer(text, "省市县", true);
                    if (text.contains("市") && text.contains("县")) {
                        while (st.hasMoreTokens()) {
                            String string = st.nextToken();
                            strings.add(string);
                        }
                        for (int j = 0; j < strings.size(); j++) {
                            if ("省".equals(strings.get(j))) {
                                province = strings.get(j - 1);
                            }
                            if ("市".equals(strings.get(j))) {
                                city = strings.get(j - 1);
                            }
                            if ("县".equals(strings.get(j))) {
                                county = strings.get(j - 1);
                            }
                        }
                        strings.clear();
                    }
                    if (!text.contains("市") && text.contains("县")) {
//                        while (st.hasMoreTokens()) {
//                            String string = st.nextToken();
//                            strings.add(string);
//                        }
//                        for (int j = 0; j < strings.size(); j++) {
//                            if ("省".equals(strings.get(j))) {
//                                province = strings.get(j - 1);
//                            }
//                            if ("市".equals(strings.get(j))) {
//                                city = strings.get(j - 1);
//                            }
//                            if ("县".equals(strings.get(j))) {
//                                county = strings.get(j - 1);
//                            }
//                        }
//                        strings.clear();
//                        Document document1 = null;
//                        try {
//                            document1 = Jsoup.connect(url + county).ignoreContentType(true).timeout(1000000).get();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        if (document1 == null) {
//                            continue;
//                        }
//                        Elements dd = document1.select("dd");
//                        for (int j =0 ; j<dd.size(); j++) {
//                            Element element1 = dd.get(j);
//                            String text1 = element1.text();
//                            if (text1.contains("市") && text1.contains("省")) {
//                                StringTokenizer st1 = new StringTokenizer(text1, "省市县", true);
//                                while (st1.hasMoreTokens()) {
//                                    String string = st1.nextToken();
//                                    strings.add(string);
//                                }
//                                for (int x = 0; x < strings.size(); x++) {
//                                    if ("市".equals(strings.get(x))) {
//                                        city = strings.get(x - 1);
//                                    }
//                                }
//                            }
//                        }
//                        strings.clear();
                    }
                    if (text.contains("市") && !text.contains("县")) {

                    }
                } else {
//                    StringTokenizer st = new StringTokenizer(text, "市县", true);
//                    if (text.contains("市") && text.contains("县")) {
//                        while (st.hasMoreTokens()) {
//                            String string = st.nextToken();
//                            strings.add(string);
//                        }
//                        for (int j = 0; j < strings.size(); j++) {
//                            if ("市".equals(strings.get(j))) {
//                                city = strings.get(j - 1);
//                            }
//                            if ("县".equals(strings.get(j))) {
//                                county = strings.get(j - 1);
//                            }
//                        }
//                        strings.clear();
//                    }

                }
            }
            county += "县";
            city += "市";
            if (city_pro.containsKey(city)) {
                province = city_pro.get(city);
            }
            System.out.println(province + "\t" + city + "\t" + county);
            boolean flag1 = !"未知".equals(province) && !"未知市".equals(city) && !"未知县".equals(county);
            boolean flag2 = province.trim().length() < 6 && city.trim().length() < 6 && county.trim().length() < 6;
            if (flag1 && flag2) {
                out.add(province + "\t" + city + "\t" + county + "\t" + station);
            } else {
                error.add(station);
            }
        }
        FileUtils.writeLines(new File("F:\\train\\Data\\test\\stations_city.txt"),out,true);
        FileUtils.writeLines(new File("F:\\train\\Data\\test\\stations_wait.txt"),error,false);
    }
}
