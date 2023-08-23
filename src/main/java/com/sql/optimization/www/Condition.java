package com.sql.optimization.www;

public class Condition {
    private String sql;
    private Object parameter;
    public Condition(String sql, Object parameter) {
        this.sql = sql;
        this.parameter = parameter;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) { this.parameter = parameter; }
}
