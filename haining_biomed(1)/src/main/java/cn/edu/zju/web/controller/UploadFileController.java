package cn.edu.zju.web.controller;

import cn.edu.zju.dao.AnnovarDao;
import cn.edu.zju.dao.SampleDao;
import cn.edu.zju.dao.VepDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@Controller
public class UploadFileController {

        @Autowired
        private SampleDao sampleDao;
        @Autowired
        private AnnovarDao annovarDao;
        @Autowired
        private VepDao vepDao;
        private static final Logger log = LoggerFactory
                .getLogger(UploadFileController.class);


        @RequestMapping(value = "/upload/{uploadType}", method = RequestMethod.POST)
        public String upload(
                @RequestParam("requestPart") MultipartFile requestPart,
                @PathVariable String uploadType,
                HttpServletRequest request)
                throws IOException {
                ModelAndView q = new ModelAndView();
                log.info("upload vcf");

                String uploadedBy = request.getParameter("uploaded_by");
                if (uploadedBy == null || uploadedBy.isEmpty()) {
                        log.info("is empty");
                        request.setAttribute("validateError", "Uploaded by can not be bkan");
                        return "matching_index_error";
                        /*q.addObject("validateError",
                                "Uploaded by can not be blank");
                        q.setViewName("matching_index_error");
                        return q;*/
                }

                if (requestPart == null) {
                        request.setAttribute("validateError", "vcf output file can not be blank");
                        return "matching_index_error";
                }
//                Part requestPart = request.getPart("vcf");
//                if (requestPart == null) {
//                        q.addObject("validateError",
//                                "Uploaded by can not be blank");
//                        q.setViewName("matching_index_error");
//                        return q;
//                }

                InputStream inputStream = new BufferedInputStream(requestPart.getInputStream());

                byte[] bytes = inputStream.readAllBytes();

                String content = new String(bytes);

                if (uploadType.equals("annovar")) {
                        int sampleId = sampleDao.save(uploadedBy, "annovar");
                        log.info(sampleId + "  upload sample id");
                        annovarDao.save(sampleId, content);
                        log.info("read file " + content.length());
                        return "redirect:/matching?sampleId=" + sampleId + "&sampleType=annovar";
                } else {
                        if (uploadType.equals("vep")) {
                                int sampleId = sampleDao.save(uploadedBy, "vep");
                                vepDao.save(sampleId, content);
                                log.info("read file " + content.length());
                                return "redirect:/matching?sampleId=" + sampleId + "&sampleType=vep";
                        } else {
                                log.info("wrong type of input");
                                return "matching_index_error";
                        }


                }

        }
}
//
//
//                int sampleId = sampleDao.save(uploadedBy, uploadedBy);
//                log.info(sampleId + "  upload sample id");
//                annovarDao.save(sampleId, content);
//                return new ModelAndView("redirect:" + request.getContextPath()
//                        + "/matching?sampleId=" + sampleId);
//
//        }

