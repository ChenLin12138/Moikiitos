package com.align.models;

public class UserFollow {
	
    private Integer id;

    private Integer userid;

    private Integer followid;
    
	public UserFollow() {
    	
    }
    
    public UserFollow (Integer userid, Integer followid) {
    	this.userid = userid;
    	this.followid = followid;
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

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }
}