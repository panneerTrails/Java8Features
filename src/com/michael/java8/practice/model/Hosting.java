/**
 * 
 */
package com.michael.java8.practice.model;

/**
 * @author 109726
 *
 */
public class Hosting {

	private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }
    
	
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the websites
	 */
	public long getWebsites() {
		return websites;
	}

	/**
	 * @param websites the websites to set
	 */
	public void setWebsites(long websites) {
		this.websites = websites;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hosting [Id=" + Id + ", name=" + name + ", websites="
				+ websites + "]";
	}


}
