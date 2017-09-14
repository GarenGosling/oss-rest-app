package org.garen.oss.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * FileType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-14T14:07:38.387Z")

public class FileType   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("maxSize")
  private Integer maxSize = null;

  @JsonProperty("available")
  private Boolean available = null;

  public FileType id(Long id) {
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

  public FileType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 名称
   * @return name
  **/
  @ApiModelProperty(value = "名称")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FileType code(String code) {
    this.code = code;
    return this;
  }

   /**
   * 编码
   * @return code
  **/
  @ApiModelProperty(value = "编码")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public FileType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * 分类
   * @return type
  **/
  @ApiModelProperty(value = "分类")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FileType maxSize(Integer maxSize) {
    this.maxSize = maxSize;
    return this;
  }

   /**
   * 最大允许的文件大小
   * @return maxSize
  **/
  @ApiModelProperty(value = "最大允许的文件大小")
  public Integer getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(Integer maxSize) {
    this.maxSize = maxSize;
  }

  public FileType available(Boolean available) {
    this.available = available;
    return this;
  }

   /**
   * 是否使用
   * @return available
  **/
  @ApiModelProperty(value = "是否使用")
  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileType fileType = (FileType) o;
    return Objects.equals(this.id, fileType.id) &&
        Objects.equals(this.name, fileType.name) &&
        Objects.equals(this.code, fileType.code) &&
        Objects.equals(this.type, fileType.type) &&
        Objects.equals(this.maxSize, fileType.maxSize) &&
        Objects.equals(this.available, fileType.available);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, code, type, maxSize, available);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
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

