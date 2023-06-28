package com.rpconsulting.app.attendance.annotations;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApiImplicitParams(
        value = {
                @ApiImplicitParam(
                        name = "name",
                        dataType = "string",
                        paramType = "query"
                ),
                @ApiImplicitParam(
                        name = "lastName",
                        dataType = "string",
                        paramType = "query"
                ),
                @ApiImplicitParam(
                        name = "birthdateStart",
                        dataType = "string",
                        paramType = "query"
                ),
                @ApiImplicitParam(
                        name = "birthdateEnd",
                        dataType = "string",
                        paramType = "query"
                ),
        }
)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentsListFilter {
}
