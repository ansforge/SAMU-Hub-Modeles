package com.hubsante.model.utils;

import com.hubsante.model.cisu.CreateCaseWrapper;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.health.CreateCaseHealthWrapper;


public class ConverterUtils {
    public static boolean isCisuModel(EdxlMessage edxlMessage) {
        return edxlMessage.getFirstContentMessage() instanceof CreateCaseWrapper
                || edxlMessage.getFirstContentMessage() instanceof CreateCaseHealthWrapper;
    }
}
