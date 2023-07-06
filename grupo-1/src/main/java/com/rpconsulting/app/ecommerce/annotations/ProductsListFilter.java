package com.rpconsulting.app.ecommerce.annotations;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApiImplicitParams(
        value = {
                @ApiImplicitParam(
                        name = "nameProduct",
                        dataType = "string",
                        paramType = "query"
                ),
                @ApiImplicitParam(
                        name = "priceProduct",
                        dataType = "bigdecimal",
                        paramType = "query"
                ),
                @ApiImplicitParam(
                        name = "nameCategory",
                        dataType = "string",
                        paramType = "query"
                )
        }
)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductsListFilter {
}
