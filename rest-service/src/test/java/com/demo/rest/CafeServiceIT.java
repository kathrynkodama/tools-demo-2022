package com.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

@Testcontainers
public class CafeServiceIT {
    private static String baseUrl;
    private static final String READINESS_ENDPOINT = "/health/ready";

    private Client client;
    private Response response;

    //testcontainer setup, package war and build image before running
    @Container
    public GenericContainer cont = new GenericContainer(DockerImageName.parse("rest-service:latest"))
            .withExposedPorts(9080)
            .withImagePullPolicy(PullPolicy.defaultPolicy())
            .waitingFor(Wait.forHttp("/health/ready"));

    // FIXME: trying to incorporte devc image with testcontainers
    // @Container
    // public GenericContainer cont = new GenericContainer(DockerImageName.parse("rest-service-dev-mode:latest"))
    //         .withExposedPorts(9080)
    //         .withImagePullPolicy(PullPolicy.defaultPolicy())
    //         .waitingFor(Wait.forHttp("/health/ready"))
    //         .withClasspathResourceMapping("/Users/kathrynkodama/devex/demos/devnexus-2022/rest-service/target/.libertyDevc/apps", "/config/apps", BindMode.READ_ONLY) // results in classloading issue
    //         .withClasspathResourceMapping("/Users/kathrynkodama/devex/demos/devnexus-2022/rest-service/target/.libertyDevc/dropins", "/config/dropins", BindMode.READ_ONLY)
    //         .withClasspathResourceMapping("/Users/kathrynkodama/devex/demos/devnexus-2022/rest-service", "/devmode", BindMode.READ_ONLY)
    //         .withClasspathResourceMapping("/Users/kathrynkodama/devex/demos/devnexus-2022/rest-service/target/liberty/wlp/usr/servers/defaultServer/logs", "/logs", BindMode.READ_ONLY)
    //         .withClasspathResourceMapping(" /Users/kathrynkodama/.m2/repository", ":/devmode-maven-cache ", BindMode.READ_ONLY);

    @BeforeEach
    public void setup() {
        baseUrl = "http://" + cont.getContainerIpAddress() + ":" + cont.getFirstMappedPort();;
        response = null;
        client = ClientBuilder.newClient();
    }

    @AfterEach
    public void teardown() {
        response.close();
        client.close();
    }

    @Test
    public void testReadinessEndpoint() {
        String readinessURL = baseUrl + READINESS_ENDPOINT;
        response = client.target(baseUrl + READINESS_ENDPOINT).request().get();
        assertEquals(200, response.getStatus(), "Incorrect response code from " + readinessURL);
    }

    @Test
    public void testCafeService() {
        response = client.target(baseUrl + "/rest-service/api/cafe/size").request().get();
        assertEquals(2, response.readEntity(int.class), "error");
    }
}