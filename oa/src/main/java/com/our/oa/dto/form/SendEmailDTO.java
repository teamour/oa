package com.our.oa.dto.form;


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
public class SendEmailDTO extends FormDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//company is jp or ch
	private String companyType;
		
	//cooperation Intention
	private String cooperationIntention;
		
	//send mail to sales or proposal
	private String sendMailType;
	
	private String emailtitle;
	
	private String emailcontext;
	
	private String customerids;
}
