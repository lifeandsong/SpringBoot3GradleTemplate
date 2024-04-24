package org.swmaestro.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Base Model
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Data
public class BaseModel {

    protected String used;
    protected String creator;
    protected Date createdAt;
    protected String updater;
    protected Date updatedAt;

}
