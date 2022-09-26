package com.company.automation.test;

import com.cognizantsoftvision.maqs.webservices.WebServiceUtilities;
import com.company.automation.models.ProductJson;
import com.cognizantsoftvision.maqs.webservices;
import com.cognizantsoftvision.maqs.webservices;
import java.io.IOException;
import java.net.http.HttpResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The type Web service test.
 */
public class WebServiceTest extends BaseWebServiceTest {

  /**
   * Gets json deserialized Test.
   */
  @Test
  public void getJsonDeserialized() {
    HttpResponse result = null;
    try {
      result = this.getTestObject().getWebServiceDriver()
          .getContent("/api/XML_JSON/GetProduct/1", ContentType.APPLICATION_JSON, false);
    } catch (Exception e) {
      e.printStackTrace();
    }


    ProductJson productJson = null;
    try {
      productJson = WebServiceUtilities.deserializeJson(result, ProductJson.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    Assert.assertEquals(productJson.getId(), 1, "Expected to get product 1");
  }
}
