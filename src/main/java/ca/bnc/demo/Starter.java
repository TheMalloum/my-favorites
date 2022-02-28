package ca.bnc.demo;

import ca.bnc.demo.api.DemoApplication;
import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.MimeMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import java.util.ArrayList;
import java.util.Collection;


public class Starter {

    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info(" ***************** Lancement du Serveur Back-EN de Demo ***************************");

        UndertowJaxrsServer server = new UndertowJaxrsServer();
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setApplicationClass(DemoApplication.class.getName());

        Undertow.Builder builder = Undertow.builder().addHttpListener(8080, "0.0.0.0");
        Collection<MimeMapping> mimeMappings = new ArrayList<>();

        DeploymentInfo deploymentInfo = server.undertowDeployment(deployment, "/")
                .setClassLoader(DemoApplication.class.getClassLoader())
                .setContextPath("/api")
                .addMimeMapping(new MimeMapping("json", "application/json"))
                .setDeploymentName("demo");

        server.deploy(deploymentInfo);

        server.start(builder);

        logger.info(" *****************  Serveur Back-EN de Demo OK  *************************** : " );

    }


}
