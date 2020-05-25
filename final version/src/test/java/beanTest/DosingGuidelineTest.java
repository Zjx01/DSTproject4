package beanTest;


import cn.edu.zju.bean.DosingGuideline;
import org.junit.Assert;
import org.junit.Test;


public class DosingGuidelineTest {
    DosingGuideline a = new DosingGuideline("1","aa","name",true,"DrugID","Source","markdown","markdown","Raw");
    @Test
    public void TestDosingGuideline(){
        a.setObjCls("set");
        a.setDrugId("set");
        a.setId("set");
        a.setName("set");
        a.setRaw("set");
        a.setRecommendation(false);
        a.setSource("set");
        a.setSummaryMarkdown("set");
        a.setTextMarkdown("set");
        Assert.assertEquals("set",a.getDrugId());
        Assert.assertEquals("set",a.getId());
        Assert.assertEquals("set",a.getObjCls());
        Assert.assertEquals("set",a.getName());
        Assert.assertEquals(false,a.isRecommendation());
    }
}
