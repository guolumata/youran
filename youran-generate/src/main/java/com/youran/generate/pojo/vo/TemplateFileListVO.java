package com.youran.generate.pojo.vo;

import com.youran.common.pojo.vo.AbstractVO;
import com.youran.generate.constant.ContextType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.youran.generate.pojo.example.TemplateFileExample.*;

/**
 * <p>Title: 【模板文件】列表展示对象</p>
 * <p>Description: </p>
 * @author cbb
 * @date 2019/10/24
 */
@ApiModel(description = "【模板文件】列表展示对象")
public class TemplateFileListVO extends AbstractVO {

    @ApiModelProperty(notes = N_FILE_ID,example = E_FILE_ID)
    private Integer fileId;

    @ApiModelProperty(notes = N_FILE_NAME,example = E_FILE_NAME)
    private String fileName;

    @ApiModelProperty(notes = N_FILE_DIR,example = E_FILE_DIR)
    private String fileDir;

    @ApiModelProperty(notes = N_TEMPLATE_ID,example = E_TEMPLATE_ID)
    private Integer templateId;

    @ApiModelProperty(notes = N_CONTEXT_TYPE,example = E_CONTEXT_TYPE, allowableValues = ContextType.VALUES_STR)
    private Integer contextType;

    @ApiModelProperty(notes = N_ABSTRACTED,example = E_ABSTRACTED)
    private Boolean abstracted;


    public Integer getFileId() {
        return this.fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public Integer getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getContextType() {
        return this.contextType;
    }

    public void setContextType(Integer contextType) {
        this.contextType = contextType;
    }

    public Boolean getAbstracted() {
        return this.abstracted;
    }

    public void setAbstracted(Boolean abstracted) {
        this.abstracted = abstracted;
    }



}
