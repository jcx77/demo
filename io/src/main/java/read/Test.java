package read;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress a=InetAddress.getAllByName("www.baidu.com")[0];
        System.out.println(a);
    }

}
