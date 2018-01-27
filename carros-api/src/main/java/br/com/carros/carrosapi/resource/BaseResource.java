package br.com.carros.carrosapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public abstract class BaseResource {

    @Autowired
    protected ApplicationEventPublisher publisher;
}
