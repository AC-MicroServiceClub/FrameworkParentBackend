package com.msclub.base.model;

public enum IssueType {
	INVALID("INVALID"), 
	NOTFOUND("NOTFOUND"), 
	EXCEPTION("EXCEPTION");
    private final String name;    //应该设置成 private final 
    private IssueType(String name) {    // 应该设置成 private
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
