package org.glassfish.jersey;

import hudson.model.UnprotectedRootAction;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

public class JerseyResource implements UnprotectedRootAction {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return "jersey";
    }

    public HttpResponse doEmployee(@QueryParameter String q) {
        String contentType;
        URL url;
        if ("json".equals(q)) {
            contentType = "application/json";
            url = getClass().getResource("1.json");
        } else {
            contentType = "text/xml";
            url = getClass().getResource("1.xml");
        }
        return new HttpResponse() {
            @Override
            public void generateResponse(StaplerRequest req, StaplerResponse rsp, Object node)
                    throws IOException, ServletException {
                rsp.setContentType(contentType + ";charset=UTF-8");
                rsp.serveFile(req, url, 0);
            }
        };
    }
}
