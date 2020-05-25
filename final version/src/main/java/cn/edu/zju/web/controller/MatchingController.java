package cn.edu.zju.web.controller;

import cn.edu.zju.bean.DosingGuideline;
import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.bean.Sample;
import cn.edu.zju.bean.RefBean;
import cn.edu.zju.bean.GeneBean;
import cn.edu.zju.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
    @Autowired
    private AnnovarDao annovarDao;
    @Autowired
    private VepDao vepDao;

    public static List<DrugLabel> matchedDrugLabel;
    public static List<DosingGuideline> matchedGuidelines;

    @RequestMapping(path = "/matchingIndex")
    public ModelAndView matchingIndex() {
        ModelAndView a1 = new ModelAndView();
        a1.setViewName("matching_index"); //��λ��WEB-IN
        return a1;
    }


    @RequestMapping(path = "/samples")
    public ModelAndView samples() {
        log.info("samples");
        ModelAndView a1 = new ModelAndView();
        a1.setViewName("samples"); //WEB-INF view下的jsp
        List<Sample> samples = sampleDao.findAll();
        a1.addObject("samples", samples);
        return a1;
    }



    @RequestMapping(path = "/matching")
    public ModelAndView matching(@RequestParam("sampleId") String sampleIdParameter,@RequestParam("sampleType") String sampleType) {
        matchedDrugLabel=null;
        matchedGuidelines =null;
        log.info("matching");

        if (sampleIdParameter == null) {
            log.info("sample id is null");
            ModelAndView q = new ModelAndView();
            q.setViewName("samples");
            return q;
        }

        Integer sampleId = null;
        try {
            sampleId = Integer.valueOf(sampleIdParameter);
        } catch (NumberFormatException e) {
            log.error("trans failed,sampleIdParameter:{}",sampleIdParameter);
            log.error("e:",e);
            ModelAndView q = new ModelAndView();
            q.setViewName("samples");
            return q;
        }

        List<RefBean> refBeans;
        if (sampleType.equals("annovar")) {refBeans = annovarDao.getsampleGenes(sampleId);} else {
            if (sampleType.equals("vep")) {refBeans = vepDao.getsampleGenes(sampleId);} else {
                log.info("sample type is not correct.");
                return new ModelAndView("matching_index_error");
            }
        }
        if (refBeans.isEmpty()){
            log.info("reference gene is empty");
            ModelAndView a = new ModelAndView();
            a.setViewName("matching_index_error");
        }
//
//        List<String> refGenes = annovarDao.getRefGenes(sampleId);
//        if (refGenes.isEmpty()) {
//            ModelAndView q = new ModelAndView();
//            q.setViewName("samples");
//            log.info("refGene is empty");
//            return q;
//        }

        log.info("getdruglabels");
        List<DrugLabel> drugLabels = drugLabelDao.findAll();
        log.info("matchdruglabels");
        List<DrugLabel> matchedLabels = doMatchdrugLabel(refBeans, drugLabels);
        log.info("getdosingguidelines");
        List<DosingGuideline>dosingGuidelines=dosingGuidelineDao.findAll();
        log.info("matchdosingguiline");
        List<DosingGuideline> matchedGuidelines =doMatchGuideline(refBeans,dosingGuidelines);

//        log.info("getDruglabels");
//        List<DrugLabel> drugLabelBeans = drugLabelDao.getDrugLabel();
//        log.info("getGuidelines");
//        List<DosingGuideline> dosingGuidelineBeans = dosingGuidelineDao.getdosingGuidelines();




        ModelAndView q = new ModelAndView();
        q.addObject("matched", matchedLabels);
        q.addObject("matchedGuidelines",matchedGuidelines);
        q.addObject("sample", sampleDao.findById(sampleId));
        q.setViewName("matching_index_search");
        return q;


    }



    private List<DosingGuideline> doMatchGuideline(List<RefBean> refGenes, List<DosingGuideline>dosingGuidelines){
        List<DosingGuideline> matchedGuidelines = new ArrayList<>();
        for (DosingGuideline dosingGuideline : dosingGuidelines) {
            boolean matched = false;
            for (RefBean gene : refGenes) {
                String a =gene.getSym_gene();
                if (dosingGuideline.getSummaryMarkdown().contains(a)) {
                    matched = true;
                }
            }
            if (matched) {
                matchedGuidelines.add(dosingGuideline);
            }
        }
        return matchedGuidelines;
    }


    private List<DrugLabel> doMatchdrugLabel(List<RefBean> refGenes, List<DrugLabel> drugLabels) {
        List<DrugLabel> matchedLabels = new ArrayList<>();
        for (DrugLabel drugLabel : drugLabels) {
            boolean matched = false;
            for (RefBean gene : refGenes) {
                String a =gene.getSym_gene();
                if (drugLabel.getSummaryMarkdown().contains(a)) {
                    matched = true;
                }
            }
            if (matched) {
                matchedLabels.add(drugLabel);
            }
        }
        return matchedLabels;
    }

//在Spring MVC 中使用 @RequestMapping 来映射请求，也就是通过它来指定控制器可以处理哪些URL请求，相当于Servlet中在web.xml中配置

}











