package com.align.models;

public class FollowRelationship {
	
    private Integer userid;

    private Integer followid;
    
    private String name;
    
    private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public FollowRelationship() {
    	
    }
    
    public FollowRelationship (Integer userid, Integer followid) {
    	this.userid = userid;
    	this.followid = followid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((followid == null) ? 0 : followid.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowRelationship other = (FollowRelationship) obj;
		if (followid == null) {
			if (other.followid != null)
				return false;
		} else if (!followid.equals(other.followid))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
    
}