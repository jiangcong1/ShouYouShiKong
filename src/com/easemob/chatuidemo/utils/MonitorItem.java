package com.easemob.chatuidemo.utils;

public class MonitorItem {

	private String name;
	private int iconResid;

	public MonitorItem(String name, int iconResid) {
		super();
		this.name = name;
		this.iconResid = iconResid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIconResid() {
		return iconResid;
	}

	public void setIconResid(int iconResid) {
		this.iconResid = iconResid;
	}

	@Override
	public String toString() {
		return "MonitorItem [name=" + name + ", iconResid=" + iconResid + "]";
	}

}
