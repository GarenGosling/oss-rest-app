package org.garen.oss.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * FileInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-18T02:46:57.436Z")

public class FileInfo   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("size")
  private Long size = null;

  @JsonProperty("minSize")
  private Integer minSize = null;

  @JsonProperty("md5")
  private String md5 = null;

  @JsonProperty("minMd5")
  private String minMd5 = null;

  @JsonProperty("preview")
  private String preview = null;

  @JsonProperty("minPreview")
  private String minPreview = null;

  public FileInfo id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * ID
   * @return id
  **/
  @ApiModelProperty(value = "ID")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FileInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 文件名
   * @return name
  **/
  @ApiModelProperty(value = "文件名")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FileInfo type(String type) {
    this.type = type;
    return this;
  }

   /**
   * 文件类型（jpg、png等）
   * @return type
  **/
  @ApiModelProperty(value = "文件类型（jpg、png等）")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FileInfo category(String category) {
    this.category = category;
    return this;
  }

   /**
   * 文件种类（picture、video等）
   * @return category
  **/
  @ApiModelProperty(value = "文件种类（picture、video等）")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public FileInfo size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * 文件大小
   * @return size
  **/
  @ApiModelProperty(value = "文件大小")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public FileInfo minSize(Integer minSize) {
    this.minSize = minSize;
    return this;
  }

   /**
   * 缩略图文件大小
   * @return minSize
  **/
  @ApiModelProperty(value = "缩略图文件大小")
  public Integer getMinSize() {
    return minSize;
  }

  public void setMinSize(Integer minSize) {
    this.minSize = minSize;
  }

  public FileInfo md5(String md5) {
    this.md5 = md5;
    return this;
  }

   /**
   * 文件MD5值
   * @return md5
  **/
  @ApiModelProperty(value = "文件MD5值")
  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public FileInfo minMd5(String minMd5) {
    this.minMd5 = minMd5;
    return this;
  }

   /**
   * 文件缩略图MD5值
   * @return minMd5
  **/
  @ApiModelProperty(value = "文件缩略图MD5值")
  public String getMinMd5() {
    return minMd5;
  }

  public void setMinMd5(String minMd5) {
    this.minMd5 = minMd5;
  }

  public FileInfo preview(String preview) {
    this.preview = preview;
    return this;
  }

   /**
   * 文件下载路径
   * @return preview
  **/
  @ApiModelProperty(value = "文件下载路径")
  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

  public FileInfo minPreview(String minPreview) {
    this.minPreview = minPreview;
    return this;
  }

   /**
   * 文件缩略图下载路径
   * @return minPreview
  **/
  @ApiModelProperty(value = "文件缩略图下载路径")
  public String getMinPreview() {
    return minPreview;
  }

  public void setMinPreview(String minPreview) {
    this.minPreview = minPreview;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileInfo fileInfo = (FileInfo) o;
    return Objects.equals(this.id, fileInfo.id) &&
        Objects.equals(this.name, fileInfo.name) &&
        Objects.equals(this.type, fileInfo.type) &&
        Objects.equals(this.category, fileInfo.category) &&
        Objects.equals(this.size, fileInfo.size) &&
        Objects.equals(this.minSize, fileInfo.minSize) &&
        Objects.equals(this.md5, fileInfo.md5) &&
        Objects.equals(this.minMd5, fileInfo.minMd5) &&
        Objects.equals(this.preview, fileInfo.preview) &&
        Objects.equals(this.minPreview, fileInfo.minPreview);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, category, size, minSize, md5, minMd5, preview, minPreview);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    minSize: ").append(toIndentedString(minSize)).append("\n");
    sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
    sb.append("    minMd5: ").append(toIndentedString(minMd5)).append("\n");
    sb.append("    preview: ").append(toIndentedString(preview)).append("\n");
    sb.append("    minPreview: ").append(toIndentedString(minPreview)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

