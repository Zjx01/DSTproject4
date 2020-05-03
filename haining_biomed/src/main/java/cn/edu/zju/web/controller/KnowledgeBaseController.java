package cn.edu.zju.web.controller;

import cn.edu.zju.bean.DosingGuideline;
import cn.edu.zju.bean.Drug;
import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.dao.DosingGuidelineDao;
import cn.edu.zju.dao.DrugDao;
import cn.edu.zju.dao.DrugLabelDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class KnowledgeBaseController {
    private static final Logger log = LoggerFactory.getLogger(KnowledgeBaseController.class);

    @Autowired//Spring 注解与自动配置：所有在spring中注入的bean 都建议定义成私有的域变量
    private DrugDao drugDao;
    @Autowired
    private DrugLabelDao drugLabelDao;
    @Autowired
    private DosingGuidelineDao dosingGuidelineDao;

    @RequestMapping("/drugs")
    public ModelAndView drugs() {
        ModelAndView drug = new ModelAndView();
        drug.setViewName("drugs");
        List<Drug> drugs = drugDao.findAll();
        drug.addObject("drugs", drugs);
        return drug;
    }


    @RequestMapping("/drugLabels")
    public ModelAndView drugLabels(){
        ModelAndView d=new ModelAndView();
        d.setViewName("drug_labels");
        List<DrugLabel> drugLabel = drugLabelDao.findAll();
        d.addObject("drugLabels", drugLabel);
        return d;
    }

    @RequestMapping("/dosingGuideline")
    public ModelAndView dosingGuideline(){
        ModelAndView d=new ModelAndView();
        d.setViewName("dosing_guideline");
        List<DosingGuideline> dosingGuidelines = dosingGuidelineDao.findAll();;
        d.addObject("dosingGuidelines", dosingGuidelines);
        return d;
    }
}

