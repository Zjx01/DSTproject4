package beanTest;

import cn.edu.zju.bean.Drug;
import org.junit.Assert;
import org.junit.Test;


public class DrugTest {
    Drug a = new Drug();
    @Test
    public void TestDrug(){
        a.setName("name");
        a.setId("id");
        a.setObjCls("objects");
        a.setDrugUrl("Url");
        a.setBiomarker(true);
        Assert.assertEquals("name",a.getName());
        Assert.assertEquals("id",a.getId());
        Assert.assertEquals("objects",a.getObjCls());
        Assert.assertEquals("Url",a.getDrugUrl());
        Assert.assertEquals(true,a.isBiomarker());
    }
}
