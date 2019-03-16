package demo.spi;

import demo.api.IOperation;
import demo.impl.DivisionOperationImpl;
import demo.impl.PlusOperationImpl;

import java.util.ServiceLoader;
//import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        IOperation plus = new PlusOperationImpl();

        IOperation division = new DivisionOperationImpl();
        System.out.println(plus.operation(5, 3));

        System.out.println(division.operation(9, 3));

        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);

        for(IOperation iOperation:operations){
            System.out.println(iOperation.operation(10,12));
        }
//        Iterator<IOperation> operationIterator = operations.iterator();
//        System.out.println("classPath:"+System.getProperty("java.class.path"));
//        while (operationIterator.hasNext()) {
//            IOperation operation = operationIterator.next();
//            System.out.println(operation.operation(6, 3));
//        }
    }

}
