package com.our.oa.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnouncementDTO implements Serializable{
	
	private Integer announcementId;

	@NotEmpty
	@Size(max=100)
    private String title;

	@NotEmpty
    private String description;
	
	private Date createTime;

	private static final long serialVersionUID = 1L;
}
