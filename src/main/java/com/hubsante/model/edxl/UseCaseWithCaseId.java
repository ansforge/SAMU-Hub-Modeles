package com.hubsante.model.edxl;

/**
 * Implemented by use case models carrying a caseId field, so that it can be retrieved
 * from any ContentMessage without knowing its concrete type.
 */
public interface UseCaseWithCaseId {
    String getCaseId();
}