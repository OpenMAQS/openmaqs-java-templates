package com.company.automation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Product json.
 */
public class ProductJson {

  /**
   * int ID
   */
  @JsonProperty("Id")
  private int id;

  /**
   * String name
   */
  @JsonProperty("Name")
  private String name;

  /**
   * String category
   */
  @JsonProperty("Category")
  private String category;

  /**
   * Integer price
   */
  @JsonProperty("Price")
  private Integer price;

  /**
   * Gets id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets category.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets category.
   *
   * @param category the category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public Integer getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(Integer price) {
    this.price = price;
  }
}