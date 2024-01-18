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
package com.hubsante.model.builders;


import com.hubsante.model.common.DistributionElement;
import com.hubsante.model.report.ErrorReport;
import com.hubsante.model.report.InfoWrapper;

public class InfoWrapperBuilder {
    private DistributionElement distributionElement;
    private ErrorReport info;

    public InfoWrapperBuilder(DistributionElement distributionElement, ErrorReport info) {
        this.distributionElement = distributionElement;
        this.info = info;
    }

    public InfoWrapper build() {
        InfoWrapper infoWrapper = new InfoWrapper();
        infoWrapper.setMessageId(distributionElement.getMessageId());
        infoWrapper.setSender(distributionElement.getSender());
        infoWrapper.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.ERROR)) {
            throw new IllegalArgumentException("InfoWrapper must be of kind ERROR");
        }
        infoWrapper.setKind(distributionElement.getKind());
        infoWrapper.setStatus(distributionElement.getStatus());
        infoWrapper.setRecipient(distributionElement.getRecipient());
        infoWrapper.setInfo(info);
        return infoWrapper;
    }
}
