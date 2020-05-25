package DaoTest;

import cn.edu.zju.bean.DosingGuideline;
import cn.edu.zju.bean.Drug;
import cn.edu.zju.bean.User;
import cn.edu.zju.dao.DosingGuidelineDao;
import cn.edu.zju.dao.DrugDao;
import cn.edu.zju.dao.UserDao;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoTest extends TestCase {
    @Before
    public void setup(){
    }
    @Test
    public void testDrugDao(){
        DrugDao a = new DrugDao();
        Drug b = new Drug("12345","2",true,"3","4");
        Assert.assertFalse(a.existsById(b.getId()));
        a.saveDrug(b);
        Assert.assertTrue(a.existsById(b.getId()));
        a.deleteByName(b.getName());
    }
    @Test
    public void testDosingGuidelineDao(){
        DosingGuidelineDao a = new DosingGuidelineDao();
        DosingGuideline b = new DosingGuideline("1","2","3",true,"5","6","7","8","9");
        Assert.assertFalse(a.existsById(b.getId()));
        a.saveDosingGuideline(b);
        Assert.assertTrue(a.existsById(b.getId()));
        a.deleteByName(b.getName());
    }
    @Test
    public void testUserDao(){
        UserDao a = new UserDao();
        User b = new User(1678,"myman","pass","email","911");
        Assert.assertFalse(a.existsByuserId(b.getId()));
        User c = new User("name","nopass");
        User d = new User("myman","nopass");
        User e = new User("myman","pass");
        a.registration(b);
        Assert.assertFalse(a.Search(c)[0]);
        Assert.assertFalse(a.Search(c)[1]);
        Assert.assertTrue(a.Search(d)[0]);
        Assert.assertFalse(a.Search(d)[1]);
        Assert.assertTrue(a.Search(e)[0]);
        Assert.assertTrue(a.Search(e)[1]);
        a.deleteByName("myman");


    }


}
