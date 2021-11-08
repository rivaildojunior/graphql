package com.example.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Ola Mundo GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }


}
