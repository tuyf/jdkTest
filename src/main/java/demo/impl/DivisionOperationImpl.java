package demo.impl;


import demo.api.IOperation;

public class DivisionOperationImpl implements IOperation {
    public int operation(int numberA, int numberB) {
        return numberA / numberB;
    }

    //    @Override
//    public int operation(int numberA, int numberB) {
//        return numberA / numberB;
//    }
}
