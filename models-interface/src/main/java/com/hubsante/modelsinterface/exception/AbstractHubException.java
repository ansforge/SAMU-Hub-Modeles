/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.modelsinterface.exception;

import com.hubsante.modelsinterface.report.ErrorCode;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;

public abstract class AbstractHubException extends AmqpRejectAndDontRequeueException {

    private ErrorCode errorCode;
    private String referencedDistributionID;
    public AbstractHubException(String message, ErrorCode errorCode, String referencedDistributionID) {
        super(message);
        this.errorCode = errorCode;
        this.referencedDistributionID = referencedDistributionID;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getReferencedDistributionID() { return referencedDistributionID; }
}
