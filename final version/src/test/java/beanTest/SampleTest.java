package beanTest;

import cn.edu.zju.bean.Sample;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleTest {
    Sample a = new Sample();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse("2020-05-01");
    public SampleTest() throws ParseException {
    }

    @Test
    public void TestSample(){
        a.setCreatedAt(date);
        a.setId(12345);
        a.setUploadedBy("me");
        Assert.assertEquals(date,a.getCreatedAt());
        Assert.assertEquals(12345,a.getId());
        Assert.assertEquals("me",a.getUploadedBy());
    }
}
