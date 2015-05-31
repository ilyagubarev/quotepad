package com.ilyagubarev.quotepad.web.presentation.models;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
public abstract class AbstractControllerBean implements Serializable {

    protected static final String JSON = "application/json;charset=utf-8";
}
