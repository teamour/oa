package com.our.oa.dto.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.our.oa.dto.FormDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class AnnouncementDTO extends FormDTO{
	
	private Integer announcementId;

	@NotEmpty
	@Size(max=100)
    private String title;

	@NotEmpty
    private String description;
	
	private Date createTime;

	private static final long serialVersionUID = 1L;
}
