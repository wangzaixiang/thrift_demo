package demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Protocol {

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public @interface Field {
		
		String DefaultValue = "?";

		int tag();

		boolean optional() default false;
		
		String deft() default DefaultValue;

	}
	
	public @interface Service {
		
	}
	
	public @interface Method {
		
		boolean oneway() default false;
	}

}
