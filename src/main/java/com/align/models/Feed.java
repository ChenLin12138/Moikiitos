package com.align.models;

public class Feed {
	
    private Integer id;

    private Integer userid;
    
    private String name;

    private String content;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

	public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}