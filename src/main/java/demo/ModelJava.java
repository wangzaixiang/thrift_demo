package demo;

/**
 * ʹ��java interface���Է���ģ����ȫ������ʽ�ı�̡�
 * 
 * 1. ��ʹ���������Ա��ʱ������ʹ�ù���Ϊ�������ɵ�Ч��Thrift IDL�ļ����������������ԵĿͻ��ˡ�
 * 2. Ԫ��Ϣ���ߣ� �����Զ�����IDL����Ԫ��ϢXML�ļ���������javadoc��ע����Ϣ���ű�������
 * 3. �����Ҫ�ֶ��������л��ȷ������Ա����л���Cacheʱ TODO
 * 
 * ������ĵ���ϢҲ�ŵ�annotation�У���ô������������ʹ�ù��ߣ��Զ��Ĵ����ģ�ͣ�����PHP��C++���������ԵĴ��롣��ͬ������һ���µ�thrift�����ˡ�
 * 
 * ʵ�ֲ��ԣ�
 * ���������й����У��Զ�Ϊ��������ʵ�ִ��룬�����ֶ����ɴ��롣
 * 
 * Calculator bean = new ...
 * TProcessor processor = Factory.getProcessor(Calculator.class)	�Զ����ɴ�����������ASM����
 * 
 * ������Ӧ�ܹ�֧�ֶ��ִ���Э�飬�� Binary/Compact/JSON/XML������������ͻ��˽��в��ԡ�
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
