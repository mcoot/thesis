package jifpolicytool;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	static String packageName = "policy";
	String name;
	List delegations;
	List declassifiers;
	
	public Principal(String name)
	{
		this.name = name;
		delegations = new ArrayList();
		declassifiers = new ArrayList();
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Principal) {
			Principal p = (Principal)o;
			return (0 == this.name.compareTo(p.name));
		}
		else return false;
	}
	
	public String getName()
	{
		return name;
	}
	public void addDelegation(Principal p)
	{
		delegations.add(p);
	}
	
	public void addDeclassifier(Declassifier d)
	{
		declassifiers.add(d);
	}
	
	public Object[] getDelegations()
	{
		return delegations.toArray();
	}
	
	public Object[] getDeclassifiers()
	{
		return declassifiers.toArray();
	}
	
	//	 returns the name that will be used as a classname
	//   e.g. "bono" -> "BonoPrincipal"
	public String toClassName() 
	{
		String firstLetter = this.name.substring(0,1);
		return firstLetter.toUpperCase() + this.name.substring(1) + "Principal";
	}
	
	public String constructorToString()
	{
		String out = "";
		out += "public " + this.toClassName() + "(String{this} name) {" + "\n";
		out += "    super(name);" + "\n";
		out += "}" + "\n\n";

		out += "public " + this.toClassName() + "(String{this} name, PublicKey{} pubKey)" + "\n";
		out += "{\n";
		out += " 	super(name,pubKey);\n";
		out += "}\n\n";

		out += "public " + this.toClassName() + "{}(String{this} name, PublicKey{} pubKey, char{user:}[]{user:} pwd, principal{} user) where caller(user)\n";
		out += "{\n";
		out += " 	super(name,pubKey,pwd,user);\n";
		out += "}\n";


		if (declassifiers.contains(new Declassifier("Password"))) {
			out += "public " + this.toClassName() + "(String{this} name, String{this:} password) {" + "\n";
			out += "this.password = password;" + "\n";
			out += "super(name);";
		    out += "\n" + "}" + "\n";
		}
		return out;
	}
	
	public String headerToString()
	{
		String out = "";
		out += "package " + packageName + ";\n\n";
		out += "import " + "java.security.PublicKey;\n\n";
		out += "public class " + this.toClassName() + " extends KeyPrincipal {" + "\n";
		return out;
	}
	
//    public boolean{authPrf; closure; lb; this} isAuthorized(Object authPrf, 
//            Closure[this, lb] closure,
//            label lb) where authority (this) {
//return closure instanceof smtp.EmailDisclaimerClosure[this, lb];
//}

	public String isAuthorizedToString()
	{
		String out = "";
		boolean requirePassword = false;
		out += "public boolean{authPrf; closure; lb; this} isAuthorized(Object authPrf, Closure[this,lb] closure, label lb)" + "\n";
		out += "where authority(this) {" + "\n";
		
		Object[] decls = declassifiers.toArray();
		if (decls.length == 0 && delegations.isEmpty()) out += "    return false;"; // default deny
		else if (declassifiers.contains(new Declassifier("Any"))) {
			out += "     return true;\n}"; 
			return out;  // need to quit after this.
		}
		else if (declassifiers.contains(new Declassifier("Password"))) {
// FIXME: In the future, we want to change this to use a Closure which does a Password check, so as to eliminate all declassifiers.
			out += "    boolean passwordOK = declassify((password == null || password.equals(authPrf)), {authPrf;this});" + "\n";
			requirePassword = true;
		}
		
// add in authorization of delegation closures
		
		boolean first = true;
		
		if (!delegations.isEmpty()){
			if (requirePassword) 	out += "    return passwordOK && ";
			else out += "    return";
			out += " ((closure instanceof " + packageName + ".AddDelClosureL[this,lb])\n";
			first = false;
		}

		for (int i = 0; i < decls.length; i++)
		{
			Declassifier decl = (Declassifier)decls[i];
			if (0 != decl.getName().compareTo("Any") && 0 != decl.getName().compareTo("Password")) {
				if (first) {
					if (requirePassword) 	out += "    return passwordOK && ";
					else out += "    return";
					out += " ((closure instanceof " + decl.getName() + "[this,lb])\n";
					first = false;
				}
				else out += " || (closure instanceof " + decl.getName() + "[this,lb])\n";
			}
		}

		if (!first) out += ");"; // close off parens from closures
		
		out += "\n" + "}";
		
		return out;
	}
	
	public String toJifCode()
	{
		String out = "";
		
		out += headerToString();
		out += "\n";
		out += constructorToString();
		out += "\n";
		out += isAuthorizedToString();
		out += "\n" + "}" + "\n";
		
		return out;
	}
	
	// for declaring a final principal
	public String toPrincipalName()
	{
		return name;
	}
	
	// for declaring a Principal variable
	public String toPrincipalVarName()
	{
		return name + "P"; 
	}
	
	// simple declaration -- doesn't include password access
	public String declarationToString()
	{
		return "Principal{} " + toPrincipalVarName() + " = new " + toClassName() + "(\"" + name + "\")";
	}
}
