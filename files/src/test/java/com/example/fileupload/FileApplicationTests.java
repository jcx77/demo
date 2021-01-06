package com.example.fileupload;


import org.junit.jupiter.api.Test;
import util.UUIDHelper;


class FileApplicationTests {

    @Test
    void read() {

    }
    @Test
    public void test(){
        String uuid = UUIDHelper.get32UUID();
        System.out.println(uuid);
    }

}
