package temp;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/10/11.
 */
public class Train {
    public static void main(String[] args) throws Exception {
        String url = "http://qq.ip138.com";
        //请求火车票根页面
        Document document = Jsoup.connect(url+"/train/").ignoreContentType(true).timeout(1000000).get();
        //拿到a标签
        Elements elements = document.select("a");
        for (int i =0 ; i<elements.size(); i++) {
            Element element = elements.get(i);
            String href = element.attr("href");
            if (!href.contains("/train/")) {
                continue;
            }
            String trim = href.replace("/train/", "").trim();
            if (trim.length() < 1) {
                continue;
            }
            //拿到每个省的数据
            getProvince(href, url);
        }
    }

    public static void getProvince(String url,String rootUrl) throws IOException, InterruptedException {
        Document document = Jsoup.connect(rootUrl+url).ignoreContentType(true).timeout(1000000).get();
        Elements elements = document.select("a");
        for (int i =0 ; i<elements.size(); i++) {
            Element element = elements.get(i);
            String href = element.attr("href");
            if (!href.contains("/train/")) {
                continue;
            }
            String[] split = href.split("/");
            if (split.length != 4) {
                continue;
            }
            listInfo(href, rootUrl);
            Thread.sleep(1000);
        }
    }

    public static void listInfo(String url,String rootUrl) throws IOException {
        List<String> list = new ArrayList<>();
        Document document = Jsoup.connect(rootUrl+url).ignoreContentType(true).timeout(1000000).get();
        Elements elements = document.select("tr");
        for (int i =0 ; i<elements.size(); i++) {
            Element tr = elements.get(i);
            Elements td = tr.select("td");
            if (td.size() != 9) {
                continue;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int j =0 ; j<td.size(); j++) {
                Element t = td.get(j);
                Elements as = t.select("a");
                if (j == 0 && as.size() == 0) {
                    break;
                }
                if (as.size() != 0) {
                    Element a = as.get(0);
                    String href = a.attr("href");
                    addInfoToBuffer(stringBuffer, rootUrl + href);
                }
                if (j == td.size() - 1) {
                    stringBuffer.append(t.text());
                    break;
                }
                stringBuffer.append(t.text() + ",");
            }
            list.add(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
        }
        FileUtils.writeLines(new File("F:\\train\\test.txt"), list, true);
    }

    public static void addInfoToBuffer(StringBuffer stringBuffer, String url) throws IOException {
        Document document = Jsoup.connect(url).ignoreContentType(true).timeout(1000000).get();
        Elements trs = document.select("tr");
        for (int i =0; i<trs.size();i++) {
            Element tr = trs.get(i);
            Elements tds = tr.select("td");
            if (tds.size() != 7) {
                continue;
            }
            for (int j = 0;j<tds.size()-1;j++) {
                Element element = tds.get(j);
                String text = element.text();
                if (j == tds.size() - 2) {
                    stringBuffer.append(text);
                    break;
                }
                stringBuffer.append(text + "|");
            }
            stringBuffer.append("@");
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        stringBuffer.append(",");
    }
}
