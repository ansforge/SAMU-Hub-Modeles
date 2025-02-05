package com.hubsante.model.converter;

import com.hubsante.model.cisu.CreateCaseWrapper;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.health.CreateCaseHealthWrapper;

import static com.hubsante.model.config.Constants.HEALTH_PREFIX;

public class ConverterUtils {

    public static boolean requiresCisuConversion(Boolean directCisuPreference, EdxlMessage edxlMessage) {
        return isPartOfCisuExchange(edxlMessage) &&
                isCisuModel(edxlMessage) &&
                !isDirectCisuForHealthActor(directCisuPreference);
    }

    public static boolean isPartOfCisuExchange(EdxlMessage edxlMessage) {
        String recipientID = getRecipientID(edxlMessage);
        String senderID = edxlMessage.getSenderID();
        return !(recipientID.startsWith(HEALTH_PREFIX) && senderID.startsWith(HEALTH_PREFIX));
    }

    public static boolean isCisuModel(EdxlMessage edxlMessage) {
        return edxlMessage.getFirstContentMessage() instanceof CreateCaseWrapper
                || edxlMessage.getFirstContentMessage() instanceof CreateCaseHealthWrapper;
    }

    public static boolean isDirectCisuForHealthActor(Boolean directCisuPreference) {
        return directCisuPreference != null && directCisuPreference;
    }

    public static String getRecipientID(EdxlMessage edxlMessage) {
        return edxlMessage.getDescriptor().getExplicitAddress().getExplicitAddressValue();
    }
}
