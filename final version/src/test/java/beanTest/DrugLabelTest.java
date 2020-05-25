package beanTest;

import cn.edu.zju.bean.DrugLabel;
import org.junit.Assert;
import org.junit.Test;

public class DrugLabelTest {
    DrugLabel a = new DrugLabel();
    @Test
    public void TestDrugLabel(){
        a.setAlternateDrugAvailable(true);
        a.setDosingInformation(true);
        a.setDrugId("ID");
        a.setId("id");
        a.setName("name");
        a.setObjCls("objcls");
        a.setPrescribingMarkdown("MD");
        a.setRaw("raw");
        a.setSource("source");
        a.setSummaryMarkdown("MD");
        a.setTextMarkdown("MD");
        Assert.assertEquals(true,a.isAlternateDrugAvailable());
        Assert.assertEquals(true,a.isDosingInformation());
        Assert.assertEquals("ID",a.getDrugId());
        Assert.assertEquals("id",a.getId());
        Assert.assertEquals("name",a.getName());
        Assert.assertEquals("objcls",a.getObjCls());
        Assert.assertEquals("MD",a.getPrescribingMarkdown());
        Assert.assertEquals("raw",a.getRaw());
        Assert.assertEquals("source",a.getSource());
        Assert.assertEquals("MD",a.getSummaryMarkdown());
        Assert.assertEquals("MD",a.getTextMarkdown());
    }
}
