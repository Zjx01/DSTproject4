package cn.edu.zju.cmd;

import cn.edu.zju.bean.DosingGuideline;
import cn.edu.zju.bean.Drug;
import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.dao.DosingGuidelineDao;
import cn.edu.zju.dao.DrugDao;
import cn.edu.zju.dao.DrugLabelDao;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PharmGKBImporter {

    private static final Logger log = LoggerFactory.getLogger(PharmGKBImporter.class);

    public static void main(String[] args) {
        PharmGKBImporter pharmGKBImporter = new PharmGKBImporter();
        pharmGKBImporter.importDosingGuideline();
        pharmGKBImporter.importDrug();
        pharmGKBImporter.importDrugLabel();
    }

    private void importDosingGuideline() {
        Gson gson = new Gson();
        InputStream is = getClass().getResourceAsStream("/dosingGuideline.data");
        List<String> drugLabelsContent =
                new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(toList());
        DosingGuidelineDao dosingGuidelineDao = new DosingGuidelineDao();

        drugLabelsContent.forEach(content -> {
            Map guideline = gson.fromJson(content, Map.class);
            Map data = ((Map) guideline.get("data"));
            String id = (String) data.get("id");
            String objCls = (String) data.get("objCls");
            String name = (String) data.get("name");
            boolean recommendation = (Boolean) data.get("recommendation");
            String drugId = ((String) ((List<Map>) data.get("relatedChemicals")).get(0).get("id"));
            String source = (String) data.get("source");
            String summaryMarkdown = ((String) ((Map) data.get("summaryMarkdown")).get("html"));
            String textMarkdown = ((String) ((Map) data.get("textMarkdown")).get("html"));
            String raw = gson.toJson(guideline);
            DosingGuideline dosingGuideline = new DosingGuideline(id, objCls, name, recommendation, drugId, source, summaryMarkdown, textMarkdown, raw);
            if (!dosingGuidelineDao.existsById(id)) {
                dosingGuidelineDao.saveDosingGuideline(dosingGuideline);
                log.info("Saving dosing guideline: {}", id);
            } else {
                log.info("Dosing guideline exists, skipping: {}", id);
            }
        });
    }

    private void importDrug() {
        Gson gson = new Gson();
        InputStream is = getClass().getResourceAsStream("/drugs.data");
        String drugsContent =
                new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().parallel().collect(
                        Collectors.joining("\n"));

        Map drugs = gson.fromJson(drugsContent, Map.class);
        List<Map> drugList = (List<Map>) drugs.get("data");

        DrugDao drugDao = new DrugDao();

        drugList.stream().forEach(x -> {
            log.info("{}", x);
            Map drug = ((Map) x.get("drug"));
            String id = (String) drug.get("id");
            String name = (String) drug.get("name");
            String objCls = (String) drug.get("objCls");
            String drugUrl = (String) x.get("drugUrl");
            boolean biomarker = ((Boolean) x.get("biomarker"));
            Drug drugBean = new Drug(id, name, biomarker, drugUrl, objCls);

            drugDao.saveDrug(drugBean);
        });
    }

    private void importDrugLabel() {
        Gson gson = new Gson();
        InputStream is = getClass().getResourceAsStream("/drugLabels.data");
        List<String> drugLabelsContent =
                new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(toList());


        DrugLabelDao drugLabelDao = new DrugLabelDao();

        drugLabelsContent.stream().forEach(line -> {
            Map x = gson.fromJson(line, Map.class);
            log.info("Going to save label: {}", (String) x.get("id"));
            String labelId = (String) x.get("id");
            String name = (String) x.get("id");
            String objCls = (String) x.get("objCls");
            boolean alternateDrugAvailable = (Boolean) x.get("alternateDrugAvailable");
            boolean dosingInformation = (Boolean) x.get("dosingInformation");
            String prescribingMarkdown = "";
            if (x.containsKey("prescribingMarkdown")) {
                prescribingMarkdown = ((String) ((Map) x.get("prescribingMarkdown")).get("html"));
            }
            String source = (String) x.get("source");
            String textMarkdown = ((String) ((Map) x.get("textMarkdown")).get("html"));
            String summaryMarkdown = ((String) ((Map) x.get("summaryMarkdown")).get("html"));
            String raw = gson.toJson(x);
            String drugId = ((String) ((List<Map>) x.get("relatedChemicals")).get(0).get("id"));
            DrugLabel drugLabelBean = new DrugLabel(labelId, name, objCls, alternateDrugAvailable, dosingInformation
                    , prescribingMarkdown, source, textMarkdown, summaryMarkdown, raw, drugId);
            if (!drugLabelDao.existsById(labelId)) {
                drugLabelDao.saveDrugLabel(drugLabelBean);
                log.info("Saved: {}", labelId);
            } else {
                log.info("Label {} already exist, skip", labelId);
            }
        });
    }
}
