package demo.impl;

import demo.api.IOperation;

public class PlusOperationImpl implements IOperation {

    public int operation(int numberA, int numberB) {
        return numberA + numberB;
    }

    //    @Override
//    public int operation(int numberA, int numberB) {
//        return numberA + numberB;
//    }
}
