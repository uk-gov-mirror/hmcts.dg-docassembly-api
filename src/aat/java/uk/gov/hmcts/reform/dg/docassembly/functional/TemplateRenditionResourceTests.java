package uk.gov.hmcts.reform.dg.docassembly.functional;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import uk.gov.hmcts.reform.dg.docassembly.testutil.Env;
import uk.gov.hmcts.reform.dg.docassembly.testutil.TestUtil;

import java.util.Base64;

public class TemplateRenditionResourceTests {

    private final TestUtil testUtil = new TestUtil();

    @Test
    public void testTemplateRendition() {

        Response response = testUtil
                .authRequest()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("{\"formPayload\":{\"a\":1}, \"templateId\":\""
                        + Base64.getEncoder().encodeToString("FL-FRM-APP-ENG-00002.docx".getBytes())
                        + "\"}")
                .request("POST",Env.getTestUrl() + "/api/template-renditions");

        System.out.println(response.getBody().print());
        Assert.assertEquals(200, response.getStatusCode());

    }
}