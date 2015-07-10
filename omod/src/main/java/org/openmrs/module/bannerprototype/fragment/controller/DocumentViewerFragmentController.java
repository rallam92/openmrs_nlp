package org.openmrs.module.bannerprototype.fragment.controller;

import org.openmrs.api.EncounterService;
import org.openmrs.api.context.Context;
import org.openmrs.module.bannerprototype.api.NLPService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentActionUiUtils;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.springframework.web.bind.annotation.RequestParam;



public class DocumentViewerFragmentController {

	
	
	public void controller(FragmentModel model, 
			@FragmentParam(value="docId", required=false) Integer docId) {
        
		String html = "";
		if(docId != null)
			html=Context.getService(NLPService.class).getSofaDocumentById(docId).getAnnotatedHTML();
 
        model.addAttribute("annotatedHTML", html);
    }
	
	public String getHTML(@RequestParam(value="docId", required=false) Integer docId, FragmentActionUiUtils ui) {
			//System.out.println("in getHTML: " + docId);
			String html= Context.getService(NLPService.class).getSofaDocumentById(docId).getAnnotatedHTML();
			
			return html;
			}
}