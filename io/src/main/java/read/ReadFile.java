package read;

import org.junit.Test;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        //System.out.println("程序运行时间： "+);
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            long startTime = System.currentTimeMillis();   //获取开始时间
//            long endTime = System.currentTimeMillis(); //获取结束时间
//            System.out.print(i + ":" + (endTime - startTime) + "ms");
//        }
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void read() {
        try {
            File f1 = new File("1a-1/mat_thumb.jpg");

            for (int i = 0; i < 1998; i++) {
                BufferedInputStream bi = new BufferedInputStream(new FileInputStream(f1));

                BufferedOutputStream bo = null;
                try {
                    File f2 = new File("1a-1/mat_thumb" + i + ".jpg");
                    bo = new BufferedOutputStream(new FileOutputStream(f2));
                    byte[] bytes = new byte[1024];
                    while (-1 != bi.read(bytes)) {
                        bo.write(bytes);
                    }
                    bo.flush();
                    //bo.
                } finally {
                    if (bo != null) {
                        bo.close();
                        //bi.close();
                    }
                }


            }
        } catch (Exception ignored) {

        }


    }

    /**
     * @Description: TODO(对象流)
     * @Param: []
     * @return: void
     * @Author: zcx
     * @Date: 2020/12/29 14:11
     */
    @Test
    public void objectWrite() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ob.bat"));
        oos.writeObject(new User("戏赠陈季张",new B(1)));
        oos.flush();
        oos.close();


    }

    @Test
    public void objectRead() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ob.bat"));
        User o = (User) ois.readObject();
        System.out.println(o);
    }
}
