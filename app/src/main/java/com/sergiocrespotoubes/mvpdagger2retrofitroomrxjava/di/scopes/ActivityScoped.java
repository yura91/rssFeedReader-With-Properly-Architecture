package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.components.AppComponent;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {
}