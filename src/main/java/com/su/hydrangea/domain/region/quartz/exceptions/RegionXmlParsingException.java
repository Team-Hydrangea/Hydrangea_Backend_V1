package com.su.hydrangea.domain.region.quartz.exceptions;

import com.su.hydrangea.global.error.ErrorCode;
import com.su.hydrangea.global.error.exception.GlobalException;

public class RegionXmlParsingException extends GlobalException {
    public RegionXmlParsingException() {
        super(ErrorCode.REGION_XML_PARSING_ERROR);
    }
}
