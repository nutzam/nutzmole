package org.nutz.mole;

public interface DatabaseAdaptor {

	MoleContext fromDb(MoleContext context);
	
	void toTarget(MoleContext context);
}
