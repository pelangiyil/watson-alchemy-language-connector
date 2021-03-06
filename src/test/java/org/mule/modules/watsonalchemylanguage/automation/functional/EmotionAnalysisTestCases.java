/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.EmotionAnalysisRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;

public class EmotionAnalysisTestCases extends AbstractTestCases {
	
	@Test
	public void testWithURL() {
		DocumentEmotion documentEmotion = getConnector().emotionAnalysis(buildTestRequest());

		assertNotNull(documentEmotion);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, documentEmotion.getUrl());
		assertFalse(documentEmotion.getEmotion().getJoy() == 0);
	}
	
	private EmotionAnalysisRequest buildTestRequest() {
		return new EmotionAnalysisRequest(TestDataBuilder.TEST_URL_BLOG);
	}
}
