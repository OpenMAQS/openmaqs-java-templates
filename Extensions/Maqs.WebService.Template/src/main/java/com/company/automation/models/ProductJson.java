package com.company.automation.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.math.BigDecimal;

/**
 * The Product json.
 */
@JsonPropertyOrder({"Id", "Name", "Category", "Price"})
public class ProductJson {

  @JacksonXmlProperty(isAttribute = true)
  private final String xmlns = "http://schemas.datacontract.org/2004/07/MainTestService.Models";

  @JsonAlias({"Id", "id"})
  @JacksonXmlProperty(localName = "Id")
  private int id;

  @JacksonXmlProperty(localName = "Name")
  @JsonAlias({"Name", "name"})
  private String name;

  @JacksonXmlProperty(localName = "Category")
  @JsonAlias({"Category", "category"})
  private String category;

  @JacksonXmlProperty(localName = "Price")
  @JsonAlias({"Price", "price"})
  private BigDecimal price;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
