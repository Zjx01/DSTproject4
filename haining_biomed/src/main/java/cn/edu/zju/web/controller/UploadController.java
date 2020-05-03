package cn.edu.zju.web.controller;

import cn.edu.zju.dao.AnnovarDao;
import cn.edu.zju.dao.SampleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/upload")
@MultipartConfig
public class UploadController extends HttpServlet {

    @Autowired
    private SampleDao sampleDao;

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("upload vcf");

        String uploadedBy = request.getParameter("uploaded_by");
        if (uploadedBy == null || uploadedBy.isEmpty()) {
            log.info("is empty");
            request.setAttribute("validateError", "Uploaded by can not be blank");
            request.getRequestDispatcher("/view/matching_index_error.jsp").forward(request, response);
            return;
        }

        Part requestPart = request.getPart("vcf");
        if (requestPart == null) {
            request.setAttribute("validateError", "vcf output file can not be blank");
            request.getRequestDispatcher("/view/matching_index_error.jsp").forward(request, response);
            return;
        }

        InputStream inputStream = ((Part) requestPart).getInputStream();

        byte[] bytes =  inputStream.readAllBytes();


        String content = new String(bytes);


        int sampleId = sampleDao.save(uploadedBy);
        log.info(sampleId+"  upload sample id");
        AnnovarDao.save(sampleId, content);
        response.sendRedirect("matching?sampleId=" + sampleId);
        log.info("read file "+content.length());
    }

}