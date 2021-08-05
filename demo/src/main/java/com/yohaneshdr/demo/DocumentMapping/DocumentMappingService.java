package com.yohaneshdr.demo.DocumentMapping;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class DocumentMappingService {
	
	private static final Map<String, String> documentMap = new HashMap<>();
	
	@PostConstruct
	public void initialize() {
		documentMap.put("INVOICE", "PROCESS");
		documentMap.put("ORDER", "DRAFT");
		documentMap.put("PAYMENT", "COMPLETED");
	}
	
	public String getDocumentMapping(String documentType) {
		
		return documentMap.get(documentType);
		
	}
}
