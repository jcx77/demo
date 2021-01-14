package LambdaTest;


import Model.Data;
import org.junit.Test;
import util.UUIDHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Optionals {
    @Test
    public void test(){
        //UUIDHelper.get32UUID();
        Optional.ofNullable(new Data().getList()).orElse(new ArrayList<>());
    }
}
