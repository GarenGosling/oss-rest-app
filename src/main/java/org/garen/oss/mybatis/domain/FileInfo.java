package org.garen.oss.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class FileInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型（jpg、png等）
     */
    private String type;

    /**
     * 文件种类（picture、video等）
     */
    private String category;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件MD5值
     */
    private String md5;

    /**
     * 文件缩略图MD5值
     */
    private String minMd5;

    /**
     * 文件下载路径
     */
    private String preview;

    /**
     * 文件缩略图下载路径
     */
    private String minPreview;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMinMd5() {
        return minMd5;
    }

    public void setMinMd5(String minMd5) {
        this.minMd5 = minMd5;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getMinPreview() {
        return minPreview;
    }

    public void setMinPreview(String minPreview) {
        this.minPreview = minPreview;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileInfo other = (FileInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getMd5() == null ? other.getMd5() == null : this.getMd5().equals(other.getMd5()))
            && (this.getMinMd5() == null ? other.getMinMd5() == null : this.getMinMd5().equals(other.getMinMd5()))
            && (this.getPreview() == null ? other.getPreview() == null : this.getPreview().equals(other.getPreview()))
            && (this.getMinPreview() == null ? other.getMinPreview() == null : this.getMinPreview().equals(other.getMinPreview()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getMd5() == null) ? 0 : getMd5().hashCode());
        result = prime * result + ((getMinMd5() == null) ? 0 : getMinMd5().hashCode());
        result = prime * result + ((getPreview() == null) ? 0 : getPreview().hashCode());
        result = prime * result + ((getMinPreview() == null) ? 0 : getMinPreview().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", category=").append(category);
        sb.append(", size=").append(size);
        sb.append(", md5=").append(md5);
        sb.append(", minMd5=").append(minMd5);
        sb.append(", preview=").append(preview);
        sb.append(", minPreview=").append(minPreview);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}