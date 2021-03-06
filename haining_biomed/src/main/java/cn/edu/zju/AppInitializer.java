package cn.edu.zju;
 
import cn.edu.zju.business.BusinessConfig;
import cn.edu.zju.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
/**
 * Created by Shower on 2017/4/1 0001.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { BusinessConfig.class};
    }
 
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class};
    }
 
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }}
