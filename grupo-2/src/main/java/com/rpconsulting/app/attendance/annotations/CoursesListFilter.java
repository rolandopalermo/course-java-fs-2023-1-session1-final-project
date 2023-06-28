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
                        name = "code",
                        dataType = "string",
                        paramType = "query"
                )
        }
)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CoursesListFilter {
}
