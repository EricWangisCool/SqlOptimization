package com.sql.optimization.www;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(
                "SELECT SOMETHING\n" +
                        "FROM TABLE\n");

        appendConditions(sb,
                Arrays.asList(
                        new Condition("COLOR = :COLOR", "RED")
                        // Add more conditions here...
                )
        );

        System.out.println("SQL is:\n" + sb);
    }

    private static void appendConditions(StringBuilder sb, List<Condition> conditions) {
        boolean isFirstCondition = true;

        for (Condition condition : conditions) {
            Object parameter = condition.getParameter();
            boolean needsAppend;
            if (parameter instanceof String) {
                needsAppend = !((String) parameter).isEmpty();
            } else {
                needsAppend = parameter != null;
            }

            if (needsAppend) {
                if (isFirstCondition) {
                    sb.append(" WHERE ").append(condition.getSql());
                    isFirstCondition = false;
                } else {
                    sb.append(" AND ").append(condition.getSql());
                }
            }
        }
    }
}
