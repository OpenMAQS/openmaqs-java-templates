package com.company.automation.test;

import com.cognizantsoftvision.maqs.utilities.helper.TestCategories;
import com.cognizantsoftvision.maqs.webservices.*;
import com.company.automation.models.ProductJson;
import java.io.IOException;
import java.net.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The Web service test.
 */
public class WebServiceTest extends BaseWebServiceTest {

  /**
   * String to hold the URL.
   */
  private static final String baseUrl = WebServiceConfig.getWebServiceUri();

  /**
   * Object holder for the web service driver.
   */
  private final WebServiceDriver webServiceDriver = new WebServiceDriver(HttpClientFactory.getDefaultClient());

  /**
   * Gets json deserialized Test.
   */
  @Test
  public void getJsonDeserialized() throws IOException, InterruptedException {
    HttpResponse<String> response = webServiceDriver.get(
        baseUrl + "/api/XML_JSON/GetProduct/2", MediaType.APP_JSON, true);
    ProductJson products = WebServiceUtilities.getResponseBody(response, MediaType.APP_JSON, ProductJson.class);
    Assert.assertEquals(products.getName(), "Yo-yo", "Expected 3 products to be returned");
  }

  /**
   * Test XML Get deserialize a single product.
   * @throws IOException if exception is thrown
   * @throws InterruptedException if exception is thrown
   */
  @Test(groups = TestCategories.WEB_SERVICE)
  public void getProductXmlDeserialize() throws IOException, InterruptedException {
    HttpResponse<String> response = webServiceDriver.get(
        baseUrl + "/api/XML_JSON/GetProduct/2", MediaType.APP_XML, true);
    ProductJson products = WebServiceUtilities.getResponseBody(response, MediaType.APP_XML, ProductJson.class);
    Assert.assertEquals(products.getName(), "Yo-yo", "Expected Yo-yo to be returned");
  }
}
