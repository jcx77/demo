package read;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    @Test
    public void test() {
        URL url=null;
        HttpURLConnection urlConnection=null;
        InputStream is =null;
        FileOutputStream fos=null;
        try{
            url= new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            urlConnection =(HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("baidu.png");
            byte [] b=new byte[1024];
            int le;
            while ((le=is.read(b))!=-1){
                fos.write(b,0,le);
            }
        }catch (Exception e){

        }finally {
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            urlConnection.disconnect();
        }

    }
}
