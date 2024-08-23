package com.hubsante.modelsinterface.interfaces;

import com.hubsante.modelsinterface.exception.AbstractHubException;
import org.springframework.amqp.core.Message;

public interface ErrorServiceInterface {
    
    ErrorInterface handleError(AbstractHubException exception, Message message);
}
