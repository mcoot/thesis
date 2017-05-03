package jifpolicytool;

public class Declassifier {
	String name;
	String inputType;
	Principal fromLevel;
	Principal toLevel;
	
	public Declassifier(String name)
	{
		this.name = name;
		this.inputType = null;
		this.fromLevel = null;
		this.toLevel = null;
	}
	
	public Declassifier(String name, String inputType, Principal fromLevel, Principal toLevel)
	{
		this.name = name;
		this.inputType = inputType;
		this.fromLevel = fromLevel;
		this.toLevel = toLevel;
	}

	public boolean equals(Object o)
	{
		if (o instanceof Declassifier) {
			Declassifier d = (Declassifier)o;
			return (0 == this.name.compareTo(d.name));
		}
		else return false;
	}
	
	public void addInputType(String inputType)
	{
		this.inputType  = inputType;
	}
	
	public void addToLevel(Principal p)
	{
		toLevel = p;
	}
	
	public void addFromLevel(Principal p)
	{
		fromLevel = p;
	}

	public Principal getFromLevel() {
		return fromLevel;
	}

	public String getInputType() {
		return inputType;
	}

	public String getName() {
		return name;
	}

	public Principal getToLevel() {
		return toLevel;
	}
	
}
