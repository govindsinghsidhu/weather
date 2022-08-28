package com.application.validator;

import com.application.common.ApplicationConstants;

public interface ApiValidator {

	public static String getURI(String city) {

		return new StringBuilder()
	    .append(ApplicationConstants.BASE_URL)
	    .append(ApplicationConstants.VERSION)
	    .append(ApplicationConstants.API_TYPE_PARAM)
	    .append(city)
	    .append(ApplicationConstants.APP_ID_PARAM)
	    .append(ApplicationConstants.KEY)
	    .append(ApplicationConstants.COUNT_PARAM)
	    .append(ApplicationConstants.DAY_COUNT)
	    .append(ApplicationConstants.UNITS_PARAM)
	    .append(ApplicationConstants.UNITS)
	    .toString();
	}
}
