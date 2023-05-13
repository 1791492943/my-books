
import com.feign_api.utils.ChineseNumToArabicNumUtil;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Txt {
    private static String name = "御兽开局之火眼金睛";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\my-books\\" + name + ".txt"));
        String s = "";
        BufferedWriter bw = null;
        boolean bool = false;
        int chapter = 0; //文件名称 不带后缀
        while (true){

            //章节开始
            if (s.contains("             第")){
                Pattern p = Pattern.compile("第.+章");
                Matcher m = p.matcher(s);

                while(m.find()){
                    //把章节的中文数字转换成阿拉伯数字
                    chapter = ChineseNumToArabicNumUtil.chineseNumToArabicNum(m.group().substring(1, m.group().length() - 1));
                    new File("E:\\my-books\\" + name + "\\" + chapter + ".txt").createNewFile();
                    File file = new File("E:\\my-books\\"+ name +"\\" + chapter + ".txt");
                    bw  = new BufferedWriter(new FileWriter(file));
                }
                bool = true;
            }

            if(bool && bw!=null){
                bw.write(s);
                bw.write("\r\n");
            }

            //章节结束
            if(s.endsWith("*")){
                bool = false;
                bw.close();
            }
            if((s = br.readLine()) == null){
                bw.close();
                break;
            }
        }
        br.close();
    }
}
