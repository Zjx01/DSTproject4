package cn.edu.zju.web.controller;

import cn.edu.zju.bean.DosingGuideline;
import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.bean.Sample;
import cn.edu.zju.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//log.info这个应该用来反馈系统的当前状态给最终用户的，所以，在这里输出的信息，应该对最终用户具有实际意义，也就是最终用户要能够看得明白是什么意思才行
@Controller
public class MatchingController {
    private static final Logger log = LoggerFactory.getLogger(MatchingController.class);

    @Autowired
    private DosingGuidelineDao dosingGuidelineDao;
    @Autowired
    private DrugLabelDao drugLabelDao;
    @Autowired
    private SampleDao sampleDao;
    @Autowired
    private DrugDao drugDao;


    public static ModelAndView a = new ModelAndView();
    public static List<DrugLabel> matchedDrugLabel;
    public static List<DosingGuideline> matchedGuidelines;
    public static List<AnnovarDao> annovarDaos;

    @RequestMapping(path = "/matchingIndex")

    public String matchingIndex() {
        log.info("matchingindex");
        return matchingIndex();
    }

    @RequestMapping(path =  "/samples")

    public ModelAndView samples() {
        log.info("samples");
        ModelAndView a1 = new ModelAndView();
        a1.setViewName("samples"); //定位到WEB-INF内的jsp
        List<Sample> samples = sampleDao.findAll();
        a1.addObject("samples", samples);
        return a1;
    }

    //setViewName()方法是ModelAndView类的方法，含义是设置View的名字（名字是String类），这个方法的参数有如下三种常见形式
    @RequestMapping(path = "/matching")
    public ModelAndView matching(@RequestParam("sampleId") String sampleIdParameter) {
        //set in jsp
        matchedDrugLabel = null;
        matchedGuidelines = null;
        log.info("matching");

        a.setViewName("matching_index_search");

        log.info(sampleIdParameter+"=sampleparameter");

        if (sampleIdParameter == null){
            log.info("sample id is null");
            ModelAndView q = new ModelAndView();
            q.setViewName("samples");
            return q;
    }
         Integer sampleId = null;
        try {
            sampleId = Integer.valueOf(sampleIdParameter);
        } catch (NumberFormatException e) {
            log.info(String.valueOf(e));
            ModelAndView q=new ModelAndView();
            q.setViewName("samples");
            return q;
        }

        List<String> refGenes = annovarDaos.getRefGenes(sampleId);


    }
}







