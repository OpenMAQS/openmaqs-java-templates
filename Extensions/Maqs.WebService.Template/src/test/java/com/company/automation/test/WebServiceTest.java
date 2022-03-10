package com.company.automation.test;

import com.company.automation.models.ProductJson;
import com.magenic.jmaqs.webservices.jdk8.BaseWebServiceTest;
import com.magenic.jmaqs.webservices.jdk8.WebServiceUtilities;
import java.io.IOException;
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
    CloseableHttpResponse result = null;
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
