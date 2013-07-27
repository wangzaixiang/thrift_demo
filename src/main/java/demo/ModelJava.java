package demo;

/**
 * 使用java interface来对服务建模，完全无侵入式的编程。
 * 
 * 1. 当使用其它语言编程时，可以使用工具为服务生成等效的Thrift IDL文件，再生成其它语言的客户端。
 * 2. 元信息工具： 可以自动根据IDL生成元信息XML文件，包括了javadoc等注释信息、脚本化工具
 * 3. 如果需要手动调用序列化等方法，以便序列化到Cache时 TODO
 * 
 * 如果把文档信息也放到annotation中，那么，后续还可以使用工具，自动的从这个模型，生成PHP、C++等其它语言的代码。等同于做了一个新的thrift工具了。
 * 
 * 实现策略：
 * 容器在运行过程中，自动为服务生成实现代码，无需手动生成代码。
 * 
 * Calculator bean = new ...
 * TProcessor processor = Factory.getProcessor(Calculator.class)	自动生成处理器，基于ASM生成
 * 
 * 服务器应能够支持多种传输协议，如 Binary/Compact/JSON/XML，这样，方便客户端进行测试。
 */
@SuppressWarnings("serial")
public interface ModelJava {
	
	enum Operation {
		
		ADD(1),
		SUBSTRACT(2),
		MULTIPLY(3),
		DIVIDE(4);
		
		
		private int value;
		private Operation(int value){
			this.value = value;
		}
		
		public int value() {
			return value;
		}
		
	}
	
	class Work {
		
		@Protocol.Field(tag = 1)
		int num1;
		
		@Protocol.Field(tag = 2)
		int num2;
		
		@Protocol.Field(tag = 3)
		Operation op;
		
		@Protocol.Field(tag = 4, optional = true)
		String comment;
		
	}
		
	class InvalidOperation extends Exception {
		int what;
		String why;
	}
	
	@Protocol.Service
	interface Calculator {
		
		/**
		 * using javadoc
		 */
		void ping();
		
		int add(int num1, int num2);
		
		int calculate(int logId, Work work) throws InvalidOperation;
		
		@Protocol.Method(oneway = true)
		void zip();
	}

}
