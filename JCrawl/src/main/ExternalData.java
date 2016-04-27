package main;

import java.util.ArrayList;

public class ExternalData {
	private ArrayList<String> tag, data;
	
	public ExternalData() {
		setTag(new ArrayList<String>());
		setData(new ArrayList<String>());
	}

	public ArrayList<String> getTag() {
		return tag;
	}

	public void setTag(ArrayList<String> tag) {
		this.tag = tag;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}
}
