package com.yohaneshdr.demo.DocumentMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.yohaneshdr.demo.GetDocumentMappingRequest;
import com.yohaneshdr.demo.GetDocumentMappingResponse;

@Endpoint
public class DocumentMappingEndpoint {
	
	@Autowired
	private DocumentMappingService documentMappingService;
	
	@PayloadRoot(namespace="http://yohaneshdr.com/demo", localPart="getDocumentMappingRequest")
	@ResponsePayload
	public GetDocumentMappingResponse getDocumentMappingRequest(@RequestPayload GetDocumentMappingRequest request) {
		GetDocumentMappingResponse response = new GetDocumentMappingResponse();
		response.setFolderTarget(documentMappingService.getDocumentMapping(request.getDocumentType()));
		return response;
	}

}
